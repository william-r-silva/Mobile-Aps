package Server.Controllers;


	import java.util.ArrayList;
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

import Server.Models.Comentario;
import Server.Models.User;
import Server.Repository.UserRepository;

@CrossOrigin
	@RestController
	@RequestMapping("/user/")
	public class UserController {
		@Autowired
		private UserRepository userR;

		@GetMapping("{id}")
		public User getUser(@PathVariable(name = "id") Integer id) {
			if(userR.findById(id).isPresent()) return userR.findById(id).get();
			else return new User();
		}
		
		
		
		@GetMapping("/{email}/{senha}")
		public User getLogin(@PathVariable(name = "email") String email, @PathVariable(name = "senha") String senha) {
			return userR.findByEmailAndSenhaIn(email, senha);
		}
		
		@GetMapping()
		public List<User> getAll() {
			return userR.findAll();
		}
		
		@PostMapping
		public ResponseEntity<User> adicionar(@RequestBody User novo) {
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
				old = novo;

				old = userR.save(old);

				return ResponseEntity.ok(old);
	
		}
		
	}



