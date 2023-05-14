package comp1110.ass2;

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
    private Integer PlayerNumber;

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

    public Player method(int playerNumber, String stateString) {
        String[] playerStatements = stateString.split(";");
        int thisindex=0;
        for(int i = 0; i <= playerStatements.length-1; i++){
            if(playerStatements[i].charAt(3) == playerNumber + 48) {
                thisindex = i;
            }
        }

        String[] stats = playerStatements[thisindex].split(" ");
        this.score = Integer.parseInt(stats[3]);
        this.coconut = Integer.parseInt(stats[4]);
        this.bamboo = Integer.parseInt(stats[5]);
        this.water = Integer.parseInt(stats[6]);
        this.stone = Integer.parseInt(stats[7]);
        this.statuette = Integer.parseInt(stats[8]);
        this.playerNumber = playerNumber;

        int settlers = 0;
        int villages = 0;
        int i = 0;
        while (!stats[8 + i].matches("T(;)?")) {
            settlers++;
            i++;
        }
        int j = 0;
        while (!stats[8 + settlers + j].matches("[T(;)?| ]")) {
            villages++;
            j++;
        }
        this.settlers = settlers;
        this.villages = villages;

        return new Player(playerNumber, score, coconut,bamboo,water,stone,statuette,settlers, villages);
    }
}

