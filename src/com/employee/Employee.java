package com.employee;

import java.math.BigDecimal;

public class Employee {
	private final String name;
	private final int age;
	private final Department department;
	private final BigDecimal salary;
	public Employee(String name, int age, Department department, BigDecimal salary) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Department getDepartment() {
		return department;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", department=" + department + ", salary=" + salary + "]";
	}
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	
  
}
