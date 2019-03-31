package org.cise.generator.modules.green;

import org.cise.generator.applications.bases.BaseViewController;
import org.cise.generator.applications.main.controllers.MainController;

import javax.inject.Inject;

public class GreenController extends BaseViewController {

    @Inject
    public GreenController(MainController mainController) {
        super(mainController, "/modules/green/green.fxml");
    }

    @Override
    public void initializeModule() {

    }
}
