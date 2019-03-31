package org.cise.generator.applications.main;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher extends Application {

    private Logger log = LogManager.getLogger(getClass());

    @Override
    public void start(Stage primaryStage) throws Exception {
        log.debug("start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/modules/templates/main_layout.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Root Menu");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1280);
        primaryStage.setMinHeight(720);
        primaryStage.show();
    }

    public static void main(String[] args) {
        initializeLogger();
        LauncherImpl.launchApplication(Launcher.class, PreLauncher.class, args);
        //launch(args);
    }

    private static void initializeLogger() {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }


}
