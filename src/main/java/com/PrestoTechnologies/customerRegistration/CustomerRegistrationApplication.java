package com.PrestoTechnologies.customerRegistration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.validation.constraints.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(

		info=@Info(
				title = "Customer registration Api",
				version = "1.0",
				description = "Customer registration Api documentation",
				contact = @Contact( email = "nehemiahkimutai32@gmail.com"),
				license = @License(name = "customer Api", url = "www.customerapi.com")
		          ),
		servers = @Server(url = "/")

                  )
public class CustomerRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRegistrationApplication.class, args);
	}

}
