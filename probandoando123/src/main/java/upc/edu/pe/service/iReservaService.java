package upc.edu.pe.service;

import java.util.List;
import java.util.Optional;

import upc.edu.pe.model.Reserva;

public interface iReservaService {
	
	public boolean insertar(Reserva reserva);
	List<Reserva>listar();
	public void eliminar(int idReserva);
	public boolean modificar(Reserva reserva);
	List<Reserva>buscarPsicologo(String nombrePsicologo);
	public Optional<Reserva> listarId(int idReserva);
	
	
}
