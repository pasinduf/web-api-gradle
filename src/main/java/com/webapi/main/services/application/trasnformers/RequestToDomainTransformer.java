package com.webapi.main.services.application.trasnformers;

import org.springframework.beans.BeanUtils;

import com.webapi.main.services.application.dto.CategoryRequest;
import com.webapi.main.services.domain.Category;

public class RequestToDomainTransformer {
	
	public static Category TransformCategoryRequestToDomain(CategoryRequest input) {
		Category category=new Category();
		BeanUtils.copyProperties(input, category);
		return category;
	}

}
