package br.com.example.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.springboot.models.Workshop;
import br.com.example.springboot.repository.WorkshopRepository;
import br.com.example.springboot.services.WorkshopService;

@Service
public class WorkshopServiceImpl implements WorkshopService{

	@Autowired
	private WorkshopRepository workshopRepository; 
	
	@Override
	public void addUpdate(Workshop workshop) {
		workshopRepository.save(workshop);
	}

	@Override
	public List<Workshop> getAll() {
		return (List<Workshop>) workshopRepository.findAll();
	}

	@Override
	public void deleteById(Long workshopId) {
		workshopRepository.delete(workshopId);
	}

	@Override
	public void deleteAll() {
		workshopRepository.deleteAll();;
	}
}