package org.cise.generator.applications.bases;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cise.generator.applications.main.controllers.MainController;

import java.io.IOException;

public abstract class BaseViewController extends AnchorPane {

    protected final Logger log = LogManager.getLogger(getClass());

    protected MainController mainController;

    public BaseViewController(String fxml) {
        loadFXML(null, fxml);
        log.debug("construct 1 baseview");
    }

    public BaseViewController(MainController mainController, String fxml) {
        loadFXML(mainController, fxml);
        log.debug("construct 2 baseview");
    }

    protected void loadFXML(MainController mainController, String fxml) {
        this.mainController = mainController;
        if (mainController != null && fxml != null && !"".equalsIgnoreCase(fxml.trim())) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml), mainController.getResourceBundle());
                fxmlLoader.setRoot(this);
                fxmlLoader.setController(this);
                fxmlLoader.load();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    public MainController getMainController() {
        if (null == mainController) {
            throw new NullPointerException("MainController not initialize before!");
        } else {
            return mainController;
        }
    }

    public void openDialog(String title, String pathXML) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BaseViewController.class.getResource(pathXML));
            AnchorPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle(title);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void initializeModule();


}
