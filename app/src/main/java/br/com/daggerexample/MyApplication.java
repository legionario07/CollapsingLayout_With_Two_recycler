package br.com.daggerexample;

import android.app.Application;
import android.util.Log;

import br.com.daggerexample.dagger.DaggerPessoaComponent;
import br.com.daggerexample.dagger.DaggerUserComponent;
import br.com.daggerexample.dagger.DaggerVehicleComponent;
import br.com.daggerexample.dagger.PessoaComponent;
import br.com.daggerexample.dagger.PessoaModule;
import br.com.daggerexample.dagger.UserComponent;
import br.com.daggerexample.dagger.UserModule;
import br.com.daggerexample.dagger.VehicleComponent;
import br.com.daggerexample.dagger.VehicleModule;

public class MyApplication extends Application {

    private static MyApplication singleton;

    public MyApplication getInstance(){
        return singleton;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        Log.i("TAG", "onCreate: MyApplication");

    }

    public static VehicleComponent vehicleComponent(){
       return DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
    }

    public static UserComponent userComponent(){
        return DaggerUserComponent.builder().userModule(new UserModule()).build();
    }

    public static PessoaComponent pessoaComponent(){
        return DaggerPessoaComponent.builder().pessoaModule(new PessoaModule()).build();
    }

}
