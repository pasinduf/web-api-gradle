package com.webapi.main.services.application.services.category;

import java.util.List;

import com.webapi.main.services.domain.Category;

public interface CategoryService {
	
	public Category createCategory(Category category);
	public Category updateCategory(String id,Category category);
	public List<Category> findAllCategory();
	public Category findCategoryById(String id);
	public void deleteCategoryById(String id);
	
	public Category findLatestCategoryByDescription(String description);
}

