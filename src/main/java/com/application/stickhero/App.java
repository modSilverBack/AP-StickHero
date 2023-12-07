package com.application.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class App extends Application
{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("MainScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("StickHero");

        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("hero.png")));
        stage.getIcons().add(icon);

        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}