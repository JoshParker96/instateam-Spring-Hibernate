package com.teamtreehouse.instateam.web;

import com.teamtreehouse.instateam.model.Project;
import com.teamtreehouse.instateam.model.Project.ProjectBuilder;
import com.teamtreehouse.instateam.model.Role;
import com.teamtreehouse.instateam.service.ProjectService;
import com.teamtreehouse.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private RoleService roleService;

    // Index of all projects (index of application)
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

        if(!model.containsAttribute("project")) {
            model.addAttribute("project", new Project());
        }

        model.addAttribute("action", "/project/create");
        model.addAttribute("heading", "Create Project");
        model.addAttribute("button", "add");
        return "edit_project";
    }

    // Project edit page
    @RequestMapping("/project/{id}/edit")
    public String projecEditPage(@PathVariable int id, Model model) {

        List<Role> roles = roleService.fetchAllRoles();
        model.addAttribute("roles", roles);

        if(!model.containsAttribute("project")) {
            model.addAttribute("project", projectService.findById(id));
        }

        model.addAttribute("action", String.format("/project/%s/edit", id));
        model.addAttribute("heading", "Edit Project");
        model.addAttribute("button", "update");
        return "edit_project";
    }

    // Project detail page
    @RequestMapping("/project/{id}")
    public String projecDetailPage(@PathVariable int id, Model model) {

        Project project = projectService.findById(id);
        model.addAttribute("project", project);
        return "project_detail";
    }

    // Projects collaborators page
    @RequestMapping("/project/collaborators")
    public String projectsCollaborators() {
        return "project_collaborators";
    }

    // Create project and redirect to index page
    @RequestMapping(value = "/project/create", method = RequestMethod.POST)
    public String createProject(@Valid Project project, BindingResult result, RedirectAttributes redirectAttributes) {

        if(result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.project", result);
            redirectAttributes.addFlashAttribute("project", project);
            return "redirect:/project/create";
        }

        projectService.saveProject(project);
        return "redirect:/";
    }

    // Update existing project and redirect to index page
    @RequestMapping(value = "/project/{id}/edit", method = RequestMethod.POST)
    public String editProject(@Valid Project project, BindingResult result, RedirectAttributes redirectAttributes) {

        if(result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.project", result);
            redirectAttributes.addFlashAttribute("project", project);
            return String.format("redirect:/project/%s/edit", project.getId());
        }

        projectService.updateProject(project);
        return "redirect:/";
    }


    // Assigning collaborator to project


    // Unassigning collaborator from project
}
