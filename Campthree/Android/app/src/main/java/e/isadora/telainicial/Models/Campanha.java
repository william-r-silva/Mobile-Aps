package e.isadora.telainicial.Models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import e.isadora.telainicial.Models.Avaliacao;
import e.isadora.telainicial.Models.Instituicao;
import e.isadora.telainicial.Models.User;


public class Campanha {

    //atributos

    private Integer id;
    private String descricao;
    private String genero;
    private String local;
    private String nome;
    private String dataInicio;
    private String dataFim;
    private boolean validada;
    private boolean colaboracaoMonetario;
    private User user;
    private Instituicao instituicao;
    private List<User> lista;
    private List<Avaliacao> avalicao;

    //getters n setters


    public boolean isColaboracaoMonetaria() {
        return colaboracaoMonetario;
    }

    public void setColaboracaoMonetaria(boolean colaboracaoMonetaria) {
        this.colaboracaoMonetario = colaboracaoMonetaria;
    }

    public boolean isAutorizada() {
        return validada;
    }

    public void setAutorizada(boolean autorizada) {
        this.validada = autorizada;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
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

    //campanha

    public Campanha() {
        super();
    }

    public Campanha(Integer id, String descricao, String genero, String local, String nome, String dataInicio, String dataFim, boolean autorizada, boolean colaboracaoMonetaria, User user, Instituicao instituicao, List<User> lista, List<Avaliacao> avalicao) {
        this.id = id;
        this.descricao = descricao;
        this.genero = genero;
        this.local = local;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.validada = autorizada;
        this.colaboracaoMonetario = colaboracaoMonetaria;
        this.user = user;
        this.instituicao = instituicao;
        this.lista = lista;
        this.avalicao = avalicao;
    }

    //hash
    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, genero, local, nome, dataInicio, dataFim, validada, colaboracaoMonetario, user, instituicao, lista, avalicao);
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campanha campanha = (Campanha) o;
        return validada == campanha.validada &&
                colaboracaoMonetario == campanha.colaboracaoMonetario &&
                id.equals(campanha.id) &&
                descricao.equals(campanha.descricao) &&
                genero.equals(campanha.genero) &&
                local.equals(campanha.local) &&
                nome.equals(campanha.nome) &&
                dataInicio.equals(campanha.dataInicio) &&
                dataFim.equals(campanha.dataFim) &&
                user.equals(campanha.user) &&
                instituicao.equals(campanha.instituicao) &&
                lista.equals(campanha.lista) &&
                avalicao.equals(campanha.avalicao);
    }
}