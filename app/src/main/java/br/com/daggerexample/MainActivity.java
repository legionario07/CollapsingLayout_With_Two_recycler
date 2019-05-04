package br.com.daggerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import br.com.daggerexample.model.Pessoa;
import br.com.daggerexample.model.Vehicle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Vehicle vehicle;
    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);

        vehicle = MyApplication.vehicleComponent().provideVehicle();
        pessoa = MyApplication.pessoaComponent().pessoaProvide();

        Log.i("TAG", "onCreate: " + vehicle.getSpeed());
        Log.i("TAG", "onCreate: " + pessoa.getUser().getLogin());


//        Perfil perfil = new Perfil("ADMIN");
//        realDao = new PerfilDaoImpl(this);
//        realDao.save(perfil);

    }

    @Override
    public void onClick(View v) {

//        List<Perfil> all = realDao.findAll();

//        Log.i("TAG", "onClick: "+all.size());

    }
}
