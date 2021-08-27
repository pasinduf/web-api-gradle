package com.webapi.main.services.application.trasnformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.webapi.main.services.application.dto.BaseEntityResponse;
import com.webapi.main.services.application.dto.CategoryResponse;
import com.webapi.main.services.domain.BaseEntity;
import com.webapi.main.services.domain.Category;

public class DomainToResponseTransformer {

	private static void copyBaseEntityFields(BaseEntityResponse target,BaseEntity input) {
		target.setId(input.getId());
	}
	
	public static CategoryResponse TransformCategoryDomainToResponse(Category category) {
		CategoryResponse response=new CategoryResponse();
		BeanUtils.copyProperties(category, response);
		copyBaseEntityFields(response, category);
		return response;
	}
	
	public static List<CategoryResponse> TransformCategoryDomainToResponse(List<Category> input){
		List<CategoryResponse> resultList=new ArrayList<CategoryResponse>();
		if(!input.isEmpty()) {
			input.stream().forEach(category->{
				CategoryResponse result= new CategoryResponse();
				BeanUtils.copyProperties(category, result);
				copyBaseEntityFields(result, category);
				resultList.add(result);
			});
		}
		return resultList;
	}
}
