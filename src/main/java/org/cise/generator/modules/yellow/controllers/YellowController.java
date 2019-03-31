package org.cise.generator.modules.yellow.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.cise.generator.applications.bases.BaseViewController;
import org.cise.generator.applications.main.controllers.MainController;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class YellowController extends BaseViewController implements Initializable {

    @FXML
    ListView sampleLV;
    @FXML
    Button okok;

    String s;

    @Inject
    public YellowController(MainController mainController) {
        super(mainController, "/modules/yellow/yellow.fxml");
        System.out.println("INIT YellowController : " + s);
    }

    @Override
    public void initializeModule() {

    }


    public void initialize(){
        System.out.println("INIT initialize YellowController : " + s);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        s = "OK";
        okok.setText(s);
    }
}
