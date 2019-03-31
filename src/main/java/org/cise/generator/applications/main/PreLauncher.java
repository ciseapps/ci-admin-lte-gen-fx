package org.cise.generator.applications.main;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cise.generator.applications.main.controllers.PreLauncherController;

public class PreLauncher extends Preloader {

    private Logger log = LogManager.getLogger(getClass());
    private Stage primaryStage;
    private PreLauncherController controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        log.debug("start");
        this.primaryStage = primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/modules/templates/loader.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(400);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        log.debug("init");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        log.debug("stop");
    }

    @Override
    public void handleProgressNotification(ProgressNotification info) {
        //controller.setProgress(info.getProgress());
        super.handleProgressNotification(info);
        log.debug("handleProgressNotification : " + info.getProgress());
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        super.handleStateChangeNotification(info);
        switch (info.getType()) {
            case BEFORE_LOAD:

                break;
            case BEFORE_INIT:
                log.debug("before init");

                break;
            case BEFORE_START:
                log.debug("before start");
                log.debug("before load");
                double i = 0;
                do {
                    i += 10;
                    final double x = i;
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            controller.setProgress(x/100);
//                        }
//                    });


                    notifyPreloader(new Preloader.ProgressNotification(i / 100));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (i < 100);
                primaryStage.hide();
                //System.exit(0);
                break;
        }

        log.debug("handleStateChangeNotification : ");
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        super.handleApplicationNotification(info);
        if (info instanceof ProgressNotification) {
            final ProgressNotification pn = (ProgressNotification) info;
            controller.setProgress(pn.getProgress());
//            log.info("progress : " + pn.getProgress());
        }

    }

    @Override
    public boolean handleErrorNotification(ErrorNotification info) {
        log.debug("handleErrorNotification : " + info.toString());
        return super.handleErrorNotification(info);
    }
}
