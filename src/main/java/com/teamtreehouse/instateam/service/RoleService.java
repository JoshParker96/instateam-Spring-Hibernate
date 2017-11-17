package com.teamtreehouse.instateam.service;

import com.teamtreehouse.instateam.model.Role;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);
    List<Role> fetchAllRoles();
    void updateRole(Role role);
}
