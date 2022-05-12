package com.example.tiendacarlos.modelos.menu;


import com.example.tiendacarlos.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class OpcionesMenuDAO {

    public static List<OpcionesMenuVO> getOpcionesMenu() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<OpcionesMenuVO> lista = session.createQuery("from opciones_menu ").list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }
}
