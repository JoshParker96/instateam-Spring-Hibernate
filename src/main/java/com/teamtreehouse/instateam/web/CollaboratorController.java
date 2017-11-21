package com.teamtreehouse.instateam.web;

import com.teamtreehouse.instateam.model.Collaborator;
import com.teamtreehouse.instateam.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CollaboratorController {

    @Autowired
    private CollaboratorService collaboratorService;

    // Index of all collaborators
    @RequestMapping("/collaborators")
    public String listOfAllCollaborators(Model model) {
        List<Collaborator> collaborators = collaboratorService.fetchAllCollaborators();
        model.addAttribute("collaborator", collaborators);
        return "collaborators";
    }

    // Create collaborator
    @RequestMapping(value = "/collaborator/{collaborator}/create", method = RequestMethod.POST)
    public String createCollaborator(@PathVariable Collaborator collaborator) {
        collaboratorService.saveCollaborator(collaborator);
        return "redirect:/collaborators";
    }

    // Update existing collaborator
    @RequestMapping(value = "/collaborator/{collaborator}/update", method = RequestMethod.POST)
    public String updateCollaborator(@PathVariable Collaborator collaborator) {
        collaboratorService.updateCollaborator(collaborator);
        return "redirect:/collaborators";
    }
}
