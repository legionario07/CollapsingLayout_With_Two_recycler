package br.com.daggerexample.repository;

import android.content.Context;
import android.util.Log;

import java.util.List;

import br.com.daggerexample.model.User;
import io.realm.Realm;

public class UserDaoImpl implements IRepository<User>{


    private Realm realm;

    public UserDaoImpl(Context context) {
        realm.init(context);
        realm = Realm.getDefaultInstance();

    }

    public void save(User user) {

        try {
            realm.beginTransaction();

            if(user.getId()==null)
                user.setId(RealmUtil.nextId(realm, user.getClass()));

            realm.insertOrUpdate(user);

            realm.commitTransaction();

        } catch (Exception e) {
            Log.i("TAG", "save: " + e.getMessage());
        }

        Log.i("TAG", "save: "+user.getClass().getSimpleName());

    }

    public void delete(User user) {


        try {
            realm.beginTransaction();
            realm.where(user.getClass()).equalTo("id", user.getId()).findFirst().deleteFromRealm();
            realm.commitTransaction();

        } catch (Exception e) {
            Log.i("TAG", "delete: " + e.getMessage());
        }

        Log.i("TAG", "delete: "+user.getClass().getSimpleName());

    }


    public List<User> findAll() {

       return realm.where(User.class).findAll();
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
