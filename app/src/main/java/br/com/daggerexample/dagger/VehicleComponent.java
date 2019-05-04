package br.com.daggerexample.dagger;

import javax.inject.Singleton;

import br.com.daggerexample.model.Vehicle;
import dagger.Component;

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {

    Vehicle provideVehicle();

}
