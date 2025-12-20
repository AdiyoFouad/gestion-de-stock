package com.gestion_de_stock.category.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion_de_stock.category.dto.CategoryRequestDTO;
import com.gestion_de_stock.category.dto.CategoryResponseDTO;
import com.gestion_de_stock.category.exceptions.CategoryNotFoundException;
import com.gestion_de_stock.category.mapper.CategoryMapper;
import com.gestion_de_stock.category.model.Category;
import com.gestion_de_stock.category.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

	private final CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public List<CategoryResponseDTO> getAllCategories() {
		return categoryRepository.findAll().stream().map(CategoryMapper::toDto).toList();
	}

	@Transactional(readOnly = true)
	public CategoryResponseDTO getCategoryById(long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Catégorie inexistante"));
		return CategoryMapper.toDto(category);
	}

	public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {
		Category category = CategoryMapper.fromDto(dto);
		Category saved = categoryRepository.save(category);
		return CategoryMapper.toDto(saved);
	}

	public CategoryResponseDTO updateCategory(long id, CategoryRequestDTO dto) {
		Category existing = categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Catégorie inexistante"));
		CategoryMapper.updateEntityFromDto(dto, existing);
		Category saved = categoryRepository.save(existing);
		return CategoryMapper.toDto(saved);
	}

	public void deleteCategory(long id) {
		if (!categoryRepository.existsById(id)) {
			throw new CategoryNotFoundException("Suppression impossible : catégorie inexistante");
		}
		categoryRepository.deleteById(id);
	}
}
