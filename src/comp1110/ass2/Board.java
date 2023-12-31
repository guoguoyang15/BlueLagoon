package comp1110.ass2;

import static comp1110.ass2.Score.calculateScores;

/**
* @author Zhou Linsheng (most methods), Tyler Le (one method)
 * */
public class Board {
    // This class deals with anything that changes the overall game status, such as the phase, the number of players,
    // the island weightage, the current turn, and the settler/village limit. It also synthesizes a lot of information
    // from other classes.

    public Spot[][] board;
    public Spot[][] getBoard() {
        return board;
    }
    public void setBoard(Spot[][] board) {
        this.board = board;
    }
    public boolean isPhase() {
        return phase;
    }
    public void setPhase(boolean phase) {
        this.phase = phase;
    }
    public int getPlayerNum() {
        return playerNum;
    }
    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getTurn() {
        return turn;
    }
    public void setTurn(int turn) {
        this.turn = turn;
    }
    //TRUE for Exploration Phase and FALSE for Settlement Phase
    private boolean phase;
    //Number of players on this board
    private int playerNum;
    //Size of this board
    private int size;
    //Turn (which player is moving)
    private int turn;
    //Number of islands on this board
    private int islandNum;
    //Array of weights of island
    public int[] weight;
    public Player[] players;

    private int villageLimit = 5;
    private int settlerLimit;

    public int getIslandNum() {
        return islandNum;
    }

    public void setIslandNum(int islandNum) {
        this.islandNum = islandNum;
    }

    public int[] getWeight() {
        return weight;
    }
    public void setWeight(int[] weight) {
        this.weight = weight;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getVillageLimit() {
        return villageLimit;
    }

    public void setVillageLimit(int villageLimit) {
        this.villageLimit = villageLimit;
    }

    public int getSettlerLimit() {
        return settlerLimit;
    }

    public void setSettlerLimit(int settlerLimit) {
        this.settlerLimit = settlerLimit;
    }

    public Board(String statestring) {
        // Split the stateString first
        String[] statement=statestring.split(";");

        // Extract size of the board
        String[] org = statement[0].split(" ");
        this.size = Integer.parseInt(org[1]);
        // Extract number of players on this board
        this.playerNum = Integer.parseInt(org[2]);
        if (playerNum == 2){
            this.settlerLimit = 30;
        } else if(playerNum == 3){
            this.settlerLimit = 25;
        } else {
            this.settlerLimit = 20;
        }

        String[] state=statement[1].split(" ");
        // Extract phase of this game
        this.phase = state[3].equals("E");
        // Extract turn of current state
        this.turn = Integer.parseInt(state[2]);

        // Calculate number of islands
        int numOfIslands = 0;
        for(int i = 0; i <= statement.length - 1; i++){
            if(statement[i].startsWith(" i"))
                numOfIslands++;
        }
        this.islandNum = numOfIslands;


        //Create array of weights of islands
        int[] weightOfIslands = new int[numOfIslands];
        //Create array of players on this board
        Player[] p = new Player[playerNum];
        //Create an empty board first
        Spot[][] spots = new Spot[size][size];
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                if(i % 2 == 0 && j == size - 1){
                    spots[i][j] = null;
                    continue;
                }
                spots[i][j] = new Spot();
            }
        }

