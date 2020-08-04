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

import com.association.entity.Pays;
import com.association.services.PaysService;

@RestController
@RequestMapping("/api/pays")
@CrossOrigin(origins = "*")
public class PaysController {

	private final Logger log = LoggerFactory.getLogger(PaysController.class);
	@Autowired
	PaysService paysService;

	@GetMapping("/get")
	public List<Pays> getAllPays() {
		final List<Pays> listPays = paysService.getAll();
		return listPays;
	}

	@GetMapping("/get/{id}")
	public Pays getPays(@PathVariable Long id) {
		log.info("REST request to get Pays : {}", id);
		Pays pays = null;
		if (id != null)
			pays = paysService.getOne(id);
		return pays;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deletePays(@PathVariable Long id) {
		log.info("REST request to delete pays: {}", id);
		boolean result = false;
		if (id != null)
			result = paysService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Pays createPays(@RequestBody Pays pays) throws URISyntaxException {
		log.info("REST request to save pays : {}", pays);

	//	if (pays.getId() != null) {
		//	log.info("A new pays cannot already have an ID", "userManagement", "idexists");
		//} else {
			Pays newPays = paysService.save(pays);
			return newPays;
	//	}
		//return null;
	}

	

	@PutMapping("/update")
	public Pays updatePays(@RequestBody Pays pays) {
		log.info("REST request to update Pays : {}", pays);
		if (pays.getId() != null)
			if (paysService.getOne(pays.getId()) != null) {

				Pays updatedPays = paysService.save(pays);
				return updatedPays;
			}
		return null;

	}

}
