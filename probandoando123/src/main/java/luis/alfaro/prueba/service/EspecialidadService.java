package luis.alfaro.prueba.service;

import java.util.List;
import java.util.Optional;

import luis.alfaro.prueba.model.Especialidad;


public interface EspecialidadService {
	
	public boolean insertar(Especialidad especialidad);
	public boolean modificar (Especialidad especialidad);
	public void eliminar(int idEspecialidad);
	public Optional<Especialidad> listarId(int idEspecialidad);
	public Optional<Especialidad> buscarId(int idEspecialidad);
	
	List<Especialidad> listar();
	
}
