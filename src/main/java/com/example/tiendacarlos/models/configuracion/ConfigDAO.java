package com.example.tiendacarlos.models.configuracion;

import com.example.tiendacarlos.util.HibernateUtil;
import org.hibernate.Session;

public class ConfigDAO {

    public static void insertar(ConfigVo config) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(config);
        session.getTransaction().commit();
        session.close();
    }
}
