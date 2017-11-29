package com.teamtreehouse.instateam.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @NotNull
    @Size(min = 3, max = 100)
    private String description;

    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Role> rolesNeeded;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Collaborator> collaborators;

    // Default constructor for JPA
    public Project(){}

    public Project(ProjectBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.status = builder.status;
        this.rolesNeeded = builder.rolesNeeded;
        this.collaborators = builder.collaborators;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", rolesNeeded=" + rolesNeeded +
                ", collaborators=" + collaborators +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Role> getRolesNeeded() {
        return rolesNeeded;
    }

    public void setRolesNeeded(List<Role> rolesNeeded) {
        this.rolesNeeded = rolesNeeded;
    }

    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<Collaborator> collaborators) {
        this.collaborators = collaborators;
    }

    public static class ProjectBuilder {

        private int id;
        private String name;
        private String description;
        private String status;
        private List<Role> rolesNeeded;
        private List<Collaborator> collaborators;

        public ProjectBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ProjectBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProjectBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProjectBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        public ProjectBuilder withRolesNeeded(List<Role> rolesNeeded) {
            this.rolesNeeded = rolesNeeded;
            return this;
        }

        public ProjectBuilder withCollaborators(List<Collaborator> collaborators) {
            this.collaborators = collaborators;
            return this;
        }

        public Project build() {
            return new Project(this);
        }

    }

}
