package luis.alfaro.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import luis.alfaro.prueba.model.Paciente;

@Repository
public interface iPacienteRepository extends JpaRepository<Paciente, Integer>{
    @Query("from Paciente p where p.nombrePaciente like %:nombrePaciente%")
	List<Paciente> buscarNombre(@Param("nombrePaciente")String nombrePaciente);
}
