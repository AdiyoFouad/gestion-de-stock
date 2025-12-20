package com.gestion_de_stock.produit.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion_de_stock.category.model.Category;
import com.gestion_de_stock.category.repository.CategoryRepository;
import com.gestion_de_stock.produit.dto.ProduitRequestDTO;
import com.gestion_de_stock.produit.dto.ProduitResponseDTO;
import com.gestion_de_stock.produit.exceptions.ProduitNotFoundException;
import com.gestion_de_stock.produit.mapper.ProduitMapper;
import com.gestion_de_stock.produit.model.Produit;
import com.gestion_de_stock.produit.repository.ProduitRepository;
import com.gestion_de_stock.supplier.exceptions.SupplierNotFoundException;
import com.gestion_de_stock.supplier.model.Supplier;
import com.gestion_de_stock.supplier.repository.SupplierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProduitService {

	private final ProduitRepository produitRepository;
	private final CategoryRepository categoryRepository;
	private final SupplierRepository supplierRepository;

	@Transactional(readOnly = true)
	public List<ProduitResponseDTO> getAllProduits() {
		// TODO Auto-generated method stub
		return produitRepository.findAll().stream().map(ProduitMapper::toDto).toList();
	}

	public ProduitResponseDTO createProduit(ProduitRequestDTO dto) {
		Set<Category> categories = categoryRepository.findAllById(dto.getCategoryIds()).stream()
				.collect(Collectors.toSet());

		Supplier supplier = null;
		if (dto.getSupplierId() != null) {
			supplier = supplierRepository.findById(dto.getSupplierId())
					.orElseThrow(() -> new SupplierNotFoundException("Fournisseur inexistant"));
		}

		Produit produit = ProduitMapper.fromDto(dto, categories, supplier);

		Produit saved = produitRepository.save(produit);
		return ProduitMapper.toDto(saved);
	}

	@Transactional(readOnly = true)
	public ProduitResponseDTO getProduitById(long id) {
		Optional<Produit> optionalProduit = produitRepository.findById(id);

		if (optionalProduit.isEmpty()) {
			throw new ProduitNotFoundException("Produit inexistant");
		}
		return ProduitMapper.toDto(optionalProduit.get());
	}

	public void deleteProduitById(long id) {
		Optional<Produit> optionalProduit = produitRepository.findById(id);

		if (optionalProduit.isEmpty()) {
			throw new RuntimeException("Suppression impossible : Produit inexistant");
		}
		produitRepository.delete(optionalProduit.get());

	}

	public ProduitResponseDTO editProduit(long id, ProduitRequestDTO dto) {
		Produit produitAModifier = produitRepository.findById(id)
				.orElseThrow(() -> new ProduitNotFoundException("Modification impossible"));

		Set<Category> categories = categoryRepository.findAllById(dto.getCategoryIds()).stream()
				.collect(Collectors.toSet());

		Supplier supplier = null;
		if (dto.getSupplierId() != null) {
			supplier = supplierRepository.findById(dto.getSupplierId())
					.orElseThrow(() -> new SupplierNotFoundException("Fournisseur inexistant"));
		}

		ProduitMapper.updateEntityFromDto(dto, produitAModifier, categories, supplier);

		Produit saved = produitRepository.save(produitAModifier);
		return ProduitMapper.toDto(saved);
	}

}
