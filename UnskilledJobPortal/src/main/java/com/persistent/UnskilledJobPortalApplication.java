package com.persistent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Unskilled Job Portal API", version = "1.0", description = "Jobs Information"))
public class UnskilledJobPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnskilledJobPortalApplication.class, args);
		System.out.println("Unskilled Job Portal Application Deployed Successfully!!!!");
	}

}
