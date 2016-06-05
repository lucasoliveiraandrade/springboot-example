package br.com.example.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.springboot.models.Workshop;
import br.com.example.springboot.services.WorkshopService;

@RestController
@RequestMapping("/workshop/")
public class WorkshopController {

	@Autowired
	private WorkshopService workshopService;
	
	@RequestMapping(value="add-update", method=RequestMethod.POST, consumes="application/json")
	public void insertNew(@RequestBody Workshop workshop){
		workshopService.addUpdate(workshop);
	}
	
	@RequestMapping(value="get-all", method=RequestMethod.GET, produces="application/json")
	public List<Workshop> getAll(){
		return workshopService.getAll();
	}
	
	@RequestMapping(value="delete-all", method=RequestMethod.DELETE)
	public void deleteAll(){
		workshopService.deleteAll();
	}
	
	@RequestMapping(value="{workshopId}/delete", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable("workshopId") Long workshopId){
		workshopService.deleteById(workshopId);
	}
}
