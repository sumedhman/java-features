package com.module2Example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.employee.Department;
import com.employee.Employee;
import com.employee.EmployeeData;

public class LambdaStandardInterfaceExample9 {
	
public static void main(String arg[]) {
  //practical implementation of standard interfaces-part 1 in java 1.8
//search employee and print the salary-Predicatem,function,consumers
  
	List<Employee> employees= EmployeeData.getEmployee();
	
	Optional<Employee> employee = findEmployee(employees,e->e.getName().equals("rich"));
	//old way approch
	/*if(employee.isPresent()) {
		System.out.println(employee.get().getSalary());
	}else {
		System.out.println("No employee is available in the data");
	}*/
	//functional way approch
	employee.map(e-> e.getSalary()).ifPresent(e->System.out.println(e));
	//employee.map(Employee::getSalary).ifPresent(System.out::println); //this is method reference
}

//predicate is help us to filter the data
//Optional is -it will not throw the null pointer exception
static Optional<Employee> findEmployee(List<Employee> employees,Predicate<Employee> predicate) {
	for(Employee empolyee:employees) {
		if(predicate.test(empolyee)) {
			return Optional.of(empolyee);
		}
	}
	return Optional.empty();
	
}

}