package comp1110.ass2;
import static comp1110.ass2.BlueLagoon.isStateStringWellFormed;


public class Player {
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

    private Integer score;
    private Integer coconut;
    private Integer bamboo;
    private Integer water;
    private Integer stone;
    private Integer statuette;
    private Integer settlers;
    private Integer villages;
    public Player() {
    }

    public Player(Integer playerNumber, Integer score, Integer coconut, Integer bamboo, Integer water, Integer stone, Integer statuette, Integer settlers, Integer villages) {
        this.playerNumber = playerNumber;
        this.score = score;
        this.coconut = coconut;
        this.bamboo = bamboo;
        this.water = water;
        this.stone = stone;
        this.statuette = statuette;
        this.settlers = settlers;
        this.villages = villages;

    }

    public Player getStats(int playerNumber, String stateString) throws Exception {
        String[] playerStatements = stateString.split("; p ");

        if (!isStateStringWellFormed(stateString)) {
            throw new Exception("State is not well-formed");
        }

        else {
            String[] stats = playerStatements[playerNumber+1].split(" ");
            this.playerNumber = Integer.parseInt(stats[0]);
            this.score = Integer.parseInt(stats[1]);
            this.coconut = Integer.parseInt(stats[2]);
            this.bamboo = Integer.parseInt(stats[3]);
            this.water = Integer.parseInt(stats[4]);
            this.stone = Integer.parseInt(stats[5]);
            this.statuette = Integer.parseInt(stats[6]);

            int settlers = 0;
            int villages = 0;
            int i = 0;
            while (!stats[8 + i].matches("T")) {
                settlers++;
                i++;
            }
            int j = 0;
            while (!stats[8 + settlers + j].matches("")) {
                villages++;
                j++;
            }
            this.settlers = settlers;
            this.villages = villages;
        }
        return new Player(playerNumber, score, coconut, bamboo, water, stone, statuette, settlers, villages);
    }
}

