package com.module2Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import com.employee.Department;
import com.employee.Employee;
import com.employee.EmployeeData;

public class LambdaFunctionalcompositionPredicateExample12 {
	static Optional<Employee> findEmployee(List<Employee> employees,Predicate<Employee> predicate) {
		for(Employee empolyee:employees) {
			if(predicate.test(empolyee)) {
				return Optional.of(empolyee);
			}
		}
		return Optional.empty();
		
	}
public static void main(String arg[]) {
 	List<Employee> employees= EmployeeData.getEmployee();
 	String employeeName="rich";
 	Optional<Employee> employee= findEmployee(employees,e->e.getSalary().equals(employeeName));
 	
 	//this is the we are formating the salary. so that it will get proper message.
 	//employee.map(Employee::getSalary).map(salary->String.format("the salary of %s is $ %.2f%n",employeeName,salary)).ifPresent(System.out::println);
 	
 	//let me split the above line in to 2 function
 	
 	Function <Employee,BigDecimal> employeeToSalary= e->e.getSalary();
 	Function <BigDecimal,String> employeeToSalaryFormattedString= salary->String.format("the salary of %s is $ %.2f%n",employeeName,salary);
    
 	//combine above 2 function
 	employee.map(employeeToSalary).map(employeeToSalaryFormattedString).ifPresent(System.out::println);
 	
 	//but now i will create another function and pass above 2 function in in this this fucntion that is called functiona composition.
 	
 	Function<Employee,String> composeEmployeetoSalaryFormattedString = employeeToSalary.andThen(employeeToSalaryFormattedString);
 	employee.map(composeEmployeetoSalaryFormattedString).ifPresent(System.out::println); //for this comment the line no 40
 	
    //now instead of andThen() method , you can use the compose(). compose method work reversaly ie first take second arg and then first. see the bellow line
 	//Function<Employee,String> composeEmployeetoSalaryFormattedString = employeeToSalaryFormattedString.compose(employeeToSalary);
}

}