package com.gestion_de_stock.produit.dto;

import java.util.Set;

import lombok.Data;

@Data
public class ProduitResponseDTO {

	private long produitId;
	private String name;
	private double price;

	// Noms des catégories (simple pour le client)
	private Set<String> categories;
}
