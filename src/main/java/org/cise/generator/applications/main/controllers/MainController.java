package org.cise.generator.applications.main.controllers;

import javafx.scene.Node;

import java.util.Locale;
import java.util.ResourceBundle;

public interface MainController {

    void setHeader(Node nodeView);

    void setNavigation(Node nodeView);

    void setContent(Node nodeView);

    void setResourceBundle(String basename);

    void setResourceBundle(String basename, Locale locale);

    ResourceBundle getResourceBundle();
}
