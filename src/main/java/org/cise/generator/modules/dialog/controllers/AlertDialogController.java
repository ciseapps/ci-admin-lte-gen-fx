package org.cise.generator.modules.dialog.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import org.cise.generator.applications.bases.BaseViewController;
import org.cise.generator.applications.commons.ui.AlertUtils;
import org.cise.generator.applications.commons.ui.DialogUtils;
import org.cise.generator.applications.main.controllers.MainController;
import org.cise.generator.modules.datagrid.ChooserCell;

public class AlertDialogController extends BaseViewController {

    @FXML
    Button btnStandard, btnWarning, btnError, btnConfirm, btnConfirmCustom, btnForm;

    public AlertDialogController(MainController mainController) {
        super(mainController, "/modules/alert/alert_dialog.fxml");
    }


    @Override
    public void initializeModule() {
        btnStandard.setOnAction(event -> {
            AlertUtils.showAlert(Alert.AlertType.INFORMATION, "Info", "Alert Info", "");
        });
        btnWarning.setOnAction(event -> {
            AlertUtils.showAlert(Alert.AlertType.WARNING, "Warning", "Alert Warning", "");

        });
        btnError.setOnAction(event -> {
            AlertUtils.showAlert(Alert.AlertType.ERROR, "Error", "Alert Error", "");

        });
        btnConfirm.setOnAction(event -> {
            AlertUtils.showAlert(Alert.AlertType.INFORMATION, "", "", "");

        });
        btnConfirmCustom.setOnAction(event -> {
            AlertUtils.showAlert(Alert.AlertType.INFORMATION, "", "", "");
        });
        btnForm.setOnAction(event -> {
            DialogUtils dialog = new DialogUtils<AlertChooserController>("/modules/alert/alert_form.fxml");
            dialog.setTitle("SEARCH");
            dialog.setCell(ChooserCell.class);
            dialog.setList(getSample());
            dialog.show(false);
        });
    }

    public ObservableList getSample(){
        ObservableList list = FXCollections.observableArrayList();
        for(int i=0 ; i<100;i++){
            list.addAll(String.valueOf(i));
        }
        return list;
    }

}