        int indexOfIslands = 0;
        // Initialize land spots on the map
        for (int i = 0; i <= statement.length - 1; i++) {
            // When this statement is island string
            if (statement[i].charAt(1) == 'i') {
                String[] land = statement[i].split(" ");
                // Point of island which owns this spot
                int weightOfThisIsland=Integer.parseInt(land[2]);
                weightOfIslands[indexOfIslands]=weightOfThisIsland;
                for (int j = 3; j <= land.length - 1; j++) { // land[0] = "", land[1] = "i", land[2] = "6/8/10"
                    String[] landXY = land[j].split(",");
                    int landx = Integer.parseInt(landXY[0]);
                    int landy = Integer.parseInt(landXY[1]);
                    spots[landx][landy].spotType = 1; // 1 means land, 0 means sea
                    spots[landx][landy].island=indexOfIslands; // index range from 0 to 7
                }
                indexOfIslands++;
            }

            if (statement[i].startsWith(" s")){
                String[] stoneString=statement[i].split(" ");
                for(int f = 0; f <= stoneString.length - 1; f++){
                    if(stoneString[f].contains(",")){
                        String[] circle = stoneString[f].split(",");
                        int stoneX = Integer.parseInt(circle[0]);
                        int stoneY = Integer.parseInt(circle[1]);
                        spots[stoneX][stoneY].circle = true;
                    }
                }
            }
            if (statement[i].startsWith(" r")){
                String flag = "";
                String[] resourcesString = statement[i].split(" ");
                for(int f = 0; f <= resourcesString.length - 1; f++){
                    if(resourcesString[f].equals("C")){
                        flag="C";
                    } else if (resourcesString[f].equals("B")) {
                        flag="B";
                    } else if (resourcesString[f].equals("W")) {
                        flag="W";
                    } else if (resourcesString[f].equals("P")) {
                        flag="P";
                    }else if(resourcesString[f].equals("S")){
                        flag="S";
                    }
                    if(resourcesString[f].contains(",")){
                        String[] circle=resourcesString[f].split(",");
                        int reX=Integer.parseInt(circle[0]);
                        int reY=Integer.parseInt(circle[1]);
                        if (flag.equals("C")) {
                            spots[reX][reY].resources = Resource.COCONUT;
                        } else if(flag.equals("B")) {
                            spots[reX][reY].resources = Resource.BAMBOO;
                        } else if(flag.equals("W")) {
                            spots[reX][reY].resources = Resource.WATER;
                        } else if(flag.equals("P")) {
                            spots[reX][reY].resources = Resource.PRECIOUSSTONE;
                        } else if(flag.equals("S")) {
                            spots[reX][reY].resources = Resource.STATUETTE;
                        }
                    }
                }
            }

            if (statement[i].startsWith(" p")) {
                String flag = "";
                int settlerNum = 0;
                int villageNum = 0;
                String[] playerPositions = statement[i].split(" ");
                int whichPlayer = Integer.parseInt(playerPositions[2]);//which player occupies these following spots
                String color = null;
                for (int j = 0; j <= playerPositions.length - 1; j++) {
                    if (playerPositions[j].equals("S")) {
                        flag = "S";
                    }
                    if (playerPositions[j].equals("T")) {
                        flag = "T";
                    }
                    if (playerPositions[j].contains(",")) {
                        String[] setPos = playerPositions[j].split(",");
                        int setx = Integer.parseInt(setPos[0]);
                        int sety = Integer.parseInt(setPos[1]);
                        spots[setx][sety].occupiedByPlayer = whichPlayer;
                        if (flag.equals("S")) {
                            spots[setx][sety].settlerOrVillage = Spot.SettlerOrVillage.SETTLER;
                            settlerNum++;
                        }
                        if (flag.equals("T")) {
                            spots[setx][sety].settlerOrVillage = Spot.SettlerOrVillage.VILLAGE;
                            villageNum++;
                        }
                    }
                    color = Player.getStats(whichPlayer, statestring).getColor();

                }
                p[whichPlayer] = new Player(Integer.parseInt(playerPositions[2]), Integer.parseInt(playerPositions[3]),
                        Integer.parseInt(playerPositions[4]), Integer.parseInt(playerPositions[5]),
                        Integer.parseInt(playerPositions[6]), Integer.parseInt(playerPositions[7]),
                        Integer.parseInt(playerPositions[8]), settlerNum, villageNum, color);
            }
        }
        this.weight = weightOfIslands;
        this.players = p;
        this.board = spots;
    }

    // Returns the game state representing this board
    public String toString(){
        String stateString="";
        //"a 13 2;"
        stateString+="a "+size+" "+playerNum+";";
        //" c 0 E"
        stateString+=" c "+turn+" ";
        if(isPhase()){
            stateString+="E;";
        }
        else{
            stateString+="S;";
        }
        // Set up island strings
        for(int i=0;i<=islandNum-1;i++){
            stateString+=" i "+weight[i];
            //Iterator the board
            for(int j=0;j<=size-1;j++){
                for(int k=0;k<=size-1;k++){
                     if(board[j][k]!=null&&board[j][k].island==i){
                         stateString+=" "+j+","+k;
                     }
                }
            }
            stateString+=";";
        }
        // Set up stone circle string
        stateString+=" s";
        for(int j=0;j<=size-1;j++){
            for(int k=0;k<=size-1;k++){
                if(board[j][k]!=null&&board[j][k].circle){
                    stateString+=" "+j+","+k;
                }
            }
        }

        stateString+=";";
        // Set up resources string
        stateString+=" r";
        stateString+=" C";
        for(int j=0;j<=size-1;j++){
            for(int k=0;k<=size-1;k++){
                if(board[j][k]!=null&&board[j][k].resources==Resource.COCONUT){
                    stateString+=" "+j+","+k;
                }
            }
        }
        stateString+=" B";
        for(int j=0;j<=size-1;j++){
            for(int k=0;k<=size-1;k++){
                if(board[j][k] != null && board[j][k].resources==Resource.BAMBOO){
                    stateString += " "+j+","+k;
                }
            }
        }
        stateString += " W";
        for(int j = 0; j <= size - 1; j++){
            for(int k = 0; k <= size - 1; k++){
                if(board[j][k] != null && board[j][k].resources == Resource.WATER){
                    stateString += " "+j+","+k;
                }
            }
        }
        stateString+=" P";
        for(int j = 0; j <= size - 1; j++){
            for(int k = 0; k <= size - 1; k++){
                if(board[j][k] != null && board[j][k].resources == Resource.PRECIOUSSTONE){
                    stateString += " "+j+","+k;
                }
            }
        }
        stateString += " S";
        for(int j = 0;j <= size-1; j++){
            for(int k = 0;k <= size - 1; k++){
                if(board[j][k] != null && board[j][k].resources == Resource.STATUETTE){
                    stateString += " "+j+","+k;
                }
            }
        }
        stateString+=";";
        // Set up player strings
        for(int i=0;i<=playerNum-1;i++){
            stateString += " p "+i+" "+players[i].getScore()+" "+players[i].getCoconut()+" "+players[i].getBamboo()+" "+players[i].getWater()+" "+players[i].getStone()+" "+players[i].getStatuette();
            stateString += " S";
            // Add settlers
            for (int j = 0; j <= size-1; j++){
                for(int k = 0; k <= size - 1; k++){
                    if(board[j][k] != null && board[j][k].occupiedByPlayer == i && board[j][k].settlerOrVillage == Spot.SettlerOrVillage.SETTLER){
                        stateString += " "+j+","+k;
                    }
                }
            }
            stateString += " T";
            // Add villages
            for (int j = 0 ;j <= size - 1; j++){
                for (int k = 0; k <= size - 1; k++){
                    if (board[j][k] != null && board[j][k].occupiedByPlayer == i && board[j][k].settlerOrVillage == Spot.SettlerOrVillage.VILLAGE){
                        stateString += " "+j+","+k;
                    }
                }
            }
            stateString+=";";
        }

        return stateString;
    }

    // @author Tyler Le
    // Checks if a stateString is correctly formatted
    public static boolean isStateStringWellFormed(String stateString) {
        String[] parts = stateString.split(";");
        // Separate strings into arrays of strings with the split method, using ";"
        if (parts[0].matches("a\\s[0-9]*[1-9][0-9]*\\s[1-9]")) {
            // Check if the game arrangement declaration is correct by means of regular expressions
            if (parts[1].matches("\\sc\\s\\d\\s[E|S]")) {
                for (int i = 2; i < parts.length; i++) {
                    // Iterate through the array to check if it is correct
                    if (parts[i].startsWith(" i")) {
                        if (!parts[i].matches("\\si\\s[0-9]*[1-9][0-9]*\\s(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})")) {
                            return false;
                        }
                    }
                    // Checks if Stones Statement is formatted correctly.
                    else if (parts[i].startsWith(" s")) {
                        if (!parts[i].matches("\\ss\\s(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})")) {
                            return false;
                        }
                    }
                    // Checks if Unclaimed Resources and Statuettes Statement is formatted correctly.
                    else if (parts[i].startsWith(" r")) {
                        if (!parts[i].matches("\\sr\\sC\\s(\\d{1,2},\\d{1,2}\\s)*B\\s(\\d{1,2},\\d{1,2}\\s)*W\\s(\\d{1,2},\\d{1,2}\\s)*P\\s(\\d{1,2},\\d{1,2}\\s)*S(\\s)??(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})*")) {
                            return false;
                        }
                    }
                    // Checks if Player Statement is formatted correctly.
                    else if (parts[i].startsWith(" p")) {
                        if (!parts[i].matches("\\sp\\s\\d\\s\\d{1,3}\\s(\\d\\s){5}S\\s(\\d{1,2},\\d{1,2}\\s)*T(\\s)??(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})*")) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                // Returns false if any errors are detected.
                return (stateString.endsWith(";"));
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // @author Zhou Linsheng
    // Checks if a phase is over, either by no more resources on the board OR no more moves
    public static boolean isPhaseOver(Board b) {
        //Count the number of resources collected by all players
        int allResources = 0;
        for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
            allResources += b.getPlayers()[i].getBamboo() + b.getPlayers()[i].getCoconut() +
                    b.getPlayers()[i].getWater() + b.getPlayers()[i].getStone();
        }
        boolean collectedAll = allResources == 24;
        int noMoves = 0;
        for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
            b.setTurn(i);
            if (Move.generateAllValidMoves(b).size() == 0) {
                noMoves++;
            }
        }
        return collectedAll || noMoves == b.getPlayerNum();
    }

    // @author Zhou Linsheng
    // Ends the current phase if no more moves can be player or if all resources are captured and then calculates scores
    public static String endPhase(Board b) {
        if (b.isPhase()) {
            b.setPhase(false);
            // Calculate current points of players
            int[] points = calculateScores(b);
            for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
                b.getPlayers()[i].setScore(b.getPlayers()[i].getScore() + points[i]);
                b.getPlayers()[i].setCoconut(0);
                b.getPlayers()[i].setBamboo(0);
                b.getPlayers()[i].setWater(0);
                b.getPlayers()[i].setStone(0);
                b.getPlayers()[i].setStatuette(0);
            }
            for (int j = 0; j <= b.getSize() - 1; j++) {
                for (int k = 0; k <= b.getSize() - 1; k++) {
                    if (b.getBoard()[j][k] != null) {
                        if (b.getBoard()[j][k].occupiedByPlayer != 100) {
                            if (b.getBoard()[j][k].settlerOrVillage == Spot.SettlerOrVillage.SETTLER) {
                                b.getBoard()[j][k].occupiedByPlayer = 100;
                                b.getBoard()[j][k].settlerOrVillage = Spot.SettlerOrVillage.NULL;
                            }
                            if (b.getBoard()[j][k].settlerOrVillage == Spot.SettlerOrVillage.VILLAGE && b.getBoard()[j][k].circle) {
                                b.getBoard()[j][k].occupiedByPlayer = 100;
                                b.getBoard()[j][k].settlerOrVillage = Spot.SettlerOrVillage.NULL;
                            }
                        }
                    }
                }
            }
            String s = b.toString();
            return Resource.distributeResources(s);

        } else {
            // Calculate current points of players
            int[] points = calculateScores(b);
            for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
                b.getPlayers()[i].setScore(b.getPlayers()[i].getScore() + points[i]);
            }
        }
        return b.toString();
    }

}
