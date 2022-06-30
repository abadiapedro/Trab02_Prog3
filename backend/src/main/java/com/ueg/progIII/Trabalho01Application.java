package com.ueg.progIII;

import com.ueg.progIII.model.Produto;
import com.ueg.progIII.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class Trabalho01Application {

	public static void main(String[] args) {
		SpringApplication.run(Trabalho01Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProdutoRepository produtoRepository) {
		return args -> {
			Produto produto = new Produto(null, "Arroz", new Date(2023 - 1900, Calendar.MAY, 24), 5.00, " Cristal");
			produto  = produtoRepository.save(produto);

			produto = new Produto(null, "Feijão", new Date(2025 - 1900, Calendar.NOVEMBER, 10), 1.00, "Barão");
			produto  = produtoRepository.save(produto);
		};
	}

}
