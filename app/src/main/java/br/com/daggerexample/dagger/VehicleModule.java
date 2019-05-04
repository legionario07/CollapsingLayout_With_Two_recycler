package br.com.daggerexample.dagger;

import javax.inject.Singleton;

import br.com.daggerexample.model.Motor;
import br.com.daggerexample.model.Vehicle;
import dagger.Module;
import dagger.Provides;

@Module
public class VehicleModule {

    @Provides @Singleton
    Motor motorProvide(){
        return new Motor();
    }

    @Provides @Singleton
    Vehicle vehicleProvide(){
        return new Vehicle(new Motor());
    }

}
