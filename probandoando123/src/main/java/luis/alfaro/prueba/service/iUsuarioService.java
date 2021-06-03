package luis.alfaro.prueba.service;

import luis.alfaro.prueba.model.Usuario;

public interface iUsuarioService {
	
	public boolean insertar(Usuario usuario);
	public Usuario findOne(Integer idUsuario);
	public Usuario login(String username); 


}
