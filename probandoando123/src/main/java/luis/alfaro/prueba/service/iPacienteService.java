package luis.alfaro.prueba.service;

import java.util.List;
import java.util.Optional;

import luis.alfaro.prueba.model.Paciente;

public interface iPacienteService {
    public boolean insertar (Paciente paciente);
    public boolean modificar (Paciente paciente);
    public void eliminar (int idPaciente);
    public Optional<Paciente> listarId(int idPaciente);
    List<Paciente> listar();
    List<Paciente> buscarNombre(String nombrePaciente);
}
