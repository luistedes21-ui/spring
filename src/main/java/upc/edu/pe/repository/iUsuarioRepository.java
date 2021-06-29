package upc.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import upc.edu.pe.model.Usuario;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario,Integer> {
	@Query("select u from Usuario u where u.codigoUsuario =:codigoUsuario")
	public Usuario findOne(@Param("codigoUsuario") Integer codigoUsuario);
	
	/*@Query("select u from Usuario u where u.username =:username and u.clave =:clave")
	public Usuario Login(@Param("username") String username, @Param("clave") String clave);*/
	
	@Query("select u from Usuario u where u.username =:username")
	public Usuario Login(@Param("username") String username);
	
}
