package com.gestion_de_stock.stockmovement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_de_stock.stockmovement.dto.StockMovementRequestDTO;
import com.gestion_de_stock.stockmovement.dto.StockMovementResponseDTO;
import com.gestion_de_stock.stockmovement.service.StockMovementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stocks")
@RequiredArgsConstructor
public class StockMovementController {

	private final StockMovementService stockMovementService;

	// Entrée de stock
	@PostMapping("/in")
	@ResponseStatus(HttpStatus.CREATED)
	public StockMovementResponseDTO createStockIn(@Valid @RequestBody StockMovementRequestDTO dto) {
		dto.setType("IN");
		// username sera plus tard récupéré via la sécurité (JWT)
		return stockMovementService.createMovement(dto, "system");
	}

	// Sortie de stock
	@PostMapping("/out")
	@ResponseStatus(HttpStatus.CREATED)
	public StockMovementResponseDTO createStockOut(@Valid @RequestBody StockMovementRequestDTO dto) {
		dto.setType("OUT");
		return stockMovementService.createMovement(dto, "system");
	}

	@GetMapping
	public List<StockMovementResponseDTO> getAllMovements() {
		return stockMovementService.getAllMovements();
	}

	// Historique des mouvements d'un produit
	@GetMapping("/history")
	public List<StockMovementResponseDTO> getHistory(@RequestParam long produitId) {
		return stockMovementService.getHistoryForProduct(produitId);
	}
}
