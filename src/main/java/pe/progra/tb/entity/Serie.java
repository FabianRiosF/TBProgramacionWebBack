package pe.progra.tb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name="Serie")
public class Serie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSerie;
	
	@Column(name = "nameSerie", length = 100, nullable = false)
	private String nameSerie;
	
	@NotNull
	@Past(message = "La fecha debe estar en el pasado")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateSerie")
	private Date dateSerie;
	
	@ManyToMany (mappedBy = "Actor_Serie")
	Set<Actor> Actores;
	
	@ManyToMany (mappedBy = "Lista_Serie")
	Set<Lista> Listas;
	
	@OneToMany(mappedBy = "serie")
    Set<ResenaSerie> series;
	
	public int getIdSerie() {
		return idSerie;
	}


	public Set<Lista> getListas() {
		return Listas;
	}


	public void setListas(Set<Lista> listas) {
		Listas = listas;
	}


	public Set<ResenaSerie> getSeries() {
		return series;
	}


	public void setSeries(Set<ResenaSerie> series) {
		this.series = series;
	}


	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}


	public String getNameSerie() {
		return nameSerie;
	}


	public void setNameSerie(String nameSerie) {
		this.nameSerie = nameSerie;
	}


	public Date getDateSerie() {
		return dateSerie;
	}


	public void setDateSerie(Date dateSerie) {
		this.dateSerie = dateSerie;
	}


	public Set<Actor> getActores() {
		return Actores;
	}


	public void setActores(Set<Actor> actores) {
		Actores = actores;
	}
	
	
	

	public Serie(int idSerie, String nameSerie, Date dateSerie, Set<Actor> actores,
			Set<Lista> listas, Set<ResenaSerie> series) {
		super();
		this.idSerie = idSerie;
		this.nameSerie = nameSerie;
		this.dateSerie = dateSerie;
		Actores = actores;
		Listas = listas;
		this.series = series;
	}


	public Serie() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSerie;
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
		Serie other = (Serie) obj;
		if (idSerie != other.idSerie)
			return false;
		return true;
	}
	
}





