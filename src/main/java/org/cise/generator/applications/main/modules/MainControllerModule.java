package org.cise.generator.applications.main.modules;

import dagger.Module;
import dagger.Provides;
import org.cise.generator.applications.main.controllers.MainController;

@Module
public class MainControllerModule {

    MainController mainController;

    public MainControllerModule(MainController mainController) {
        this.mainController = mainController;
    }

    @Provides
    public MainController provideMainController(){
        return mainController;
    }
}
