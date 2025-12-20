package com.gestion_de_stock.category.mapper;

import com.gestion_de_stock.category.dto.CategoryRequestDTO;
import com.gestion_de_stock.category.dto.CategoryResponseDTO;
import com.gestion_de_stock.category.model.Category;

public class CategoryMapper {

	public static CategoryResponseDTO toDto(Category entity) {
		CategoryResponseDTO dto = new CategoryResponseDTO();
		dto.setCategoryId(entity.getCategoryId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		return dto;
	}

	public static Category fromDto(CategoryRequestDTO dto) {
		return Category.builder().name(dto.getName()).description(dto.getDescription()).build();
	}

	public static void updateEntityFromDto(CategoryRequestDTO dto, Category entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
	}
}
