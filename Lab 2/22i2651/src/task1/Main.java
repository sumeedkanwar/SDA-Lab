package task1;

public class Main {
	public static void main(String[] args) {
		
		Student student = new Student("Sumeed", "DHA");
		student.addCourse("Maths", 100.0);
		student.addCourse("Computers", 0.0);
		student.printCourses();
		student.averageGrade();
		
		Professor professor = new Professor("Daniyal", "Abbotabad");
		professor.removeCourse();
		professor.addCourse("SDA");
		professor.addCourse("DB");
		professor.removeCourse();
		
		
	}
}
