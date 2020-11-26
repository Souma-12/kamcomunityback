package com.association.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.association.entity.Don;
import com.association.entity.Utilisateur;
import com.association.services.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin(origins = "*")
public class UtilisateurController {

	private final Logger log = LoggerFactory.getLogger(UtilisateurController.class);
	@Autowired
	UtilisateurService utilisateurService;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@GetMapping("/get")
	public List<Utilisateur> getAllUtilisateur() {
		final List<Utilisateur> listUtilisateur = utilisateurService.getAll();
		return listUtilisateur;
	}

	@GetMapping("/get/{id}")
	public Utilisateur getUtilisateur(@PathVariable Long id) {
		log.info("REST request to get Utilisateur : {}", id);
		Utilisateur utilisateur = null;
		if (id != null)
			utilisateur = utilisateurService.getOne(id);
		return utilisateur;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteUtilisateur(@PathVariable Long id) {
		log.info("REST request to delete utilisateur: {}", id);
		boolean result = false;
		if (id != null)
			result = utilisateurService.delete(id);
		return result;
	}
	
	

	@PostMapping("/save")
	public Utilisateur postUtilisateur(@RequestBody Utilisateur utilisateur) {
		log.info("utilisateur :{}", utilisateur);
		utilisateur.setUsername(utilisateur.getEmail());
		utilisateur.setPassword(bcryptEncoder.encode(utilisateur.getPassword()));
		Utilisateur result = utilisateurService.save(utilisateur);
		log.info("utilisateur :{}", result.toString());
		return result;
	}
	
	
	@PutMapping("/update")
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		log.info("REST request to update Utilisateur : {}", utilisateur);
		if (utilisateur.getId_utilisateur() != null)
			if (utilisateurService.getOne(utilisateur.getId_utilisateur()) != null) {

				Utilisateur updatedUtilisateur = utilisateurService.save(utilisateur);
				return updatedUtilisateur;
			}
		return null;

	}

	@GetMapping(value = "/findByLogin/{login}")
	public Utilisateur findByLogin(@PathVariable("login") String login) {
		log.info("REST request to find Utilisateur by login : {}", login);
		Utilisateur utitlisateur = utilisateurService.findUtilisateurByEmail(login.toLowerCase());
		log.info("result request to fing Utilisateur by login : {}", utitlisateur);
		return utitlisateur;

	}


	@GetMapping(value = "/getAllAdmin")
	public List<Utilisateur> getAllAdmin() {
		log.info("REST request to find getAllAdmin  : {}");
		List<Utilisateur> utitlisateurs = utilisateurService.findAllAdmin();
		return utitlisateurs;

	}

	@PostMapping(value = "/uploadfile")
	public boolean handleFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam(value = "mail", required = true) String email) {
		log.info("A new save file :{}, with email :{}: {}", file.getOriginalFilename(), email);

		if (!file.isEmpty()) {
			try {
				Utilisateur utilisateur = utilisateurService.findByUsername(email);
				utilisateur.setPhoto(file.getBytes());
				utilisateurService.save(utilisateur);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	@GetMapping(value = "/getAllAdherent")
	public List<Utilisateur> getAllAdherent() {
		log.info("REST request to find getAllAdherent  : {}");
		List<Utilisateur> utitlisateurs = utilisateurService.findAllAdherent();
		return utitlisateurs;

	}

}
