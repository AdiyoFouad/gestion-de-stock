package com.gestion_de_stock.security.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

	@NotBlank(message = "Le nom d'utilisateur est obligatoire")
	private String username;

	@NotBlank(message = "Le mot de passe est obligatoire")
	private String password;

	// "ADMIN", "USER" ou "MANAGER"
	@NotBlank(message = "Le rôle est obligatoire")
	private String role;
}
