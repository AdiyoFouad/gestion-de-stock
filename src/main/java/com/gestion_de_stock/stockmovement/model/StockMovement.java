package com.gestion_de_stock.stockmovement.model;

import java.time.LocalDateTime;

import com.gestion_de_stock.produit.model.Produit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockMovement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movementId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "produit_id")
	private Produit product;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MovementType type; // IN / OUT

	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false)
	private LocalDateTime date;

	// On mettra plus tard un lien vers User (quand la sécurité sera en place)
	private String username; // temporaire, ou à remplacer par une entité User
}
