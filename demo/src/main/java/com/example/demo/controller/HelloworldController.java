package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody//because whatever data is coming from the java object is converted into json
/*so it tells a controller that the object returned is automatically serialized into JSON and 
 passed back into the HttpResponse Object we can use*/


@RestController/*controller+responsebody*/
public class HelloworldController {
//now creating a RESTAPI is easy we have to create a method and on that we use spring annotation to make it RestAPI
	//HTTP GET Request
	@GetMapping("/hello-world")
	public String HelloWorld(){
		return "Hello world";//If i run and on browser access http://localhost:8080/hello-world i should see hello world
	}
}
//Returning simple text to the client