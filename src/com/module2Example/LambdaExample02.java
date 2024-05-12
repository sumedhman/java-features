package com.module2Example;

import java.math.BigDecimal;
import java.util.List;

import com.employee.Employee;
import com.employee.EmployeeData;

public class LambdaExample02 {
//print the salary whose salary is less than the salary limit
	
	/*	private static void printEmployees(List<Employee> employeeList,BigDecimal salaryLimit) {
			for(Employee employee:employeeList) {
				if(employee.getSalary().compareTo(salaryLimit)<0) {
					System.out.println(employee);
				}
			}
		}*/

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
		
//above 2 method/function has same code except one if condition, what if i write single piece of code
//and pass the parameter, that is what functional proggramming comes in to picture.see the example 3 with functional interface
public static void main(String arg[]) {
  List<Employee> employees = EmployeeData.getEmployee();
  //printEmployees(employees,new BigDecimal(12000));
   System.out.println("Less Than");
  printEmployeesLessThan(employees,new BigDecimal(12000));
  System.out.println("Gretter Than");
  printEmployeesGretterThan(employees,new BigDecimal(12000));
}
}