package comp1110.ass2.gui;
import comp1110.ass2.*;
import comp1110.ass2.shapes.Hexagon;
import comp1110.ass2.shapes.Square;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhou Linsheng, Zhang Zhining, Tyler Le (authorship of each method is indicated)
 * This class generates all the JavaFX objects used in the game.
 */

public class Display {
    // @author Zhang Zhining and Zhou Linsheng
    // Displays images of the tiles
    public List<Shape> displayTiles(String stateString) {
        Board b = new Board(stateString);
        List<ImageView> imageViews = new ArrayList<>();
        List<Polygon> tileList=new ArrayList<>();
        List<Circle> villageList=new ArrayList<>();
        List<Shape> shapes=new ArrayList<>();
        int rand = 0;
        Image[] land = new Image[18];
        Image[] circle = new Image[6];
        Image[] ocean = new Image[12];
        Image[] settlers = new Image[4];
        Image[] villages = new Image[4];
        Image bamboo, coconuts, precious_stones, statuettes, water;

        // Background images
        Image background = new Image(getClass().getResourceAsStream("/image/background.png"), 1000, 800, false, false);
        // Land tile images
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

        // Stone circle images
        circle[0] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (1).png"), 69.28, 80, false, false);
        circle[1] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (2).png"), 69.28, 80, false, false);
        circle[2] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (3).png"), 69.28, 80, false, false);
        circle[3] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (4).png"), 69.28, 80, false, false);
        circle[4] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (5).png"), 69.28, 80, false, false);
        circle[5] = new Image(getClass().getResourceAsStream("/image/Circle/Circle (6).png"), 69.28, 80, false, false);

        // Sea tile images
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

        // Settler piece images
        settlers[0] = new Image(getClass().getResourceAsStream("/image/Villagers/1.png"), 69.28, 80, false, false);
        settlers[1] = new Image(getClass().getResourceAsStream("/image/Villagers/2.png"), 69.28, 80, false, false);
        settlers[2] = new Image(getClass().getResourceAsStream("/image/Villagers/3.png"), 69.28, 80, false, false);
        settlers[3] = new Image(getClass().getResourceAsStream("/image/Villagers/4.png"), 69.28, 80, false, false);

        // Village piece images
        villages[0] = new Image(getClass().getResourceAsStream("/image/Villages/1.png"), 69.28, 80, false, false);
        villages[1] = new Image(getClass().getResourceAsStream("/image/Villages/2.png"), 69.28, 80, false, false);
        villages[2] = new Image(getClass().getResourceAsStream("/image/Villages/3.png"), 69.28, 80, false, false);
        villages[3] = new Image(getClass().getResourceAsStream("/image/Villages/4.png"), 69.28, 80, false, false);

        // Resource images
        bamboo = new Image(getClass().getResourceAsStream("/image/Resources/bamboo.png"), 69.28, 80, false, false);
        coconuts = new Image(getClass().getResourceAsStream("/image/Resources/coconuts.png"), 69.28, 80, false, false);
        precious_stones = new Image(getClass().getResourceAsStream("/image/Resources/precious_stones.png"), 69.28, 80, false, false);
        statuettes = new Image(getClass().getResourceAsStream("/image/Resources/statuettes.png"), 69.28, 80, false, false);
        water = new Image(getClass().getResourceAsStream("/image/Resources/water.png"), 69.28, 80, false, false);


        // Sets up background
        ImageView back=new ImageView(background);
        imageViews.add(back);
        // Sets up all land and sea spots
        for (int i = 0; i <= b.getSize() - 1; i++) {
            for (int j = 0; j <= b.getSize() - 1; j++) {
                if (b.getBoard()[i][j] != null) {
                    ImageView imageView = new ImageView();
                    Hexagon hexagon;
                    if (i % 2 == 0) {
                        hexagon=new Hexagon(43.25+43.25*j,37.5*i+25,25);
                    } else {
                        hexagon=new Hexagon(21.625+43.25*j,37.5*i+25,25);
                    }
                    imageView.setY(60 * i);
                    if (b.getBoard()[i][j].spotType == 1)
                    {
                        rand += 7;
                        imageView.setImage(land[rand % 18]);
                        hexagon.setFill(Color.LIGHTGREEN);
                    } else {
                        rand += 11;
                        imageView.setImage(ocean[rand % 12]);
                        hexagon.setFill(Color.BLUE);
                    }
//                    imageViews.add(imageView);
                    tileList.add(hexagon);
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
                        Hexagon hexagon;
                        if (i % 2 == 0) {
                            hexagon=new Hexagon(43.25+43.25*j,37.5*i+25,20);
                        } else {
                            hexagon=new Hexagon(21.625+43.25*j,37.5*i+25,20);
                        }
                        imageView.setY(60 * i);
//                        imageViews.add(imageView);
                        hexagon.setFill(Color.LIGHTGRAY);
                        tileList.add(hexagon);
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
                        Polygon square=new Polygon();
                        if (i % 2 == 0) {
                            square.getPoints().addAll(30.75+43.25*j,12.5+37.5*i,
                                    30.75+43.25*j,37.5+37.5*i,
                                    55.75+43.25*j,37.5+37.5*i,
                                    55.75+43.25*j,12.5+37.5*i
                                    );
                        } else {
                            square.getPoints().addAll(9.125+43.25*j,12.5+37.5*i,
                                    9.125+43.25*j,37.5+37.5*i,
                                    34.125+43.25*j,37.5+37.5*i,
                                    34.125+43.25*j,12.5+37.5*i
                                    );
                        }
                        if (b.getBoard()[i][j].resources == Resource.COCONUT) {
                            imageView.setImage(coconuts);
                            square.setFill(Color.BROWN);
                        } else if (b.getBoard()[i][j].resources == Resource.BAMBOO) {
                            imageView.setImage(bamboo);
                            square.setFill(Color.DARKGREEN);
                        } else if (b.getBoard()[i][j].resources == Resource.WATER) {
                            imageView.setImage(water);
                            square.setFill(Color.CYAN);
                        } else if (b.getBoard()[i][j].resources == Resource.PRECIOUSSTONE) {
                            imageView.setImage(precious_stones);
                            square.setFill(Color.GOLD);
                        } else {
                            imageView.setImage(statuettes);
                            square.setFill(Color.BLACK);
                        }
//                        imageViews.add(imageView);
                        tileList.add(square);
                    }
                }
            }
        }

