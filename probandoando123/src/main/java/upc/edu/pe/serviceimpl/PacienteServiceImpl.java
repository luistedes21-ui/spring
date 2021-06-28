package upc.edu.pe.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.model.Paciente;
import upc.edu.pe.repository.iPacienteRepository;
import upc.edu.pe.service.iPacienteService;

@Service
public class PacienteServiceImpl implements iPacienteService{

	@Autowired
	private iPacienteRepository dPaciente;
	
	@Override
	@Transactional
	public boolean insertar(Paciente paciente) {
		Paciente objPaciente =dPaciente.save(paciente);
		if (objPaciente == null)
		return false;
		else
		return true;
	}

	@Override
	@Transactional
	public boolean modificar(Paciente paciente) {
		boolean flag = false;
		try {
		      dPaciente.save(paciente);
		      flag = true;
	        }catch(Exception ex) {		
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}
	

	@Override
	@Transactional
	public void eliminar(int idPaciente) {
		dPaciente.deleteById(idPaciente);
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Paciente> listarId(int idPaciente) {
		return dPaciente.findById(idPaciente);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Paciente> listar() {
		return dPaciente.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public List<Paciente> buscarNombre(String nombrePaciente) {
		return dPaciente.buscarNombre(nombrePaciente);
	}

}
