package task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Sumeed", 1000000.0));
        employeeList.add(new Employee("Ubaid", 100000.0));
        employeeList.add(new Employee("Rafay", 500000.0));
        employeeList.add(new Employee("Huzaifa", 250000.0));
        
        Collections.sort(employeeList, Comparator.comparingDouble(Employee::getSalary));
        
        System.out.println("Employee List:");
        for (Employee employee : employeeList)
        {
        	employee.display();
        }
	}
}
