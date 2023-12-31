package comp1110.ass2;

import comp1110.ass2.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

@Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
public class GetStatsTest {
    @Test
    public void newGame(){
        String newGame = "a 13 2; c 0 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T;";
        Assertions.assertEquals(Player.getStats(0, newGame).getScore(), 0);
    }
    @Test
    public void randomGame1(){
        String randomGame1 = "a 13 2; c 0 S; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C 1,12 2,1 8,2 9,0 10,3 B 1,8 7,12 11,0 W 0,9 3,12 4,0 P 3,7 6,6 S 0,0 1,4 6,3 7,0 10,6 11,5 12,2; p 0 116 0 1 1 2 1 S 0,5 5,9 7,9 7,11 10,10 11,9 12,8 12,11 T 1,6 6,9 7,10 11,10 12,10; p 1 94 1 2 2 2 0 S 3,5 3,10 4,2 4,3 5,11 7,8 8,5 9,9 T 4,4 4,10 7,5 8,7 8,9;";
        Assertions.assertTrue(Player.getStats(0, randomGame1).getScore() == 116 && Player.getStats(0, randomGame1).getCoconut() == 0 && Player.getStats(0, randomGame1).getBamboo() == 1 && Player.getStats(0, randomGame1).getVillages() == 5);
    }
    @Test
    public void randomGame2(){
        String randomGame2 = "a 13 3; c 0 S; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 10 0 0 0 0 0 S 9,2 9,3 T 8,2; p 1 90 0 0 0 0 0 S 3,4 4,2 T 3,3; p 2 107 0 0 0 0 0 S 7,8 8,6 T 8,7;";
        Assertions.assertTrue(Player.getStats(2, randomGame2).getScore() == 107 && Player.getStats(2, randomGame2).getWater() == 0 && Player.getStats(2, randomGame2).getStone() == 0 && Player.getStats(2, randomGame2).getSettlers() == 2);
    }

    @Test
    public void randomGame3() {
        String randomGame3 = "a 13 4; c 3 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C 6,6 7,8 10,6 B 3,5 6,3 W 0,0 11,0 12,2 12,11 P 9,9 11,5 S 1,12 4,2 7,0 9,0; p 0 0 2 1 0 2 0 S 2,2 3,10 3,12 4,9 5,9 5,10 5,11 6,9 8,2 9,3 T 4,11; p 1 0 0 2 0 2 1 S 0,8 0,9 1,8 1,9 2,1 3,1 4,0 7,7 10,2 11,9 12,8 T; p 2 0 0 0 1 0 2 S 3,0 3,7 3,8 4,6 8,5 8,6 8,10 9,11 10,10 11,10 T 12,10; p 3 0 1 1 1 0 1 S 0,5 1,4 1,5 4,8 7,10 7,11 7,12 9,4 10,3 T 8,11;";
        Assertions.assertTrue(Player.getStats(3, randomGame3).getPlayerNumber() == 3 && Player.getStats(3, randomGame3).getStatuette() == 1 && Player.getStats(3, randomGame3).getVillages() == 1 && Player.getStats(3, randomGame3).getSettlers() == 9);
    }
}
