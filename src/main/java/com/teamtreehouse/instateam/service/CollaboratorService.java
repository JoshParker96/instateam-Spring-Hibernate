package com.teamtreehouse.instateam.service;

import com.teamtreehouse.instateam.model.Collaborator;

import java.util.List;

public interface CollaboratorService {
    void saveCollaborator(Collaborator c);
    List<Collaborator> fetchAllCollaborators();
    void updateCollaborator(Collaborator c);
}
