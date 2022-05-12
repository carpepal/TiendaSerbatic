package com.example.tiendacarlos.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Proporciona un objeto de la clase SessionFactory para ser utilizado con Hibernate
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory configureSessionFactory() throws HibernateException {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) sessionFactory = configureSessionFactory();
        return sessionFactory;
    }
}
