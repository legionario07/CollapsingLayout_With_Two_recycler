package br.com.daggerexample.repository;

import android.content.Context;
import android.util.Log;

import java.util.List;

import br.com.daggerexample.model.Pessoa;
import io.realm.Realm;

public class PessoaDaoImpl implements IRepository<Pessoa>{


    private Realm realm;

    public PessoaDaoImpl(Context context) {
        realm.init(context);
        realm = Realm.getDefaultInstance();

    }

    public void save(Pessoa pessoa) {

        try {
            realm.beginTransaction();

            if(pessoa.getId()==null)
                pessoa.setId(RealmUtil.nextId(realm, pessoa.getClass()));

            realm.insertOrUpdate(pessoa);

            realm.commitTransaction();

        } catch (Exception e) {
            Log.i("TAG", "save: " + e.getMessage());
        }

        Log.i("TAG", "save: "+pessoa.getClass().getSimpleName());

    }

    public void delete(Pessoa pessoa) {


        try {
            realm.beginTransaction();
            realm.where(pessoa.getClass()).equalTo("id", pessoa.getId()).findFirst().deleteFromRealm();
            realm.commitTransaction();

        } catch (Exception e) {
            Log.i("TAG", "delete: " + e.getMessage());
        }

        Log.i("TAG", "delete: "+pessoa.getClass().getSimpleName());

    }


    public List<Pessoa> findAll() {

       return realm.where(Pessoa.class).findAll();
    }

    public void deleteAll() {

        try {
            realm.beginTransaction();
            realm.deleteAll();
            realm.commitTransaction();
        } catch (Exception e) {
            Log.i("TAG", "delete: " + e.getMessage());
        }
        Log.i("TAG", "deleteAll: ");

    }


}
