package comp1110.ass2;

import java.util.List;

public class Board {
    Spot[][] spotMatrix;
    private List<Player> players;

    public Board(String stateString) {

    }

    public int numberOfPlayers(){
        return players.size();
    }

    public void setResources(){

    };
     public boolean endPhase1(){
         return true;
     }

     public void preparationPhaseTwo(){

     }
}
