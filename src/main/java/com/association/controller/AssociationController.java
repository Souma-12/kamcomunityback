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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.association.entity.Association;
import com.association.entity.Utilisateur;
import com.association.services.AssociationService;

@RestController
@RequestMapping("/api/association")
@CrossOrigin(origins = "*")
public class AssociationController {

	private final Logger log = LoggerFactory.getLogger(AssociationController.class);
	@Autowired
	AssociationService associationService;

	@GetMapping("/get")
	public List<Association> getAllAssociations() {
		final List<Association> listAssociation = associationService.getAll();
		return listAssociation;
	}

	@GetMapping("/get/{id}")
	public Association getAssociation(@PathVariable Long id) {
		log.info("REST request to get Association : {}", id);
		Association association = null;
		if (id != null)
			association = associationService.getOne(id);
		return association;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteAssociation(@PathVariable Long id) {
		log.info("REST request to delete association: {}", id);
		boolean result = false;
		if (id != null)
			result = associationService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Association createAssociation(@RequestBody Association association) throws URISyntaxException {
		//log.info("REST request to save association : {}", association);

		//if (association.getId_association() != null) {
			//log.info("A new association cannot already have an ID", "userManagement", "idexists");
	//	} else {
			Association newAssociation = associationService.save(association);
			return newAssociation;
		//}
		//return null;
	}

	@PutMapping("/update")
	public Association updateAssociation(@RequestBody Association association) {
		log.info("REST request to update candidat : {}", association);
		if (association.getId_association() != null)
			if (associationService.getOne(association.getId_association()) != null) {

				Association updatedAssociation = associationService.save(association);
				return updatedAssociation;
			}
		return null;

	}
	@PostMapping(value = "/uploadfile")
	public boolean handleFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam(value = "mail", required = true) String email,
			@RequestParam(value = "id", required = false) String id) {
		log.info("A new save file :{}, with email :{} ,and id :{} : {}", file.getOriginalFilename(), email, id);

		if (!file.isEmpty()) {
			try {
				Association association = associationService.getOne(Long.valueOf(id));
				association.setPhoto(file.getBytes());
				associationService.save(association);

				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	

}
