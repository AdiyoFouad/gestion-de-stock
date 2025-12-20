package com.gestion_de_stock.category.controller;

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

import com.gestion_de_stock.category.dto.CategoryRequestDTO;
import com.gestion_de_stock.category.dto.CategoryResponseDTO;
import com.gestion_de_stock.category.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;

	@GetMapping
	public List<CategoryResponseDTO> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@GetMapping("/{id}")
	public CategoryResponseDTO getCategoryById(@PathVariable long id) {
		return categoryService.getCategoryById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryResponseDTO createCategory(@Valid @RequestBody CategoryRequestDTO dto) {
		return categoryService.createCategory(dto);
	}

	@PutMapping("/{id}")
	public CategoryResponseDTO updateCategory(@PathVariable long id, @Valid @RequestBody CategoryRequestDTO dto) {
		return categoryService.updateCategory(id, dto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
	}
}
