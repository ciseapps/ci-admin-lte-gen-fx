package org.cise.generator.modules.datagrid;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ChooserCell extends ListCell {

    @FXML
    private AnchorPane contentCell;
    @FXML
    private Label label;

    private FXMLLoader loader;

    @Override
    protected void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            try {
                if (loader == null) {
                    loader = new FXMLLoader(getClass().getResource("/modules/alert/chooser_cell.fxml"));
                    loader.setController(this);
                    loader.load();
                }
                if(item instanceof String){
                    label.setText(String.valueOf(item));
                }
                setGraphic(contentCell);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
