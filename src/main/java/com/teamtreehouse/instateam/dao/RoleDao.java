package com.teamtreehouse.instateam.dao;

import com.teamtreehouse.instateam.model.Role;

import java.util.List;

public interface RoleDao {
    void saveRole(Role role);
    List<Role> fetchAllRoles();
    void updateRole(Role role);
}
