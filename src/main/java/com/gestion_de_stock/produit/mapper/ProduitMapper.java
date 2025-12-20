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
		dto.setPrice(produit.getPrice());
		Set<String> categories = produit.getCategoryList().stream().map(Category::getName).collect(Collectors.toSet());
		dto.setCategories(categories);
		return dto;
	}

	public static void updateEntityFromDto(ProduitRequestDTO dto, Produit produit, Set<Category> categories) {
		produit.setName(dto.getName());
		produit.setPrice(dto.getPrice());
		produit.setCategoryList(categories);
	}
}
