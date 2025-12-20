package com.gestion_de_stock.stockmovement.mapper;

import com.gestion_de_stock.stockmovement.dto.StockMovementResponseDTO;
import com.gestion_de_stock.stockmovement.model.StockMovement;

public class StockMovementMapper {

	public static StockMovementResponseDTO toDto(StockMovement entity) {
		StockMovementResponseDTO dto = new StockMovementResponseDTO();
		dto.setMovementId(entity.getMovementId());
		dto.setProduitId(entity.getProduct().getProduitId());
		dto.setProductName(entity.getProduct().getName());
		dto.setType(entity.getType().name());
		dto.setQuantity(entity.getQuantity());
		dto.setDate(entity.getDate());
		dto.setUsername(entity.getUsername());
		return dto;
	}
}
