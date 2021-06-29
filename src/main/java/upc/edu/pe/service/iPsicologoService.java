package upc.edu.pe.service;

import java.util.List;
import java.util.Optional;

import upc.edu.pe.model.Psicologo;

public interface iPsicologoService {
	public boolean insertar(Psicologo psicologo);
	public boolean modificar(Psicologo psicologo);
	public void eliminar(int idPsicologo);
	public Optional<Psicologo> listarId(int idPsicologo);
	List<Psicologo>listar();
	List<Psicologo>buscarPsicologo(String nombrePsicologo);
	List<Psicologo>findByCod(String codigoCPSP);
}