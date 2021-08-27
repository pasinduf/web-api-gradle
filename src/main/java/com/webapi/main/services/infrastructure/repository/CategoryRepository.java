package com.webapi.main.services.infrastructure.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webapi.main.services.domain.Category;

public interface CategoryRepository extends MongoRepository<Category,String>{
	
	public Category findByNameAndDeleted(String name,boolean deleted);
	public List<Category> findAllCategoryByDeleted(boolean deleted);
	public Category findByIdAndDeleted(String id, boolean deleted);
	
    public List<Category> findByDescriptionAndDeleted(String description,boolean deleted);
	
	public Category findFirstByDescriptionOrderByCreatedDateDesc(String description);
}
