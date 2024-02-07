package task6;

public class Employee
{
	private String name;
    private double salary;

    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public void display()
    {
    	System.out.println("Name: " + name + ", Salary: " + salary);
    }

}
