package com.gestion_de_stock.produit.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_de_stock.produit.model.Produit;
import com.gestion_de_stock.produit.service.ProduitService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {

	private final ProduitService produitService;

	@GetMapping("/all")
	public List<Produit> getAllProduits() {
		return produitService.getAllProduits();
	}

	@PostMapping("/add")
	public Produit createProduit(@RequestBody Produit p) {
		return produitService.createProduit(p);
	}
}
