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

import com.association.entity.Role;
import com.association.services.RoleService;

@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins = "*")
public class RoleController {

	private final Logger log = LoggerFactory.getLogger(RoleController.class);
	@Autowired
	RoleService roleService;

	@GetMapping("/get")
	public List<Role> getAllRole() {
		final List<Role> listRole = roleService.getAll();
		return listRole;
	}

	@GetMapping("/get/{id}")
	public Role getRole(@PathVariable Long id) {
		log.info("REST request to get Role : {}", id);
		Role role = null;
		if (id != null)
			role = roleService.getOne(id);
		return role;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteRole(@PathVariable Long id) {
		log.info("REST request to delete role: {}", id);
		boolean result = false;
		if (id != null)
			result = roleService.delete(id);
		return result;
	}

	@PostMapping("/save")
	public Role createRole(@RequestBody Role role) throws URISyntaxException {
		log.info("REST request to save Role : {}", role);

		if (role.getId() != null) {
			log.info("A new pays cannot already have an ID", "userManagement", "idexists");
		} else {
			Role newRole = roleService.save(role);
			return newRole;
		}
		return null;
	}

	@PutMapping("/update")
	public Role updateRole(@RequestBody Role role) {
		log.info("REST request to update Role : {}", role);
		if (role.getId() != null)
			if (roleService.getOne(role.getId()) != null) {

				Role updatedRole = roleService.save(role);
				return updatedRole;
			}
		return null;

	}

}
