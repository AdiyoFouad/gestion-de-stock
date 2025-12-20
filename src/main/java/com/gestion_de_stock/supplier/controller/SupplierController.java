package com.gestion_de_stock.supplier.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_de_stock.supplier.dto.SupplierRequestDTO;
import com.gestion_de_stock.supplier.dto.SupplierResponseDTO;
import com.gestion_de_stock.supplier.service.SupplierService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {

	private final SupplierService supplierService;

	@GetMapping
	public List<SupplierResponseDTO> getAllSuppliers() {
		return supplierService.getAllSuppliers();
	}

	@GetMapping("/{id}")
	public SupplierResponseDTO getSupplierById(@PathVariable long id) {
		return supplierService.getSupplierById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SupplierResponseDTO createSupplier(@Valid @RequestBody SupplierRequestDTO dto) {
		return supplierService.createSupplier(dto);
	}

	@PutMapping("/{id}")
	public SupplierResponseDTO updateSupplier(@PathVariable long id, @Valid @RequestBody SupplierRequestDTO dto) {
		return supplierService.updateSupplier(id, dto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSupplier(@PathVariable long id) {
		supplierService.deleteSupplier(id);
	}
}
