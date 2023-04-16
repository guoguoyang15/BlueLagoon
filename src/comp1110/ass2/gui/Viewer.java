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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;


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
    // FIXME Task 5
    void displayState(String stateString) {
        String[] parts = stateString.split(";");
        Polygon[] tiles = new Polygon[400];

        for (int i = 0; i < parts.length; i++) {

            if (parts[i].startsWith(" i")) {
                String[] islands = parts[i].split(" ");

                for (int j = 2; j < islands.length; j++) {
                    // Generates the islands
                    if (islands[j].startsWith("[0|2|4|6|8|10|12]")) {
                        String[] coords = islands[j].split(",");
                        int x = Integer.parseInt(coords[0]);
                        int y = Integer.parseInt(coords[1]);
                        tiles[j - 2] = new Polygon();
                        tiles[j - 2].getPoints().addAll(34.64 + 70.28 * y, 0.0 + 81 * x,
                                0.0 + 70.28 * y, 20.0 + 81 * x,
                                0.0 + 70.28 * y, 60.0 + 81 * x,
                                34.64 + 70.28 * y, 80.0 + 81 * x,
                                69.28 + 70.28 * y, 60.0 + 81 * x,
                                69.28 + 70.28 * y, 20.0 + 81 * x);
                        tiles[j - 2].setFill(Color.GREEN);
                    }
                    else if (islands[j].startsWith("[1|3|5|7|9|11]")) {
                        String[] coords = islands[j].split(",");
                        int x = Integer.parseInt(coords[0]);
                        int y = Integer.parseInt(coords[1]);
                        tiles[j - 2] = new Polygon();
                        tiles[j - 2].getPoints().addAll(94.64 + 70.28 * y, 34.64 + 81 * x,
                                60.0 + 70.28 * y, 54.64 + 81 * x,
                                70.0 + 70.28 * y, 94.64 + 81 * x,
                                94.64 + 70.28 * y, 114.64 + 81 * x,
                                159.28 + 70.28 * y, 94.64 + 81 * x,
                                159.28 + 70.28 * y, 54.64 + 81 * x);
                        tiles[j - 2].setFill(Color.GREEN);
                    }
                }
            }
            // Generates the stone circles
            else if (parts[i].startsWith(" s")) {
                String[] stones = parts[i].split(" ");

                for (int j = 2; j < stones.length; j++) {
                    if (stones[j].startsWith("[0|2|4|6|8|10|12]")) {
                        String[] coords = stones[j].split(",");
                        int x = Integer.parseInt(coords[0]);
                        int y = Integer.parseInt(coords[1]);
                        tiles[j + 114] = new Polygon();
                        tiles[j + 114].getPoints().addAll(34.64 + 70.28 * y, 0.0 + 81 * x,
                                0.0 + 70.28 * y, 20.0 + 81 * x,
                                0.0 + 70.28 * y, 60.0 + 81 * x,
                                34.64 + 70.28 * y, 80.0 + 81 * x,
                                69.28 + 70.28 * y, 60.0 + 81 * x,
                                69.28 + 70.28 * y, 20.0 + 81 * x);
                        tiles[j + 114].setFill(Color.LIGHTGREY);
                    }
                    else if (stones[j].startsWith("[1|3|5|7|9|11]")) {
                        String[] coords = stones[j].split(",");
                        int x = Integer.parseInt(coords[0]);
                        int y = Integer.parseInt(coords[1]);
                        tiles[j + 114] = new Polygon();
                        tiles[j + 114].getPoints().addAll(94.64 + 70.28 * y, 34.64 + 81 * x,
                                60.0 + 70.28 * y, 54.64 + 81 * x,
                                70.0 + 70.28 * y, 94.64 + 81 * x,
                                94.64 + 70.28 * y, 114.64 + 81 * x,
                                159.28 + 70.28 * y, 94.64 + 81 * x,
                                159.28 + 70.28 * y, 54.64 + 81 * x);
                        tiles[j + 114].setFill(Color.LIGHTGREY);
                    }
                }
            }
            // Generates the resources
            else if (parts[i].startsWith(" r")) {
                String[] resources = parts[i].split("[C|B|W|P|S]");
                // Generates coconuts
                String[] coconuts = resources[1].split(" ");
                int c1 = 0;
                for (int j = 0; j < coconuts.length; j++) {
                    String[] coords = coconuts[j].split(",");
                    int x = Integer.parseInt(coords[0]);
                    int y = Integer.parseInt(coords[1]);
                    tiles[j + 146] = new Polygon();
                    tiles[j + 146].getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                            39.64 + 70.28 * y, 35.0 + 81 * x,
                            29.64 + 70.28 * y, 45.0 + 81 * x,
                            39.64 + 70.28 * y, 45.0 + 81 * x);
                    tiles[j + 146].setFill(Color.BROWN);
                    c1 = c1 + 1;
                }
                while (c1 < 6) {
                        tiles[c1 + 146] = new Polygon();
                        tiles[c1 + 146].getPoints().addAll(500.0, 10.0 + 10*c1,
                                500.0, 20.0 + 10*c1,
                                510.0, 20.0 + 10*c1,
                                510.0, 10.0 + 10*c1);
                        tiles[c1 + 146].setFill(Color.BROWN);
                    c1++;
                }
                // Generates bamboo
                String[] bamboo = resources[2].split(" ");
                int c2 = 0;
                for (int j = 0; j < bamboo.length; j++) {
                    String[] coords = bamboo[j].split(",");
                    int x = Integer.parseInt(coords[0]);
                    int y = Integer.parseInt(coords[1]);
                    tiles[j + 152] = new Polygon();
                    tiles[j + 152].getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                            39.64 + 70.28 * y, 35.0 + 81 * x,
                            29.64 + 70.28 * y, 45.0 + 81 * x,
                            39.64 + 70.28 * y, 45.0 + 81 * x);
                    tiles[j + 152].setFill(Color.DARKOLIVEGREEN);
                    c2 = c2 + 1;
                }
                while (c2 < 6) {
                        tiles[c1 + 152] = new Polygon();
                        tiles[c1 + 152].getPoints().addAll(500.0, 10.0 + 10*c2,
                                500.0, 20.0 + 10*c2,
                                510.0, 20.0 + 10*c2,
                                510.0, 10.0 + 10*c2);
                        tiles[c1 + 152].setFill(Color.DARKOLIVEGREEN);
                        c2++;
                }

                // Generates water
                String[] water = resources[3].split(" ");
                int c3 = 0;
                for (int j = 0; j < water.length; j++) {
                    String[] coords = water[j].split(",");
                    int x = Integer.parseInt(coords[0]);
                    int y = Integer.parseInt(coords[1]);
                    tiles[j + 158] = new Polygon();
                    tiles[j + 158].getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                            39.64 + 70.28 * y, 35.0 + 81 * x,
                            29.64 + 70.28 * y, 45.0 + 81 * x,
                            39.64 + 70.28 * y, 45.0 + 81 * x);
                    tiles[j + 158].setFill(Color.LIGHTBLUE);
                    c3 = c3 + 1;
                }
                while (c3 < 6) {
                    tiles[c3 + 158] = new Polygon();
                    tiles[c3 + 158].getPoints().addAll(500.0, 10.0 + 10*c3,
                            500.0, 20.0 + 10*c3,
                            510.0, 20.0 + 10*c3,
                            510.0, 10.0 + 10*c3);
                    tiles[c3 + 158].setFill(Color.BROWN);
                    c3++;
                }

                // Generates precious stone
                String[] preciousStone = resources[4].split(" ");
                int c4 = 0;
                for (int j = 0; j < preciousStone.length; j++) {
                    String[] coords = preciousStone[j].split(",");
                    int x = Integer.parseInt(coords[0]);
                    int y = Integer.parseInt(coords[1]);
                    tiles[j + 164] = new Polygon();
                    tiles[j + 164].getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                            39.64 + 70.28 * y, 35.0 + 81 * x,
                            29.64 + 70.28 * y, 45.0 + 81 * x,
                            39.64 + 70.28 * y, 45.0 + 81 * x);
                    tiles[j + 164].setFill(Color.LIGHTBLUE);
                    c4 = c4 + 1;
                }
                while (c4 < 6) {
                    tiles[c4 + 164] = new Polygon();
                    tiles[c4 + 164].getPoints().addAll(500.0, 10.0 + 10*c4,
                            500.0, 20.0 + 10*c4,
                            510.0, 20.0 + 10*c4,
                            510.0, 10.0 + 10*c4);
                    tiles[c4 + 164].setFill(Color.LIGHTBLUE);
                    c4++;
                }

                // Generates statuettes
                String[] statuette = resources[5].split(" ");
                int c5 = 0;
                for (int j = 0; j < statuette.length; j++) {
                    String[] coords = statuette[j].split(",");
                    int x = Integer.parseInt(coords[0]);
                    int y = Integer.parseInt(coords[1]);
                    tiles[j + 172] = new Polygon();
                    tiles[j + 172].getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                            39.64 + 70.28 * y, 35.0 + 81 * x,
                            29.64 + 70.28 * y, 45.0 + 81 * x,
                            39.64 + 70.28 * y, 45.0 + 81 * x);
                    tiles[j + 172].setFill(Color.LIGHTBLUE);
                    c5 = c5 + 1;
                }
                while (c5 < 8) {
                    tiles[c5 + 172] = new Polygon();
                    tiles[c5 + 172].getPoints().addAll(500.0, 10.0 + 10*c5,
                            500.0, 20.0 + 10*c5,
                            510.0, 20.0 + 10*c5,
                            510.0, 10.0 + 10*c5);
                    tiles[c5 + 172].setFill(Color.LIGHTBLUE);
                    c5++;
                }
            }
        }
        List<Polygon> tilesList = Arrays.asList(tiles);
        root.getChildren().addAll(tilesList);
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
