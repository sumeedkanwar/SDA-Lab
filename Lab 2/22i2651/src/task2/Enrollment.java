package task2;

import java.util.ArrayList;

public class Enrollment
{
	ArrayList<Student> students;
    Course course;

    public Enrollment(Course course)
    {
        this.students = new ArrayList<>();
        this.course = course;
    }

    public void enrollStudent(Student student)
    {
        students.add(student);
    }

    public void dropStudent(Student student)
    {
        students.remove(student);
    }

    public void displayEnrolledStudents()
    {
        System.out.println(course.getCourseName() + ":");
        for (Student student : students)
        {
        	System.out.println("Id: " + student.getId());
        	
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
        }
    }
}
