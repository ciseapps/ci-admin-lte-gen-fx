package org.cise.generator.applications.main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import org.cise.generator.applications.main.components.DaggerMainAppComponent;
import org.cise.generator.applications.main.components.MainAppComponent;
import org.cise.generator.applications.main.modules.MainControllerModule;

import javax.inject.Inject;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainControllerImpl implements MainController, Initializable {

    @FXML
    BorderPane mainPane;
    @Inject
    HeaderController headerController;
    @Inject
    NavigationController navigationController;

    private ResourceBundle resources = ResourceBundle.getBundle("lang/en_US");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MainAppComponent component = DaggerMainAppComponent.builder().mainControllerModule(new MainControllerModule(this)).build();
        component.inject(this);
        setHeader(headerController);
        setNavigation(navigationController);
    }

    @Override
    public void setHeader(Node nodeView) {
        mainPane.setTop(nodeView);
    }

    @Override
    public void setNavigation(Node nodeView) {
        mainPane.setLeft(nodeView);
    }

    @Override
    public void setContent(Node nodeView) {
        mainPane.setCenter(nodeView);
    }

    @Override
    public void setResourceBundle(String basename, Locale locale) {
        StringBuilder sb = new StringBuilder();
        sb.append("lang/");
        sb.append(basename);
        resources = ResourceBundle.getBundle(sb.toString(), locale);
    }

    @Override
    public void setResourceBundle(String basename) {
        StringBuilder sb = new StringBuilder();
        sb.append("lang/");
        sb.append(basename);
        resources = ResourceBundle.getBundle(sb.toString());
    }

    @Override
    public ResourceBundle getResourceBundle() {
        return resources;
    }

}
