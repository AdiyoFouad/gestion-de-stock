package com.gestion_de_stock.supplier.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion_de_stock.supplier.dto.SupplierRequestDTO;
import com.gestion_de_stock.supplier.dto.SupplierResponseDTO;
import com.gestion_de_stock.supplier.exceptions.SupplierNotFoundException;
import com.gestion_de_stock.supplier.mapper.SupplierMapper;
import com.gestion_de_stock.supplier.model.Supplier;
import com.gestion_de_stock.supplier.repository.SupplierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplierService {

	private final SupplierRepository supplierRepository;

	@Transactional(readOnly = true)
	public List<SupplierResponseDTO> getAllSuppliers() {
		return supplierRepository.findAll().stream().map(SupplierMapper::toDto).toList();
	}

	@Transactional(readOnly = true)
	public SupplierResponseDTO getSupplierById(long id) {
		Supplier supplier = supplierRepository.findById(id)
				.orElseThrow(() -> new SupplierNotFoundException("Fournisseur inexistant"));
		return SupplierMapper.toDto(supplier);
	}

	public SupplierResponseDTO createSupplier(SupplierRequestDTO dto) {
		Supplier supplier = SupplierMapper.fromDto(dto);
		Supplier saved = supplierRepository.save(supplier);
		return SupplierMapper.toDto(saved);
	}

	public SupplierResponseDTO updateSupplier(long id, SupplierRequestDTO dto) {
		Supplier existing = supplierRepository.findById(id)
				.orElseThrow(() -> new SupplierNotFoundException("Fournisseur inexistant"));
		SupplierMapper.updateEntityFromDto(dto, existing);
		Supplier saved = supplierRepository.save(existing);
		return SupplierMapper.toDto(saved);
	}

	public void deleteSupplier(long id) {
		if (!supplierRepository.existsById(id)) {
			throw new SupplierNotFoundException("Suppression impossible : fournisseur inexistant");
		}
		supplierRepository.deleteById(id);
	}
}
