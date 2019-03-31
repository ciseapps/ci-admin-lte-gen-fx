package org.cise.generator.applications.bases;

import javafx.collections.ObservableList;
import javafx.stage.Stage;
import org.cise.generator.applications.main.controllers.MainController;

import java.util.function.Predicate;

public abstract class BaseDialogController extends BaseViewController {

    private Stage stage;

    public BaseDialogController(String fxml) {
        super(fxml);
    }

    public BaseDialogController(MainController mainController, String fxml) {
        super(mainController, fxml);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void close() {
        if (stage != null) stage.close();
    }

    public abstract void setTitle(String title);

    public abstract void setCell(Class clazzCell);

    public abstract void setList(ObservableList list);

    public abstract void setPredicate(Predicate predicate);
}
