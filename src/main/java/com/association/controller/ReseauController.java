package com.association.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.association.entity.Reseau;
import com.association.services.ReseauService;

@RestController
@RequestMapping("/api/reseau")
@CrossOrigin(origins = "*")
public class ReseauController {

	private final Logger log = LoggerFactory.getLogger(ReseauController.class);

	@Autowired
	ReseauService reseauService;

	@GetMapping("/get")
	public List<Reseau> getAllReseau() {
		final List<Reseau> listReseau = reseauService.getAll();
		return listReseau;
	}

	@GetMapping("/get/{id}")
	public Reseau getReseau(@PathVariable Long id) {
		log.info("REST request to get Reseau : {}", id);
		Reseau reseau = null;
		if (id != null)
			reseau = reseauService.getOne(id);
		return reseau;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteReseau(@PathVariable Long id) {
		log.info("REST request to delete Reseau: {}", id);
		boolean result = false;
		if (id != null)
			result = reseauService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Reseau createReseau(@RequestBody Reseau reseau) throws URISyntaxException {
		//log.info("REST request to save reseau : {}", reseau);

	//	if (reseau.getId() != null) {
		//	log.info("A new reseau cannot already have an ID", "userManagement", "idexists");
		//} else {
			Reseau newReseau = reseauService.save(reseau);
			return newReseau;
		//}
		//return null;
	}

	@PutMapping("/update")
	public Reseau updateReseau(@RequestBody Reseau reseau) {
		log.info("REST request to update Reseau : {}", reseau);
		if (reseau.getId() != null)
			if (reseauService.getOne(reseau.getId()) != null) {

				Reseau updatedReseau = reseauService.save(reseau);
				return updatedReseau;
			}
		return null;

	}

}
