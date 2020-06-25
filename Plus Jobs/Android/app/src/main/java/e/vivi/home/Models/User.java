package e.vivi.home.Models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer id;
    private String email;
    private String senha;
    private String nome;
    private String estado;
    private String cidade;

    private List<Comentario> comentarios = new ArrayList<>();

    public User() {
        super();
        id = 0;
    }

    public User(Integer id, String email, String senha, String nome, String estado, String cidade, List<Comentario> comentarios) {
        super();
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
        this.comentarios = comentarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
