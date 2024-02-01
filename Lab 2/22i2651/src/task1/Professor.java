package task1;

public class Professor extends Person {
	String[] courses = new String[5];
	int size = 0;
	
	
	
	public Professor(String name, String address) {
		super(name, address);
		// TODO Auto-generated constructor stub
	}

	public void addCourse(String name)
	{
		if (size >= 5)
		{
			System.out.println("Cannot teach more courses");
			return;
		}
		else
		{
			courses[size] = name;
			size++;
		}
	}
	
	public void removeCourse()
	{
		if (size <= 0)
		{
			System.out.println("No courses to remove");
			return;
		}
		else
		{
			size--;
		}
	}
	
	
}
