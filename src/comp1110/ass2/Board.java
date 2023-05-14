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

    private int villageLimit=5;
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
        //Split the statestring first
        String[] statement=statestring.split(";");

        //Extract size of the board
        String[] org=statement[0].split(" ");
        this.size=Integer.parseInt(org[1]);
        //Extract number of players on this board
        this.playerNum=Integer.parseInt(org[2]);
        if(playerNum==2){
            this.settlerLimit=30;
        }else if(playerNum==3){
            this.settlerLimit=25;
        }else {
            this.settlerLimit=20;
        }

    };
     public boolean endPhase1(){
         return true;
     }

     public void preparationPhaseTwo(){

     }


}
