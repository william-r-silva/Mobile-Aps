package Server.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User implements Serializable {
	
	//atributos
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@Column(unique=true, nullable=false) 
	private String email;
	private String senha;
	private String endereco;
	private String cidade;
	private String uf;
	private String telefone;
	private boolean tipo;
	private String cpf;
	
	
	//relacionamentos
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	@Nullable
	private List<Campanha> criadas;
	
	@ManyToMany
	@JoinTable(name = "user_campanha", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "campanha_id"))	
	@JsonIgnore
	@Nullable
	private List<Campanha> participadas;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	@Nullable
	private List<Avaliacao> avalicoes;
	
	//getters n setters
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getNome() {
		return nome;
	}




	public boolean isTipo() {
		return tipo;
	}




	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}




	public String getCpf() {
		return cpf;
	}




	public void setCpf(String cpf) {
		this.cpf = cpf;
	}







	public String getCidade() {
		return cidade;
	}




	public void setCidade(String cidade) {
		this.cidade = cidade;
	}




	public String getUf() {
		return uf;
	}




	public void setUf(String uf) {
		this.uf = uf;
	}




	public String getTelefone() {
		return telefone;
	}




	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}




	public List<Avaliacao> getAvalicoes() {
		return avalicoes;
	}




	public void setAvalicoes(List<Avaliacao> avalicoes) {
		this.avalicoes = avalicoes;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	public String getEndereco() {
		return endereco;
	}




	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}




	public List<Campanha> getCriadas() {
		return criadas;
	}




	public void setCriadas(List<Campanha> criadas) {
		this.criadas = criadas;
	}




	public List<Campanha> getParticipadas() {
		return participadas;
	}




	public void setParticipadas(List<Campanha> participadas) {
		this.participadas = participadas;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//construtores
	
		public User() {
			super();
		}

	public User(Integer id, String nome, String email, String senha, String endereco, String cidade, String uf,
				String telefone, boolean tipo, String cpf, List<Campanha> criadas,
				List<Campanha> participadas, List<Avaliacao> avalicoes) {
			super();
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.senha = senha;
			this.endereco = endereco;
			this.cidade = cidade;
			this.uf = uf;
			this.telefone = telefone;
			this.tipo = tipo;
			this.cpf = cpf;
			this.criadas = criadas;
			this.participadas = participadas;
			this.avalicoes = avalicoes;
		}


//hashCode


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avalicoes == null) ? 0 : avalicoes.hashCode());
		result = prime * result + ((cidade== null) ? 0 : cidade.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((criadas == null) ? 0 : criadas.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((participadas == null) ? 0 : participadas.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + (tipo ? 1231 : 1237);
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}


//equals

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (avalicoes == null) {
			if (other.avalicoes != null)
				return false;
		} else if (!avalicoes.equals(other.avalicoes))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (criadas == null) {
			if (other.criadas != null)
				return false;
		} else if (!criadas.equals(other.criadas))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (participadas == null) {
			if (other.participadas != null)
				return false;
		} else if (!participadas.equals(other.participadas))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipo != other.tipo)
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
	
}
