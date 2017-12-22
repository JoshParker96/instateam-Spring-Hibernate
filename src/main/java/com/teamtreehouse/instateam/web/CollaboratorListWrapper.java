package com.teamtreehouse.instateam.web;

import com.teamtreehouse.instateam.model.Collaborator;

import java.util.ArrayList;
import java.util.List;

public class CollaboratorListWrapper {

    private List<Collaborator> collaborators = new ArrayList<>();

    public CollaboratorListWrapper(List<Collaborator> collabs) {
        this.collaborators = collabs;
    }

    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<Collaborator> collabs) {
        this.collaborators = collabs;
    }
}
