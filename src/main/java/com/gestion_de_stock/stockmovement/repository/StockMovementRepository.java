package com.gestion_de_stock.stockmovement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion_de_stock.stockmovement.model.StockMovement;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

	List<StockMovement> findByProduct_ProduitIdOrderByDateDesc(long produitId);
}
