package br.com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan		// procura automaticamente pelas classes gerenciadas pelo Spring (@Beans) nos diretorios abaixo deste
@SpringBootApplication		// @SpringBootApplication ja equivale a @Configuration, @EnableAutoConfiguration e @ComponentScan   
public class SpringbootExampleApplication {
	
	 public static void main(String[] args) {
        SpringApplication.run(SpringbootExampleApplication.class, args);
	 }
}