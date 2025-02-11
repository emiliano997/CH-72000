package com.coderhouse.jpa_practica.services;

import com.coderhouse.jpa_practica.entities.Cliente;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoFactory {
    private final SessionFactory sessionFactory;

    @Autowired
    public DaoFactory(EntityManagerFactory factory) {
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public void create(Object obj) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
    }

    public void update(Object obj) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(obj);
        session.getTransaction().commit();
    }

    public void delete(Object obj) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.remove(obj);
        session.getTransaction().commit();
    }

    public Cliente getCliente(long id) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Cliente cliente = (Cliente) session.get(Cliente.class, id);
        session.getTransaction().commit();
        return cliente;
    }
}
