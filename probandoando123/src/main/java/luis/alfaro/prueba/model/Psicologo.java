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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigoCPSP ^ (codigoCPSP >>> 32));
		result = prime * result + idPsicologo;
		result = prime * result + ((nombrePsicologo == null) ? 0 : nombrePsicologo.hashCode());
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
		Psicologo other = (Psicologo) obj;
		if (codigoCPSP != other.codigoCPSP)
			return false;
		if (idPsicologo != other.idPsicologo)
			return false;
		if (nombrePsicologo == null) {
			if (other.nombrePsicologo != null)
				return false;
		} else if (!nombrePsicologo.equals(other.nombrePsicologo))
			return false;
		return true;
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
