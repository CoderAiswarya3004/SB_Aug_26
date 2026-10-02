package com.example.many_to_many;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToManyApplication {
	private final StudentRepository studentRepository;
	private final SubjectRepository subjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner()
	{
		return args -> {
//			oneWayBinding();

			Student student4 = Student.builder().studentName("Priya").studentEmail("priya@gmail.com").build();
			Student student5 = Student.builder().studentName("Ramesh").studentEmail("ramesh@gmail.com").build();
			Student student6 = Student.builder().studentName("Arpita").studentEmail("arpita@gmail.com").build();

			Subject subject5 = Subject.builder().subjectName("CSS").students(List.of(student4,student5)).build();
			Subject subject6 = Subject.builder().subjectName("HTML").students(List.of(student6,student5)).build();
			Subject subject7 = Subject.builder().subjectName("JavaScript").students(List.of(student4,student5)).build();

			student4.setSubjects(List.of(subject5,subject6));
			student5.setSubjects(List.of(subject7,subject5));
			student6.setSubjects(List.of(subject7,subject6));
			subjectRepository.saveAll(List.of(subject5,subject6,subject7));


			//Update
			subjectRepository.

		};

	}

	public void oneWayBinding(){
//SAVE
		Subject subject1 = Subject.builder().subjectName("C").build();
		Subject subject2 = Subject.builder().subjectName("C++").build();
		Subject subject3 = Subject.builder().subjectName("Java").build();
		Subject subject4 = Subject.builder().subjectName("Python").build();

		Student student1 = Student.builder()
				.studentName("Amit")
				.studentEmail("Amit@gmail.com")
				.subjects(List.of(subject1,subject2))
				.build();
		Student student2 = Student.builder()
				.studentName("Ankit")
				.studentEmail("ankit@gmail.com")
				.subjects(List.of(subject2,subject3))
				.build();
		Student student3 = Student.builder()
				.studentName("Raj")
				.studentEmail("raj@gmail.com")
				.subjects(List.of(subject4,subject3))
				.build();

		studentRepository.saveAll(List.of(student1,student2,student3));

//		update

//		Delete

//		Extract
		studentRepository.findAll().forEach(student -> {
			System.out.println("Student name is " + student.getStudentName() );

			student.getSubjects().forEach(subject -> {
				System.out.println(subject.getSubjectName());
			});
		});
	}
}
