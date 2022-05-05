package com.example.demo.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class MyExpression {

	private String name;
	private String expression;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	@Override
	public String toString() {
		return "MyExpression [name=" + name + ", expression=" + expression + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(expression, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyExpression other = (MyExpression) obj;
		return Objects.equals(expression, other.expression) && Objects.equals(name, other.name);
	}
	
}
