package com.example.tiendacarlos.modelos.pedido;


import com.example.tiendacarlos.modelos.usuarios.UsuarioVO;
import com.example.tiendacarlos.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class PedidoDAO {

    public static void insert(PedidoVO pedido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(pedido);
        session.getTransaction().commit();
        session.close();
    }

    public static void update(PedidoVO pedido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(pedido);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(PedidoVO pedido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(pedido);
        session.getTransaction().commit();
        session.close();
    }

    public static PedidoVO getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        PedidoVO pedido = (PedidoVO) session.get(PedidoVO.class, id);
        session.close();
        return pedido;
    }

    public static List<PedidoVO> getAllPedidosbyUser(UsuarioVO usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PedidoVO> pedidos = session.createQuery("from pedidos where id_usuario = :id_usuario")
                .setParameter("id_usuario", usuario.getId()).list();
        session.close();
        return pedidos;
    }
}
