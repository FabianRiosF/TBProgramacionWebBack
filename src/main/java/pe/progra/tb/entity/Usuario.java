package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PR_MOTOR")
public class Motor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMotor;
    @Column(name = "nombreMotor", nullable = false, length = 50)
	private String nombreMotor;
	private Date fechaMotor;
	
	public Motor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Motor(int idMotor, String nombreMotor, Date fechaMotor) {
		super();
		this.idMotor = idMotor;
		this.nombreMotor = nombreMotor;
		this.fechaMotor = fechaMotor;
	}

	public int getIdMotor() {
		return idMotor;
	}

	public void setIdMotor(int idMotor) {
		this.idMotor = idMotor;
	}

	public String getNombreMotor() {
		return nombreMotor;
	}

	public void setNombreMotor(String nombreMotor) {
		this.nombreMotor = nombreMotor;
	}

	public Date getFechaMotor() {
		return fechaMotor;
	}

	public void setFechaMotor(Date fechaMotor) {
		this.fechaMotor = fechaMotor;
	}
	
	
	
	
}
