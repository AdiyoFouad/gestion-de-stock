package com.gestion_de_stock.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion_de_stock.category.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
