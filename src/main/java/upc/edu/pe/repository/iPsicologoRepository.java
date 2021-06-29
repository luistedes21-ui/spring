package upc.edu.pe.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import upc.edu.pe.model.Psicologo;

//importante indicar acá que es un Repository
@Repository 
public interface iPsicologoRepository extends JpaRepository<Psicologo,Integer> {
	
	@Query("from Psicologo p where p.nombrePsicologo like %:nombrePsicologo%")
	List<Psicologo>buscarPsicologo(@Param("nombrePsicologo")String nombrePsicologo);
	
	@Query("select p from Psicologo p where p.codigoCPSP like %:codigoCPSP%")
	List<Psicologo> findByCod(String codigoCPSP);
}