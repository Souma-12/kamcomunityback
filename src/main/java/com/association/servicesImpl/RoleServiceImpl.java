package com.association.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.association.entity.Role;
import com.association.repository.RoleRepository;
import com.association.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> getAll() {
		return roleRepository.findAll();

	}

	@Override
	public Role getOne(Long id) {
		if (id != null)
			return roleRepository.getOne(id);
		return new Role();
	}

	@Override
	public Role save(Role role) {
		if (role != null)
			return roleRepository.save(role);
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if (id != null) {
			roleRepository.deleteById(id);

		}
		if (roleRepository.getOne(id) == null) {
			return false;
		}
		return true;
	}

}
