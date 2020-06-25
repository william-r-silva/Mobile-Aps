package Server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Server.Models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	Optional<Empresa> findById(Integer id);
	
	List<Empresa> findAll();
	
	List<Empresa> findByNomeMarca(String nomeMarca);
	
	List<Empresa> findByAutorizado(boolean autorizado);

	

}
