package br.com.example.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.example.springboot.models.Workshop;

public interface WorkshopRepository extends CrudRepository<Workshop, Long> { 
	
}