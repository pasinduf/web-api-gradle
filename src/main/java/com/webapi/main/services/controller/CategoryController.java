package com.webapi.main.services.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.webapi.main.services.application.dto.CategoryRequest;
import com.webapi.main.services.application.dto.CategoryResponse;
import com.webapi.main.services.application.dto.EntityDeleteResponse;
import com.webapi.main.services.application.services.category.CategoryService;
import com.webapi.main.services.application.trasnformers.DomainToResponseTransformer;
import com.webapi.main.services.application.trasnformers.RequestToDomainTransformer;
import com.webapi.main.services.domain.Category;

@RestController
@RequestMapping("/services/category")
public class CategoryController extends BaseController{

	@Autowired
	private CategoryService service;
	
	//@Autowired
	  //private Argon2PasswordEncoder argon2PasswordEncoder;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody CategoryResponse createCategory(HttpServletRequest request, HttpServletResponse response,
	@RequestBody CategoryRequest createCategoryRQ) {
		
		//Category category= RequestToDomainTransformer.TransformCategoryRequestToDomain(createCategoryRQ);
		return DomainToResponseTransformer.TransformCategoryDomainToResponse(service.createCategory(RequestToDomainTransformer.TransformCategoryRequestToDomain(createCategoryRQ)));
	}
	
	@PutMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CategoryResponse updateCategory(HttpServletRequest request,HttpServletResponse response,
			@PathVariable("id") String id,@RequestBody CategoryRequest updateCategoryRQ){
		
		RequestToDomainTransformer.TransformCategoryRequestToDomain(updateCategoryRQ);
		Category updatedCategory=service.updateCategory(id, RequestToDomainTransformer.TransformCategoryRequestToDomain(updateCategoryRQ));
		return DomainToResponseTransformer.TransformCategoryDomainToResponse(updatedCategory);
	}
	
	@GetMapping(path = "/all", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<CategoryResponse> getAllActiveCategory(HttpServletRequest request,HttpServletResponse response){
		
		return DomainToResponseTransformer.TransformCategoryDomainToResponse(service.findAllCategory());
	}
	
	@GetMapping(path="/{id}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CategoryResponse getCategoryById(HttpServletRequest request,HttpServletResponse response,
			@PathVariable("id") String id) {
		return DomainToResponseTransformer.TransformCategoryDomainToResponse(service.findCategoryById(id));
	}
	
	
	@GetMapping(path="/description/{desc}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CategoryResponse getLatestCategoryByDescription(HttpServletRequest request,HttpServletResponse response,
			@PathVariable("desc") String desc) {
		return DomainToResponseTransformer.TransformCategoryDomainToResponse(service.findLatestCategoryByDescription(desc));
	}
	
	
	@DeleteMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody EntityDeleteResponse deleteCategory(HttpServletRequest request,HttpServletResponse response,
			@PathVariable("id") String id){
		service.deleteCategoryById(id);
		EntityDeleteResponse result=new EntityDeleteResponse();
		result.setStatus(true);
		return result;
	}
	
	
	
	@GetMapping(path="/validate/{term}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getText(HttpServletRequest request,HttpServletResponse response,
			@PathVariable("term") String term) {
		//return argon2PasswordEncoder.encode("12345");
		  String ANSWER_LABEL_LENGTH_REGEX="^[a-zA-Z]{3,100}$";
		  Assert.isTrue(term.matches(ANSWER_LABEL_LENGTH_REGEX), "invalid");
		  return "valid";
	}
	
	
}
