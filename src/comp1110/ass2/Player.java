package comp1110.ass2;
import comp1110.ass2.Board;

public class Player {
    // Written by Tyler
    private Integer playerNumber;
    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCoconut() {
        return coconut;
    }

    public void setCoconut(Integer coconut) {
        this.coconut = coconut;
    }

    public Integer getBamboo() {
        return bamboo;
    }

    public void setBamboo(Integer bamboo) {
        this.bamboo = bamboo;
    }

    public Integer getWater() {
        return water;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public Integer getStone() {
        return stone;
    }

    public void setStone(Integer stone) {
        this.stone = stone;
    }

    public Integer getStatuette() {
        return statuette;
    }

    public void setStatuette(Integer statuette) {
        this.statuette = statuette;
    }

    public Integer getSettlers() {
        return settlers;
    }

    public void setSettlers(Integer settlers) {
        this.settlers = settlers;
    }

    public Integer getVillages() {
        return villages;
    }

    public void setVillages(Integer villages) {
        this.villages = villages;
    }

    public String getColor() {
        return color;
    }

    private Integer PlayerNumber;
    private Integer score;
    private Integer coconut;
    private Integer bamboo;
    private Integer water;
    private Integer stone;
    private Integer statuette;
    private Integer settlers;
    private Integer villages;
    private String color;


    // Creates a Player object which is later used to make the Board class and the scoreboard in the Game class 
    public Player(Integer playerNumber, Integer score, Integer coconut, Integer bamboo, Integer water, Integer stone, Integer statuette, Integer settlers, Integer villages, String color) {
        this.playerNumber = playerNumber;
        this.score = score;
        this.coconut = coconut;
        this.bamboo = bamboo;
        this.water = water;
        this.stone = stone;
        this.statuette = statuette;
        this.settlers = settlers;
        this.villages = villages;
        this.color = color;
    }

    // Given a player's number and the current game state, returns a Player object representing the Player's stats
    public static Player getStats(int playerNumber, String stateString) {
        String[] playerStatements = stateString.split(";");
        int index=0;
        for(int i = 0; i <= playerStatements.length-1; i++){
            if(playerStatements[i].charAt(3) == playerNumber + 48) {
                index = i;
            }
        }

        String[] stats = playerStatements[index].split(" ");
        int score = Integer.parseInt(stats[3]);
        int coconut = Integer.parseInt(stats[4]);
        int bamboo = Integer.parseInt(stats[5]);
        int water = Integer.parseInt(stats[6]);
        int stone = Integer.parseInt(stats[7]);
        int statuette = Integer.parseInt(stats[8]);

        int settlers ;
        int villages ;
        int indexS = 0;
        int indexT=0;
        for(int i=0;i<=stats.length-1;i++){
            if(stats[i].equals("S")){
                indexS=i;
            }
            if(stats[i].equals("T")){
                indexT=i;
            }
        }
        settlers=indexT-indexS-1;
        villages=stats.length-1-indexT;
        String playerColor = "";
        if (playerNumber == 0) {
            playerColor = "Orange";
        }
        else if (playerNumber == 1) {
            playerColor = "Blue";
        }
        else if (playerNumber == 2) {
            playerColor = "Green";
        }
        else if (playerNumber == 3) {
            playerColor = "Purple";
        }
        return new Player(playerNumber, score, coconut, bamboo,water,stone,statuette, settlers, villages, playerColor);
    }
}

