package com.gestion_de_stock.produit.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.gestion_de_stock.category.model.Category;
import com.gestion_de_stock.produit.dto.ProduitRequestDTO;
import com.gestion_de_stock.produit.dto.ProduitResponseDTO;
import com.gestion_de_stock.produit.model.Produit;

public class ProduitMapper {

	public static ProduitResponseDTO toDto(Produit produit) {
		ProduitResponseDTO dto = new ProduitResponseDTO();
		dto.setProduitId(produit.getProduitId());
		dto.setName(produit.getName());
		dto.setDescription(produit.getDescription());
		dto.setPrice(produit.getPrice());
		dto.setQuantity(produit.getQuantity());
		dto.setCreatedAt(produit.getCreatedAt());
		dto.setUpdatedAt(produit.getUpdatedAt());

		Set<String> categories = produit.getCategoryList().stream().map(Category::getName).collect(Collectors.toSet());
		dto.setCategories(categories);

		return dto;
	}

	public static Produit fromDto(ProduitRequestDTO dto, Set<Category> categories) {
		return Produit.builder().name(dto.getName()).description(dto.getDescription()).price(dto.getPrice())
				.quantity(dto.getQuantity()).categoryList(categories).build();
	}

	public static void updateEntityFromDto(ProduitRequestDTO dto, Produit produit, Set<Category> categories) {
		produit.setName(dto.getName());
		produit.setDescription(dto.getDescription());
		produit.setPrice(dto.getPrice());
		produit.setQuantity(dto.getQuantity());
		produit.setCategoryList(categories);
	}
}
