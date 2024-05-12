package com.module2Example;

import java.math.BigDecimal;
import java.util.List;

import com.employee.Employee;
import com.employee.EmployeeData;

public class LambdaFunctionalInterfaceExample3 {
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

		private static void printEmployeesLessThan(List<Employee> employeeList,BigDecimal salaryLimit) {
			for(Employee employee:employeeList) {
				if(employee.getSalary().compareTo(salaryLimit)<0) {
					System.out.println(employee);
				}
			}
		}
		
		private static void printEmployeesGretterThan(List<Employee> employeeList,BigDecimal salaryLimit) {
			for(Employee employee:employeeList) {
				if(employee.getSalary().compareTo(salaryLimit)>0) {
					System.out.println(employee);
				}
			}
		}
		
//so functional programming is remove the code duplicacy that is 2 function remove with one functional interface
public static void main(String arg[]) {
  List<Employee> employees = EmployeeData.getEmployee();
  //printEmployees(employees,new BigDecimal(12000));
   System.out.println("Less Than");
   printEmployees(employees,(Employee e)-> e.getSalary().compareTo(new BigDecimal(12000))<0);
  //printEmployeesLessThan(employees,new BigDecimal(12000));
  System.out.println("Gretter Than");
  //printEmployeesGretterThan(employees,new BigDecimal(12000));
  //implement the filter
  printEmployees(employees,(Employee e)-> e.getSalary().compareTo(new BigDecimal(12000))>0);
}
}