package luis.alfaro.prueba.service;

import java.util.List;
import java.util.Optional;
import luis.alfaro.prueba.model.Psicologo;

public interface iPsicologoService {
	
	public boolean insertar(Psicologo psicologo);
	public boolean modificar(Psicologo psicologo);
	public void eliminar(int idPsicologo);
	public Optional<Psicologo> listarId(int idPsicologo);
	List<Psicologo>listar();
	List<Psicologo>buscaNombrePsicologo(String nombrePsicologo);
	
}
