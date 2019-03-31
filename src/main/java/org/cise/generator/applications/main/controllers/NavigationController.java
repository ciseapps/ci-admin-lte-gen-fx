package org.cise.generator.applications.main.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.cise.generator.applications.bases.BaseViewController;
import org.cise.generator.applications.main.components.MainAppComponent;
import org.cise.generator.applications.main.components.DaggerMainAppComponent;
import org.cise.generator.applications.main.modules.MainControllerModule;
import org.cise.generator.modules.datagrid.controllers.DatagridController;
import org.cise.generator.modules.dialog.controllers.AlertDialogController;
import org.cise.generator.modules.green.GreenController;
import org.cise.generator.modules.login.constrollers.LoginController;
import org.cise.generator.modules.pageable.controllers.PageableController;
import org.cise.generator.modules.red.RedController;
import org.cise.generator.modules.yellow.controllers.YellowController;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NavigationController extends BaseViewController implements EventHandler<MouseEvent> {

    @FXML
    VBox navContainer;

    @Inject
    YellowController yellowController ;

    @Inject
    RedController redController;

    @Inject
    GreenController greenController;

    private AtomicInteger index = new AtomicInteger(1);
    private Map<String, Pane> menus = new HashMap<>();
    private String currentMenuId;

    @Inject
    public NavigationController(MainController mainController) {
        super(mainController, "/modules/templates/navigation.fxml");
        MainAppComponent component = DaggerMainAppComponent.builder().mainControllerModule(new MainControllerModule(mainController)).build();
        component.inject(this);
        initializeMenu();
    }

    @Override
    public void initializeModule() {
    }

    /**
     * initialize menu
     */
    private void initializeMenu() {
        log.debug("register templates models start");
        AlertDialogController adc = new AlertDialogController(mainController);
        registerMenuNavigation("Alert", adc);
        registerMenuNavigation("Yellow", yellowController);
        registerMenuNavigation("Red", redController);
        registerMenuNavigation("Green", greenController);
        registerMenuNavigation("Green 2", greenController);
        registerMenuNavigation("DataGrid", new DatagridController(mainController));
        registerMenuNavigation("Pageable", new PageableController(mainController));
        registerMenuNavigation("Login", new LoginController(mainController));
        log.debug("register templates models finish");
        getMainController().setContent(adc);
        adc.initializeModule();
    }

    private void registerMenuNavigation(String name, BaseViewController baseViewController) {
        Button btn = new Button(name);
        btn.setId("nav-" + index.getAndIncrement());
        btn.setPrefWidth(Double.MAX_VALUE);
        btn.setOnMouseClicked(this);
        navContainer.getChildren().add(btn);
        menus.put(btn.getId(), baseViewController);
    }

    @Override
    public void handle(MouseEvent event) {
        Node node = (Node) event.getSource();
        if (!(node.getId().equalsIgnoreCase(currentMenuId))) {
            currentMenuId = node.getId();
            log.debug("navigate module : " + node.getId());
            Pane pane = menus.get(node.getId());
            BaseViewController bvc;
            getMainController().setContent(pane);
            if (pane instanceof BaseViewController) {
                bvc = (BaseViewController) pane;
                bvc.initializeModule();
            }
        }
    }

}