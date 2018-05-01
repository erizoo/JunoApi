package by.boiko.erizo.juno.injection;

import javax.inject.Singleton;

import by.boiko.erizo.juno.screens.JunoViewModel;
import dagger.Component;


@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    void inject(JunoViewModel junoViewModel);

}
