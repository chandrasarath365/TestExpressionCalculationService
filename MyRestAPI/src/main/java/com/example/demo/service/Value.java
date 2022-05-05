package com.example.demo.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class Value {

	private String name;
	private double value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Value [name=" + name + ", value=" + value + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, value);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Value other = (Value) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}
	
}
