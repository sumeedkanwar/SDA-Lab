package Lab1;
import java.util.ArrayList;
import java.util.List;

class Professor {
private String name;

public Professor(String name) {
this.name = name;
}

public String getName() {
return name;
}
}

class Department {
private String name;
private List<Professor> professors;

public Department(String name) {
this.name = name;
this.professors = new ArrayList<>();
}

public void addProfessor(Professor professor) {
professors.add(professor);
}

public List<Professor> getProfessors() {
return professors;
}

public String getName() {
return name;
}
}

class University {
private List<Department> departments;

public University() {
this.departments = new ArrayList<>();
}

public void addDepartment(Department department) {
departments.add(department);
}

public List<Department> getDepartments() {
return departments;
}

// Simulating destruction of the university (composition)
public void closeUniversity() {
departments.clear();
}
}

class helloworld {
	public static void main(String[] args) {
		University university = new University();

		// Creating departments
		Department dept1 = new Department("Department of Computer Science");
		Department dept2 = new Department("Department of Software Engineering");

		// Adding professors to departments
		Professor prof1 = new Professor("Dr. Kashif Muneer");
		Professor prof2 = new Professor("Dr. Usman Habib");

		dept1.addProfessor(prof1);
		dept2.addProfessor(prof2);

		// Adding departments to the university
		university.addDepartment(dept1);
		university.addDepartment(dept2);

		// Displaying information before closing the university
		System.out.println("University Information:");
		for (Department department : university.getDepartments()) {
		System.out.println("Department: " + department.getName());
		for (Professor professor : department.getProfessors()) {
		System.out.println(" Professor: " + professor.getName());
		}
		}

		// Simulating the destruction of the university (composition)
		university.closeUniversity();

		// Displaying information after closing the university
		System.out.println("\nUniversity Information after closure:");
		System.out.println("Number of departments: " +
		university.getDepartments().size());
		}
		}