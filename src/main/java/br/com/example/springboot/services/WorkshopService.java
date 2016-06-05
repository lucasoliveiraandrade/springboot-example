package br.com.example.springboot.services;

import java.util.List;

import br.com.example.springboot.models.Workshop;

public interface WorkshopService {
	
	void addUpdate(Workshop workshop);

	List<Workshop> getAll();

	void deleteById(Long workshopId);

	void deleteAll();
}
