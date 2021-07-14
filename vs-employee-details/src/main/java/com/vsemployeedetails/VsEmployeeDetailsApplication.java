package com.vsemployeedetails;

import com.vsemployeedetails.entity.test.MyEntity;
import com.vsemployeedetails.entity.test.MyEntityDetails;
import com.vsemployeedetails.entity.test.MyEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class VsEmployeeDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VsEmployeeDetailsApplication.class, args);
	}

	@Bean
	public CommandLineRunner saveData(@Autowired MyEntityRepo repo) {
		return args -> {
			MyEntity myEntity = new MyEntity();
			myEntity.setName("VishabSingh");
			myEntity.setTransient3(10);
			myEntity.setTransient4(20);

			MyEntityDetails myEntityDetails = new MyEntityDetails();
			myEntityDetails.setMyEntity(myEntity);
			repo.save(myEntity);
		};
	}


}
