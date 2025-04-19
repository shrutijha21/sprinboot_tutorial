package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Student;

@RestController
public class StudentController {
	//Returning Java beans(objects) in JSON to client at http://localhost:8080/student
	@GetMapping("student")
	public Student getStudent() {
        Student student = new Student(1, "Shruti", "Jha");
        return student;
    }
	
	
	//Returning List of Students in separate Java beans in JSON to client at http://localhost:8080/studentList
	@GetMapping("studentList")
	public List<Student> getStudents(){
		List<Student> students=new ArrayList<>();
		students.add(new Student(1,"Shruti","Jha"));
		students.add(new Student(2,"Shrey","Jha"));
		students.add(new Student(3,"Shanu","Kumar"));
		return students;
	}
	
	
	//SpringBoot RESTAPI with Path Variable
	//{id}: url template variable.
	@GetMapping("students/{id}")
	public Student studentPathVariable(@PathVariable int id) {
		//whenever i want to bind the url template variable to the method we use @PathVariable
		return new Student(id,"Shruti","Jha");
	}
	
	
//	@GetMapping("students/{id}")
//	public Student studentPathVariable(@PathVariable("id") int studentId) {
//	//id we change the parameter argument name and we have to bind url variable to a id with different name then 
	//we use this @Pathvariable("url template variable name")
//		return new Student(studentId,"Shruti","Jha");
//	}
	
	
	@GetMapping("students/{id}/{first-name}/{last-name}")
	public Student studentPathVariable2(@PathVariable("id") int id,
			@PathVariable("first-name")String firstName,
			@PathVariable("last-name")String lastName) {
		//This removes the hardcoded values
		return new Student(id,firstName,lastName);
	}
	
	
//SpringBoot RESTAPI with REQUESTPARAM --> @RequestParam
//Sometimes we get a url with  request param like this: http://localhost:8080/studentRequest?id=1  -->id=1this is called querry parameter
//to handle this we do:
	@GetMapping("studentRequest")
	public Student studentRequestVariable(@RequestParam int id ) {
		return new Student(id,"Shrey","Jha");
	}
	
	//how to handle multiple querry parameter?
	//http://localhost:8080/studentRequest?id=1&firstName=Benu&lastName=Jha
	@GetMapping("studentRequest2")
	public Student studentRequestVariable2(@RequestParam int id,
			@RequestParam String firstName,
			@RequestParam String lastName) {
		//This removes the hardcoded values
		return new Student(id,firstName,lastName);
	}
	
	

	//Springboot REST API that handle http Post Request:
	
	//we use Springboot RequestBody and PostMapping request:
	@PostMapping("postStudent")
	public Student createStudent(@RequestBody Student student) {
		//@requestbody converts json(http requestbody)to java object
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	@PostMapping("post/{id}")
	public Student createStudent2(@PathVariable int id,@RequestBody Student student) {
		student.setId(id);
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
}


