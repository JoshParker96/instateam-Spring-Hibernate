package com.teamtreehouse.instateam.web;

import com.teamtreehouse.instateam.model.Project;
import com.teamtreehouse.instateam.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @RequestMapping("/")
    public String listOfProjects(ModelMap modelMap) {
        List<Project> projects = projectService.fetchAllProjects();
        modelMap.put("project", projects);
        return "index";
    }
}
