package luis.alfaro.prueba.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import luis.alfaro.prueba.model.Usuario;
import luis.alfaro.prueba.repository.iUsuarioRepository;
import luis.alfaro.prueba.service.iUsuarioService;

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
