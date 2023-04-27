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

    public Coordinate[] generateAllPairs(int n) throws Exception {
        if (x < 0 || y < 0) {
            throw new Exception("There cannot be a negative number of rows");
        }
        List<Integer> coordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
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
        int[] array = new int[coordinates.size()];
        for(int i = 0; i < coordinates.size(); i++) {
            array[i] = coordinates.get(i);
        }
        Coordinate[] pairs = new Coordinate[array.length / 2];
        for (int i = 0; i < array.length; i =+ 2) {
            pairs[i].x = (array[i]);
            pairs[i].y = array[i+1];
        }

        return pairs;
    }
}
