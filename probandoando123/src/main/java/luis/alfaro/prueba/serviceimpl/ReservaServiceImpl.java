package luis.alfaro.prueba.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luis.alfaro.prueba.model.Reserva;
import luis.alfaro.prueba.repository.iReservaRepository;
import luis.alfaro.prueba.service.iReservaService;

@Service //importante
public class ReservaServiceImpl implements iReservaService {
	
	
	@Autowired   //La inyeccion
	private iReservaRepository dP;
	
	@Override
	@Transactional //transaction annotaion transactional
	public boolean insertar(Reserva reserva) {
		Reserva objP = dP.save(reserva);
		if(objP== null)
			return false;
		else
			return true;		
	}

	@Override
	@Transactional
	public boolean modificar(Reserva reserva) {
		boolean flag = false;
		try {
			dP.save(reserva);
			flag= true;
		} catch (Exception ex) {
			System.out.println("Sucedió un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idReserva) {
		dP.deleteById(idReserva);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Reserva> listarId(int idReserva) {
		return dP.findById(idReserva);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reserva> listar() {
		return dP.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reserva> buscarPsicologo(String nombrePsicologo) {
		return dP.buscarPsicologo(nombrePsicologo);
	}

}
