package luis.alfaro.prueba.service;

import java.util.List;
import java.util.Optional;

import luis.alfaro.prueba.model.Servicio;

public interface ServicioService {
    public boolean insertar (Servicio servicio);
    public boolean modificar (Servicio servicio);
    public void eliminar (int idServicio);
    public Optional<Servicio> listarId(int idServicio);
    List<Servicio> listar();
    List<Servicio> buscarNombre(String nombreServicio);
}