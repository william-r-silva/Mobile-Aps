package Server.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "campanha")
public class Campanha implements Serializable {
	
	//atributos
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String genero;
	private String local;
	private String nome;
	private String dataInicio;
	private String dataFim;
	private boolean colaboracaoMonetario;
	private boolean validada;
	
	//relacionamentos
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "instituicao_id")
	@Nullable
	@JsonIgnore
	private Instituicao instituicao;
	
	@ManyToMany(mappedBy = "participadas")
	@Nullable
	private List<User> lista;
	
	@OneToMany(mappedBy = "campanha")
	@JsonIgnore
	@Nullable
	private List<Avaliacao> avalicao;
	
	//getters n setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	 
	public boolean isValidada() {
		return validada;
	}

	public void setValidada(boolean validada) {
		this.validada = validada;
	}

	public String getDescricao() {
		return descricao;
	}

	
	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	
	
	public boolean getColaboracaoMonetario() {
		return colaboracaoMonetario;
	}

	public void setColaboracaoMonetario(boolean colaboracaoMonetario) {
		this.colaboracaoMonetario = colaboracaoMonetario;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	
	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public List<Avaliacao> getAvalicao() {
		return avalicao;
	}

	public void setAvalicao(List<Avaliacao> avalicao) {
		this.avalicao = avalicao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getLista() {
		return lista;
	}

	public void setLista(List<User> lista) {
		this.lista = lista;
	}

	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//construtor
	
	public Campanha() {
		super();
	}
	
	public Campanha(Integer id, String descricao, String genero, String local, String nome, String dataInicio,
			String dataFim, boolean colaboracaoMonetario, boolean validada, User user, Instituicao instituicao,
			List<User> lista, List<Avaliacao> avalicao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.genero = genero;
		this.local = local;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.colaboracaoMonetario = colaboracaoMonetario;
		this.validada = validada;
		this.user = user;
		this.instituicao = instituicao;
		this.lista = lista;
		this.avalicao = avalicao;
	}

	//hash code
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avalicao == null) ? 0 : avalicao.hashCode());
		result = prime * result + (colaboracaoMonetario ? 1231 : 1237);
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instituicao == null) ? 0 : instituicao.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + (validada ? 1231 : 1237);
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
		Campanha other = (Campanha) obj;
		if (avalicao == null) {
			if (other.avalicao != null)
				return false;
		} else if (!avalicao.equals(other.avalicao))
			return false;
		if (colaboracaoMonetario != other.colaboracaoMonetario)
			return false;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instituicao == null) {
			if (other.instituicao != null)
				return false;
		} else if (!instituicao.equals(other.instituicao))
			return false;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (validada != other.validada)
			return false;
		return true;
	}

	
}	
	