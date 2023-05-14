package comp1110.ass2.gui;

import comp1110.ass2.*;
import comp1110.ass2.gui.Viewer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.transform.Translate;

import java.util.ArrayList;
import java.util.List;


// FIXME Task 14
// FIXME Task 15

public class Game extends Application {
    private final Group root = new Group();
    private final Group controls = new Group();
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 700;
    private TextField stateTextField;
    private TextField xTextField;
    private TextField yTextField;
    private TextField typeTextField;
    private Board b;
    final VBox scoreTable = new VBox();

    private String boardString;
    // Written by Tyler
    public static void main(String[] args) {
        launch(args);
    }



    // Displays the scoreboard using a table
//    public void scoreboard(String stateString) {
//        Board b = new Board(stateString);
//
//        TableView scores = new TableView();
//
//        TableColumn<Player, Integer> column1 =
//            new TableColumn<>("Player #");
//        column1.setCellValueFactory(
//            new PropertyValueFactory<>("playerNumber"));
//        TableColumn<Player, Integer> column2 =
//            new TableColumn<>("Score");
//        column2.setCellValueFactory(
//            new PropertyValueFactory<>("score"));
//        TableColumn<Player, Integer> column3 =
//            new TableColumn<>("C");
//        column3.setCellValueFactory(
//            new PropertyValueFactory<>("coconut"));
//        TableColumn<Player, Integer> column4 =
//                new TableColumn<>("B");
//        column4.setCellValueFactory(
//                new PropertyValueFactory<>("bamboo"));
//        TableColumn<Player, Integer> column5 =
//                new TableColumn<>("W");
//        column5.setCellValueFactory(
//                new PropertyValueFactory<>("water"));
//        TableColumn<Player, Integer> column6 =
//                new TableColumn<>("P");
//        column6.setCellValueFactory(
//                new PropertyValueFactory<>("stone"));
//        TableColumn<Player, Integer> column7 =
//                new TableColumn<>("S");
//        column7.setCellValueFactory(
//                new PropertyValueFactory<>("statuette"));
//
//        scores.getColumns().add(column1);
//        scores.getColumns().add(column2);
//        scores.getColumns().add(column3);
//        scores.getColumns().add(column4);
//        scores.getColumns().add(column5);
//        scores.getColumns().add(column6);
//        scores.getColumns().add(column7);
//
//        Translate tablePosition = new Translate(1000, 0);
//        scores.getTransforms().add(tablePosition);
//
//      for (int i = 0; i < b.getPlayerNum(); i++) {
//          scores.getItems().add(
//                 Player.getStats(i, stateString));
//      }
//
//        scoreTable.getChildren().addAll(scores);
//    }
    public String initializeGame(int n) {
        if (n == 2)  {
            boardString = "a 13 2; c 0 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T;";
        }
        else if (n == 3) {
            boardString = "a 13 3; c 0 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T; p 2 0 0 0 0 0 0 S T;";
        }
        else if (n == 4) {
            boardString = "a 13 4; c 0 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T; p 2 0 0 0 0 0 0 S T; p 3 0 0 0 0 0 0 S T;";
        }
        return boardString;
    }


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

        Translate tablePosition = new Translate(1500, 0);
        scores.getTransforms().add(tablePosition);

        for (int i = 0; i < b.getPlayerNum(); i++) {
            scores.getItems().add(
                    Player.getStats(i, stateString));
        }
        root.getChildren().addAll(scores);

    }


    private void makeControls() {
        Label playerLabel = new Label("Select Number of Players");
        Button twoPlayers = new Button("2");
        Button threePlayers = new Button("3");
        Button fourPlayers = new Button("4");
        twoPlayers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                boardString = initializeGame(2);
                boardString = BlueLagoon.distributeResources(boardString);
                b=new Board(boardString);
                displayState(boardString);
            }
        });
        threePlayers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                boardString = initializeGame(3);
                boardString = BlueLagoon.distributeResources(boardString);
                b=new Board(boardString);
                displayState(boardString);
            }
        });
        fourPlayers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                boardString = initializeGame(4);
                boardString = BlueLagoon.distributeResources(boardString);
                b=new Board(boardString);
                displayState(boardString);
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(playerLabel, twoPlayers, threePlayers, fourPlayers);
        hb.setSpacing(10);
        hb.setLayoutX(100);
        hb.setLayoutY(WINDOW_HEIGHT - 50);
        controls.getChildren().add(hb);

        Label xLabel = new Label("X:");
        xTextField = new TextField();
        xTextField.setPrefWidth(50);
        Label yLabel = new Label("Y:");
        yTextField = new TextField();
        yTextField.setPrefWidth(50);
        Label typeLabel = new Label("S/T:");
        typeTextField = new TextField();
        typeTextField.setPrefWidth(50);
        Button button2 = new Button("Apply");
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(xLabel,yLabel,typeLabel, xTextField,yTextField,typeTextField, button2);
        hb2.setSpacing(10);
        hb2.setLayoutX(1000);
        hb2.setLayoutY(WINDOW_HEIGHT - 50);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String moveX = xTextField.getText();
                String moveY = yTextField.getText();
                String piece = typeTextField.getText();
                String move = piece + " " + moveX + "," + moveY;
                boardString = BlueLagoon.applyMove(boardString,move);
                root.getChildren().remove(scoreTable);
                displayState(boardString);
            }
        });

        controls.getChildren().add(hb2);
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
