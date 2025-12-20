package com.gestion_de_stock.supplier.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SupplierRequestDTO {

	@NotBlank(message = "Le nom du fournisseur est obligatoire")
	private String name;

	@NotBlank(message = "L'email du fournisseur est obligatoire")
	@Email(message = "L'email du fournisseur n'est pas valide")
	private String email;

	private String phone;
}
