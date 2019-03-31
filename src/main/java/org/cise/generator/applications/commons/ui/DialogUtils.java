package org.cise.generator.applications.commons.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.cise.generator.applications.bases.BaseDialogController;

import java.io.IOException;
import java.util.function.Predicate;

public class DialogUtils<T extends BaseDialogController> {

    private T controller;
    private FXMLLoader loader = new FXMLLoader();
    private Stage stage = new Stage();

    public DialogUtils(String pathXML) {
        initialize(null, pathXML);
    }

    public DialogUtils(String title, String pathXML) {
        initialize(title, pathXML);
    }

    private void initialize(String title, String pathXML) {
        try {
            loader.setLocation(getClass().getResource(pathXML));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            controller = loader.getController();
            controller.initializeModule();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setController(T controller) {
        loader.setController(controller);
    }

    public T getController() {
        return loader.getController();
    }

    public void setTitle(String title) {
        controller.setTitle(title);
    }

    public void show(boolean isWaiting) {
        if (isWaiting) {
//            Bounds currentMouseLocation = controller.localToScreen(controller.getBoundsInLocal());
//            double popOverX = (currentMouseLocation.getMinX() + currentMouseLocation.getMaxX()) / 2;
//            double popOverY = (currentMouseLocation.getMinY() + currentMouseLocation.getMaxY()) / 2;
//            stage.setX(popOverX);
//            stage.setY(popOverY);
            stage.showAndWait();
        } else {
//            Bounds currentMouseLocation = controller.localToScreen(controller.getBoundsInLocal());
//            double popOverX = (currentMouseLocation.getMinX() + currentMouseLocation.getMaxX()) / 2;
//            double popOverY = (currentMouseLocation.getMinY() + currentMouseLocation.getMaxY()) / 2;
//            stage.setX(popOverX);
//            stage.setY(popOverY);
            stage.show();
        }
    }


    public void setCell(Class clazzCell) {
        controller.setCell(clazzCell);
    }

    public void setList(ObservableList list) {
        controller.setList(list);
    }

    public void setPredicate(Predicate predicate) {
        controller.setPredicate(predicate);
    }
}
