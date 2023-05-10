package comp1110.ass2;

import javax.swing.plaf.synth.SynthTableUI;

public class Player {
    private Integer playerNumber = 0;
    private Integer score = 0;
    private Integer settlers = 0;
    private Integer villages = 0;
    private Integer bamboo = 0;
    private Integer coconut = 0;
    private Integer stone = 0;
    private Integer water = 0;
    private Integer statuette = 0;

    public Player() {
    }

    public Player(Integer playerNumber, Integer score, Integer settlers, Integer villages, Integer bamboo, Integer coconut, Integer stone, Integer water, Integer statuette) {
        this.playerNumber = playerNumber;
        this.score = score;
        this.settlers = settlers;
        this.villages = villages;
        this.bamboo = bamboo;
        this.coconut = coconut;
        this.stone = stone;
        this.water = water;
        this.statuette = statuette;

    }
}

