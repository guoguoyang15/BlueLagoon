package comp1110.ass2;

/**
 * @author Zhou Linsheng
 */
public class Spot {

    public enum SettlerOrVillage{
        NULL,
        SETTLER,
        VILLAGE
    }
    public int occupiedByPlayer;
    public int spotType;
    public Resource resources;
    public int island;//No. of island the spot belongs to
    public boolean circle;//If this spot has a stone circle, then it's true or it's false
    public SettlerOrVillage settlerOrVillage;

    public Spot() {
        this.occupiedByPlayer=100;//there are players 0~3, at first nobody occupies this spot
        this.spotType=0;//We can change it later, those are still not changed will be sea
        this.resources=Resource.NULL;
        this.island=100;//we change it later,from 0 to 7
        this.settlerOrVillage=SettlerOrVillage.NULL;//At first nothing this spot
        this.circle=false;//When meeting a stone circle, change the value to true
    }
    /**
     * @author Zhou Linsheng
     * @param size
     * @param x
     * @param y
     * @return whether this spot is on this board
     */
    public static boolean isPosInIndex(int size, int x, int y) {
        if (x < 0 || x >= size) {
            return false;
        } else {
            if (x % 2 == 0) {
                return y >= 0 && y <= size - 2;
            } else {
                return y >= 0 && y <= size - 1;
            }
        }
    }




}
