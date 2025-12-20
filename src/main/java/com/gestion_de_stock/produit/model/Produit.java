package com.gestion_de_stock.produit.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.gestion_de_stock.category.model.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue
	private long produitId;

	@Column(nullable = false)
	private String name;

	private String description;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private int quantity;

	@ManyToMany()
	@JoinTable(name = "produit_category", joinColumns = @JoinColumn(name = "produit_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categoryList;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
		updatedAt = createdAt;
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = LocalDateTime.now();
	}
}
