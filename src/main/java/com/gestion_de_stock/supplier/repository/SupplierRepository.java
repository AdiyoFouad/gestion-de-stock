package com.gestion_de_stock.supplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion_de_stock.supplier.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
