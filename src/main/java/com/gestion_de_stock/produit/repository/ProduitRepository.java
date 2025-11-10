package com.gestion_de_stock.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion_de_stock.produit.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
