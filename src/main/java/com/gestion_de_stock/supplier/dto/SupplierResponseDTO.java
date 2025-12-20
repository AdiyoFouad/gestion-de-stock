package com.gestion_de_stock.supplier.dto;

import lombok.Data;

@Data
public class SupplierResponseDTO {

	private long supplierId;
	private String name;
	private String email;
	private String phone;
}
