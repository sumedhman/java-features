package com.module2Example;

import java.math.BigDecimal;
import java.util.List;

import com.employee.Employee;
import com.employee.EmployeeData;

public class LambdaFunctionalInterfaceExample4 {
	@FunctionalInterface
	interface EmployeeFilter{
		boolean test(Employee employee);
	}	
	
	
	
	
		private static void printEmployees(List<Employee> employeeList,EmployeeFilter filter) {
			for(Employee employee:employeeList) {
				if(filter.test(employee)) {
					System.out.println(employee);
				}
			}
		}

		
public static void main(String arg[]) {
  List<Employee> employees = EmployeeData.getEmployee();
  BigDecimal salarylimit= new BigDecimal(12000);
   
  // salarylimit= new BigDecimal(12000); //you will get final or effectivaly final error
  printEmployees(employees,(Employee e)-> e.getSalary().compareTo((salarylimit))>0);
  
}
}