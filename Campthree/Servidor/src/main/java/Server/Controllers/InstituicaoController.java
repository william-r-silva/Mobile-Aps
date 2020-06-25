package Server.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Server.Models.Campanha;
import Server.Models.Instituicao;
import Server.Repository.CampanhaRepository;
import Server.Repository.InstituicaoRepository;

@CrossOrigin
@RestController
@RequestMapping("/institutos/")
public class InstituicaoController {
	
	@Autowired
	private InstituicaoRepository instituicaoR;
	
	@Autowired
	private CampanhaRepository campanhaR;
	
	@GetMapping("{id}")
	public Instituicao getById(@PathVariable(name = "id") Integer id) {
		return instituicaoR.findById(id).get();
	}
	
	@GetMapping()
	public List<Instituicao> getAll() {
		return instituicaoR.findAll();
	}
	
	@GetMapping("{email}/{senha}")
	public Instituicao login(@PathVariable(name = "email") String email, @PathVariable(name = "senha") String senha) {
		return instituicaoR.findByEmailAndSenhaIn(email, senha);
	}
	
	@GetMapping("autorizada/{id}")
	public List<Campanha> autorizadas(@PathVariable(name="id")Integer id){
		return campanhaR.findByValidadaAndInstituicaoIn(true, instituicaoR.findById(id).get());
	}
	
	@GetMapping("naoautorizada/{id}")
	public List<Campanha> naoautorizadas(@PathVariable(name="id")Integer id){
		return campanhaR.findByValidadaAndInstituicaoIn(false, instituicaoR.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<Instituicao> adicionar(@RequestBody Instituicao novo) {
		return ResponseEntity.ok(instituicaoR.save(novo));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		if (instituicaoR.existsById(id)) {
			instituicaoR.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping()
	public ResponseEntity<Instituicao> atualizar(@RequestBody Instituicao novo) {
			Instituicao old = instituicaoR.getOne(novo.getId());
			old.setEndereco(novo.getEndereco());
			old.setEmail(novo.getEmail());
			old.setNome(novo.getNome());
			old.setSenha(novo.getSenha());
			old.setId(novo.getId());	
			old.setUf(novo.getUf());
			old.setCidade(novo.getCidade());
			old.setCnpj(novo.getCnpj());
			old.setRazaoSocial(novo.getRazaoSocial());
			old = instituicaoR.save(old);
			return ResponseEntity.ok(old);
	}

}

