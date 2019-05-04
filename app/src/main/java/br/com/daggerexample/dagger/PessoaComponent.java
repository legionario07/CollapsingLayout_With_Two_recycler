package br.com.daggerexample.dagger;

import javax.inject.Singleton;

import br.com.daggerexample.model.Pessoa;
import dagger.Component;

@Singleton
@Component(modules = {PessoaModule.class})
public interface PessoaComponent {

    Pessoa pessoaProvide();

}
