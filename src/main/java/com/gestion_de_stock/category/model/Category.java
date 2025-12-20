package com.gestion_de_stock.category.model;

import java.util.HashSet;
import java.util.Set;

import com.gestion_de_stock.produit.model.Produit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;

	@Column(nullable = false, unique = true)
	private String name;

	private String description;

	@ManyToMany(mappedBy = "categoryList")
	@Builder.Default
	private Set<Produit> produitList = new HashSet<>();

}
