package comp1110.ass2.gui;

import comp1110.ass2.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Viewer extends Application {

    private static final int VIEWER_WIDTH = 1300;
    private static final int VIEWER_HEIGHT = 800;

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
        Board b = new Board(stateString);
        // Written by Tyler

        List<Polygon> tilesList = new ArrayList<>();
        List<Circle> villageList = new ArrayList<>();
        Hexagon[][] hexagons = new Hexagon[b.getSize()][b.getSize()];

        //Set up spots
        for (int i = 0; i <= b.getSize() - 1; i++) {
            for (int j = 0; j <= b.getSize()-1; j++) {
                if (b.getBoard()[i][j] != null) {
                    if (i % 2 == 0) {
                        Hexagon hexagon = new Hexagon(69.28 + 69.28 * j, 40 + 60 * i, 40);
                        if (b.getBoard()[i][j].spotType == 1) {
                            hexagon.setFill(Color.LIGHTGREEN);
                            hexagons[i][j] = hexagon;
                            tilesList.add(hexagon);
                        } else {
                            hexagon.setFill(Color.BLUE);
                            hexagons[i][j] = hexagon;
                            tilesList.add(hexagon);
                        }
                    } else {
                        Hexagon hexagon = new Hexagon(34.64 + 69.28 * j, 40 + 60 * i, 40);
                        if (b.getBoard()[i][j].spotType == 1) {
                            hexagon.setFill(Color.LIGHTGREEN);
                            hexagons[i][j] = hexagon;
                            tilesList.add(hexagon);
                        } else {
                            hexagon.setFill(Color.BLUE);
                            hexagons[i][j] = hexagon;
                            tilesList.add(hexagon);
                        }
                    }
                } else {
                    hexagons[i][j] = null;
                }
            }
        }
        //Add stone circle
        for (int i = 0; i <= b.getSize() - 1; i++) {
            for (int j = 0; j <= b.getSize()-1; j++) {
                if (b.getBoard()[i][j] != null) {
                    if (b.getBoard()[i][j].circle) {
                        if (i % 2 == 0) {
                            Hexagon hexagon = new Hexagon(69.28 + 69.28 * j, 40 + 60 * i, 35);
                            hexagon.setFill(Color.DARKGRAY);
                            hexagons[i][j] = hexagon;
                            tilesList.add(hexagon);
                        } else {
                            Hexagon hexagon = new Hexagon(34.64 + 69.28 * j, 40 + 60 * i, 35);
                            hexagon.setFill(Color.DARKGRAY);
                            hexagons[i][j] = hexagon;
                            tilesList.add(hexagon);
                        }
                    }
                }
            }
        }

        //Add resources
        for (int i = 0; i <= b.getSize() - 1; i++) {
            for (int j = 0; j <= b.getSize()-1; j++) {
                if (b.getBoard()[i][j] != null) {
                    if (b.getBoard()[i][j].resources!= Resource.NULL) {
                        Polygon p=new Polygon();
                        if (i % 2 == 0) {
                            p.getPoints().addAll(54.28 + 69.28 * j, (double)25 + 60 * i,
                                    84.28 + 69.28 * j, (double)25 + 60 * i,
                                    84.28 + 69.28 * j, (double)55 + 60 * i,
                                    54.28 + 69.28 * j, (double)55 + 60 * i);
                        } else {
                            p.getPoints().addAll(19.64 + 69.28 * j, (double)25 + 60 * i,
                                    49.64 + 69.28 * j, (double)25 + 60 * i,
                                    49.64 + 69.28 * j, (double)55 + 60 * i,
                                    19.64 + 69.28 * j, (double)55 + 60 * i);
                        }
                        if(b.getBoard()[i][j].resources== Resource.COCONUT){
                            p.setFill(Color.BROWN);
                            tilesList.add(p);
                        } else if (b.getBoard()[i][j].resources== Resource.BAMBOO) {
                            p.setFill(Color.GREEN);
                            tilesList.add(p);
                        } else if (b.getBoard()[i][j].resources== Resource.WATER) {
                            p.setFill(Color.CYAN);
                            tilesList.add(p);
                        } else if (b.getBoard()[i][j].resources== Resource.PRECIOUSSTONE) {
                            p.setFill(Color.YELLOW);
                            tilesList.add(p);
                        }else {
                            p.setFill(Color.GREY);
                            tilesList.add(p);
                        }
                    }
                }
            }
        }
        //Add players
        for (int i = 0; i <= b.getSize() - 1; i++) {
            for (int j = 0; j <= b.getSize()-1; j++) {
                if (b.getBoard()[i][j] != null && b.getBoard()[i][j].occupiedByPlayer != 100) {
                    if (b.getBoard()[i][j].settlerOrVillage == Spot.SettlerOrVillage.SETTLER) {
                        Polygon p=new Polygon();
                        if (i % 2 == 0) {
                            p.getPoints().addAll(69.28 + 69.28 * j, (double)20 + 60 * i,
                                    89.28 + 69.28 * j, (double)60 + 60 * i,
                                    49.28 + 69.28 * j, (double)60 + 60 * i);
                        } else {
                            p.getPoints().addAll(34.64 + 69.28 * j,(double) 20 + 60 * i,
                                    54.64 + 69.28 * j,(double) 60 + 60 * i,
                                    14.64 + 69.28 * j, (double)60 + 60 * i);
                        }
                        if(b.getBoard()[i][j].occupiedByPlayer==0) {
                            p.setFill(Color.PINK);
                            tilesList.add(p);
                        }else if(b.getBoard()[i][j].occupiedByPlayer==1){
                            p.setFill(Color.CRIMSON);
                            tilesList.add(p);
                        } else if (b.getBoard()[i][j].occupiedByPlayer==2) {
                            p.setFill(Color.PURPLE);
                            tilesList.add(p);
                        }else {
                            p.setFill(Color.YELLOWGREEN);
                            tilesList.add(p);
                        }

                    }else {
                        Circle c = new Circle();
                        if (i % 2 == 0) {
                            c.setCenterX(69.28 + 69.28 * j);
                            c.setCenterY(40 + 60 * i);
                            c.setRadius(25);
                        } else {
                            c.setCenterX(34.64 + 69.28 * j);
                            c.setCenterY(40 + 60 * i);
                            c.setRadius(25);
                        }
                        if(b.getBoard()[i][j].occupiedByPlayer==0) {
                            c.setFill(Color.PINK);
                            villageList.add(c);
                        }else if(b.getBoard()[i][j].occupiedByPlayer==1){
                            c.setFill(Color.CRIMSON);
                            villageList.add(c);
                        } else if (b.getBoard()[i][j].occupiedByPlayer==2) {
                            c.setFill(Color.PURPLE);
                            villageList.add(c);
                        }else {
                            c.setFill(Color.YELLOWGREEN);
                            villageList.add(c);
                        }
                    }
                }
            }
        }


        root.getChildren().addAll(tilesList);
        root.getChildren().addAll(villageList);

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

        Translate tablePosition = new Translate(1500, 0);
        scores.getTransforms().add(tablePosition);

        for (int i = 0; i < b.getPlayerNum(); i++) {
            scores.getItems().add(
                    Player.getStats(i, stateString));
        }
        root.getChildren().addAll(scores);

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
