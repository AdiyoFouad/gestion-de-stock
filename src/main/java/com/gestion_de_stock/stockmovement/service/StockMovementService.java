package com.gestion_de_stock.stockmovement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion_de_stock.produit.exceptions.ProduitNotFoundException;
import com.gestion_de_stock.produit.model.Produit;
import com.gestion_de_stock.produit.repository.ProduitRepository;
import com.gestion_de_stock.stockmovement.dto.StockMovementRequestDTO;
import com.gestion_de_stock.stockmovement.dto.StockMovementResponseDTO;
import com.gestion_de_stock.stockmovement.exceptions.StockInsufficientException;
import com.gestion_de_stock.stockmovement.mapper.StockMovementMapper;
import com.gestion_de_stock.stockmovement.model.MovementType;
import com.gestion_de_stock.stockmovement.model.StockMovement;
import com.gestion_de_stock.stockmovement.repository.StockMovementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class StockMovementService {

	private final StockMovementRepository stockMovementRepository;
	private final ProduitRepository produitRepository;

	public StockMovementResponseDTO createMovement(StockMovementRequestDTO dto) {
		Produit produit = produitRepository.findById(dto.getProduitId())
				.orElseThrow(() -> new ProduitNotFoundException("Produit inexistant"));

		MovementType type = MovementType.valueOf(dto.getType().toUpperCase());

		if (type == MovementType.OUT && produit.getQuantity() < dto.getQuantity()) {
			throw new StockInsufficientException("Stock insuffisant pour effectuer la sortie");
		}

		// mise à jour du stock
		if (type == MovementType.IN) {
			produit.setQuantity(produit.getQuantity() + dto.getQuantity());
		} else { // OUT
			produit.setQuantity(produit.getQuantity() - dto.getQuantity());
		}
		produitRepository.save(produit);

		String username = getCurrentUsername();
		// enregistrement du mouvement
		StockMovement movement = StockMovement.builder().product(produit).type(type).quantity(dto.getQuantity())
				.date(LocalDateTime.now()).username(username) // provisoire
				.build();

		StockMovement saved = stockMovementRepository.save(movement);
		return StockMovementMapper.toDto(saved);
	}

	@Transactional(readOnly = true)
	public List<StockMovementResponseDTO> getAllMovements() {
		return stockMovementRepository.findAll().stream().map(StockMovementMapper::toDto).toList();
	}

	@Transactional(readOnly = true)
	public List<StockMovementResponseDTO> getHistoryForProduct(long produitId) {
		return stockMovementRepository.findByProduct_ProduitIdOrderByDateDesc(produitId).stream()
				.map(StockMovementMapper::toDto).toList();
	}

	private String getCurrentUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return "system"; // ou null, selon ton choix
		}
		return authentication.getName();
	}
}
