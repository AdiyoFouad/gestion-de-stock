package com.gestion_de_stock.produit.service;

import java.util.List;
import java.util.Optional;

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

	public Produit getProduitById(long id) {
		Optional<Produit> optionalProduit = produitRepository.findById(id);

		if (optionalProduit.isEmpty()) {
			throw new RuntimeException("Produit inexistant");
		}
		return optionalProduit.get();
	}

	public String deleteProduitById(long id) {
		Optional<Produit> optionalProduit = produitRepository.findById(id);

		if (optionalProduit.isEmpty()) {
			throw new RuntimeException("Suppression impossible : Produit inexistant");
		}
		produitRepository.delete(optionalProduit.get());

		return "Produit supprimé avec succès !";

	}

	public Produit editProduit(long id, Produit p) {

		Optional<Produit> optionalProduit = produitRepository.findById(id);

		if (optionalProduit.isEmpty()) {
			throw new RuntimeException("Modification impossible");
		}

		Produit produitAModifier = optionalProduit.get();

		produitAModifier.setName(p.getName());
		produitAModifier.setPrice(p.getPrice());

		return produitRepository.save(produitAModifier);
	}
}
