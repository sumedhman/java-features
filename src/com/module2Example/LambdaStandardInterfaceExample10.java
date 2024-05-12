package com.module2Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import com.employee.Department;
import com.employee.Employee;
import com.employee.EmployeeData;

public class LambdaStandardInterfaceExample10 {
	 //practical implementation of standard interfaces-part 2 in java 1.8
	//Group employee by its department-function,consumers,Biconsumer use here
	
	//this is old style
/*static void employeeByDept(List<Employee> employees) {
	Map<Department,List<Employee>> employeeeByDept = new HashMap<>();
	for(Employee employee:employees) {
		if(!employeeeByDept.containsKey(employee.getDepartment())) {
			employeeeByDept.put(employee.getDepartment(),new ArrayList<Employee>());
		}
		employeeeByDept.get(employee.getDepartment()).add(employee);
	}
	//printing using the map
	for(Map.Entry<Department, List<Employee>> entry:employeeeByDept.entrySet()) {
		System.out.println("Department"+entry.getKey());
		for(Employee e:entry.getValue()) {
			System.out.println(e);
		}
	}
}*/
//functional approch
static void employeeByDeptFunctionalStyle(List<Employee> employees) {
	Map<Department,List<Employee>> employeeeByDept = new HashMap<>();
	
	employees.forEach(employee ->{
		Department department=employee.getDepartment();
		employeeeByDept.computeIfAbsent(department,d->new ArrayList<>()).add(employee);
	});
	
	//printing using the map
	employeeeByDept.forEach((department,employeeList)->{
		System.out.println("department"+department);
		employeeList.forEach(System.out::println);
	});
}


public static void main(String arg[]) {
 
	List<Employee> employees= EmployeeData.getEmployee();
	//employeeByDept(employees);
	employeeByDeptFunctionalStyle(employees);
}


}