package com.example.tareas;

import com.example.tareas.model.Account;
import com.example.tareas.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class TareasApplication {



	public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);

		//System.out.println("hola");
	}
	@Bean
	public CommandLineRunner initData(AccountRepository accountRepository) {
		return args -> {
			// Validamos si ya existe para no duplicar en reinicios calientes
			if (accountRepository.count() == 0) {
				Account defaultAccount = new Account();
				defaultAccount.setAccountNumber("191-445588-01");
				defaultAccount.setBalance(2500.0);

				accountRepository.save(defaultAccount);
				System.out.println("Cajero automático inicializado: Cuenta de prueba creada con $2500.0");
			}
		};
	}
}
