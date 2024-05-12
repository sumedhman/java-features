package com.module2Example;

import java.math.BigDecimal;
import java.util.List;

import com.employee.Department;
import com.employee.Employee;
import com.employee.EmployeeData;

public class LambdaMethodReferenceExample8 {
public static void main(String arg[]) {
  List<Employee> employees = EmployeeData.getEmployee();
  //employees.forEach(e->System.out.println(e));
  employees.forEach(System.out::println); //this is method reference
  
  //we can apply the method reference to static method,constructor and instance methods
  //static method
  employees.removeIf(LambdaMethodReferenceExample8::isOverPaid);  
  
//method refernce to functional interface
  EmployeeFactory factory= Employee::new;
  Employee employee=factory.create("richarde",23,Department.DIGITAL,new BigDecimal(9000.00));
  
}

static boolean isOverPaid(Employee employee) {
	
	return employee.getSalary().compareTo(new BigDecimal(12000))>0;	
}

@FunctionalInterface
interface EmployeeFactory{
	Employee create(String name, int age,Department department,BigDecimal salary);
}
}