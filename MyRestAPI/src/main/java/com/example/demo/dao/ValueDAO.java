package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.MyExpression;
import com.example.demo.service.Value;

public class ValueDAO {
	
	@Autowired
	private Value value;
	private List<MyExpression> exp = new ArrayList<>();

	public ValueDAO() {
		value = new Value();

		value.setName("Value");
		value.setValue(0);
	}

	public Value calculateExpressionValue(String name, List<MyExpression> expList, Map<String, String> payload) {
		value = new Value();
		StringBuilder exp1 = new StringBuilder();
		for (MyExpression item : expList) {
			if (item.getName().equals(name)) {
				 exp1 = new StringBuilder(item.getExpression());
				break;
			}
		}

		value.setName("Value");
		value.setValue(calcExp(exp1.toString(),payload));
		return value;
	}
	
	public double calcExp(String str,Map<String, String> payload) {
		System.out.println("Exp : " + str);
		for (Map.Entry<String,String> entry : payload.entrySet()) {
			str = str.replace(entry.getKey(),entry.getValue());
		}
		double result=evaluate(str);
		System.out.println("String Value is : " + str);
		
		
		return result;
	}
	public static double evaluate(String expression)
	{
		char[] expCharArray = expression.toCharArray();

		Stack<Double> operand = new Stack<Double>();

		Stack<Character> operator = new Stack<Character>();

		for (int i = 0; i < expCharArray.length; i++)
		{
			if (expCharArray[i] == ' ')
				continue;
			if (expCharArray[i] >= '0' && expCharArray[i] <= '9')
			{
				StringBuffer strBuffer = new StringBuffer();

				while (i < expCharArray.length && expCharArray[i] >= '0' && expCharArray[i] <= '9')
					strBuffer.append(expCharArray[i++]);
				operand.push(Double.parseDouble(strBuffer.toString()));

				i--;
			}

			else if (expCharArray[i] == '(')
				operator.push(expCharArray[i]);

			else if (expCharArray[i] == ')')
			{
				while (operator.peek() != '(')
					operand.push(doSimpleCalculation(operator.pop(),operand.pop(),operand.pop()));
				operator.pop();
			}

			else if (expCharArray[i] == '+' || expCharArray[i] == '-' || expCharArray[i] == '*' || expCharArray[i] == '/')
			{
				while (!operator.empty() && checkPrecedence(expCharArray[i],operator.peek()))
					operand.push(doSimpleCalculation(operator.pop(),operand.pop(),operand.pop()));

				operator.push(expCharArray[i]);
			}
		}

		while (!operator.empty())
			operand.push(doSimpleCalculation(operator.pop(),operand.pop(),operand.pop()));

		return operand.pop();
	}

	public static boolean checkPrecedence(
			char a, char b)
	{
		if (b == '(' || b == ')')
			return false;
		if ((a == '*' || a == '/') &&
				(b == '+' || b == '-'))
			return false;
		else
			return true;
	}


	public static double doSimpleCalculation(char op,double b, double a)
	{
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new
				UnsupportedOperationException(
						"Cannot divide by zero");
			return a / b;
		}
		return 0;
	}
}
