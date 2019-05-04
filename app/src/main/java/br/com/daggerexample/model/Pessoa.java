package br.com.daggerexample.model;

import javax.inject.Inject;

import dagger.Module;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Pessoa extends RealmObject {

    @PrimaryKey
    private Integer id;
    private String nome;
    private Integer idade;
    @Inject User user;

    public Pessoa(){
    }

    public Pessoa(User user){
        this.user = user;
    }


    public Pessoa(String nome, Integer idade, User user){
        setNome(nome);
        setIdade(idade);
        setUser(user);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", user=" + user +
                '}';
    }
}
