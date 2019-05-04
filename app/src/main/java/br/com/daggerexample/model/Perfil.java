package br.com.daggerexample.model;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Perfil extends RealmObject {

    private String nivel;
    @PrimaryKey
    private Integer id;

    public Perfil(){

    }

    public Perfil(String nivel){
        this();
        setNivel(nivel);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNivel(){
        return nivel;
    }

    public void setNivel(String nivel){
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "nivel='" + nivel + '\'' +
                '}';
    }
}
