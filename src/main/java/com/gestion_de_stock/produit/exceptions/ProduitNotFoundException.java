package com.gestion_de_stock.produit.exceptions;

public class ProduitNotFoundException extends RuntimeException {

	public ProduitNotFoundException(String message) {
		super(message);
	}

}
