package com.module2Example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.employee.Employee;
import com.employee.EmployeeData;
public class LambdaExpressionExceptionHandlingExample7 {
//Handling Exception in java
//Use case -1 print the list of employee in file
	public static void main(String[] args) {
		//old way
	/*	List<Employee> employees= EmployeeData.getEmployee();
		try(FileWriter writer = new FileWriter("Employee_list.txt")) {  //try with resources
			for(Employee employee:employees) {
				writer.write(employee.toString()+"\n");
				
		//employees.forEach(e->writer.write(e.toString()+"\n"));
			}		
		}catch(Exception e) {
			System.err.println("An IO Exception occured"+e.getMessage());
		}
	} */

	/*List<Employee> employees= EmployeeData.getEmployee();
	try(FileWriter writer = new FileWriter("Employee_list.txt")) {  //try with resources			
	employees.forEach(e->{//when you write the lambda expression here, it will say sarround with try cathc
		//so we did but we can see that here we handle the IO exception 2 times . how to remove this redendency in the code
		try {
			writer.write(e.toString()+"\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	});
	}catch(IOException e) {
		System.err.println("An IO Exception occured"+e.getMessage());
	}
}*/
	
List<Employee> employees= EmployeeData.getEmployee();
	try(FileWriter writer = new FileWriter("Employee_list.txt")) {  //try with resources			
	employees.forEach(e->{try {
			writer.write(e.toString()+"\n");
		} catch (IOException e1) {  //this is way we can handle the Exception in lambda
			throw new RuntimeException(e1.getMessage());
		}
	});
	}catch(IOException e) {
		System.err.println("An IO Exception occured"+e.getMessage());
	}
}	
//now it up to you how which method u use for handling the exception in lambda becouse the code is incresing while using try and catch in the lambda expression
//you can use old approch ie for each or lambda expression	
}
