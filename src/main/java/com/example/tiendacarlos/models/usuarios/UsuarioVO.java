package com.example.tiendacarlos.models.usuarios;


import com.example.tiendacarlos.models.rol.RolVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuarios")
@Table()
public class UsuarioVO implements Serializable {

	private static final long serialVersionUID = 3317107958460470841L;
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private int id;

	@JoinColumn(name = "id_rol"  , insertable = false , updatable = false , nullable = true)
	@ManyToOne(cascade = CascadeType.ALL )
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
