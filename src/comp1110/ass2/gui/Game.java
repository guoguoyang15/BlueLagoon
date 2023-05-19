package comp1110.ass2.gui;

import comp1110.ass2.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.transform.Translate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tyler Le (all methods)
 * This class synthesizes all other classes to generate the underlying game logic and creates the GUI for the game.
 */

public class Game extends Application {
    private final Group root = new Group();
    private final Group controls = new Group();
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 700;
    private ChoiceBox<String> villageOrSettler;
    private ChoiceBox<String> xPosition;
    private ChoiceBox<String> yPosition;
    private ChoiceBox<String> playerCount;
    private ChoiceBox<String> AICount;
    private String pieceType;
    private String boardString;
    private Text phase;

    public static String initializeGame(int n) {
        // Initializes the starting game state
        String gameStart = "";
        if (n == 2) {
            // 2 Players
            gameStart = "a 13 2; c 0 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T;";
        } else if (n == 3) {
            // 3 Players
            gameStart = "a 13 3; c 0 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T; p 2 0 0 0 0 0 0 S T;";
        } else if (n == 4) {
            // 4 Players
            gameStart = "a 13 4; c 0 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T; p 2 0 0 0 0 0 0 S T; p 3 0 0 0 0 0 0 S T;";
        }
        return gameStart;
    }

    // Triggers the AI to make moves automatically when it has a turn
    public void triggerAI(int n) {
        Board b = new Board(boardString);
        if ((b.getPlayerNum() - n) % 4 <= b.getTurn()) {
            boardString = BlueLagoon.applyMove(boardString, BlueLagoon.generateAIMove(boardString));
            root.getChildren().remove(phase);
            displayState(boardString);
        }
    }

    // Puts together all the individual elements of the game UI
    void displayState(String stateString) {
        // Calls displayBoard from Display class to show the board tiles
        Board b = new Board(stateString);
        Display boardImage = new Display();
        root.getChildren().addAll(boardImage.displayTiles(stateString));

        //Add sample example of resources
        for(int i=0;i<=4;i++){
            Polygon polygon=new Polygon();
            polygon.getPoints().addAll(600.0+50*i,500.0,
                    600.0+50*i,530.0,
                    630.0+50*i,530.0,
                    630.0+50*i,500.0);
            if(i==0){
                polygon.setFill(Color.BROWN);
            }else if(i==1){
                polygon.setFill(Color.DARKGREEN);
            }else if(i==2){
                polygon.setFill(Color.CYAN);
            }else if(i==3){
                polygon.setFill(Color.GOLD);
            }else {
                polygon.setFill(Color.BLACK);
            }
            root.getChildren().add(polygon);
        }
        Text sample=new Text("Coconut  Bamboo  Water   P.Stone  Statuette        Settler        Village");
        sample.setX(590);
        sample.setY(490);
        root.getChildren().add(sample);

        Polygon tri=new Polygon();
        tri.getPoints().addAll(900.0,500.0,
                885.0,532.5,
                915.0,532.5);
        tri.setFill(Color.CRIMSON);
        root.getChildren().add(tri);

        Circle c=new Circle();
        c.setRadius(15);
        c.setCenterX(960);
        c.setCenterY(515);
        c.setFill(Color.YELLOW);
        root.getChildren().add(c);

        // Calls phaseDisplay from Display class to show the phase and player to move
        phase = Display.phaseDisplay(stateString);
        root.getChildren().add(phase);

        // Calls rowDisplay from Display class to show the row numbers
        Text[] rows = Display.rowDisplay(stateString);
        root.getChildren().addAll(rows);
        // Calls columnDisplay from Display class to show column coordinates on each tile
        for (int i = 0; i < b.getSize(); i++) {
            for (int j = 0; j < b.getSize(); j++) {
                if (Display.columnDisplay(b.getSize(), b.getSize())[i][j] != null) {
                    root.getChildren().addAll(Display.columnDisplay(b.getSize(), b.getSize())[i][j]);
                }
            }
        }

        // Calls weightDisplay from Display class to show the island values on each tile
        for (int i = 0; i < b.getSize(); i++) {
            for (int j = 0; j < b.getSize(); j++) {
                if (Display.weightDisplay(b.getSize(), b.getSize(), b)[i][j] != null) {
                    root.getChildren().addAll(Display.weightDisplay(b.getSize(), b.getSize(), b)[i][j]);
                }
            }
        }

        // Calls displayWinner from Display class to show the winner if there is one
        root.getChildren().add(Display.displayWinner(stateString));

        // Calls scoreTable from Display class to make a table for the scores
        TableView scoreBoard = Display.scoreTable(stateString);
        Translate tablePosition = new Translate(580, 0);
        scoreBoard.getTransforms().add(tablePosition);
        root.getChildren().add(scoreBoard);
    }

