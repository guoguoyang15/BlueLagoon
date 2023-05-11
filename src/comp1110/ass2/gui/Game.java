package comp1110.ass2.gui;

import comp1110.ass2.Player;
//import comp1110.ass2.Player.getStats;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


// FIXME Task 14
// FIXME Task 15
public class Game extends Application {
    // Written by Tyler
    public static void main(String[] args) {
        launch(args);
    }
    // Displays the scoreboard using a table
    public void scoreboard(String stateString) {
        TableView scores = new TableView();

        TableColumn<Player, Integer> column1 =
            new TableColumn<>("Player #");
        column1.setCellValueFactory(
            new PropertyValueFactory<>("playerNumber"));
        TableColumn<Player, Integer> column2 =
            new TableColumn<>("Score");
        column2.setCellValueFactory(
            new PropertyValueFactory<>("score"));
        TableColumn<Player, Integer> column3 =
            new TableColumn<>("C");
        column3.setCellValueFactory(
            new PropertyValueFactory<>("coconut"));
        TableColumn<Player, Integer> column4 =
                new TableColumn<>("B");
        column4.setCellValueFactory(
                new PropertyValueFactory<>("bamboo"));
        TableColumn<Player, Integer> column5 =
                new TableColumn<>("W");
        column5.setCellValueFactory(
                new PropertyValueFactory<>("water"));
        TableColumn<Player, Integer> column6 =
                new TableColumn<>("P");
        column6.setCellValueFactory(
                new PropertyValueFactory<>("stone"));
        TableColumn<Player, Integer> column7 =
                new TableColumn<>("S");
        column7.setCellValueFactory(
                new PropertyValueFactory<>("statuette"));
        TableColumn<Player, Integer> column8 =
                new TableColumn<>("Settlers");
        column8.setCellValueFactory(
                new PropertyValueFactory<>("settlers"));
        TableColumn<Player, Integer> column9 =
                new TableColumn<>("Villages");
        column9.setCellValueFactory(
                new PropertyValueFactory<>("villages"));


        scores.getColumns().add(column1);
        scores.getColumns().add(column2);
        scores.getColumns().add(column3);
        scores.getColumns().add(column4);
        scores.getColumns().add(column5);
        scores.getColumns().add(column6);
        scores.getColumns().add(column7);
        scores.getColumns().add(column8);
        scores.getColumns().add(column9);

//        scores.getItems().add(
//            new getStats(0, stateString));
        scores.getItems().add(
            new Player());

        VBox vbox = new VBox(scores);
        Scene scene = new Scene(vbox);
        }

    private final Group root = new Group();
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 700;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
}
