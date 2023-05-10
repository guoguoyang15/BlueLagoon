package comp1110.ass2.gui;

import comp1110.ass2.Player;
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
    public static class Scoreboard<PlayerNumber, Score> extends Application {
        // Written by Tyler
        // Displays the scoreboard using a table
        public static void main(String[] args) {
            launch(args);
        }
        @Override
        public void start(Stage primaryStage) {

            TableView tableView = new TableView();

            TableColumn<PlayerNumber, Integer> column1 =
                    new TableColumn<>("Player #");

            column1.setCellValueFactory(
                    new PropertyValueFactory<>("playerNumber"));

            TableColumn<Score, Integer> column2 =
                    new TableColumn<>("Score");

            column2.setCellValueFactory(
                    new PropertyValueFactory<>("score"));

            TableColumn<Score, Integer> column3 =
                    new TableColumn<>("Settlers");

            column3.setCellValueFactory(
                    new PropertyValueFactory<>("settlers"));


            tableView.getColumns().add(column1);
            tableView.getColumns().add(column2);

            tableView.getItems().add(
                    new Player());
            tableView.getItems().add(
                    new Player());

            VBox vbox = new VBox(tableView);

            Scene scene = new Scene(vbox);

            primaryStage.setScene(scene);

            primaryStage.show();
        }

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
