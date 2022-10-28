package com.example.mybootstrap.service;

import com.example.mybootstrap.repository.RoleRepository;
import com.example.mybootstrap.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    public Role getRole(String userRole) {
        return roleRepository.getRole(userRole);
    }

    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }

    @Transactional
    public void addRole(Role role) {
        roleRepository.addRole(role);
    }
}
