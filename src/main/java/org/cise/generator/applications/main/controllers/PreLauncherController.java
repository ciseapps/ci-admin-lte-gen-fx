package org.cise.generator.applications.main.controllers;

import javafx.fxml.FXML;;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class PreLauncherController implements Initializable {

    private Logger log = LogManager.getLogger(getClass());

    @FXML
    ProgressBar progressBar;

    public void setProgress(final double progressV) {
        progressBar.setProgress(progressV);
        log.debug(progressBar.getProgress());
//        Platform.runLater(() -> progressBar.setProgress(progressV));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize");
        // progressBar.setProgress(0.5);
    }

}