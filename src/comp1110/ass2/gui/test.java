package comp1110.ass2.gui;

import comp1110.ass2.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.transform.Translate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class test extends Application {
    @Override
    public void start(Stage stage) {
        Button button1 = new Button("Stage 1");
        button1.setOnAction(event -> {
            AudioClip music=new AudioClip(getClass().getResource("/music/music.mp3").toString());
            music.play();
        });
        StackPane root = new StackPane(button1);
        Scene scene = new Scene(root, 300, 200);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.show();
        // 将Stage 1设置为始终显示在最前面
        stage1.setAlwaysOnTop(true);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
