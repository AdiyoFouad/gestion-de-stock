package com.gestion_de_stock.produit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion_de_stock.produit.model.Produit;
import com.gestion_de_stock.produit.repository.ProduitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProduitService {

	private final ProduitRepository produitRepository;

	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return produitRepository.findAll();
	}

	public Produit createProduit(Produit p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}
}
