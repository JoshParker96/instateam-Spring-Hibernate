package com.teamtreehouse.instateam.dao;

import com.teamtreehouse.instateam.dao.RoleDao;
import com.teamtreehouse.instateam.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findById(int id) {

        Session session = sessionFactory.openSession();

        Role role = session.get(Role.class, id);

        return role;
    }

    @Override
    public void saveRole(Role role) {

        // Open sessionFactory
        Session session = sessionFactory.openSession();

        // Begin transaction
        session.beginTransaction();

        // Save Role object
        session.save(role);

        // Commit transaction
        session.getTransaction().commit();

        // Close session
        session.close();
    }

    @Override
    public List<Role> fetchAllRoles() {

        // Open SessionFactory
        Session session = sessionFactory.openSession();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Role> query = builder.createQuery(Role.class);

        // Specify criteria root
        query.from(Role.class);

        // Execute query
        List<Role> Roles = session.createQuery(query).getResultList();

        // Close session
        session.close();

        return Roles;
    }

    @Override
    public void updateRole(Role role) {

        // Open sessionFactory
        Session session = sessionFactory.openSession();

        // Begin transaction
        session.beginTransaction();

        // Update Role Object
        session.update(role);

        // Commit transaction
        session.getTransaction().commit();

        // Close session
        session.close();
    }
}
