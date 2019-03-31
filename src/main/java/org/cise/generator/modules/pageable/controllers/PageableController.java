package org.cise.generator.modules.pageable.controllers;

import org.cise.generator.applications.bases.BaseViewController;
import org.cise.generator.applications.main.controllers.MainController;

public class PageableController extends BaseViewController {

    public PageableController(MainController mainController) {
        super(mainController, "/modules/pageable/pageable.fxml");
    }

    @Override
    public void initializeModule() {

    }
}
