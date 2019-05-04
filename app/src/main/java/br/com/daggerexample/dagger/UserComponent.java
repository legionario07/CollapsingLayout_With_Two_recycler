package br.com.daggerexample.dagger;

import javax.inject.Singleton;

import br.com.daggerexample.model.User;
import dagger.Component;

@Singleton
@Component(modules = {UserModule.class})
public interface UserComponent {

    User userProvide();

}
