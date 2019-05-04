package br.com.daggerexample.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {

    @PrimaryKey
    private Integer id;
    private String login;
    private String password;
    private Perfil perfil;

    public User(){

    }

    public User(String login){
        setLogin(login);
    }

    public User(String login, String password, Perfil perfil){
        this();
        setLogin(login);
        setPassword(password);
        setPerfil(perfil);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", perfil=" + perfil +
                '}';
    }
}
