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

import com.association.entity.Association;
import com.association.entity.Don;
import com.association.entity.Utilisateur;
import com.association.services.AssociationService;
import com.association.services.DonService;
import com.association.services.UtilisateurService;
import com.association.utils.ApiConstants;
import com.association.utils.SumResponseByAssociation;
import com.association.utils.SumResponseByUser;

@RestController
@RequestMapping(path = ApiConstants.API + ApiConstants.DON)
@CrossOrigin(origins = "*")
public class DonController {

	private final Logger log = LoggerFactory.getLogger(DonController.class);

	@Autowired
	DonService donService;

	@Autowired
	UtilisateurService utilisateurService;

	@Autowired
	AssociationService associationService;

	@GetMapping(path = ApiConstants.GET)
	public List<Don> getAllDons() {
		final List<Don> listDon = donService.getAll();
		return listDon;
	}

	@GetMapping(path = ApiConstants.GET + ApiConstants.ID)
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
		Utilisateur user = utilisateurService.findByUsername(don.getUtilisateur().getEmail());
		if (don.getId() != null) {
			log.info("A new don cannot already have an ID", "userManagement", "idexists");
		} else {
			log.info("user.getAssociations().get(0) : {}", user.getAssociations().get(0));

			don.setAssociation(user.getAssociations().get(0));
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

	@GetMapping("/utilisateur/{id_utilisateur}")
	public List<Don> getDons(@PathVariable("id_utilisateur") Long id) {
		log.info(" get don");
		List<Don> result = donService.getAllByUtilisateur(id);
		log.info("don :{}", result.toString());
		return result;
	}

	@GetMapping("/association/{id_association}")
	public List<Don> getDonsAssociation(@PathVariable("id_association") Long id) {
		log.info(" get don");
		List<Don> result = donService.getAllByAssociation(id);
		log.info("don :{}", result.toString());
		return result;

	}

	@GetMapping("/association/somme/{id}")
	public SumResponseByAssociation getSommeDonsByAssociation(@PathVariable("id") Long id) {
		log.info(" get don");
		SumResponseByAssociation result = donService.SommeByAssociation(id);

		log.info("don :{}", result.toString());
		return result;

	}

	@GetMapping("/utilisateur/somme/{id}")
	public SumResponseByUser getSommeDonsByUtilisateur(@PathVariable("id") Long id) {
		log.info(" get don");
		SumResponseByUser result = donService.SommeByUtilisateur(id);
		log.info("don :{}", result.toString());
		return result;

	}

}
