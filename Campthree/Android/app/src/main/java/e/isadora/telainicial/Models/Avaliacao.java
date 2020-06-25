package e.isadora.telainicial.Models;

import java.io.Serializable;

public class Avaliacao implements Serializable {

    //atributos

    private static final long serialVersionUID = 1L;


    private Integer id;
    private Short nota; //na minha cabeça vai ser de 0 a 10
    private String descricao;
    private User user;
    private Campanha campanha;

    //getters n setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getNota() {
        return nota;
    }

    public void setNota(Short nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    //construtores

    public Avaliacao(Integer id, Short nota, String descricao, User user, Campanha campanha) {
        super();
        this.id = id;
        this.nota = nota;
        this.descricao = descricao;
        this.user = user;
        this.campanha = campanha;
    }

    public Avaliacao() {
        super();
    }

    //hashcode

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((campanha == null) ? 0 : campanha.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nota == null) ? 0 : nota.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        Avaliacao other = (Avaliacao) obj;
        if (campanha == null) {
            if (other.campanha != null)
                return false;
        } else if (!campanha.equals(other.campanha))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nota == null) {
            if (other.nota != null)
                return false;
        } else if (!nota.equals(other.nota))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }



}

