package com.association.services;

import java.util.List;

import com.association.entity.Role;

public interface RoleService {

	List<Role> getAll();

	Role getOne(Long id);

	Role save(Role Role);

	boolean delete(Long id);

}
