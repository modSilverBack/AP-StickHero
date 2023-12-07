package com.application.stickhero;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainSceneController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private CheckBox musicCheckbox;
    @FXML
    private Button playButton;
    @FXML
    private Button avatarsButton;
    @FXML
    private Label berriesCount;
    MediaPlayer mediaPlayer;

    @FXML
    private void initialize() {
        String musicFilePath = App.class.getResource("music.mp3").toString();;
        Media media = new Media(musicFilePath);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), playButton);
        translateTransition.setByY(-3);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), playButton);
        scaleTransition.setToX(1.02);
        scaleTransition.setToY(1.02);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);

        ParallelTransition parallelTransition = new ParallelTransition(translateTransition, scaleTransition);
        parallelTransition.play();
    }
    @FXML
    private void toggleMusic() {
        if (musicCheckbox.isSelected()) {
            mediaPlayer.play();
        } else {
            mediaPlayer.pause();
        }
    }

    @FXML
    private void switchToPlayScene() throws IOException {
        Stage stage = (Stage) musicCheckbox.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("GameScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }


}
