package pe.progra.tb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name = "nameUsuario", length = 50, nullable = false)
	private String nameUsuario;
	
	@Column(name = "lastnameUsuario", length = 50, nullable = false)
	private String lastnameUsuario;
	
	@NotNull
	@Past(message = "La fecha debe estar en el pasado")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateUsuario")
	private Date dateUsuario;
	
	@Column(name = "idAdministrador", nullable = true)
	private int idAdministrador;
	
	@Email
	@Column(name = "emailUsuario", nullable = false, length = 30)
	private String emailPowner;
	
	@Column(name = "passwordUsuario", nullable = false, length = 25)
	private String passwordUsuario;
	
	@OneToMany(mappedBy = "usuariopeli")
    Set<ResenaPelicula> resenapelicula;
	
	@OneToMany(mappedBy = "usuarioserie")
    Set<ResenaSerie> resenaserie;
	
	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNameUsuario() {
		return nameUsuario;
	}


	public void setNameUsuario(String nameUsuario) {
		this.nameUsuario = nameUsuario;
	}


	public String getLastnameUsuario() {
		return lastnameUsuario;
	}


	public void setLastnameUsuario(String lastnameUsuario) {
		this.lastnameUsuario = lastnameUsuario;
	}


	public Date getDateUsuario() {
		return dateUsuario;
	}


	public void setDateUsuario(Date dateUsuario) {
		this.dateUsuario = dateUsuario;
	}


	public int getIdAdministrador() {
		return idAdministrador;
	}


	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}


	public String getEmailPowner() {
		return emailPowner;
	}


	public void setEmailPowner(String emailPowner) {
		this.emailPowner = emailPowner;
	}


	public String getPasswordUsuario() {
		return passwordUsuario;
	}


	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}



	
	public Usuario(int idUsuario, String nameUsuario, String lastnameUsuario,Date dateUsuario, int idAdministrador,String emailPowner, String passwordUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nameUsuario = nameUsuario;
		this.lastnameUsuario = lastnameUsuario;
		this.dateUsuario = dateUsuario;
		this.idAdministrador = idAdministrador;
		this.emailPowner = emailPowner;
		this.passwordUsuario = passwordUsuario;
	}


	

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}

	
}





