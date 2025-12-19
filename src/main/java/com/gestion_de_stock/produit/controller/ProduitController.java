package com.gestion_de_stock.produit.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_de_stock.produit.dto.ProduitRequestDTO;
import com.gestion_de_stock.produit.dto.ProduitResponseDTO;
import com.gestion_de_stock.produit.service.ProduitService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {

	private final ProduitService produitService;

	@GetMapping("/all")
	public List<ProduitResponseDTO> getAllProduits() {
		return produitService.getAllProduits();
	}

	@GetMapping("/{id}")
	public ProduitResponseDTO getProduitById(@PathVariable long id) {
		return produitService.getProduitById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteProduitById(@PathVariable long id) {
		produitService.deleteProduitById(id);
	}

	@PutMapping("/{id}")
	public ProduitResponseDTO editProduit(@PathVariable long id, @Valid @RequestBody ProduitRequestDTO p) {
		return produitService.editProduit(id, p);
	}
}
