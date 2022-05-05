package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MyExpressionDAO;
import com.example.demo.dao.ValueDAO;
import com.example.demo.service.MyExpression;
import com.example.demo.service.Value;

@RestController
public class ValueController {

	MyExpressionDAO expDao = new MyExpressionDAO();
	ValueDAO value = new ValueDAO();
	
	
	@RequestMapping(value="/api/v1/expressions/{name}/calculations",method=RequestMethod.POST)
	public Value calculateExpression(@PathVariable("name") String name,@RequestBody Map<String, String> payload)
	{
		return value.calculateExpressionValue(name,expDao.getExpressions(),payload);
	}
}
