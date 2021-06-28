package upc.edu.pe.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.model.Servicio;
import upc.edu.pe.repository.ServicioRepository;
import upc.edu.pe.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService{

	@Autowired
	private ServicioRepository dServicio;
	
	@Override
	@Transactional
	public boolean insertar(Servicio servicio) {
		Servicio objServicio =dServicio.save(servicio);
		if (objServicio == null)
		return false;
		else
		return true;
	}

	@Override
	@Transactional
	public boolean modificar(Servicio servicio) {
		boolean flag = false;
		try {
		      dServicio.save(servicio);
		      flag = true;
	        }
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}
	

	@Override
	@Transactional
	public void eliminar(int idServicio) {
		dServicio.deleteById(idServicio);
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Servicio> listarId(int idServicio) {
		return dServicio.findById(idServicio);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Servicio> listar() {
		return dServicio.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public List<Servicio> buscarServicio(String nombreServicio) {
		return dServicio.buscarServicio(nombreServicio);
	}

}
