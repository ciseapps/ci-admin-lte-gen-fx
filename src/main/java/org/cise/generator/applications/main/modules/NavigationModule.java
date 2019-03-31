package org.cise.generator.applications.main.modules;

import dagger.Module;
import dagger.Provides;
import org.cise.generator.applications.main.controllers.MainController;
import org.cise.generator.applications.main.controllers.NavigationController;
import org.cise.generator.modules.green.GreenController;
import org.cise.generator.modules.red.RedController;
import org.cise.generator.modules.yellow.controllers.YellowController;

import javax.inject.Inject;
import javax.inject.Singleton;

@Module
public class NavigationModule {

    @Provides
    @Inject
    @Singleton
    public NavigationController providesNavigationController(MainController controller) {
        return new NavigationController(controller);
    }

    @Provides
    @Inject
    @Singleton
    public YellowController provideYellowController(MainController controller){
        return new YellowController(controller);
    }

    @Provides
    @Inject
    @Singleton
    public RedController provideRedController(MainController controller){
        return new RedController(controller);
    }

    @Provides
    @Inject
    @Singleton
    public GreenController provideGreenController(MainController controller){
        return new GreenController(controller);
    }



}
