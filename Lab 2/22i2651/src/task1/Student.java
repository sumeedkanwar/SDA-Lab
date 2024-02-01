package task1;

public class Student extends Person {
	String[] courses = new String[30];
	Double[] grades = new Double[30];
	int size = 0;
	
	
	
	
	public Student(String name, String address) {
		super(name, address);
		// TODO Auto-generated constructor stub
	}

	public void addCourse(String name, Double grade)
	{
		if (size >= 30)
		{
			System.out.println("Cannot pick more courses");
			return;
		}
		else
		{
			courses[size] = name;
			grades[size] = grade;
			size++;
		}
	}
	
	public void printCourses()
	{
		for (int i = 0; i < size; i++)
		{
			System.out.println("Course " + i + " : " + courses[i]);
		}
	}
	
	public void averageGrade()
	{
		Double total = 0.0;
		for (int i = 0; i < size; i++)
		{
			total += grades[i];
		}
		
		total /= size;
		
		System.out.println("Average Grade: " + total);
	}

}
