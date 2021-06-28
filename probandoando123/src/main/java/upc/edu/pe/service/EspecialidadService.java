package upc.edu.pe.service;

import java.util.List;
import java.util.Optional;

import upc.edu.pe.model.Especialidad;


public interface EspecialidadService {
	
	public boolean insertar(Especialidad especialidad);
	public boolean modificar (Especialidad especialidad);
	public void eliminar(int idEspecialidad);
	public Optional<Especialidad> listarId(int idEspecialidad);
	List<Especialidad> listar();
	List<Especialidad> buscarEspecialidad(String nombreEspecialidad);
	
}
