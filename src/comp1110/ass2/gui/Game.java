package comp1110.ass2.gui;

import comp1110.ass2.Board;
import comp1110.ass2.Player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


// FIXME Task 14
// FIXME Task 15

public class Game extends Application {
    private final Group root = new Group();
    private final Group controls = new Group();
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 700;
    private TextField stateTextField;
    final VBox scoreTable = new VBox();

    // Written by Tyler
    public static void main(String[] args) {
        launch(args);
    }
    // Displays the scoreboard using a table
    public void scoreboard(String stateString) {
        Board b = new Board(stateString);

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

        scores.getColumns().add(column1);
        scores.getColumns().add(column2);
        scores.getColumns().add(column3);
        scores.getColumns().add(column4);
        scores.getColumns().add(column5);
        scores.getColumns().add(column6);
        scores.getColumns().add(column7);

//        for (int i = 0; i < b.getPlayerNum(); i++) {
//            scores.getItems().add(
////                    new Player(i, stateString));
//        }

        scoreTable.getChildren().addAll(scores);
        }

    private void makeControls() {
        Label playerLabel = new Label("Game State:");
        stateTextField = new TextField();
        stateTextField.setPrefWidth(200);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {scoreboard(stateTextField.getText());
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(playerLabel, stateTextField, button);
        hb.setSpacing(10);
        hb.setLayoutX(50);
        hb.setLayoutY(WINDOW_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(scene);
        root.getChildren().addAll(controls, scoreTable);

        makeControls();

        stage.setScene(scene);
        stage.show();
    }
}
