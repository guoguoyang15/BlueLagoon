package comp1110.ass2;

/**
 * @author Tyler Le (all methods)
 */

// This class deals with all things related to the players, their stats and the winner of the game.
public class Player {
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
    private final Integer settlers;
    private final Integer villages;
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
            playerColor = "Pink";
        }
        else if (playerNumber == 1) {
            playerColor = "Crimson";
        }
        else if (playerNumber == 2) {
            playerColor = "Purple";
        }
        else if (playerNumber == 3) {
            playerColor = "Yellow";
        }
        return new Player(playerNumber, score, coconut, bamboo,water,stone,statuette, settlers, villages, playerColor);
    }

    // Returns the number of the winner as a string
    public static String findWinner(String stateString) {
        Board b = new Board(stateString);
        int[] scores = new int[b.getPlayerNum()];
        for (int i = 0; i < b.getPlayerNum(); i++) {
            scores[i] = getStats(i, stateString).getScore();
        }
        int maxAt = 0;

        for (int i = 0; i < scores.length; i++) {
            maxAt = scores[i] > scores[maxAt] ? i : maxAt;
        }
        return Integer.toString(maxAt);
    }
}

