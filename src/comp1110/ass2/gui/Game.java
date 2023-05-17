package comp1110.ass2.gui;

import comp1110.ass2.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.transform.Translate;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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

    void displayState(String stateString) {
        // Adds images of the tiles
        Board b = new Board(stateString);

        List<ImageView> imageViews = new ArrayList<>();
        int rand = 0;
        Image[] land = new Image[18];
        Image[] circle = new Image[6];
        Image[] ocean = new Image[12];
        Image bamboo, coconuts, precious_stones, statuettes, water;
        Image[] villagers = new Image[4];
        Image[] villages = new Image[4];
        land[0] = new Image(getClass().getResourceAsStream("/image/Land/Land (1).png"), 69.28, 80, false, false);
        land[1] = new Image(getClass().getResourceAsStream("/image/Land/Land (2).png"), 69.28, 80, false, false);
        land[2] = new Image(getClass().getResourceAsStream("/image/Land/Land (3).png"), 69.28, 80, false, false);
        land[3] = new Image(getClass().getResourceAsStream("/image/Land/Land (4).png"), 69.28, 80, false, false);
        land[4] = new Image(getClass().getResourceAsStream("/image/Land/Land (5).png"), 69.28, 80, false, false);
        land[5] = new Image(getClass().getResourceAsStream("/image/Land/Land (6).png"), 69.28, 80, false, false);
        land[6] = new Image(getClass().getResourceAsStream("/image/Land/Land (7).png"), 69.28, 80, false, false);
        land[7] = new Image(getClass().getResourceAsStream("/image/Land/Land (8).png"), 69.28, 80, false, false);
        land[8] = new Image(getClass().getResourceAsStream("/image/Land/Land (9).png"), 69.28, 80, false, false);
        land[9] = new Image(getClass().getResourceAsStream("/image/Land/Land (10).png"), 69.28, 80, false, false);
        land[10] = new Image(getClass().getResourceAsStream("/image/Land/Land (11).png"), 69.28, 80, false, false);
        land[11] = new Image(getClass().getResourceAsStream("/image/Land/Land (12).png"), 69.28, 80, false, false);
        land[12] = new Image(getClass().getResourceAsStream("/image/Land/Land (13).png"), 69.28, 80, false, false);
        land[13] = new Image(getClass().getResourceAsStream("/image/Land/Land (14).png"), 69.28, 80, false, false);
        land[14] = new Image(getClass().getResourceAsStream("/image/Land/Land (15).png"), 69.28, 80, false, false);
        land[15] = new Image(getClass().getResourceAsStream("/image/Land/Land (16).png"), 69.28, 80, false, false);
        land[16] = new Image(getClass().getResourceAsStream("/image/Land/Land (17).png"), 69.28, 80, false, false);
        land[17] = new Image(getClass().getResourceAsStream("/image/Land/Land (18).png"), 69.28, 80, false, false);
        circle[0] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (1).png"), 69.28, 80, false, false);
        circle[1] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (2).png"), 69.28, 80, false, false);
        circle[2] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (3).png"), 69.28, 80, false, false);
        circle[3] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (4).png"), 69.28, 80, false, false);
        circle[4] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (5).png"), 69.28, 80, false, false);
        circle[5] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (6).png"), 69.28, 80, false, false);
        ocean[0] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (1).png"), 69.28, 80, false, false);
        ocean[1] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (2).png"), 69.28, 80, false, false);
        ocean[2] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (3).png"), 69.28, 80, false, false);
        ocean[3] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (4).png"), 69.28, 80, false, false);
        ocean[4] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (5).png"), 69.28, 80, false, false);
        ocean[5] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (6).png"), 69.28, 80, false, false);
        ocean[6] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (7).png"), 69.28, 80, false, false);
        ocean[7] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (8).png"), 69.28, 80, false, false);
        ocean[8] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (9).png"), 69.28, 80, false, false);
        ocean[9] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (10).png"), 69.28, 80, false, false);
        ocean[10] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (11).png"), 69.28, 80, false, false);
        ocean[11] = new Image(getClass().getResourceAsStream("/image/Ocean/Ocean (12).png"), 69.28, 80, false, false);
        villagers[0] = new Image(getClass().getResourceAsStream("/image/Villagers/1.png"), 69.28, 80, false, false);
        villagers[1] = new Image(getClass().getResourceAsStream("/image/Villagers/2.png"), 69.28, 80, false, false);
        villagers[2] = new Image(getClass().getResourceAsStream("/image/Villagers/3.png"), 69.28, 80, false, false);
        villagers[3] = new Image(getClass().getResourceAsStream("/image/Villagers/4.png"), 69.28, 80, false, false);
        villages[0] = new Image(getClass().getResourceAsStream("/image/Villages/1.png"), 69.28, 80, false, false);
        villages[1] = new Image(getClass().getResourceAsStream("/image/Villages/2.png"), 69.28, 80, false, false);
        villages[2] = new Image(getClass().getResourceAsStream("/image/Villages/3.png"), 69.28, 80, false, false);
        villages[3] = new Image(getClass().getResourceAsStream("/image/Villages/4.png"), 69.28, 80, false, false);
        bamboo = new Image(getClass().getResourceAsStream("/image/Resources/bamboo.png"), 69.28, 80, false, false);
        coconuts = new Image(getClass().getResourceAsStream("/image/Resources/coconuts.png"), 69.28, 80, false, false);
        precious_stones = new Image(getClass().getResourceAsStream("/image/Resources/precious_stones.png"), 69.28, 80, false, false);
        statuettes = new Image(getClass().getResourceAsStream("/image/Resources/statuettes.png"), 69.28, 80, false, false);
        water = new Image(getClass().getResourceAsStream("/image/Resources/water.png"), 69.28, 80, false, false);
        // Sets up all spots
        for (int i = 0; i <= b.getSize() - 1; i++) {
            for (int j = 0; j <= b.getSize() - 1; j++) {
                if (b.getBoard()[i][j] != null) {
                    ImageView imageView = new ImageView();
                    if (i % 2 == 0) {
                        imageView.setX(34.64 + 69.28 * j);
                    } else {
                        imageView.setX(69.28 * j);
                    }
                    imageView.setY(60 * i);
                    if (b.getBoard()[i][j].spotType == 1)
                    {
                        rand += 7;
                        imageView.setImage(land[rand % 18]);
                    } else {
                        rand += 11;
                        imageView.setImage(ocean[rand % 12]);
                    }
                    imageViews.add(imageView);
                }
            }
        }
        // Adds stone circles
        for (int i = 0; i <= b.getSize() - 1; i++) {
            for (int j = 0; j <= b.getSize() - 1; j++) {
                if (b.getBoard()[i][j] != null) {
                    rand += 7;
                    if (b.getBoard()[i][j].circle) {
                        ImageView imageView = new ImageView();
                        imageView.setImage(circle[rand % 6]);
                        if (i % 2 == 0) {
                            imageView.setX(34.64 + 69.28 * j);
                        } else {
                            imageView.setX(69.28 * j);
                        }
                        imageView.setY(60 * i);
                        imageViews.add(imageView);
                    }
                }
            }
        }
        // Adds resources
        for (int i = 0; i <= b.getSize() - 1; i++) {
            for (int j = 0; j <= b.getSize() - 1; j++) {
                if (b.getBoard()[i][j] != null) {
                    if (b.getBoard()[i][j].resources != Resource.NULL) {
                        ImageView imageView = new ImageView();
                        if (i % 2 == 0) {
                            imageView.setX(34.64 + 69.28 * j);
                            imageView.setY(60 * i);
                        } else {
                            imageView.setX(69.28 * j);
                            imageView.setY(60 * i);
                        }
                        if (b.getBoard()[i][j].resources == Resource.COCONUT) {
                            imageView.setImage(coconuts);
                        } else if (b.getBoard()[i][j].resources == Resource.BAMBOO) {
                            imageView.setImage(bamboo);
                        } else if (b.getBoard()[i][j].resources == Resource.WATER) {
                            imageView.setImage(water);
                        } else if (b.getBoard()[i][j].resources == Resource.PRECIOUSSTONE) {
                            imageView.setImage(precious_stones);
                        } else {
                            imageView.setImage(statuettes);
                        }
                        imageViews.add(imageView);
                    }
                }
            }
        }
        // Adds player pieces
        for (int i = 0; i <= b.getSize() - 1; i++) {
            for (int j = 0; j <= b.getSize() - 1; j++) {
                if (b.getBoard()[i][j] != null && b.getBoard()[i][j].occupiedByPlayer != 100) {
                    ImageView imageView = new ImageView();
                    if (i % 2 == 0) {
                        imageView.setX(34.64 + 69.28 * j);
                        imageView.setY(60 * i);
                    } else {
                        imageView.setX(69.28 * j);
                        imageView.setY(60 * i);
                    }
                    if (b.getBoard()[i][j].settlerOrVillage == Spot.SettlerOrVillage.SETTLER) {
                        if (b.getBoard()[i][j].occupiedByPlayer == 0) {
                            imageView.setImage(villagers[0]);
                        } else if (b.getBoard()[i][j].occupiedByPlayer == 1) {
                            imageView.setImage(villagers[1]);
                        } else if (b.getBoard()[i][j].occupiedByPlayer == 2) {
                            imageView.setImage(villagers[2]);
                        } else {
                            imageView.setImage(villagers[3]);
                        }
                    } else {
                        if (b.getBoard()[i][j].occupiedByPlayer == 0) {
                            imageView.setImage(villages[0]);
                        } else if (b.getBoard()[i][j].occupiedByPlayer == 1) {
                            imageView.setImage(villages[1]);
                        } else if (b.getBoard()[i][j].occupiedByPlayer == 2) {
                            imageView.setImage(villages[2]);
                        } else {
                            imageView.setImage(villages[3]);
                        }
                    }
                    imageViews.add(imageView);
                }
            }
        }
        root.getChildren().addAll(imageViews);

        // Calls phaseDisplay from Display class to show the phase and player to move
        phase = Display.phaseDisplay(stateString);
        root.getChildren().add(phase);

        // Calls rowDisplay from Display class to show the row numbers
        Text[] rows = Display.rowDisplay(stateString);
        root.getChildren().addAll(rows);

        // Calls columnDisplay from Display class to show column coordinates on each tile
        for (int i = 0; i < b.getSize(); i++) {
            for (int j = 0; j < b.getSize(); j++) {
                if (Display.columnDisplay(b.getSize(), b.getSize(), stateString)[i][j] != null) {
                    root.getChildren().addAll(Display.columnDisplay(b.getSize(), b.getSize(), stateString)[i][j]);
                }
            }
        }

        // Calls scoreTable from Display class to make a table for the scores
        TableView scoreBoard = Display.scoreTable(stateString);
        Translate tablePosition = new Translate(1000, 0);
        scoreBoard.getTransforms().add(tablePosition);
        root.getChildren().add(scoreBoard);
    }

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
        // Creates the title screen
        Text title = new Text("BLUE LAGOON");
        title.setFill(Color.TEAL);
        title.setFont(Font.font("Serif", 100));

        HBox titleBox = new HBox();
        titleBox.getChildren().add(title);
        titleBox.setLayoutX(590);
        titleBox.setLayoutY(400);

        // Number of players selection
        Label playerLabel = new Label("Select Number of Players:");
        playerCount = new ChoiceBox<>();
        playerCount.getItems().addAll("2", "3", "4");
        playerCount.setValue("2");
        Button selectPlayerCount = new Button("Select");

        HBox playerBox = new HBox();
        playerBox.getChildren().addAll(playerLabel, playerCount, selectPlayerCount);
        playerBox.setSpacing(10);
        playerBox.setLayoutX(855);
        playerBox.setLayoutY(520);
        controls.getChildren().addAll(playerBox, titleBox);

        // Creates the number of AI opponents selection
        Label AILabel = new Label("Select Number of AI Opponents:");
        AICount = new ChoiceBox<>();
        AICount.getItems().addAll("0", "1", "2", "3");
        AICount.setValue("0");
        Button start = new Button("Start Game");

        HBox AIBox = new HBox();
        AIBox.getChildren().addAll(AILabel, AICount, start);
        AIBox.setSpacing(10);
        AIBox.setLayoutX(820);
        AIBox.setLayoutY(550);

        // Creates menu for entering moves
        Label moveLabel = new Label("Choose the piece and position:");
        Label rowLabel = new Label("Row:");
        Label colLabel = new Label("Column:");
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
        // For testing
        Button random = new Button("Random Move");
        // For testing
        HBox moveBox = new HBox();
        moveBox.getChildren().addAll(moveLabel, villageOrSettler, xPosition, yPosition, play, random);
        moveBox.setSpacing(10);
        moveBox.setLayoutX(1000);
        moveBox.setLayoutY(670);

        HBox labelBox = new HBox();
        labelBox.getChildren().addAll(rowLabel, colLabel);
        labelBox.setSpacing(27);
        labelBox.setLayoutX(1305);
        labelBox.setLayoutY(650);

        // Creates error text
        Text badSetup = new Text("Error: Number of AI opponents cannot be equal to or greater than total number of players");
        badSetup.setFill(Color.RED);
        badSetup.setX(100);
        badSetup.setY(740);

        // Creates "invalid move" text
        Text badMove = new Text("Error: invalid move");
        badMove.setFill(Color.RED);
        badMove.setX(1000);
        badMove.setY(720);


        // After # of Players is chosen, make choice for # of AIs appear
        selectPlayerCount.setOnAction(e -> {
            controls.getChildren().remove(AIBox);
            controls.getChildren().add(AIBox);
        });

        // Action taken when the "Start Game" button is pressed
        start.setOnAction(e -> {
            if (Integer.parseInt(playerCount.getValue()) <= Integer.parseInt(AICount.getValue())) {
                // If AIs >= Players then show error
                root.getChildren().remove(badSetup);
                root.getChildren().add(badSetup);
            }
            else {
                // If AIs < Players then begin the game
                root.getChildren().remove(badSetup);
                controls.getChildren().removeAll(titleBox, AIBox, playerBox);
                boardString = BlueLagoon.distributeResources(initializeGame(Integer.parseInt(playerCount.getValue())));
                displayState(boardString);
                controls.getChildren().addAll(moveBox, labelBox);
                Timer t = new Timer();
                t.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        triggerAI(Integer.parseInt(AICount.getValue()));
                    }
                }, 0, 5000);
            }
        });

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
                root.getChildren().remove(badMove);
            } else {
                root.getChildren().remove(badMove);
                root.getChildren().add(badMove);
            }

            root.getChildren().remove(phase);
            displayState(boardString);
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
