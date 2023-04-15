package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class Viewer extends Application {

    private static final int VIEWER_WIDTH = 1200;
    private static final int VIEWER_HEIGHT = 700;

    private final Group root = new Group();
    private final Group controls = new Group();
    private TextField stateTextField;


    /**
     * Given a state string, draw a representation of the state
     * on the screen.
     * <p>
     * This may prove useful for debugging complex states.
     *
     * @param stateString a string representing a game state
     */
    void displayState(String stateString) {
        String[] parts = stateString.split(";");
        class Hex extends Application {
            public void start(Stage stage) {
                Polygon p = new Polygon();
                p.getPoints().addAll(34.64, 0.0,
                        0.0, 20.0,
                        0.0, 60.0,
                        34.64, 80.0,
                        69.28, 60.0,
                        69.28, 20.0);
                p.setFill(Color.LIGHTGREY);

                Group root = new Group(p);
                Scene scene = new Scene(root, 600, 519);
                root.setLayoutX(300.0);
                root.setLayoutY(259.5);

                stage.setTitle("Board");
                stage.setScene(scene);
                stage.show();
            }
        }

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].startsWith(" i")) {
                String[] islands = parts[i].split(" ");
                for (int j = 2; j < parts[i].length(); j++) {
                    if (islands[j].startsWith("[1|3|5|7|9|11]")) {

                    }
                }
            }
        }
    }
    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label playerLabel = new Label("Game State:");
        stateTextField = new TextField();
        stateTextField.setPrefWidth(200);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayState(stateTextField.getText());
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(playerLabel, stateTextField, button);
        hb.setSpacing(10);
        hb.setLayoutX(50);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Blue Lagoon Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        root.getChildren().add(controls);

        makeControls();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
