package org.cise.generator.applications.commons.ui;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class AlertUtils {

    public static void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
