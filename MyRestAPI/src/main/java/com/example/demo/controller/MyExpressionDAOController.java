package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MyExpressionDAO;
import com.example.demo.service.MyExpression;
import com.example.demo.service.Value;

@RestController
public class MyExpressionDAOController {

	MyExpressionDAO expDao = new MyExpressionDAO();

	@RequestMapping(value="/api/v1/getData",method=RequestMethod.GET)
	public MyExpression getData() {
		MyExpression exp1 = new MyExpression();
		exp1.setName("calories");
		exp1.setExpression("4*Carbohydrates+9*Fat+4*Protein");
		return exp1;
	}

	@RequestMapping(value="/api/v1/getExpressions",method=RequestMethod.GET)
	public List<MyExpression> getExpression()
	{
		System.out.println("Get Expression called...");
		return expDao.getExpressions();
	}

	@RequestMapping(value="/api/v1/expressions",method=RequestMethod.POST)
	public MyExpression setExpression(@RequestBody MyExpression exp)
	{
		System.out.println("Create Expression called...");
		System.out.println("Exp is : " + exp);
		return expDao.create(exp);
	}

}
