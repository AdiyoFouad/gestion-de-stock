package com.gestion_de_stock.produit.model;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(int statut, String message, LocalDateTime timestamp, Map<String, String> errors) {

	// Constructeur pratique pour une erreur simple
	public ErrorResponse(int statut, String message) {
		this(statut, message, LocalDateTime.now(), null);
	}

	// Constructeur pour plusieurs erreurs (validation)
	public ErrorResponse(int statut, String message, Map<String, String> errors) {
		this(statut, message, LocalDateTime.now(), errors);
	}
}