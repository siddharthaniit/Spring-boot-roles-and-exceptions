package com.selfJwt.repo;

import org.springframework.data.repository.CrudRepository;

import com.selfJwt.model.Roles;

public interface RolesRepo extends CrudRepository<Roles, Long> {
	public Roles findByRolesName(String rolesName);
}
