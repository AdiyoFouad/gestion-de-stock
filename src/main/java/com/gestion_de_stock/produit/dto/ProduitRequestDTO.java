package com.gestion_de_stock.produit.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProduitRequestDTO {

	@NotBlank(message = "Le nom du produit est obligatoire")
	private String name;

	@Positive(message = "Le prix doit être positif")
	private double price;

	// On ne reçoit QUE les IDs des catégories
	private Set<Long> categoryIds;
}
