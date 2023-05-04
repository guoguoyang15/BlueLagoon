package comp1110.ass2;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate[] generateAllCoordinates(int n) throws Exception {
        // Written by Tyler
        if (n < 0) {
            throw new Exception("There cannot be a negative number of rows");
        }
        List<Integer> coordinates = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 12; j++) {
                    coordinates.add(i);
                    coordinates.add(j);
                }
            }
            else {
                for (int j = 0; j < 13; j++) {
                    coordinates.add(i);
                    coordinates.add(j);
                }
            }
        }
        Coordinate[] pairs = new Coordinate[coordinates.size() / 2];
        for (int i = 0; i < coordinates.size(); i += 2) {
            pairs[i/2] = new Coordinate(coordinates.get(i), coordinates.get(i+1));
        }
        return pairs;
    }
}
