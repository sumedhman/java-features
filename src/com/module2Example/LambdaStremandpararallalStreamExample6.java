package com.module2Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.employee.Employee;
import com.employee.EmployeeData;

public class LambdaStremandpararallalStreamExample6 {
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
		//count the no. of employee which is salary less than salary limit
		/*private static int countEmployees(List<Employee> employeeList,EmployeeFilter filter) {
			List<Employee> filterEmoloyeeList =new ArrayList<Employee>();
			//employeeList.parallalStream().forEach(employee-> //if you increse the data in EmployeeData and try 2 to 3times then you will get the runtimeexception to remove the that see the next methods.
			employeeList.stream().forEach(employee->{
				if(filter.test(employee)) {
					filterEmoloyeeList.add(employee);
				}
			});
			return filterEmoloyeeList.size(); 
		}*/


		private static long countEmployees(List<Employee> employeeList,Predicate<Employee> employeePredicate) {
			List<Employee> filterEmoloyeeList =new ArrayList<Employee>();
			
		return	employeeList.parallelStream().filter(employeePredicate).count();
		/*	employeeList.parallelStream().forEach(employee->{
				if(filter.test(employee)) {
					filterEmoloyeeList.add(employee);
				}
			});
			return filterEmoloyeeList.size(); */
		}
public static void main(String arg[]) {
  List<Employee> employees = EmployeeData.getEmployee();
  BigDecimal salarylimit= new BigDecimal(12000);
   
  // salarylimit= new BigDecimal(12000); //you will get final or effectivaly final error
  printEmployees(employees,(Employee e)-> e.getSalary().compareTo((salarylimit))>0);
  System.out.println("Less Than");
  System.out.println(countEmployees(employees,(Employee e)-> e.getSalary().compareTo((salarylimit))<0));
  System.out.println("Gretter Than");
  System.out.println(countEmployees(employees,(Employee e)-> e.getSalary().compareTo((salarylimit))>0));

  
}
}