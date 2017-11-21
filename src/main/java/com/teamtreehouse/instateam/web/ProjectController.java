package com.teamtreehouse.instateam.web;

import com.teamtreehouse.instateam.model.Project;
import com.teamtreehouse.instateam.model.Project.ProjectBuilder;
import com.teamtreehouse.instateam.model.Role;
import com.teamtreehouse.instateam.service.ProjectService;
import com.teamtreehouse.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private RoleService roleService;

    // Index page
    @RequestMapping("/")
    public String listOfProjects(Model model) {
        List<Project> projects = projectService.fetchAllProjects();
        model.addAttribute("projects", projects);
        return "index";
    }

    // Project create page
    @RequestMapping("/project/create")
    public String projectCreatePage(Model model) {
        List<Role> roles = roleService.fetchAllRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("project", new Project());
        return "edit_project";
    }

    // Project detail page
    @RequestMapping("/project/{projectId}")
    public String projecDetailPage(@PathVariable int id, Model model) {
        Project project = projectService.findById(id);
        model.addAttribute(project);
        return "project_detail";
    }

    // Create project and redirect to index page
    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public String createProject(Project project) {
        projectService.saveProject(project);
        return "redirect:/";
    }

    // Update existing project and redirect to index page
    @RequestMapping(value = "/project/{project}/update", method = RequestMethod.POST)
    public String updateProject(@PathVariable Project project ) {
        projectService.updateProject(project);
        return "redirect:/";
    }

    // Delete existing project and redirect to index page
    @RequestMapping(value = "/project/{project}/delete", method = RequestMethod.POST)
    public String deleteProject(@PathVariable Project project) {
        projectService.deleteProject(project);
        return "redirect:/";
    }

    // Add collaborator to project


    // Delete collaborator from project
}
