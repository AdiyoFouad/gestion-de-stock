package com.gestion_de_stock.supplier.mapper;

import com.gestion_de_stock.supplier.dto.SupplierRequestDTO;
import com.gestion_de_stock.supplier.dto.SupplierResponseDTO;
import com.gestion_de_stock.supplier.model.Supplier;

public class SupplierMapper {

	public static SupplierResponseDTO toDto(Supplier entity) {
		SupplierResponseDTO dto = new SupplierResponseDTO();
		dto.setSupplierId(entity.getSupplierId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		return dto;
	}

	public static Supplier fromDto(SupplierRequestDTO dto) {
		return Supplier.builder().name(dto.getName()).email(dto.getEmail()).phone(dto.getPhone()).build();
	}

	public static void updateEntityFromDto(SupplierRequestDTO dto, Supplier entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
	}
}
