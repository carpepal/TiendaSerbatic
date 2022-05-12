package com.example.tiendacarlos.modelos.productos;


import com.example.tiendacarlos.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO {
	
	public ProductoVO producto = null;

	public ProductoDAO(ProductoVO producto) {
		this.producto = producto;
	}
	
	public static ArrayList<ProductoVO> getProductos()  {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.clear();
			session.beginTransaction();
			ArrayList<ProductoVO> productos = (ArrayList<ProductoVO>) session.createQuery("select a from productos a").list();
			session.close();
			return productos;
		}catch(HibernateException e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static ProductoVO getProductoById(Integer id){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			ProductoVO producto = (ProductoVO) session.get(ProductoVO.class, id);
			session.close();
			return producto;
		}catch(HibernateException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static void insertProducto(ProductoVO producto) {

		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(producto);
			session.getTransaction().commit();
			session.close();
		}catch(HibernateException e){
			System.out.println(e.getMessage());
		}

	}
}
