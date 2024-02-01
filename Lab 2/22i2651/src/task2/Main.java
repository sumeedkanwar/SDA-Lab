package task2;

public class Main
{
	public static void main(String[] args)
	{
        Student student1 = new Student(1, "Sumeed", 20);
        Student student2 = new Student(2, "Rafay", 20);

        Course course1 = new Course("SDA01", "Software Design and Architecture");
        Course course2 = new Course("LSDA01", "Software Design and Architecture Lab");
        Course course3 = new Course("DB02", "Data Base");
        

        Enrollment enrollment1 = new Enrollment(course1);
        Enrollment enrollment2 = new Enrollment(course2);
        Enrollment enrollment3 = new Enrollment(course3);

        enrollment1.enrollStudent(student1);
        enrollment1.enrollStudent(student2);
        enrollment2.enrollStudent(student1);
        enrollment3.enrollStudent(student1);
        enrollment3.enrollStudent(student2);
        
        enrollment1.displayEnrolledStudents();
        enrollment2.displayEnrolledStudents();
        
        enrollment3.dropStudent(student1);

        enrollment3.displayEnrolledStudents();
    }

}
