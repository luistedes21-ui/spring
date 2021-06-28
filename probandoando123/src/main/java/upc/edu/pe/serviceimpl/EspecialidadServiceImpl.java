package upc.edu.pe.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.model.Especialidad;
import upc.edu.pe.repository.EspecialidadRepository;
import upc.edu.pe.service.EspecialidadService;
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

	
	

}
