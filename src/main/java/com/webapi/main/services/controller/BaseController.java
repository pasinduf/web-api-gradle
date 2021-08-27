package com.webapi.main.services.controller;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BaseController {

	private static final Logger logger=LoggerFactory.getLogger(BaseController.class);
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({IllegalArgumentException.class})
	public @ResponseBody Map<String,Object> handleIllegalArgumentException(IllegalArgumentException ex){
		logger.error(ex.getMessage(),ex);
		HashMap<String, Object> result=new HashMap<>();
		result.put("error", true);
		result.put("error_message",ex.getMessage());
		return result;
	}
}
