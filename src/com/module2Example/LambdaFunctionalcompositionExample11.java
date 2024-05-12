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
//Fucntianl composition using the predicate
public class LambdaFunctionalcompositionExample11 {
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
   Predicate<Employee> isFinance=e->e.getDepartment().equals(Department.FINANCE);
   Predicate<Employee> isSalary=e->e.getSalary().compareTo(new BigDecimal(15000))<0;
   
  Optional<Employee>employee =findEmployee(employees,isFinance.and(isSalary));

}

}