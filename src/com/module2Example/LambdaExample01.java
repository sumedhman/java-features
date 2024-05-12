package com.module2Example;
import java.util.List;
import com.employee.Employee;
import com.employee.EmployeeData;

public class LambdaExample01 {

	public static void main(String[] args) {
		//print all employee -sorted by salary
		List<Employee> employees = EmployeeData.getEmployee();
		System.out.println("Employee List");
		
		for(Employee employee:employees) {
			System.out.println(employee);
		}
		
		//sort with old way
		/*employees.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee arg0, Employee arg1) {
				// TODO Auto-generated method stub
				return arg0.getSalary().compareTo(arg1.getSalary());
			}		
		});*/
		
		//the above 5 line of code replace with lambda expression bellow
	employees.sort((arg0,arg1)->arg0.getSalary().compareTo(arg1.getSalary()));
System.out.println("Employee List-sorted");
		
		for(Employee employee:employees) {
			System.out.println(employee);
		}

	}

}