    // Creates the various buttons and menus that the players can interact with
    public void gameControls() {
        // Creates the number of players selection menu
        Label playerLabel = new Label("Select Number of Players:");
        playerCount = new ChoiceBox<>();
        playerCount.getItems().addAll("2", "3", "4");
        playerCount.setValue("2");
        Button selectPlayerCount = new Button("Select");

        HBox playerBox = new HBox();
        playerBox.getChildren().addAll(playerLabel, playerCount, selectPlayerCount);
        playerBox.setSpacing(10);
        playerBox.setLayoutX(330);
        playerBox.setLayoutY(520);

        // Creates the number of AI opponents selection
        Label AILabel = new Label("Select Number of AI Opponents:");
        AICount = new ChoiceBox<>();
        AICount.getItems().addAll("0", "1", "2", "3");
        AICount.setValue("0");
        Button start = new Button("Start Game");

        HBox AIBox = new HBox();
        AIBox.getChildren().addAll(AILabel, AICount, start);
        AIBox.setSpacing(10);
        AIBox.setLayoutX(330);
        AIBox.setLayoutY(550);

        // Displays the player selection menu and title screen
        controls.getChildren().addAll(playerBox, Display.titleScreen());

        // Creates menu for entering moves
        Label moveLabel = new Label("Choose the piece and position:");
        villageOrSettler = new ChoiceBox<>();
        villageOrSettler.getItems().addAll("Settler", "Village");
        villageOrSettler.setValue("Settler");

        xPosition = new ChoiceBox<>();
        xPosition.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        xPosition.setValue("0");

        yPosition = new ChoiceBox<>();
        yPosition.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        yPosition.setValue("0");

        Button play = new Button("Play");
        HBox moveBox = new HBox();
        moveBox.getChildren().addAll(moveLabel, villageOrSettler, xPosition, yPosition, play);
        moveBox.setSpacing(10);
        moveBox.setLayoutX(500);
        moveBox.setLayoutY(600);

        // Adds the row and column labels for the move menus
        Label rowLabel = new Label("Row:");
        Label colLabel = new Label("Column:");
        HBox labelBox = new HBox();
        labelBox.getChildren().addAll(rowLabel, colLabel);
        labelBox.setSpacing(27);
        labelBox.setLayoutX(770);
        labelBox.setLayoutY(580);

        // Adds the restart button to restart the game
        Button restart = new Button("Restart");
        HBox restartBox = new HBox();
        restartBox.getChildren().add(restart);
        restartBox.setLayoutX(1000);
        restartBox.setLayoutY(650);

        // After # of Players is chosen, make choice for # of AIs appear
        selectPlayerCount.setOnAction(e -> {
            controls.getChildren().remove(AIBox);
            controls.getChildren().add(AIBox);
        });

        // Action taken when the "Start Game" button is pressed
        start.setOnAction(e -> {
            if (Integer.parseInt(playerCount.getValue()) <= Integer.parseInt(AICount.getValue())) {
                // If AIs >= Players then show error
                controls.getChildren().clear();
                controls.getChildren().addAll(playerBox, AIBox, Display.titleScreen());
                controls.getChildren().add(Display.badSetupScreen());
            }
            else {
                // If AIs < Players then begin the game
                controls.getChildren().clear();
                boardString = BlueLagoon.distributeResources(initializeGame(Integer.parseInt(playerCount.getValue())));
                displayState(boardString);
                controls.getChildren().addAll(moveBox, labelBox);
                root.getChildren().add(restartBox);
            }
        });

        // Action taken when a player attempts to make a move
        play.setOnAction(e -> {
            // Encodes the entered move as a moveString
            String xPos = xPosition.getValue();
            String yPos = yPosition.getValue();
            String piece = villageOrSettler.getValue();
            if (piece.equals("Village")) {
                pieceType = "T";
            } else if (piece.equals("Settler")) {
                pieceType = "S";
            }
            String move = pieceType + " " + xPos + "," + yPos;

            // Makes "invalid move" text if player enters an invalid move
            if (BlueLagoon.isMoveValid(boardString, move)) {
                boardString = BlueLagoon.applyMove(boardString, move);
                root.getChildren().clear();
                root.getChildren().add(controls);
            } else {
                root.getChildren().clear();
                root.getChildren().addAll(Display.badMoveScreen());
                root.getChildren().add(controls);
            }

            // If it's the AI's turn next, then trigger AI moves until it's the next human player's turn
            if (new Board(boardString).getTurn() >= Integer.parseInt(playerCount.getValue()) - Integer.parseInt(AICount.getValue())) {
                for (int i = 0; i < Integer.parseInt(AICount.getValue()); i++) {
                    triggerAI(Integer.parseInt(AICount.getValue()));
                }
            }

            root.getChildren().remove(phase);
            root.getChildren().remove(restartBox);
            root.getChildren().add(restartBox);
            displayState(boardString);
        });

        // Restarts the game if "restart" is pressed
        restart.setOnAction(e -> {
        root.getChildren().clear();
        controls.getChildren().clear();
        controls.getChildren().addAll(playerBox, Display.titleScreen());
        root.getChildren().add(controls);
        });
    }

    @Override
    public void start(Stage stage) {
        Scene scene1 = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Blue Lagoon Game");
        stage.setScene(scene1);
        root.getChildren().addAll(controls);
        gameControls();
        stage.setScene(scene1);
        stage.show();
    }
}
