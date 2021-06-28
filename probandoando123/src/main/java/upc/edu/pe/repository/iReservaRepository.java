package upc.edu.pe.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import upc.edu.pe.model.Reserva;

@Repository //importante indicar acá que es un Repository
public interface iReservaRepository extends JpaRepository<Reserva,Integer> {
	@Query("from Reserva p where p.psicologo.nombrePsicologo like %:nombrePsicologo%")
	List<Reserva>buscarPsicologo(@Param("nombrePsicologo")String nombrePsicologo);

}
