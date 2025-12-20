package com.gestion_de_stock.stockmovement.exceptions;

public class StockInsufficientException extends RuntimeException {

	public StockInsufficientException(String message) {
		super(message);
	}
}
