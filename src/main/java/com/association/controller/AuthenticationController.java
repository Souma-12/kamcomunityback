package com.association.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.association.entity.Utilisateur;
import com.association.security.JwtTokenUtil;
import com.association.security.LoginRequest;
import com.association.security.LoginResponse;
import com.association.services.UtilisateurService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/authentification")
public class AuthenticationController {
	Logger log = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UtilisateurService utilisateurService;

	@PostMapping(value = "/login")
	public ResponseEntity<LoginResponse> authentification(@RequestBody LoginRequest loginUser)
			throws AuthenticationException {
		log.info("LoginRequest:{}", loginUser);

		try {
			final Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));

			log.info("Lossss:{}",authentication);

			final Utilisateur utilisateur = utilisateurService.findByUsername(loginUser.getUsername());
			log.info("utilisateur:{}", utilisateur);

			if (utilisateur != null) {
				final String token = jwtTokenUtil.generateToken(utilisateur);
				return new ResponseEntity<LoginResponse>(new LoginResponse(token, utilisateur.getUsername()),
						HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<LoginResponse>(new LoginResponse(null, null), HttpStatus.UNAUTHORIZED);

		}
		return new ResponseEntity<LoginResponse>(new LoginResponse(null, null), HttpStatus.UNAUTHORIZED);
	}

}
