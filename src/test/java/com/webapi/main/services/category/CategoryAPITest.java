package com.webapi.main.services.category;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.webapi.main.services.application.dto.CategoryRequest;
import com.webapi.main.services.application.services.category.CategoryService;
import com.webapi.main.services.domain.Category;
import com.webapi.main.services.platform.common.GlobalUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CategoryAPITest {

	@Autowired
	protected MockMvc mockMvc;
	
	@MockBean
	private CategoryService service;
	
	@Test
	public void testCreateCategory() throws Exception {
		
		CategoryRequest request =new CategoryRequest();
		request.setName("cate1");
		request.setDescription("desc");
		request.setDiscount(2);
		
		Category category=new Category();
		category.setId(UUID.fromString("a35dd460-4b29-4ca4-9ca3-f8874b7610a2").toString());
		category.setName(request.getName());
		category.setDescription(request.getDescription());
		category.setDiscount(request.getDiscount());
		
		Category categoryAfterAdd =new Category();
		//categoryAfterAdd.setId(UUID.fromString("a35dd460-4b29-4ca4-9ca3-f8874b7610a2").toString());
		categoryAfterAdd.setName(request.getName());
		categoryAfterAdd.setDescription(request.getDescription());
		categoryAfterAdd.setDiscount(request.getDiscount());
		categoryAfterAdd.setCreatedBy("admin");
		categoryAfterAdd.setCreatedDate(new Date());
		categoryAfterAdd.setLastModifiedBy("Nuwan");
		categoryAfterAdd.setLastModifiedDate(new Date());
		categoryAfterAdd.setDeleted(false);
		
		Mockito.when(service.createCategory(category)).thenReturn(categoryAfterAdd);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/services/category")
				.content(GlobalUtil.asJsonString(request))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
		//.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("cate1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.description").value("desc"));
				
		
	}
}
