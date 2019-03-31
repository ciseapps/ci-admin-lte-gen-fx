package org.cise.generator.modules.red;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.cise.generator.applications.bases.BaseViewController;
import org.cise.generator.applications.main.controllers.MainController;

import javax.inject.Inject;

public class RedController extends BaseViewController {

    @FXML
    Button toGreenButton;
    @FXML
    Label lblThread;
    @FXML
    ComboBox<String> changeLanguage;

    @Inject
    public RedController(MainController mainController) {
        super(mainController, "/modules/red/red.fxml");
        toGreenButton.setOnMouseClicked(event -> {
                    //mainController.setContent(new GreenController(mainController))
            testThread();
                }
        );
    }

    private void testThread() {
        new Thread((new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    Thread.sleep(200);
                    final int x = i;
                    Platform.runLater(() -> lblThread.setText(String.valueOf(x)));
                }
                return null;
            }
        })).start();
    }


    @Override
    public void initializeModule() {
        /*
        log.debug("initialize RED");
        changeLanguage.setItems(FXCollections.observableArrayList(new ArrayList<String>() {{
            add("en_US");
            add("in_ID");
        }}));
        changeLanguage.getSelectionModel().selectFirst();
        changeLanguage.setOnAction(event -> getMainController().setResourceBundle(changeLanguage.getSelectionModel().getSelectedItem()));
        */
    }
}
