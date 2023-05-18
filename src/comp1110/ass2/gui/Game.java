package comp1110.ass2.gui;

import comp1110.ass2.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.transform.Translate;


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

    // @author Tyler Le
    public String initializeGame(int n) {
        // Initializes the starting game state
        if (n == 2) {
            // 2 Players
            boardString = "a 13 2; c 0 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T;";
        } else if (n == 3) {
            // 3 Players
            boardString = "a 13 3; c 0 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T; p 2 0 0 0 0 0 0 S T;";
        } else if (n == 4) {
            // 4 Players
            boardString = "a 13 4; c 0 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T; p 2 0 0 0 0 0 0 S T; p 3 0 0 0 0 0 0 S T;";
        }
        return boardString;
    }

    // Puts together all the individual elements of the game UI
    void displayState(String stateString) {
        // Calls displayBoard from Display class to show the board tiles
        Board b = new Board(stateString);
        Display boardImage = new Display();
        root.getChildren().addAll(boardImage.displayTiles(stateString));

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
        Translate tablePosition = new Translate(1000, 0);
        scoreBoard.getTransforms().add(tablePosition);
        root.getChildren().add(scoreBoard);

        root.setLayoutX(15);
        root.setLayoutY(25);
    }

    // @author Tyler Le
    // Triggers the AI to make moves automatically when it has a turn
    public void triggerAI(int n) {
        Board b = new Board(boardString);
        if ((b.getPlayerNum() - n) % 4 <= b.getTurn()) {
            boardString = BlueLagoon.applyMove(boardString, BlueLagoon.generateAIMove(boardString));
            root.getChildren().remove(phase);
            displayState(boardString);
        }
    }

    // @author Tyler Le
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
        playerBox.setLayoutX(830);
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
        AIBox.setLayoutX(795);
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

        // For testing
        Button random = new Button("Random Move");
        // For testing
        Button play = new Button("Play");
        HBox moveBox = new HBox();
        moveBox.getChildren().addAll(moveLabel, villageOrSettler, xPosition, yPosition, play, random);
        moveBox.setSpacing(10);
        moveBox.setLayoutX(1000);
        moveBox.setLayoutY(670);

        // Adds the row and column labels for the move menus
        Label rowLabel = new Label("Row:");
        Label colLabel = new Label("Column:");
        HBox labelBox = new HBox();
        labelBox.getChildren().addAll(rowLabel, colLabel);
        labelBox.setSpacing(27);
        labelBox.setLayoutX(1305);
        labelBox.setLayoutY(650);

        // Adds the restart button to restart the game
        Button restart = new Button("Restart");
        HBox restartBox = new HBox();
        restartBox.getChildren().add(restart);
        restartBox.setLayoutX(1820);
        restartBox.setLayoutY(0);

        // After # of Players is chosen, make choice for # of AIs appear
        selectPlayerCount.setOnAction(e -> {
            controls.getChildren().remove(AIBox);
            controls.getChildren().add(AIBox);
        });

        // Action taken when the "Start Game" button is pressed
        start.setOnAction(e -> {
            if (Integer.parseInt(playerCount.getValue()) <= Integer.parseInt(AICount.getValue())) {
                // If AIs >= Players then show error
                root.getChildren().remove(Display.badSetup());
                root.getChildren().add(Display.badSetup());
            }
            else {
                // If AIs < Players then begin the game
                root.getChildren().remove(Display.badSetup());
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
                root.getChildren().remove(Display.badMove());
            } else {
                root.getChildren().remove(Display.badMove());
                root.getChildren().add(Display.badMove());
            }

            // If it's the AI's turn next, then trigger AI moves until it's the next human player's turn
            if (new Board(boardString).getTurn() >= Integer.parseInt(playerCount.getValue()) - Integer.parseInt(AICount.getValue())) {
                for (int i = 0; i < Integer.parseInt(AICount.getValue()); i++) {
                    triggerAI(Integer.parseInt(AICount.getValue()));
                }
            }

            root.getChildren().remove(phase);
            displayState(boardString);
        });

        // Restarts the game if "restart" is pressed
        restart.setOnAction(e -> {
        root.getChildren().clear();
        controls.getChildren().clear();
        controls.getChildren().addAll(playerBox, Display.titleScreen());
        root.getChildren().add(controls);
        });

        // For testing
        random.setOnAction(e -> {
            boardString = BlueLagoon.applyMove(boardString, BlueLagoon.generateAIMove(boardString));
            root.getChildren().removeAll(phase);
            displayState(boardString);
        });
        // For testing
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene1 = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("BlueLagoon Game");
        stage.setScene(scene1);
        root.getChildren().addAll(controls);
        gameControls();
        stage.setScene(scene1);
        stage.show();
    }
}
