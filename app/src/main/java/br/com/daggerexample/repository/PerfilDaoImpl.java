package br.com.daggerexample.repository;

import android.content.Context;
import android.util.Log;

import java.util.List;

import br.com.daggerexample.model.Perfil;
import io.realm.Realm;

public class PerfilDaoImpl implements IRepository<Perfil>{


    private Realm realm;

    public PerfilDaoImpl(Context context) {
        realm.init(context);
        realm = Realm.getDefaultInstance();

    }

    public void save(Perfil perfil) {

        try {
            realm.beginTransaction();

            if(perfil.getId()==null)
                perfil.setId(RealmUtil.nextId(realm, perfil.getClass()));

            realm.insertOrUpdate(perfil);

            realm.commitTransaction();

        } catch (Exception e) {
            Log.i("TAG", "save: " + e.getMessage());
        }

        Log.i("TAG", "save: "+perfil.getClass().getSimpleName());

    }

    public void delete(Perfil perfil) {


        try {
            realm.beginTransaction();
            realm.where(perfil.getClass()).equalTo("id", perfil.getId()).findFirst().deleteFromRealm();
            realm.commitTransaction();

        } catch (Exception e) {
            Log.i("TAG", "delete: " + e.getMessage());
        }

        Log.i("TAG", "delete: "+perfil.getClass().getSimpleName());

    }


    public List<Perfil> findAll() {

       return realm.where(Perfil.class).findAll();
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
