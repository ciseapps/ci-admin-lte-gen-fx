package org.cise.generator.applications.main.modules;

import dagger.Module;
import dagger.Provides;
import org.cise.generator.applications.main.controllers.HeaderController;
import org.cise.generator.applications.main.controllers.MainController;

import javax.inject.Inject;
import javax.inject.Singleton;

@Module
public class HeaderModule {

    @Provides
    @Inject
    @Singleton
    public HeaderController provideHeaderController(MainController mainController){
        return new HeaderController(mainController);
    }

}
