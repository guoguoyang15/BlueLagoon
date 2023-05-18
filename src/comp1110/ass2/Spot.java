package comp1110.ass2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhou Linsheng (all methods)
 * This class deals with anything that has to do with the different positions of the board, such as if a position is
 * next to another, or whether it is even valid. It also deals with what they contain, such as a piece or a resource.
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
    public int island; // No. of island the spot belongs to
    public boolean circle; // If this spot has a stone circle, then it's true; otherwise, it's false
    public SettlerOrVillage settlerOrVillage;

    public Spot() {
        this.occupiedByPlayer = 100; // there are players 0~3, at first nobody occupies this spot
        this.spotType = 0; // We can change it later, those are still not changed will be sea
        this.resources = Resource.NULL;
        this.island = 100; // we change it later,from 0 to 7
        this.settlerOrVillage = SettlerOrVillage.NULL; // At first nothing is in this spot
        this.circle = false; // When meeting a stone circle, change the value to true
    }

    // Checks if this spot is on the board
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

    // Checks if two spots are next to each other
    public static boolean ifAdjacent(int x1, int y1, int x2, int y2) {
        //four positions are true for all rows
        if (x1 == x2 && Math.abs(y1 - y2) == 1) {
            return true;
        }
        if (y1 == y2 && Math.abs(x1 - x2) == 1) {
            return true;
        }
        //sometimes we need to consider two cases: odd rows and even rows
        if (x1 % 2 == 0) {
            return Math.abs(x1 - x2) == 1 && (y2 - y1) == 1;
        } else {
            return Math.abs(x1 - x2) == 1 && (y1 - y2) == 1;
        }
    }

    // Returns a list of all adjacent position of a player given a certain spot
    public static List<Coordinate> getAdjacentSpots(Coordinate cord, List<Coordinate> listSet) {
        List<Coordinate> adj = new ArrayList<>();
        for (Coordinate cc : listSet) {
            if (Spot.ifAdjacent(cord.x, cord.y, cc.x, cc.y)) {
                adj.add(cc);
            }
        }
        return adj;
    }
}
