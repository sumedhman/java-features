package com.employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeData {
	public static final List<Employee> EMPLOYEE_LIST = Arrays.asList(
			new Employee("richarde",23,Department.DIGITAL,new BigDecimal(9000.00)),
			
			new Employee("richa",24,Department.DIGITAL,new BigDecimal(8000.00)),
			new Employee("rich",22,Department.DIGITAL,new BigDecimal(7000.00)),
			new Employee("ric",23,Department.DIGITAL,new BigDecimal(60000.00)),
			new Employee("richar",23,Department.DIGITAL,new BigDecimal(57000.00))
			
			);
    public static List<Employee> getEmployee(){
    	return new ArrayList<>(EMPLOYEE_LIST);
    }
}
