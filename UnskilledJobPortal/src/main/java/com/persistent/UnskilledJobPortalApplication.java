package com.persistent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.persistent.entity.Categories;

@SpringBootApplication
public class UnskilledJobPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnskilledJobPortalApplication.class, args);
		System.out.println("Unskilled Job Portal Application Deployed Successfully!!!!");
		
		Categories c=new Categories(9,"carpenter");
	}

}
