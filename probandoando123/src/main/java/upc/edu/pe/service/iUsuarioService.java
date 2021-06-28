package upc.edu.pe.service;

import upc.edu.pe.model.Usuario;

public interface iUsuarioService {
	
	public boolean insertar(Usuario usuario);
	public Usuario findOne(Integer idUsuario);
	public Usuario login(String username); 


}
