package com.example.mybootstrap.repository;

import com.example.mybootstrap.model.Role;
import java.util.List;

public interface RoleRepository {

    List<Role> getAllRoles();

    Role getRole(String userRole);

    Role getRoleById(Long id);

    void addRole(Role role);
}
