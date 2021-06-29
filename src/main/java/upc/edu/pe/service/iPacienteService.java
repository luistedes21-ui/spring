package upc.edu.pe.service;

import java.util.List;
import java.util.Optional;

import upc.edu.pe.model.Paciente;

public interface iPacienteService {
    public boolean insertar (Paciente paciente);
    public boolean modificar (Paciente paciente);
    public void eliminar (int idPaciente);
    public Optional<Paciente> listarId(int idPaciente);
    List<Paciente> listar();
    List<Paciente> buscarPaciente(String nombrePaciente);
}
