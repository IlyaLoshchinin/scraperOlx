package com.scraperJava.App;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.concurrent.Future;


public class App extends Application {

  Future result;
  Stage window;


  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("Scraper");

    BorderPane layoutBorder = new BorderPane();
    Button btn = new Button("Start");
    btn.setPrefSize(50, 100);
    btn.setOnAction(event -> {
      Scraper.startScraping();
      //((Button) event.getSource()).setDisable(true);
    });

    // Future result =  es.submit(scraper);

    layoutBorder.setCenter(btn);

    window.setOnCloseRequest(e -> {
      Scraper.executorShoutdown();
      Platform.exit();
    });
    Scene scene = new Scene(layoutBorder, 250, 200);
    window.setScene(scene);
    window.show();
  }
}
