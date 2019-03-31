package org.cise.generator.modules.dialog.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.cise.generator.applications.bases.BaseDialogController;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AlertChooserController extends BaseDialogController {

    @FXML
    Label title;

    @FXML
    TextField txtSearch;

    @FXML
    ListView listView;

    Predicate predicate;

    private ObservableList<String> listSource = FXCollections.observableArrayList();
    private ObservableList<String> listFilter = FXCollections.observableArrayList();

    public AlertChooserController() {
        super(null);
    }

    @Override
    public void initializeModule() {
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("textfield changed from " + oldValue + " to " + newValue);
            if (!newValue.isEmpty()) {
                listFilter.clear();
                listFilter.addAll(listSource.stream().filter(x -> {
//                    log.info(x + " is equal " + newValue);
//                    log.info(String.valueOf(x).contains(newValue));
                    return String.valueOf(x).contains(newValue);
                }).collect(Collectors.toList()));
            } else {
                log.debug(newValue);
                listFilter.clear();
                listFilter.addAll(listSource);
            }
        });
    }

    @Override
    public void setCell(Class clazzCell) {
        listView.setCellFactory(s -> {
            try {
                return ((ListCell) clazzCell.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new IllegalArgumentException("cannot cast cell from " + clazzCell.getName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                log.error(e.getMessage());
                return null;
            }
        });
    }

    @Override
    public void setList(ObservableList list) {
        listSource.addAll(list);
        listFilter.addAll(list);
        if (listView.getItems() == null) {
            listView.setItems(listFilter);
        } else {
            listFilter = listView.getItems();
            listFilter.addAll(list);
        }
    }

    @Override
    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }

}
