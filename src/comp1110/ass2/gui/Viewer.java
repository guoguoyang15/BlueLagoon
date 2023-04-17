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
import java.util.ArrayList;
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
    void displayState(String stateString) {
        String[] parts = stateString.split(";");
        List<Polygon> tilesList = new ArrayList<>();

        for (int i = 0; i < parts.length; i++) {

            // Generates the islands
            if (parts[i].startsWith(" i")) {
                String[] islands = parts[i].split(" ");
                for (int j = 2; j < islands.length; j++) {
                    if (islands[j].startsWith("[0|2|4|6|8|10|12]")) {
                        String[] coords = islands[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(34.64 + 70.28*y, 0.0 + 81*x,
                                0.0 + 70.28*y, 20.0 + 81*x,
                                0.0 + 70.28*y, 60.0 + 81*x,
                                34.64 + 70.28*y, 80.0 + 81*x,
                                69.28 + 70.28*y, 60.0 + 81*x,
                                69.28 + 70.28*y, 20.0 + 81*x);
                        p.setFill(Color.LIGHTGREEN);
                        tilesList.add(p);
                    }
                    else if (islands[j].startsWith("[1|3|5|7|9|11]")) {
                        String[] coords = islands[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(94.64 + 70.28 * y, 34.64 + 81 * x,
                                60.0 + 70.28 * y, 54.64 + 81 * x,
                                70.0 + 70.28 * y, 94.64 + 81 * x,
                                94.64 + 70.28 * y, 114.64 + 81 * x,
                                159.28 + 70.28 * y, 94.64 + 81 * x,
                                159.28 + 70.28 * y, 54.64 + 81 * x);
                        p.setFill(Color.LIGHTGREEN);
                        tilesList.add(p);
                    }
                }
            }
            // Generates the stone circles
            else if (parts[i].startsWith(" s")) {
                String[] stones = parts[i].split(" ");
                for (int j = 2; j < stones.length; j++) {
                    if (stones[j].startsWith("[0|2|4|6|8|10|12]")) {
                        String[] coords = stones[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(34.64 + 70.28 * y, 0.0 + 81 * x,
                                0.0 + 70.28 * y, 20.0 + 81 * x,
                                0.0 + 70.28 * y, 60.0 + 81 * x,
                                34.64 + 70.28 * y, 80.0 + 81 * x,
                                69.28 + 70.28 * y, 60.0 + 81 * x,
                                69.28 + 70.28 * y, 20.0 + 81 * x);
                        p.setFill(Color.DARKSLATEGRAY);
                        tilesList.add(p);
                    }
                    else if (stones[j].startsWith("[1|3|5|7|9|11]")) {
                        String[] coords = stones[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(94.64 + 70.28 * y, 34.64 + 81 * x,
                                60.0 + 70.28 * y, 54.64 + 81 * x,
                                70.0 + 70.28 * y, 94.64 + 81 * x,
                                94.64 + 70.28 * y, 114.64 + 81 * x,
                                159.28 + 70.28 * y, 94.64 + 81 * x,
                                159.28 + 70.28 * y, 54.64 + 81 * x);
                        p.setFill(Color.DARKSLATEGRAY);
                        tilesList.add(p);
                    }
                }
            }
            // Generates the resources
            else if (parts[i].startsWith(" r")) {
                String[] resources = parts[i].split("[C|B|W|P|S]");
                // Generates coconuts
                String[] coconuts = resources[1].split(" ");
                int c1 = 0;
                for (int j = 1; j < coconuts.length; j++) {
                    String[] coords = coconuts[j].split(",");
                    double x = Double.parseDouble(coords[0]);
                    double y = Double.parseDouble(coords[1]);
                    Polygon p = new Polygon();
                    p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                            39.64 + 70.28 * y, 35.0 + 81 * x,
                            29.64 + 70.28 * y, 45.0 + 81 * x,
                            39.64 + 70.28 * y, 45.0 + 81 * x);
                    p.setFill(Color.LIGHTGRAY);
                    tilesList.add(p);
                    c1 = c1 + 1;
                }
                while (c1 < 6) {
                        Polygon p = new Polygon();
                        p.getPoints().addAll(900.0, 10.0 + 15*c1,
                                900.0, 20.0 + 15*c1,
                                910.0, 20.0 + 15*c1,
                                910.0, 10.0 + 15*c1);
                        p.setFill(Color.LIGHTGRAY);
                    tilesList.add(p);
                    c1++;
                }
                // Generates bamboo
                String[] bamboo = resources[2].split(" ");
                int c2 = 0;
                for (int j = 1; j < bamboo.length; j++) {
                    String[] coords = bamboo[j].split(",");
                    double x = Double.parseDouble(coords[0]);
                    double y = Double.parseDouble(coords[1]);
                    Polygon p = new Polygon();
                    p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                            39.64 + 70.28 * y, 35.0 + 81 * x,
                            29.64 + 70.28 * y, 45.0 + 81 * x,
                            39.64 + 70.28 * y, 45.0 + 81 * x);
                    p.setFill(Color.LIGHTYELLOW);
                    tilesList.add(p);
                    c2 = c2 + 1;
                }
                while (c2 < 6) {
                        Polygon p = new Polygon();
                        p.getPoints().addAll(950.0, 10.0 + 15*c2,
                                950.0, 20.0 + 15*c2,
                                960.0, 20.0 + 15*c2,
                                960.0, 10.0 + 15*c2);
                        p.setFill(Color.LIGHTYELLOW);
                    tilesList.add(p);
                        c2++;
                }
                // Generates water
                String[] water = resources[3].split(" ");
                int c3 = 0;
                for (int j = 1; j < water.length; j++) {
                    String[] coords = water[j].split(",");
                    double x = Double.parseDouble(coords[0]);
                    double y = Double.parseDouble(coords[1]);
                    Polygon p = new Polygon();
                    p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                            39.64 + 70.28 * y, 35.0 + 81 * x,
                            29.64 + 70.28 * y, 45.0 + 81 * x,
                            39.64 + 70.28 * y, 45.0 + 81 * x);
                    p.setFill(Color.LIGHTBLUE);
                    tilesList.add(p);
                    c3 = c3 + 1;
                }
                while (c3 < 6) {
                    Polygon p = new Polygon();
                    p.getPoints().addAll(1000.0, 10.0 + 15*c3,
                            1000.0, 20.0 + 15*c3,
                            1010.0, 20.0 + 15*c3,
                            1010.0, 10.0 + 15*c3);
                    p.setFill(Color.LIGHTBLUE);
                    tilesList.add(p);
                    c3++;
                }
                // Generates precious stone
                String[] preciousStone = resources[4].split(" ");
                int c4 = 0;
                for (int j = 1; j < preciousStone.length; j++) {
                    String[] coords = preciousStone[j].split(",");
                    double x = Double.parseDouble(coords[0]);
                    double y = Double.parseDouble(coords[1]);
                    Polygon p = new Polygon();
                    p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                            39.64 + 70.28 * y, 35.0 + 81 * x,
                            29.64 + 70.28 * y, 45.0 + 81 * x,
                            39.64 + 70.28 * y, 45.0 + 81 * x);
                    p.setFill(Color.DARKSEAGREEN);
                    tilesList.add(p);
                    c4 = c4 + 1;
                }
                while (c4 < 6) {
                    Polygon p = new Polygon();
                    p.getPoints().addAll(1050.0, 10.0 + 15*c4,
                            1050.0, 20.0 + 15*c4,
                            1060.0, 20.0 + 15*c4,
                            1060.0, 10.0 + 15*c4);
                    p.setFill(Color.DARKSEAGREEN);
                    tilesList.add(p);
                    c4++;
                }
                // Generates statuettes
                int c5 = 0;
                if (resources.length == 5) {
                }
                else {
                    String[] statuette = resources[5].split(" ");
                    for (int j = 1; j < statuette.length; j++) {
                        String[] coords = statuette[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                                39.64 + 70.28 * y, 35.0 + 81 * x,
                                29.64 + 70.28 * y, 45.0 + 81 * x,
                                39.64 + 70.28 * y, 45.0 + 81 * x);
                        p.setFill(Color.MAROON);
                        tilesList.add(p);
                        c5 = c5 + 1;
                    }
                }
                while (c5 < 8) {
                    Polygon p = new Polygon();
                    p.getPoints().addAll(1100.0, 10.0 + 15*c5,
                            1100.0, 20.0 + 15*c5,
                            1110.0, 20.0 + 15*c5,
                            1110.0, 10.0 + 15*c5);
                    p.setFill(Color.MAROON);
                    tilesList.add(p);
                    c5++;
                }
            }
            // Generates villages and settlers
            else if (parts[i].startsWith(" p")) {
                String[] pieces = parts[i].split("[p |S|T]");
                // Player 0
                if (pieces[1].startsWith("0")) {
                    String[] settlers = pieces[3].split(" ");
                    for (int j = 0; j < settlers.length; j++) {
                        String[] coords = settlers[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                                39.64 + 70.28 * y, 35.0 + 81 * x,
                                29.64 + 70.28 * y, 45.0 + 81 * x,
                                39.64 + 70.28 * y, 45.0 + 81 * x);
                        p.setFill(Color.PINK);
                        tilesList.add(p);
                    }
                    String[] villages = pieces[4].split(" ");
                    for (int j = 0; j < villages.length; j++) {
                        String[] coords = villages[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                                39.64 + 70.28 * y, 35.0 + 81 * x,
                                29.64 + 70.28 * y, 45.0 + 81 * x,
                                39.64 + 70.28 * y, 45.0 + 81 * x);
                        p.setFill(Color.DEEPPINK);
                        tilesList.add(p);
                    }
                }
                // Player 1
                else if (pieces[1].startsWith("1")) {
                    String[] settlers = pieces[3].split(" ");
                    for (int j = 0; j < settlers.length; j++) {
                        String[] coords = settlers[j].split(",");
                        int x = Integer.parseInt(coords[0]);
                        int y = Integer.parseInt(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                                39.64 + 70.28 * y, 35.0 + 81 * x,
                                29.64 + 70.28 * y, 45.0 + 81 * x,
                                39.64 + 70.28 * y, 45.0 + 81 * x);
                        p.setFill(Color.ORANGE);
                        tilesList.add(p);
                    }
                    String[] villages0 = pieces[4].split(" ");
                    for (int j = 0; j < villages0.length; j++) {
                        String[] coords = villages0[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                                39.64 + 70.28 * y, 35.0 + 81 * x,
                                29.64 + 70.28 * y, 45.0 + 81 * x,
                                39.64 + 70.28 * y, 45.0 + 81 * x);
                        p.setFill(Color.ORANGE);
                        tilesList.add(p);
                    }
                }
                // Player 2
                else if (pieces[1].startsWith("2")) {
                    String[] settlers = pieces[3].split(" ");
                    for (int j = 0; j < settlers.length; j++) {
                        String[] coords = settlers[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                                39.64 + 70.28 * y, 35.0 + 81 * x,
                                29.64 + 70.28 * y, 45.0 + 81 * x,
                                39.64 + 70.28 * y, 45.0 + 81 * x);
                        p.setFill(Color.DARKBLUE);
                        tilesList.add(p);
                    }
                    String[] villages0 = pieces[4].split(" ");
                    for (int j = 0; j < villages0.length; j++) {
                        String[] coords = villages0[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                                39.64 + 70.28 * y, 35.0 + 81 * x,
                                29.64 + 70.28 * y, 45.0 + 81 * x,
                                39.64 + 70.28 * y, 45.0 + 81 * x);
                        p.setFill(Color.DARKBLUE);
                        tilesList.add(p);
                    }
                }
                // Player 3
                else if (pieces[1].startsWith("3")) {
                    String[] settlers = pieces[3].split(" ");
                    for (int j = 0; j < settlers.length; j++) {
                        String[] coords = settlers[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                                39.64 + 70.28 * y, 35.0 + 81 * x,
                                29.64 + 70.28 * y, 45.0 + 81 * x,
                                39.64 + 70.28 * y, 45.0 + 81 * x);
                        p.setFill(Color.PURPLE);
                        tilesList.add(p);
                    }
                    String[] villages0 = pieces[4].split(" ");
                    for (int j = 0; j < villages0.length; j++) {
                        String[] coords = villages0[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        p.getPoints().addAll(29.64 + 70.28 * y, 35.0 + 81 * x,
                                39.64 + 70.28 * y, 35.0 + 81 * x,
                                29.64 + 70.28 * y, 45.0 + 81 * x,
                                39.64 + 70.28 * y, 45.0 + 81 * x);
                        p.setFill(Color.PURPLE);
                        tilesList.add(p);
                    }
                }
            }
        }
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
