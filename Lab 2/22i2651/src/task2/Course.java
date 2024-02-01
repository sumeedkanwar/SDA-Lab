package task2;

public class Course
{
	String courseCode;
    String courseName;
    
	public Course(String courseCode, String courseName)
	{
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
	}
	
	public String getCourseCode()
	{
		return courseCode;
	}
	public void setCourseCode(String courseCode)
	{
		this.courseCode = courseCode;
	}
	public String getCourseName()
	{
		return courseName;
	}
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
    
    
}
