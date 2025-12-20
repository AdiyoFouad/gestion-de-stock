package com.gestion_de_stock.supplier.model;

import java.util.HashSet;
import java.util.Set;

import com.gestion_de_stock.produit.model.Produit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long supplierId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	private String phone;

	@OneToMany(mappedBy = "supplier")
	@Builder.Default
	private Set<Produit> produits = new HashSet<>();
}
