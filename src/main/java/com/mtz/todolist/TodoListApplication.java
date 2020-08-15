package com.mtz.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan
public class TodoListApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
		System.out.println("SENHA CRIPTOGRAFADA     " + new BCryptPasswordEncoder().encode("456"));
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
