package com.teamtreehouse.instateam.dao;

import com.teamtreehouse.instateam.dao.ProjectDao;
import com.teamtreehouse.instateam.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Project findById(int id) {
        Session session = sessionFactory.openSession();
        Project project = session.get(Project.class, id);
        session.close();
        return project;
    }

    @Override
    public void saveProject(Project project) {

        // Open sessionFactory
        Session session = sessionFactory.openSession();

        // Begin transaction
        session.beginTransaction();

        // Save Project object
        session.save(project);

        // Commit transaction
        session.getTransaction().commit();

        // Close session
        session.close();
    }

    @Override
    public List<Project> fetchAllProjects() {

        // Open SessionFactory
        Session session = sessionFactory.openSession();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Project> query = builder.createQuery(Project.class);

        // Specify criteria root
        query.from(Project.class);

        // Execute query
        List<Project> projects = session.createQuery(query).getResultList();

        // Close session
        session.close();

        return projects;
    }

    @Override
    public void updateProject(Project project) {

        // Open a sessionFactory
        Session session = sessionFactory.openSession();

        // Begin transaction
        session.beginTransaction();

        // Update Project object
        session.update(project);

        // Commit transaction
        session.getTransaction().commit();

        // Close session
        session.close();

    }

    @Override
    public void deleteProject(Project project) {

        // Open sessionFactory
        Session session = sessionFactory.openSession();

        // Being transaction
        session.beginTransaction();

        // Delete Project object
        session.delete(project);

        // Commit transaction
        session.getTransaction().commit();

        // Close session
        session.close();
    }
}
