package luis.alfaro.prueba.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luis.alfaro.prueba.model.Especialidad;
import luis.alfaro.prueba.repository.EspecialidadRepository;
import luis.alfaro.prueba.service.EspecialidadService;
@Service

public class EspecialidadServiceImpl implements EspecialidadService {

	@Autowired
	private EspecialidadRepository dEspe;
	
	@Override
	@Transactional
	
	public boolean insertar(Especialidad especialidad) {
		Especialidad objEspecialidad = dEspe.save(especialidad);
		if(objEspecialidad==null)return false;
		else return true;
	
	}
	
	@Override
	@Transactional
	
	public boolean modificar(Especialidad especialidad) {
		boolean flag = false;
		try{
			dEspe.save(especialidad);
			flag = true;
			
		} catch (Exception ex)
		{
			System.out.println("Ocurrió un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idEspecialidad) {
		dEspe.deleteById(idEspecialidad);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Especialidad> listarId(int idEspecialidad) {
		
		return dEspe.findById(idEspecialidad);
		
	}

	@Override
	public Optional<Especialidad> buscarId(int idEspecialidad) {
		
		return dEspe.findById(idEspecialidad);
	}

	@Override
	@Transactional
	public List<Especialidad> listar() {
		
		return dEspe.findAll();
	}

	@Override
	@Transactional
	public List<Especialidad> buscarnombre(String nombreEspecialidad) {
		
		return dEspe.buscarNombre(nombreEspecialidad);
	}

	@Override
	@Transactional
	public List<Especialidad> buscarServicio(String nameServicio) {
		
		return dEspe.buscarServicio(nameServicio);
	}

}
