package com.gestion_de_stock.stockmovement.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class StockMovementResponseDTO {

	private long movementId;
	private long produitId;
	private String productName;
	private String type;
	private int quantity;
	private LocalDateTime date;
	private String username;
}
