package com.example.one_to_one;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToOneApplication {

	private final StudentRepository studentRepository;
	private final AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args ->{
		 // owningSideOperation();

		//Inverse Side Operation

			// Save
//			Student student = Student.builder()
//					.studentName("Snigdha")
//					.studentEmail("sni@gmail.com")
////					.address(address)
//					.build();
//
//			Address address = Address.builder()
//					.city("BBSR")
//					.state("Odisha")
//					.country("IN")
//					.student(student)
//					.build();

//			student.setAddress(address);
//			addressRepository.save(address);

			// UPDATE
			Address existingAddress = addressRepository.findById(3).orElseThrow();
			existingAddress.setCity("Bangkok");
			existingAddress.setCountry("Thailand");

			Student existingAddressStudent = existingAddress.getStudent();
			existingAddressStudent.setStudentEmail("binaymuna7337@gmail.com");
			addressRepository.save(existingAddress);
		};
 	}

	 private void owningSideOperation(){
//		 Address address = Address.builder()
//				 .city("BBSR")
//				 .state("Odisha")
//				 .country("IN")
//				 .build();
//
//		 Student student = Student.builder()
//				 .studentName("Amrita")
//				 .studentEmail("amr@gmail.com")
//				 .address(address)
//				 .build();
//
//		 studentRepository.save(student); //because when we save owning side , inverse side should be present in the database

		 //1. Manually save Address Object then Save Student Object
//			addressRepository.save(address);
//			studentRepository.save(student);

		 //2. Use Cascading
//			studentRepository.save(student);

		 //UPDATE

//			Student existingStudent = studentRepository.findById(4).orElseThrow();
//			existingStudent.setStudentName("Subhra");
//			existingStudent.setStudentEmail("s1@gmail.com");
//			Address existingAddress = existingStudent.getAddress();
//			existingAddress.setCity("Bbs");
//			studentRepository.save(existingStudent);

		 //Remove
//			studentRepository.deleteById(4);

		 //Retrive
//			Student studentWithRoll5 = studentRepository.findById(5).orElseThrow();
//			System.out.println("Student Name:-"+studentWithRoll5.getStudentName());
//			System.out.println("Student Email:-"+studentWithRoll5.getStudentEmail());
//
//			Address studentWithRoll5Address = studentWithRoll5.getAddress();
//			System.out.println("Adress City:-"+studentWithRoll5Address.getCity());
//			System.out.println("Adress State:-"+studentWithRoll5Address.getState());
//			System.out.println("Adress Country:-"+studentWithRoll5Address.getCountry());
	 }
}
