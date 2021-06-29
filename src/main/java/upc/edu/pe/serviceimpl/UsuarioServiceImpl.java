package upc.edu.pe.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.model.Usuario;
import upc.edu.pe.repository.iUsuarioRepository;
import upc.edu.pe.service.iUsuarioService;

public class UsuarioServiceImpl implements iUsuarioService {
	@Autowired   //La inyeccion
	private iUsuarioRepository dP;
	
	@Override
	@Transactional //transaction annotaion transactional
	public boolean insertar(Usuario usuario) {
		Usuario objP = dP.save(usuario);
		if(objP== null)
			return false;
		else
			return true;		
	}


	@Override
	public Usuario findOne(Integer idUsuario) {
		return dP.findOne(idUsuario);

	}

	@Override
	public Usuario login(String username) {
		// TODO Auto-generated method stub
		return dP.Login(username);
	}
	
	
	
	
	
}
