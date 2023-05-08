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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
        // Written by Tyler
        String[] parts = stateString.split(";");
        List<Polygon> tilesList = new ArrayList<>();
        String[] firstString = parts[0].split(" ");
        int size = Integer.parseInt(firstString[1]);
        double a;
        double b;
        for (a = 0; a <= size - 1; a++) {
            for (b = 0; b <= size - 1; b++) {
                if (a % 2 == 0 && b == size - 1)
                    continue;
                if (a % 2 == 0) {
                    //Size=40px
                    Polygon p = new Polygon();
                    p.getPoints().addAll(69.28 + 69.28 * b, 60 * a,
                            103.92 + 69.28 * b, 20 + 60 * a,
                            103.92 + 69.28 * b, 60 + 60 * a,
                            69.28 + 69.28 * b, 80 + 60 * a,
                            34.64 + 69.28 * b, 60 + 60 * a,
                            34.64 + 69.28 * b, 20 + 60 * a);
                    p.setFill(Color.BLUE);
                    tilesList.add(p);
                } else if (a % 2 == 1) {
                    Polygon p = new Polygon();
                    p.getPoints().addAll(34.64 + 69.28 * b, 60 * a,
                            69.28 + 69.28 * b, 20 + 60 * a,
                            69.28 + 69.28 * b, 60 + 60 * a,
                            34.64 + 69.28 * b, 80 + 60 * a,
                            69.28 * b, 60 + 60 * a,
                            69.28 * b, 20 + 60 * a);
                    p.setFill(Color.BLUE);
                    tilesList.add(p);
                }
            }
            for (int i = 0; i < parts.length; i++) {
                // Generates the islands
                if (parts[i].startsWith(" i")) {
                    String[] islands = parts[i].split(" ");
                    for (int j = 3; j < islands.length; j++) {
                        String[] coords = islands[j].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        double[] spot = new double[2];
                        spot[0] = x;
                        spot[1] = y;
                        if (x % 2 == 0) {
                            //Size=40px
                            Polygon p = new Polygon();
                            p.getPoints().addAll(69.28 + 69.28 * y, 60 * x,
                                    103.92 + 69.28 * y, 20 + 60 * x,
                                    103.92 + 69.28 * y, 60 + 60 * x,
                                    69.28 + 69.28 * y, 80 + 60 * x,
                                    34.64 + 69.28 * y, 60 + 60 * x,
                                    34.64 + 69.28 * y, 20 + 60 * x);
                            p.setFill(Color.LIGHTGREEN);
                            tilesList.add(p);
                        } else if (x % 2 == 1) {
                            Polygon p = new Polygon();
                            p.getPoints().addAll(34.64 + 69.28 * y, 60 * x,
                                    69.28 + 69.28 * y, 20 + 60 * x,
                                    69.28 + 69.28 * y, 60 + 60 * x,
                                    34.64 + 69.28 * y, 80 + 60 * x,
                                    69.28 * y, 60 + 60 * x,
                                    69.28 * y, 20 + 60 * x);
                            p.setFill(Color.LIGHTGREEN);
                            tilesList.add(p);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < parts.length; i++) {
            // Generates the stone circles
            if (parts[i].startsWith(" s")) {
                String[] stones = parts[i].split(" ");
                for (int j = 2; j < stones.length; j++) {
                    String[] coords = stones[j].split(",");
                    double x = Double.parseDouble(coords[0]);
                    double y = Double.parseDouble(coords[1]);
                    if (x % 2 == 0) {
                        Polygon p = new Polygon();
                        p.getPoints().addAll(69.28 + 69.28 * y, 3 + 60 * x,
                                100.92 + 69.28 * y, 20 + 60 * x,
                                100.92 + 69.28 * y, 60 + 60 * x,
                                69.28 + 69.28 * y, 77 + 60 * x,
                                37.64 + 69.28 * y, 60 + 60 * x,
                                37.64 + 69.28 * y, 20 + 60 * x);
                        p.setFill(Color.DARKSLATEGRAY);
                        tilesList.add(p);
                    } else {
                        Polygon p = new Polygon();
                        p.getPoints().addAll(34.64 + 69.28 * y, 3 + 60 * x,
                                66.28 + 69.28 * y, 20 + 60 * x,
                                66.28 + 69.28 * y, 60 + 60 * x,
                                34.64 + 69.28 * y, 77 + 60 * x,
                                3+69.28 * y, 60 + 60 * x,
                                3+69.28 * y, 20 + 60 * x);
                        p.setFill(Color.DARKSLATEGRAY);
                        tilesList.add(p);
                    }
                }
            }
            // Generates the resources
            else if (parts[i].startsWith(" r")) {
                String[] resources = parts[i].split(" ");
                String flag = "";
                for (int l = 0; l <= resources.length - 1; l++) {
                    if (resources[l].equals("C")) {
                        flag = "C";
                    } else if (resources[l].equals("B")) {
                        flag = "B";
                    } else if (resources[l].equals("W")) {
                        flag = "W";
                    } else if (resources[l].equals("P")) {
                        flag = "P";
                    } else if (resources[l].equals("S")) {
                        flag = "S";
                    } else {
                    }
                    if (resources[l].contains(",")) {
                        String[] coords = resources[l].split(",");
                        double x = Double.parseDouble(coords[0]);
                        double y = Double.parseDouble(coords[1]);
                        Polygon p = new Polygon();
                        if (x % 2 == 0) {
                            p.getPoints().addAll(49.28 + 69.28 * y, 20 + 60 * x,
                                    89.28 + 69.28 * y, 20 + 60 * x,
                                    89.28 + 69.28 * y, 60 + 60 * x,
                                    49.28 + 69.28 * y, 60 + 60 * x);
                        } else {
                            p.getPoints().addAll(14.64 + 69.28 * y, 20 + 60 * x,
                                    54.64 + 69.28 * y, 20 + 60 * x,
                                    54.64 + 69.28 * y, 60 + 60 * x,
                                    14.64 + 69.28 * y, 60 + 60 * x);
                        }
                        if (flag.equals("C")) {
                            p.setFill(Color.BROWN);
                            tilesList.add(p);
                        } else if (flag.equals("B")) {
                            p.setFill(Color.GREEN);
                            tilesList.add(p);
                        } else if (flag.equals("W")) {
                            p.setFill(Color.CYAN);
                            tilesList.add(p);
                        } else if (flag.equals("P")) {
                            p.setFill(Color.YELLOW);
                            tilesList.add(p);
                        } else{
                            p.setFill(Color.GREY);
                            tilesList.add(p);
                        }
                    }
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
