package Server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Server.Models.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer> {

	Optional<Instituicao> findById(Integer id);
	
	List<Instituicao> findAll();
	
	Instituicao findByEmailAndSenhaIn(String email, String senha);
}