package com.example.demo;

import com.example.demo.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
        System.out.println("Application Running....");


//        Employee student = new Employee(1L, "Abu Huzaifa" , "emai@gmai.com" );
//        System.out.println(student.getId());
//        System.out.println(student.getName());
//        System.out.println(student.getEmail());
	}

}