        // Adds player pieces
        for (int i = 0; i <= b.getSize() - 1; i++) {
            for (int j = 0; j <= b.getSize() - 1; j++) {
                if (b.getBoard()[i][j] != null && b.getBoard()[i][j].occupiedByPlayer != 100) {
                    ImageView imageView = new ImageView();
//                    if (i % 2 == 0) {
//                        imageView.setX(34.64 + 69.28 * j);
//                        imageView.setY(60 * i);
//                    } else {
//                        imageView.setX(69.28 * j);
//                        imageView.setY(60 * i);
//                    }
                    if (b.getBoard()[i][j].settlerOrVillage == Spot.SettlerOrVillage.SETTLER) {
                        Polygon triangle=new Polygon();
                        if(i%2==0){
                            triangle.getPoints().addAll(43.25+43.25*j,5.0+37.5*i,
                                    58.25+43.25*j,37.5+37.5*i,
                                    28.25+43.25*j,37.5+37.5*i
                                    );
                        }else {
                            triangle.getPoints().addAll(21.625+43.25*j,5.0+37.5*i,
                                    6.625+43.25*j,37.5+37.5*i,
                                    36.625+43.25*j,37.5+37.5*i
                            );
                        }
                        if (b.getBoard()[i][j].occupiedByPlayer == 0) {
                            imageView.setImage(settlers[0]);
                            triangle.setFill(Color.PINK);
                        } else if (b.getBoard()[i][j].occupiedByPlayer == 1) {
                            imageView.setImage(settlers[1]);
                            triangle.setFill(Color.CRIMSON);
                        } else if (b.getBoard()[i][j].occupiedByPlayer == 2) {
                            imageView.setImage(settlers[2]);
                            triangle.setFill(Color.PURPLE);
                        } else {
                            imageView.setImage(settlers[3]);
                            triangle.setFill(Color.YELLOW);
                        }
                        tileList.add(triangle);
                    } else {
                        Circle circle1=new Circle();
                        if(i%2==0){
                            circle1.setCenterX(43.25+43.25*j);
                        }else {
                            circle1.setCenterX(21.625+43.25*j);
                        }
                        circle1.setCenterY(25+37.5*i);
                        circle1.setRadius(15);
                        if (b.getBoard()[i][j].occupiedByPlayer == 0) {
                            imageView.setImage(villages[0]);
                            circle1.setFill(Color.PINK);
                        } else if (b.getBoard()[i][j].occupiedByPlayer == 1) {
                            imageView.setImage(villages[1]);
                            circle1.setFill(Color.CRIMSON);
                        } else if (b.getBoard()[i][j].occupiedByPlayer == 2) {
                            imageView.setImage(villages[2]);
                            circle1.setFill(Color.PURPLE);
                        } else {
                            imageView.setImage(villages[3]);
                            circle1.setFill(Color.YELLOW);
                        }
                        villageList.add(circle1);
                    }
//                    imageViews.add(imageView);

                }
            }
        }
        shapes.addAll(tileList);
        shapes.addAll(villageList);
        return shapes;
    }

    // @author Tyler Le
    // Takes in a game state and presents all the player information in tabular form
    public static TableView scoreTable (String stateString) {
        Board b = new Board(stateString);
        TableView scores = new TableView();

        // Creates each individual column and the Value Factories to set the value of each cell in the column
        TableColumn<Player, Integer> column1 = new TableColumn<>("Player");
        column1.setCellValueFactory(new PropertyValueFactory<>("playerNumber"));

        TableColumn<Player, Integer> column2 = new TableColumn<>("Score");
        column2.setCellValueFactory(new PropertyValueFactory<>("score"));

        TableColumn<Player, Integer> column3 = new TableColumn<>("Coconut");
        column3.setCellValueFactory(new PropertyValueFactory<>("coconut"));

        TableColumn<Player, Integer> column4 = new TableColumn<>("Bamboo");
        column4.setCellValueFactory(new PropertyValueFactory<>("bamboo"));

        TableColumn<Player, Integer> column5 = new TableColumn<>("Water");
        column5.setCellValueFactory(new PropertyValueFactory<>("water"));

        TableColumn<Player, Integer> column6 = new TableColumn<>("P.Stone");
        column6.setCellValueFactory(new PropertyValueFactory<>("stone"));

        TableColumn<Player, Integer> column7 = new TableColumn<>("Statuette");
        column7.setCellValueFactory(new PropertyValueFactory<>("statuette"));

        TableColumn<Player, Integer> column8 = new TableColumn<>("Settler");
        column8.setCellValueFactory(new PropertyValueFactory<>("settlers"));

        TableColumn<Player, Integer> column9 = new TableColumn<>("Village");
        column9.setCellValueFactory(new PropertyValueFactory<>("villages"));

        TableColumn<Player, String> column10 = new TableColumn<>("Color");
        column10.setCellValueFactory(new PropertyValueFactory<>("color"));

        // Adds columns to the table
        scores.getColumns().add(column1);
        scores.getColumns().add(column2);
        scores.getColumns().add(column3);
        scores.getColumns().add(column4);
        scores.getColumns().add(column5);
        scores.getColumns().add(column6);
        scores.getColumns().add(column7);
        scores.getColumns().add(column8);
        scores.getColumns().add(column9);
        scores.getColumns().add(column10);

        // Adds player information
        for (int i = 0; i < b.getPlayerNum(); i++) {
            scores.getItems().add(
                    Player.getStats(i, stateString));
        }
        return scores;
    }

    // @author Zhou Linsheng
    // Generates the phase and player to move text
    public static Text phaseDisplay (String stateString) {
        Board b = new Board(stateString);
        String info = "";
        if (b.isPhase()) {
            info += "Exploration Phase     ";
        } else {
            info += "Settlement Phase      ";
        }
        info += "Player "+b.getTurn()+" to move.";
        Text phase = new Text(info);
        phase.setX(500);
        phase.setY(550);
        return phase;
    }

    // @author Zhou Linsheng
    // Generates the row coordinate text
    public static Text[] rowDisplay (String stateString) {
        Board b = new Board(stateString);
        Text[] rows = new Text[b.getSize()];
        for(int i = 0; i <= rows.length - 1; i++){
            rows[i]=new Text(""+ i);
            rows[i].setX(570);
            rows[i].setY(37.5*i +23);
        }
        return rows;
    }

    // @author Zhou Linsheng
    // Generates the column coordinate text
    public static Text[][] columnDisplay (int lines, int columns) {
        Text[][] coordinates = new Text[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++){
                if (i % 2 == 0 && j == columns - 1){
                    coordinates[i][j] = null;
                } else {
                    coordinates[i][j] = new Text(""+ j);
                    if (i % 2 == 0){
                        coordinates[i][j].setX(39 + 43.25*j);
                    } else {
                        coordinates[i][j].setX(17 + 43.25*j);
                    }
                    coordinates[i][j].setY(45 + 37.5*i);
                }
            }
        }
        return coordinates;
    }

    // @author Zhou Linsheng
    // Display the point weight of each island
    public static Text[][] weightDisplay (int lines, int columns, Board b){
        Text[][] weights = new Text[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++){
                if (i % 2 == 0 && j == columns - 1){
                    weights[i][j] = null;
                } else {
                    if(b.getBoard()[i][j].spotType == 1){
                        weights[i][j] = new Text("("+b.getWeight()[b.getBoard()[i][j].island]+")");
                        if (i % 2 == 0){
                            weights[i][j].setX(37+ 43.25*j);
                        } else {
                            weights[i][j].setX(15 + 43.25*j);
                        }
                        weights[i][j].setY(37.5*i+23);
                    } else {
                        weights[i][j] = null;
                    }
                }
            }
        }
        return weights;
    }

    // @author Tyler Le
    // Displays the winner if there is one
    public static Text displayWinner (String stateString) {
        Board b = new Board(stateString);
        if (!b.isPhase() && BlueLagoon.generateAllValidMoves(stateString).size() == 0) {
            Text winner = new Text("Player " + Player.findWinner(stateString) + " has won!");
            winner.setX(200);
            winner.setY(600);
            winner.setFill(Color.DARKGREEN);
            winner.setFont(Font.font("Serif"));
            return winner;
        }
        else {
            return new Text("");
        }
    }

    // @author Tyler Le
    // Displays the title screen
    public static HBox titleScreen() {
        Text title = new Text("BLUE LAGOON");
        title.setFill(Color.TEAL);
        title.setFont(Font.font("Serif", 100));

        HBox titleBox = new HBox();
        titleBox.getChildren().add(title);
        titleBox.setLayoutX(200);
        titleBox.setLayoutY(300);

        return titleBox;
    }
    // @author Tyler Le
    // Displays the title screen
    public static HBox badMoveScreen() {
        // Creates "invalid move" text
        Text badMove = new Text("Error: invalid move");
        badMove.setFill(Color.RED);

        HBox badMoveBox = new HBox();
        badMoveBox.getChildren().add(badMove);
        badMoveBox.setLayoutX(500);
        badMoveBox.setLayoutY(620);

        return badMoveBox;
    }
    // @author Tyler Le
    // Displays the title screen
    public static HBox badSetupScreen() {
        Text badSetup = new Text("Error: Number of AI opponents cannot be equal to or greater than total number of players");
        badSetup.setFill(Color.RED);

        HBox badSetupBox = new HBox();
        badSetupBox.getChildren().add(badSetup);
        badSetupBox.setLayoutX(330);
        badSetupBox.setLayoutY(500);

        return badSetupBox;
    }

}
