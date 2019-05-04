package br.com.daggerexample.dagger;

import javax.inject.Singleton;

import br.com.daggerexample.model.Pessoa;
import br.com.daggerexample.model.User;
import dagger.Module;
import dagger.Provides;

@Module
public class PessoaModule {

    @Provides @Singleton
    Pessoa pessoaProvide(){
        return new Pessoa(new UserModule().userProvide());
    }

}
