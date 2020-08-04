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

import com.association.entity.Don;
import com.association.services.DonService;

@RestController
@RequestMapping("/api/don")
@CrossOrigin(origins = "*") 
public class DonController {

	private final Logger log = LoggerFactory.getLogger(DonController.class);
	@Autowired
	DonService donService;
	@Autowired
	DonService utilisateurService;
	@Autowired
	DonService associationService;

	@GetMapping("/get")
	public List<Don> getAllDons() {
		final List<Don> listDon = donService.getAll();
		return listDon;
	}

	@GetMapping("/get/{id}")
	public Don getDon(@PathVariable Long id) {
		log.info("REST request to get Don : {}", id);
		Don don = null;
		if (id != null)
			don = donService.getOne(id);
		return don;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteDon(@PathVariable Long id) {
		log.info("REST request to delete don: {}", id);
		boolean result = false;
		if (id != null)
			result = donService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Don createDon(@RequestBody Don don) throws URISyntaxException {
		log.info("REST request to save Don : {}", don);

		if (don.getId() != null) {
			log.info("A new don cannot already have an ID", "userManagement", "idexists");
		} else {
			Don newDon = donService.save(don);
			return newDon;
		}
		return null;
	}

	@PutMapping("/update")
	public Don updateDon(@RequestBody Don don) {
		log.info("REST request to update don : {}", don);
		if (don.getId() != null)
			if (donService.getOne(don.getId()) != null) {

				Don updatedDon = donService.save(don);
				return updatedDon;
			}
		return null;

	}

	@GetMapping("/{id_utilisateur}")
	public List<Don> getDons(@PathVariable("id") Long id) {
		log.info(" get don");
		List<Don> result = donService.getAllByUtilisateur(id);
		log.info("don :{}", result.toString());
		return result;
	}

	
	  @GetMapping("/{id_association}") 
	  public List<Don> getDonsAssociation(@PathVariable("id") Long id) { log.info(" get don"); 
	  List<Don> result = donService.getAllByAssociation(id); 
	  log.info("don :{}", result.toString());
	  return result;
	 
}}
