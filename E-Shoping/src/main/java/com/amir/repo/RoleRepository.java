package com.amir.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amir.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRoleName(String roleName);

}
