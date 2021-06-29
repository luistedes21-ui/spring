package upc.edu.pe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;


@Entity
@Table(name = "Reserva")
public class Reserva implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReserva;
	
	@Column(name = "descripcionReserva", nullable = false)
	private String descripcionReserva;
	
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaReserva;
	
	@ManyToOne
	@JoinColumn(name="idPsicologo", nullable = false)
	private Psicologo psicologo;	
	
	@ManyToOne
	@JoinColumn(name="idPaciente", nullable = false)
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="idServicio", nullable = false)
	private Servicio servicio;

	@Transient
	private String costoTotal;
	
	public Reserva() {
		super();
		
	}

	public Reserva(int idReserva, String descripcionReserva, Date fechaReserva, Psicologo psicologo, Paciente paciente,
			Servicio servicio) {
		super();
		this.idReserva = idReserva;
		this.descripcionReserva = descripcionReserva;
		this.fechaReserva = fechaReserva;
		this.psicologo = psicologo;
		this.paciente = paciente;
		this.servicio = servicio;
		this.costoTotal ="S/. "+ Double.toString(servicio.getCostoServicio()*1.18);
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getDescripcionReserva() {
		return descripcionReserva;
	}

	public void setDescripcionReserva(String descripcionReserva) {
		this.descripcionReserva = descripcionReserva;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Psicologo getPsicologo() {
		return psicologo;
	}

	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public String getCostoTotal() {
		return "S/. "+ Double.toString(servicio.getCostoServicio()*1.18);
	}

	public void setCostoTotal(String costoTotal) {
		this.costoTotal = costoTotal;
	}

}