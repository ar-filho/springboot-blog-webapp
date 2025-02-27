package com.arfilho.springboot_blog_webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringbootBlogWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogWebappApplication.class, args);

		Student student = new Student();
		student.setId(1);
		student.setName("John Doe");
		student.setEmail("john.doe@gmail.com");

		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getEmail());
	}
}
