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

import Server.Models.Avaliacao;
import Server.Models.Campanha;
import Server.Models.User;
import Server.Repository.CampanhaRepository;
import Server.Repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserRepository userR;
	
	@Autowired
	private CampanhaRepository campanhaR;
	
	@GetMapping("{id}")
	public User getById(@PathVariable(name = "id") Integer id) {
		return userR.findById(id).get();
	}
	
	@GetMapping()
	public List<User> getAll() {
		return userR.findAll();
	}
	
	@GetMapping("{email}/{senha}")
	public User login(@PathVariable(name = "email") String email, @PathVariable(name = "senha") String senha) {
		return userR.findByEmailAndSenhaIn(email, senha.hashCode()+"");
	}
	
	@GetMapping("criadas/{id}")
	public List<Campanha> getCriadas(@PathVariable(name="id") Integer id){
		return userR.findById(id).get().getCriadas();
	}
	
	@GetMapping("campanhassemrelacao/{id}")
	public List<Campanha> getCampanhasSemRelacao(@PathVariable(name="id") Integer id){
		List<Campanha> x = campanhaR.findAll();
		for(int i = 0;i<x.size();i++) {
			if(x.get(i).getUser().getId()==id) {
				x.remove(i);
				i--;
			}
		}
		User u = userR.findById(id).get();
		for(int i = 0;i<x.size();i++) {
			for(int ii = 0;ii<u.getParticipadas().size();ii++) {
				if(x.get(i).getId()==u.getParticipadas().get(ii).getId()) {
					x.remove(i);
					i--;
					break;
				}
			}
		}
		return x;
	}
	
	@GetMapping("participadas/{id}")
	public List<Campanha> getParticipadas(@PathVariable(name="id")Integer id){
		return userR.findById(id).get().getParticipadas();
	}
	
	@GetMapping("avaliacao/{id}")
	public List<Avaliacao> getAvaliacao(@PathVariable(name="id")Integer id){
		return userR.findById(id).get().getAvalicoes();
	}
	@PostMapping
	public ResponseEntity<User> adicionar(@RequestBody User novo) {
		novo.setSenha(novo.getSenha().hashCode()+"");
		return ResponseEntity.ok(userR.save(novo));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		if (userR.existsById(id)) {
			userR.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping()
	public ResponseEntity<User> atualizar(@RequestBody User novo) {
			User old = userR.getOne(novo.getId());
			old.setEndereco(novo.getEndereco());
			old.setCriadas(novo.getCriadas());
			old.setEmail(novo.getEmail());
			old.setNome(novo.getNome());
			old.setSenha(novo.getSenha().hashCode()+"");
			old.setParticipadas(novo.getParticipadas());
			old.setId(novo.getId());	
			old.setUf(novo.getUf());
			old.setCpf(novo.getCpf());
			old.setCidade(novo.getCidade());
			old.setAvalicoes(novo.getAvalicoes());
			old = userR.save(old);
			return ResponseEntity.ok(old);
	}

}
