package org.cise.generator.modules.login.constrollers;

import org.cise.generator.applications.bases.BaseViewController;
import org.cise.generator.applications.main.controllers.MainController;

import javax.inject.Inject;

public class LoginController extends BaseViewController {

    @Inject
    MainController controller;

    @Inject
    public LoginController(MainController mainController) {
        super(mainController, "/modules/login/login.fxml");
    }


    @Override
    public void initializeModule() {
        loadFXML(controller, "/modules/login/login.fxml");
    }

}
