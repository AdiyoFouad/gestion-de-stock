package com.gestion_de_stock.stockmovement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StockMovementRequestDTO {

	@NotNull(message = "L'identifiant du produit est obligatoire")
	private Long produitId;

	@NotNull(message = "Le type de mouvement est obligatoire")
	private String type; // "IN" ou "OUT"

	@Min(value = 1, message = "La quantité doit être au moins 1")
	private int quantity;
}
