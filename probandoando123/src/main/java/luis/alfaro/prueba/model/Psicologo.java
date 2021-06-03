package luis.alfaro.prueba.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="psicologo")
public class Psicologo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idPsicologo; 
	
	@Column(name="nombrePsicologo", length=60, nullable=false)
	private String nombrePsicologo;
	
	@Column(name="codigoCPSP",nullable=false)
	private long codigoCPSP;

	public Psicologo() {
	}

	public Psicologo(int idPsicologo, String nombrePsicologo, long codigoCPSP) {
		super();
		this.idPsicologo = idPsicologo;
		this.nombrePsicologo = nombrePsicologo;
		this.codigoCPSP = codigoCPSP;
	}

	public int getIdPsicologo() {
		return idPsicologo;
	}

	public void setIdPsicologo(int idPsicologo) {
		this.idPsicologo = idPsicologo;
	}

	public String getNombrePsicologo() {
		return nombrePsicologo;
	}

	public void setNombrePsicologo(String nombrePsicologo) {
		this.nombrePsicologo = nombrePsicologo;
	}

	public long getCodigoCPSP() {
		return codigoCPSP;
	}

	public void setCodigoCPSP(long codigoCPSP) {
		this.codigoCPSP = codigoCPSP;
	}
	
	
	
	
}
