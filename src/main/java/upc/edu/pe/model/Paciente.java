package upc.edu.pe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Paciente")
public class Paciente implements Serializable{
	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idPaciente;
	
	@Column(name="namePaciente", nullable=false, length=30)
	private String nombrePaciente;
	
	@Column(name="apellidoPaciente", nullable=false, length=30)
	private String apellidoPaciente;
	
	@Column(name="edadPaciente", nullable=false, length=30)
	private int edadPaciente;
	
	@Column(name="dniPaciente", nullable=false, length=30)
	private int dniPaciente;
	
	public Paciente() {
		super();
		
	}

	public Paciente(int idPaciente, String nombrePaciente, String apellidoPaciente, int edadPaciente, int dniPaciente) {
		super();
		this.idPaciente = idPaciente;
		this.nombrePaciente = nombrePaciente;
		this.apellidoPaciente = apellidoPaciente;
		this.edadPaciente = edadPaciente;
		this.dniPaciente = dniPaciente;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getApellidoPaciente() {
		return apellidoPaciente;
	}

	public void setApellidoPaciente(String apellidoPaciente) {
		this.apellidoPaciente = apellidoPaciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoPaciente == null) ? 0 : apellidoPaciente.hashCode());
		result = prime * result + dniPaciente;
		result = prime * result + edadPaciente;
		result = prime * result + idPaciente;
		result = prime * result + ((nombrePaciente == null) ? 0 : nombrePaciente.hashCode());
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
		Paciente other = (Paciente) obj;
		if (apellidoPaciente == null) {
			if (other.apellidoPaciente != null)
				return false;
		} else if (!apellidoPaciente.equals(other.apellidoPaciente))
			return false;
		if (dniPaciente != other.dniPaciente)
			return false;
		if (edadPaciente != other.edadPaciente)
			return false;
		if (idPaciente != other.idPaciente)
			return false;
		if (nombrePaciente == null) {
			if (other.nombrePaciente != null)
				return false;
		} else if (!nombrePaciente.equals(other.nombrePaciente))
			return false;
		return true;
	}

	public int getEdadPaciente() {
		return edadPaciente;
	}

	public void setEdadPaciente(int edadPaciente) {
		this.edadPaciente = edadPaciente;
	}

	public int getDniPaciente() {
		return dniPaciente;
	}

	public void setDniPaciente(int dniPaciente) {
		this.dniPaciente = dniPaciente;
	}
	
}
