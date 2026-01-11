package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.entity.Student;

import java.util.List;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return  runner-> {
			//createStudent(studentDAO);

			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);

		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//returns the list of students
		List<Student> theStudent = studentDAO.findByLastName("Popescu");

		//display list of students
		for (Student newStudent : theStudent){
			System.out.println(newStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get the list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for (Student newStudent : theStudents) {
			System.out.println(newStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a Student object
		System.out.println("Creating new student object ...");
		Student newStudent = new Student("Mircea","Popescu","mirceap@pixel.academy");

		//save the student in the database
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);

		//display the ID of the saved student
		int theId = newStudent.getId();
		System.out.println("Saved student. Genereated id: " + theId);

		//retrieve the student based on the ID (PK)
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display the student's details
		System.out.println("Found the student: " + myStudent);
	}

	private void createStudent(StudentDAO studentDAO){// create an object Student
		System.out.println("Creating new student object ...");
		Student newStudent = new Student("John", "Doe","john@pixelacademy.md");

		//save the Student object in the database using DAO
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);
		//display the saved student ID
		System.out.println("Saved student. Generated id:" + newStudent.getId());
	}
	
	private void createMultipleStudents(StudentDAO studentDAO) {
		//cream mai multi studenti
    	System.out.println("Creating 3 student objects ...");
		Student newStudent1 = new Student("Andrei","Munteanu","andrei@pixelacademy");
		Student newStudent2 = new Student("Iulia","Munteanu","andrei@pixelacademy");
		Student newStudent3 = new Student("Maira","Munteanu","andrei@pixelacademy");

		System.out.println("Saving the students ...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);
	}
	
	
}
