package com.gestion_de_stock.category.dto;

import lombok.Data;

@Data
public class CategoryResponseDTO {

	private long categoryId;
	private String name;
	private String description;
}
