package luis.alfaro.prueba.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import luis.alfaro.prueba.model.Especialidad;


@Repository

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer>{
	
	

}
