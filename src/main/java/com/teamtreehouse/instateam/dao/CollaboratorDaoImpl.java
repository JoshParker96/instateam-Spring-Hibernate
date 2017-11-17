package com.teamtreehouse.instateam.dao;

import com.teamtreehouse.instateam.dao.CollaboratorDao;
import com.teamtreehouse.instateam.model.Collaborator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class CollaboratorDaoImpl implements CollaboratorDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveCollaborator(Collaborator c) {

        // Open sessionFactory
        Session session = sessionFactory.openSession();

        // Begin transaction
        session.beginTransaction();

        // Save Collaborator object
        session.save(c);

        // Commit transaction
        session.getTransaction().commit();

        // Close session
        session.close();
    }

    @Override
    public List<Collaborator> fetchAllCollaborators() {

        // Open SessionFactory
        Session session = sessionFactory.openSession();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Collaborator> query = builder.createQuery(Collaborator.class);

        // Specify criteria root
        query.from(Collaborator.class);

        // Execute query
        List<Collaborator> collaborators = session.createQuery(query).getResultList();

        // Close session
        session.close();

        return collaborators;
    }

    @Override
    public void updateCollaborator(Collaborator c) {

        // Open sessionFactory
        Session session = sessionFactory.openSession();

        // Begin Transaction
        session.beginTransaction();

        // Edit Collaborator Object
        session.update(c);

        // Commit transaction
        session.getTransaction().commit();

        // Close session
        session.close();
    }
}
