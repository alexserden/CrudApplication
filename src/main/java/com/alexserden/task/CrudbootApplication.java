package com.alexserden.task;

import com.alexserden.task.model.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alexserden.task.repository.CustomerRepository;
import com.alexserden.task.model.User;
import com.alexserden.task.repository.UserRepository;

@SpringBootApplication
public class CrudbootApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CrudbootApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner demo(CustomerRepository repository, UserRepository urepository) {
		return (args) -> {
			//create customers
			repository.save(new Customer("Alexander", "Ivanov", "Java Developer"));
			repository.save(new Customer("Mark", "Yonil", "PhpDeveloper"));
			repository.save(new Customer("Danil", "Prytko", "RubyDeveloper"));
			repository.save(new Customer("Vladimir", "Fokin", "C#Developer"));
			repository.save(new Customer("Diana", "Gnatenko", "C++Developer"));


			// Create users with BCrypt encoded password (user/user, admin/admin)
			User user = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User admin = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
			urepository.save(user);
			urepository.save(admin);
		};
	}
}
