package org.cise.generator.applications.main.components;

import dagger.Component;
import org.cise.generator.applications.main.controllers.MainControllerImpl;
import org.cise.generator.applications.main.controllers.NavigationController;
import org.cise.generator.applications.main.modules.MainControllerModule;

@Component(modules = {MainControllerModule.class})
public interface MainAppComponent {

    void inject(MainControllerImpl mainController);

    void inject(NavigationController navigationController);

}
