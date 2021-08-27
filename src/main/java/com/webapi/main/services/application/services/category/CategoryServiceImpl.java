package com.webapi.main.services.application.services.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.webapi.main.services.domain.Category;
import com.webapi.main.services.infrastructure.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository repository;
	
	@Override
	public Category createCategory(Category category) {		
		Category exist= repository.findByNameAndDeleted(category.getName(), false);
		Assert.isNull(exist,"Duplicate category -"+category.getName());
		return repository.save(category);
	}

	@Override
	public List<Category> findAllCategory() {
		return repository.findAllCategoryByDeleted(false);
	}

	@Override
	public Category findCategoryById(String id) {
		Category exist= repository.findByIdAndDeleted(id, false);
		Assert.notNull(exist,"No record found for id");
		return exist;
	}

	@Override
	public Category updateCategory(String id, Category category) {
		Category exist = repository.findByIdAndDeleted(id,false);
		Assert.notNull(exist,"No record found");
		if (category.getName() != null && !category.getName().trim().isEmpty()) {
			Category existName= repository.findByNameAndDeleted(category.getName(), false);		
			if(existName !=null) {
				Assert.isTrue(existName.getId().equals(exist.getId()), "Duplicate category -"+category.getName());
			}
			exist.setName(category.getName());
			exist.setDescription(category.getDescription());
			exist.setDiscount(category.getDiscount());
		}
		return repository.save(exist);
	}

	@Override
	public void deleteCategoryById(String id) {
		Category category= repository.findByIdAndDeleted(id, false);
		Assert.notNull(category,"No record found");
		category.setDeleted(true);
		repository.save(category);
	}

	@Override
	public Category findLatestCategoryByDescription(String description) {
		List<Category> exist= repository.findByDescriptionAndDeleted(description, false);
		Assert.isTrue(!exist.isEmpty(),"No record found for description- "+description);
		return repository.findFirstByDescriptionOrderByCreatedDateDesc(description);
	}
}
