package org.cise.generator.modules.datagrid.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.cise.generator.applications.bases.BaseViewController;
import org.cise.generator.applications.main.controllers.MainController;
import org.cise.generator.modules.datagrid.models.PageableListener;

import java.util.concurrent.atomic.AtomicInteger;

public class DatagridController extends BaseViewController implements PageableListener {

    @FXML
    Button previousPage, nextPage;

    @FXML
    TextField infoPage;

    public DatagridController(MainController mainController) {
        super(mainController, "/modules/datagrid/datagrid.fxml");
    }

    @Override
    public void onPageChange(int currentPage) {
        log.debug("current page : " + currentPage);
    }

    @Override
    public void initializeModule() {
        new Pageable(this, previousPage, nextPage, infoPage);
    }

    private class Pageable {

        private PageableListener pageableListener;

        Button previousPage, nextPage;
        TextField infoPage;

        AtomicInteger page = new AtomicInteger(1);

        public Pageable(PageableListener pageableListener, Button previousPage, Button nextPage, TextField infoPage) {
            this.pageableListener = pageableListener;
            this.previousPage = previousPage;
            this.nextPage = nextPage;
            this.infoPage = infoPage;
            this.previousPage.setOnAction(event -> {
                previousAction();
            });
            this.nextPage.setOnAction(event -> {
                nextAction();
            });
            this.infoPage.setOnAction(event -> {
                log.debug(infoPage.getText());
                currentAction(infoPage.getText());
            });
            this.previousPage.setDisable(true);
            this.infoPage.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("[0-9]*")) {
                    this.infoPage.setText(oldValue);
                }
            });
        }

        private void previousAction() {
            page.decrementAndGet();
            log.debug("previous : " + page.get());
            if (page.get() < 2) {
                this.previousPage.setDisable(true);
            }
            infoPage.setText(String.valueOf(page.get()));
            onUpdatePage(page.get());
        }

        private void currentAction(String pageValue) {
            if (!"".equalsIgnoreCase(pageValue)) {
                page.set(Integer.valueOf(pageValue));
                this.previousPage.setDisable(page.get() < 2);
                log.debug("current: " + page.get());
            }
            infoPage.clear();
            infoPage.appendText(String.valueOf(page.get()));
            onUpdatePage(page.get());
        }

        private void nextAction() {
            page.incrementAndGet();
            log.debug("next: " + page.get());
            if (page.get() > 1) {
                this.previousPage.setDisable(false);
            }
            infoPage.setText(String.valueOf(page.get()));
            onUpdatePage(page.get());
        }


        private void onUpdatePage(int currentPage) {
            if (pageableListener != null) {
                pageableListener.onPageChange(currentPage);
            }
        }

    }
}
