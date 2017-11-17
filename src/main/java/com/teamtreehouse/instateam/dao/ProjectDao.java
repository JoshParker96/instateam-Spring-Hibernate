package com.teamtreehouse.instateam.dao;

import com.teamtreehouse.instateam.model.Project;

import java.util.List;

public interface ProjectDao {
    void saveProject(Project project);
    List<Project> fetchAllProjects();
    void updateProject(Project project);
    void deleteProject(Project project);
}
