package br.com.daggerexample.dagger;

import javax.inject.Singleton;

import br.com.daggerexample.model.User;
import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides @Singleton
    User userProvide(){
        return new User("TESTE");
    }

}
