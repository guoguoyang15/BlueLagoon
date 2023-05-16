package comp1110.ass2;


public class Player {
    // Written by Tyler
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
    public Integer getVillages() {
        return villages;
    }
    public String getColor() {
        return color;
    }

    private Integer playerNumber;
    private Integer score;
    private Integer coconut;
    private Integer bamboo;
    private Integer water;
    private Integer stone;
    private Integer statuette;
    private Integer settlers;
    private Integer villages;
    private final String color;

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
        String[] playerStatements = stateString.split("; p ");

        String[] stats = playerStatements[playerNumber + 1].split(" ");
        int score = Integer.parseInt(stats[1]);
        int coconut = Integer.parseInt(stats[2]);
        int bamboo = Integer.parseInt(stats[3]);
        int water = Integer.parseInt(stats[4]);
        int stone = Integer.parseInt(stats[5]);
        int statuette = Integer.parseInt(stats[6]);

        // Counts the number of settlers and villages for each player
        int settlers = 0;
        int i = 0;
        while (!stats[8 + i].matches("T(;)?")) {
            settlers++;
            i++;
        }

        int villages = stats.length - (9 + i);

        // Sets the color for each player number
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

