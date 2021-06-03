package luis.alfaro.prueba.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import luis.alfaro.prueba.model.Psicologo;

@Repository //importante indicar acá que es un Repository
public interface iPsicologoRepository extends JpaRepository<Psicologo,Integer> {
	@Query("from Psicologo p where p.nombrePsicologo like %:nombrePsicologo%")
	List<Psicologo>buscarPsicologo(@Param("nombrePsicologo")String nombrePsicologo);

}
