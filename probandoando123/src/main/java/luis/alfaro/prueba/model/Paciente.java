package luis.alfaro.prueba.model;

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
