package upc.edu.pe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table (name="servicio")
public class Servicio implements Serializable{
	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicio;
	
	@Column(name = "nombreServicio", nullable = false, length =30)
	private String nombreServicio;
	
	
	@Column(name="costoServicio", nullable= false)
	private int costoServicio;
	
	@ManyToOne
	@JoinColumn(name="idEspecialidad", nullable = false)
	public Especialidad especialidad;

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Servicio(int idServicio, String nombreServicio, int costoServicio,
			upc.edu.pe.model.Especialidad especialidad) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.costoServicio = costoServicio;
		this.especialidad = especialidad;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public int getCostoServicio() {
		return costoServicio;
	}

	public void setCostoServicio(int costoServicio) {
		this.costoServicio = costoServicio;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	
}
