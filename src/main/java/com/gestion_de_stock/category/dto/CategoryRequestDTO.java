package com.gestion_de_stock.category.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequestDTO {

	@NotBlank(message = "Le nom de la catégorie est obligatoire")
	private String name;

	private String description;
}
