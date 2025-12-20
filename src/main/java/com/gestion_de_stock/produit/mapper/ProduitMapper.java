package com.gestion_de_stock.produit.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.gestion_de_stock.category.model.Category;
import com.gestion_de_stock.produit.dto.ProduitRequestDTO;
import com.gestion_de_stock.produit.dto.ProduitResponseDTO;
import com.gestion_de_stock.produit.model.Produit;
import com.gestion_de_stock.supplier.model.Supplier;

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

		if (produit.getSupplier() != null) {
			dto.setSupplierId(produit.getSupplier().getSupplierId());
			dto.setSupplierName(produit.getSupplier().getName());
		}

		return dto;
	}

	public static Produit fromDto(ProduitRequestDTO dto, Set<Category> categories, Supplier supplier) {
		return Produit.builder().name(dto.getName()).description(dto.getDescription()).price(dto.getPrice())
				.quantity(dto.getQuantity()).categoryList(categories).supplier(supplier).build();
	}

	public static void updateEntityFromDto(ProduitRequestDTO dto, Produit entity, Set<Category> categories,
			Supplier supplier) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setQuantity(dto.getQuantity());
		entity.setCategoryList(categories);
		entity.setSupplier(supplier);
	}
}
