package org.cise.generator.applications.main.controllers;

import org.cise.generator.applications.bases.BaseViewController;

import javax.inject.Inject;

public class HeaderController extends BaseViewController {

    @Inject
    public HeaderController(MainController mainController) {
        super(mainController, "/modules/templates/header.fxml");
    }

    @Override
    public void initializeModule() {

    }
}
