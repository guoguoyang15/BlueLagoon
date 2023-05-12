package comp1110.ass2;

public class Player {
    private Integer playerNumber;
    private Integer score;
    private Integer coconut;
    private Integer bamboo;
    private Integer water;
    private Integer stone;
    private Integer statuette;
    private Integer settlers;
    private Integer villages;
    private Integer PlayerNumber;

    public Player(int playerNumber, String stateString) {
        String[] playerStatements = stateString.split(";");
        int thisindex=0;
        for(int i=0;i<=playerStatements.length-1;i++){
            if(playerStatements[i].charAt(3)==playerNumber+48){
                thisindex=i;
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
    }
}

