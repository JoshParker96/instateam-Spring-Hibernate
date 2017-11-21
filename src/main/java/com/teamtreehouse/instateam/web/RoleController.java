package com.teamtreehouse.instateam.web;

import com.teamtreehouse.instateam.model.Role;
import com.teamtreehouse.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Index of all roles
    @RequestMapping("/roles")
    public String listOfAllRoles(Model model) {
        List<Role> roles = roleService.fetchAllRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("role", new Role());
        return "roles";
    }

    // Create role
    @RequestMapping(value = "/role/create", method = RequestMethod.POST)
    public String createRole(Role role) {
        roleService.saveRole(role);
        return "redirect:/roles";
    }

    // Update existing role
    @RequestMapping(value = "/role/{role}/update", method = RequestMethod.POST)
    public String updateRole(@PathVariable Role role) {
        roleService.updateRole(role);
        return "redirect:/roles";
    }
}
