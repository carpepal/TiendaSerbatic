package com.example.tiendacarlos.modelos.usuarios;


import com.example.tiendacarlos.modelos.rol.RolVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuarios")
@Table(name = "usuarios")
public class UsuarioVO {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL)
	private RolVO rol = new RolVO(2 , "user");
	private String email;
	@Column(name = "clave")
	private String password;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	private String provincia;
	private String localidad;
	private String telefono;
	private String dni;

	public UsuarioVO(String email, String password) {
		this.email = email;
		this.password = password;
	}


	

}
