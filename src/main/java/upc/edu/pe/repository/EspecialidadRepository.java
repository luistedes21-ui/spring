package upc.edu.pe.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import upc.edu.pe.model.Especialidad;


@Repository

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer>{
	 @Query("from Especialidad e where e.nombreEspecialidad like %:nombreEspecialidad%")
		List<Especialidad> buscarEspecialidad(@Param("nombreEspecialidad")String nombreEspecialidad);
	

}
