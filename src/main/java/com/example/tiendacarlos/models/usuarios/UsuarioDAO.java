package com.example.tiendacarlos.models.usuarios;


import com.example.tiendacarlos.util.HibernateUtil;
import org.hibernate.Session;
import org.jasypt.util.password.StrongPasswordEncryptor;

public class UsuarioDAO {

    private static StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

    public static UsuarioVO getUsuario(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UsuarioVO usuario = (UsuarioVO) session.get(UsuarioVO.class, id);
        session.getTransaction().commit();
        session.close();
        return usuario;
    }

    public static UsuarioVO login(String email , String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UsuarioVO usuario = (UsuarioVO) session.createQuery("FROM usuarios where email = :email",UsuarioVO.class).setParameter("email", email).uniqueResult();
        if(usuario != null && passwordEncryptor.checkPassword(password, usuario.getPassword())){
            session.close();
            return usuario;
        }else{
            System.out.println("Usuario no encontrado");
        }
        session.close();
        return null;
    }

    public static UsuarioVO register(UsuarioVO usuario) {
        usuario.setPassword(passwordEncryptor.encryptPassword(usuario.getPassword()));
       try{
           Session session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.save(usuario);
           session.getTransaction().commit();
           session.close();
           return usuario;
       }catch(Exception e){
           return null;
       }
    }


}
