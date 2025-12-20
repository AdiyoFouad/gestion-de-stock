package com.gestion_de_stock.produit.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Data;

@Data
public class ProduitResponseDTO {

	private long produitId;
	private String name;
	private String description;
	private double price;
	private int quantity;

	// Noms des catégories (simple pour le client)
	private Set<String> categories;

	private Long supplierId;
	private String supplierName;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
