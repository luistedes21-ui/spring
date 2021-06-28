package upc.edu.pe.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.model.Psicologo;
import upc.edu.pe.repository.iPsicologoRepository;
import upc.edu.pe.service.iPsicologoService;

@Service //importante
public class PsicologoServiceImpl implements iPsicologoService {
	
	
	@Autowired   //La inyeccion
	private iPsicologoRepository dP;
	
	@Override
	@Transactional //transaction annotaion transactional
	public boolean insertar(Psicologo psicologo) {
		Psicologo objP = dP.save(psicologo);
		if(objP== null)
			return false;
		else
			return true;		
	}

	@Override
	@Transactional
	public boolean modificar(Psicologo psicologo) {
		boolean flag = false;
		try {
			dP.save(psicologo);
			flag= true;
		} catch (Exception ex) {
			System.out.println("Sucedió un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPsicologo) {
		dP.deleteById(idPsicologo);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Psicologo> listarId(int idPsicologo) {
		return dP.findById(idPsicologo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Psicologo> listar() {
		return dP.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Psicologo> buscaNombrePsicologo(String nombrePsicologo) {
		return dP.buscarPsicologo(nombrePsicologo);
	}

}
