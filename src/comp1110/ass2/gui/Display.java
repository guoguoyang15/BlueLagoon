package comp1110.ass2.gui;
import comp1110.ass2.Board;
import comp1110.ass2.Player;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

// @author Tyler Le
// This class generates all the JavaFX objects used in the game
public class Display {

    public static TableView scoreTable (String stateString) {
        // Generates a display including all Player information in table form
        Board b = new Board(stateString);
        TableView scores = new TableView();

        TableColumn<Player, Integer> column1 = new TableColumn<>("Player #");
        column1.setCellValueFactory(new PropertyValueFactory<>("playerNumber"));

        TableColumn<Player, Integer> column2 = new TableColumn<>("Score");
        column2.setCellValueFactory(new PropertyValueFactory<>("score"));

        TableColumn<Player, Integer> column3 = new TableColumn<>("Coconut");
        column3.setCellValueFactory(new PropertyValueFactory<>("coconut"));

        TableColumn<Player, Integer> column4 = new TableColumn<>("Bamboo");
        column4.setCellValueFactory(new PropertyValueFactory<>("bamboo"));

        TableColumn<Player, Integer> column5 = new TableColumn<>("Water");
        column5.setCellValueFactory(new PropertyValueFactory<>("water"));

        TableColumn<Player, Integer> column6 = new TableColumn<>("P. Stone");
        column6.setCellValueFactory(new PropertyValueFactory<>("stone"));

        TableColumn<Player, Integer> column7 = new TableColumn<>("Statuettes");
        column7.setCellValueFactory(new PropertyValueFactory<>("statuette"));

        TableColumn<Player, Integer> column8 = new TableColumn<>("Settlers");
        column8.setCellValueFactory(new PropertyValueFactory<>("settlers"));

        TableColumn<Player, Integer> column9 = new TableColumn<>("Villages");
        column9.setCellValueFactory(new PropertyValueFactory<>("villages"));

        TableColumn<Player, String> column10 = new TableColumn<>("Color");
        column10.setCellValueFactory(new PropertyValueFactory<>("color"));

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

        for (int i = 0; i < b.getPlayerNum(); i++) {
            scores.getItems().add(
                    Player.getStats(i, stateString));
        }

        return scores;
    }
    // @author Linsheng Zhou
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
        phase.setX(1000);
        phase.setY(640);
        return phase;
    }

    // @author Linsheng Zhou
    // Generates the row coordinate text
    public static Text[] rowDisplay (String stateString) {
        Board b = new Board(stateString);
        Text[] rows = new Text[b.getSize()];
        for(int i = 0; i<= rows.length-1; i++){
            rows[i]=new Text(""+i);
            rows[i].setX(920);
            rows[i].setY(61*i+40);
        }
        return rows;
    }

    // @author Linsheng Zhou
    // Generates the column coordinate text
    public static Text[][] columnDisplay (int lines, int columns, String stateString) {

        Text[][] coordinates = new Text[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++){
                if (i % 2 == 0 && j == columns - 1){
                    coordinates[i][j] = null;
                } else {
                    coordinates[i][j] = new Text(""+j);
                    if (i % 2 == 0){
                        coordinates[i][j].setX(65+69.28*j);
                    } else {
                        coordinates[i][j].setX(30+69.28*j);
                    }
                    coordinates[i][j].setY(75+60*i);
                }
            }
        }
        return coordinates;
    }
    // @author Linsheng Zhou
    //Display the point weight of each island
    public static Text[][] weightDisplay (int lines, int columns, Board b){
        Text[][] weights = new Text[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++){
                if (i % 2 == 0 && j == columns - 1){
                    weights[i][j] = null;
                } else {
                    if(b.getBoard()[i][j].spotType==1){
                        weights[i][j] = new Text("("+b.getWeight()[b.getBoard()[i][j].island]+")");
                        if (i % 2 == 0){
                            weights[i][j].setX(65+69.28*j);
                        } else {
                            weights[i][j].setX(30+69.28*j);
                        }
                        weights[i][j].setY(35+60*i);
                    }else {
                        weights[i][j] =null;
                    }
                }
            }
        }
        return weights;
    }

}
