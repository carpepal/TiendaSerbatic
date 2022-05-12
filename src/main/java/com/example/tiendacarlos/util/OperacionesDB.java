package com.example.tiendacarlos.util;//package modelos.operaciones;
//
//import java.sql.*;
//import java.util.ArrayList;
//
//import modelos.usuarios.UsuarioVO;
//import modelos.productos.ProductoVO;
//
//public class OperacionesDB {
//
//	private Connection con = null;
//	private String url = "jdbc:mysql://localhost:3306/tienda_curso?zeroDateTimeBehavior=convertToNull";
//
//	public OperacionesDB() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public boolean compareUserByUsername(UsuarioVO usuario) throws SQLException {
//		if (con == null)
//			getConnection();
//		PreparedStatement ps = con.prepareStatement("SELECT clave from usuarios where email=? ");
//		ps.setString(1, usuario.getEmail());
//		ps.setString(2, usuario.getPassword());
//		ResultSet rs = ps.executeQuery();
//		if (rs.next()) {
//			return rs.getString("clave").equals(usuario.getPassword());
//		}
//		return false;
//	}
//
//	public boolean registerUser(UsuarioVO newUser) throws SQLException {
//		if(con == null)getConnection();
//		PreparedStatement ps = con.prepareStatement("INSERT INTO usuarios(email , clave , nombre , apellido1 , apellido2"
//				+ ",direccion,provincia,localidad,telefono,dni) VALUES (?,?,?,?,?,?,?,?,?,?)");
//		ps.setString(1, newUser.getEmail());
//		ps.setString(2, newUser.getPassword());
//		ps.setString(3, newUser.getNombre());
//		ps.setString(4, newUser.getApellido1());
//		ps.setString(5, newUser.getApellido2());
//		ps.setString(6, newUser.getDirecion());
//		ps.setString(7, newUser.getProvincia());
//		ps.setString(8, newUser.getLocalidad());
//		ps.setString(9, newUser.getTelefono());
//		ps.setString(10, newUser.getDni());
//		boolean flag = ps.execute();
//		con.commit();
//		return flag;
//	}
//
//	public ArrayList<ProductoVO> getProducts() throws SQLException {
//		ArrayList<ProductoVO> productos = new ArrayList();
//		if (con == null)
//			getConnection();
//		PreparedStatement ps = con.prepareStatement("SELECT * from productos");
//		ResultSet rs = ps.executeQuery();
//		while (rs.next()) {
//			productos.add(new ProductoVO(rs.getInt("id"), rs.getString("descripcion"), rs.getString("nombre"),
//					rs.getDouble("impuesto"), rs.getFloat("precio"), rs.getInt("stock")));
//		}
//		return productos;
//	}
//
//	public ProductoVO getProductById(Integer id) throws SQLException {
//		ArrayList<ProductoVO> productos = new ArrayList();
//		if (con == null)
//			getConnection();
//		PreparedStatement ps = con.prepareStatement("SELECT * from productos where id=?");
//		ps.setInt(1, id);
//		ResultSet rs = ps.executeQuery();
//		if (rs.next()) {
//			return new ProductoVO(rs.getInt("id"), rs.getString("descripcion"), rs.getString("nombre"),
//					rs.getDouble("impuesto"), rs.getFloat("precio"), rs.getInt("stock"));
//		}
//		return null;
//	}
//
//	private void getConnection() {
//		try {
//			// cargo el driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			this.con = DriverManager.getConnection(url, "root", "");
//
//			con.setAutoCommit(false);
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} catch (ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//}
