package comp1110.ass2;

public class Board {
    private Spot[][] board;
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

    public Board(String statestring) {
        //Split the statestring first
        String[] statement=statestring.split(";");

        //Extract size of the board
        String[] org=statement[0].split(" ");
        this.size=Integer.parseInt(org[1]);
        //Extract number of players on this board
        this.playerNum=Integer.parseInt(org[2]);

        String[] state=statement[1].split(" ");
        //Extract phase of this game
        this.phase=state[3].equals("E");
        //Extract turn of current state
        this.turn=Integer.parseInt(state[2]);

        //Calculate number of islands
        int numOfIslands=0;
        for(int i=0;i<=statement.length-1;i++){
            if(statement[i].startsWith(" i"))
                numOfIslands++;
        }
        this.islandNum=numOfIslands;


        //Create array of weights of islands
        int[] weightOfIslands=new int[numOfIslands];
        //Create array of players on this board
        Player[] p=new Player[playerNum];
        //Create an empty board first
        Spot[][] spots=new Spot[size][size];
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                if(i%2==0&&j==size-1){
                    spots[i][j]=null;
                    continue;
                }
                spots[i][j] = new Spot();
            }
        }

        int indexOfIslands=0;
        //initialize land spots on the map
        for (int i = 0; i <= statement.length - 1; i++) {
            //when this statement is island string
            if (statement[i].charAt(1) == 'i') {
                String[] land = statement[i].split(" ");
                //Point of island which owns this spot
                int weightOfThisIsland=Integer.parseInt(land[2]);
                weightOfIslands[indexOfIslands]=weightOfThisIsland;
                for (int j = 3; j <= land.length - 1; j++) {//land[0]="",land[1]="i",land[2]="6/8/10"
                    String[] landXY = land[j].split(",");
                    int landx = Integer.parseInt(landXY[0]);
                    int landy = Integer.parseInt(landXY[1]);
                    spots[landx][landy].spotType = 1;//1 means land, 0 means sea
                    spots[landx][landy].island=indexOfIslands;//index range from 0 to 7
                }
                indexOfIslands++;
            }

            if(statement[i].startsWith(" s")){
                String[] stoneString=statement[i].split(" ");
                for(int f=0;f<= stoneString.length-1;f++){
                    if(stoneString[f].contains(",")){
                        String[] circle=stoneString[f].split(",");
                        int stoneX=Integer.parseInt(circle[0]);
                        int stoneY=Integer.parseInt(circle[1]);
                        spots[stoneX][stoneY].circle=true;
                    }
                }
            }
            if(statement[i].startsWith(" r")){
                String flag="";
                String[] resourcesString=statement[i].split(" ");
                for(int f=0;f<= resourcesString.length-1;f++){
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
                    }else {
                    }
                    if(resourcesString[f].contains(",")){
                        String[] circle=resourcesString[f].split(",");
                        int reX=Integer.parseInt(circle[0]);
                        int reY=Integer.parseInt(circle[1]);
                        if(flag.equals("C")){
                            spots[reX][reY].resources=Resource.COCONUT;
                        }else if(flag.equals("B")){
                            spots[reX][reY].resources=Resource.BAMBOO;
                        }else if(flag.equals("W")){
                            spots[reX][reY].resources=Resource.WATER;
                        }else if(flag.equals("P")){
                            spots[reX][reY].resources=Resource.PRECIOUSSTONE;
                        }else if(flag.equals("S")){
                            spots[reX][reY].resources=Resource.STATUETTE;
                        }else {
                        }
                    }
                }
            }

            if (statement[i].startsWith(" p")) {
                String flag="";
                int settlerNum=0;
                int villageNum=0;
                String[] playerPositions = statement[i].split(" ");
                int whichplayer = Integer.parseInt(playerPositions[2]);//which player occupies these following spots
                for (int j = 0; j <= playerPositions.length - 1; j++) {
                    if(playerPositions[j].equals("S")){
                        flag="S";
                    }
                    if(playerPositions[j].equals("T")){
                        flag="T";
                    }
                    if (playerPositions[j].contains(",")) {
                        String[] setPos = playerPositions[j].split(",");
                        int setx = Integer.parseInt(setPos[0]);
                        int sety = Integer.parseInt(setPos[1]);
                        spots[setx][sety].occupiedByPlayer = whichplayer;
                        if(flag.equals("S")){
                            spots[setx][sety].settlerOrVillage= Spot.SettlerOrVillage.SETTLER;
                            settlerNum++;
                        }
                        if(flag.equals("T")){
                            spots[setx][sety].settlerOrVillage= Spot.SettlerOrVillage.VILLAGE;
                            villageNum++;
                        }
                    }
                }
                p[whichplayer]=new Player(Integer.parseInt(playerPositions[2]),Integer.parseInt(playerPositions[3]),
                        Integer.parseInt(playerPositions[4]),Integer.parseInt(playerPositions[5]),
                        Integer.parseInt(playerPositions[6]),Integer.parseInt(playerPositions[7]),
                        Integer.parseInt(playerPositions[8]),settlerNum,villageNum);
            }
        }

        this.weight=weightOfIslands;
        this.players = p;

    }


}
