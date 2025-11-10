package com.gestion_de_stock.produit.service;

import org.springframework.stereotype.Service;

import com.gestion_de_stock.produit.repository.ProduitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProduitService {

	private ProduitRepository produitRepository;
}
