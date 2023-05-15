package comp1110.ass2.gui;

import comp1110.ass2.Spot;

import java.util.HashSet;
import java.util.Set;

public class TRY {
    public static void main(String[] args) {
        String a="a 7 3; c 2 E; i 4 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 2,0 2,1 2,2 2,3 3,0 3,1 3,2 3,3 4,0 4,1 4,2 4,3 5,0 5,1 5,2 5,3 6,0 6,1 6,2 6,3; i 20 0,5 1,5 1,6 2,5 3,5 3,6 4,5 5,5 5,6 6,5; s 0,0 0,1 0,2 0,3 1,1 1,2 1,3 1,5 1,6 2,0 2,1 2,2 2,3 3,0 3,1 3,2 3,3 3,5 3,6 4,0 4,1 4,2 4,3 5,1 5,2 5,3 5,5 5,6 6,0 6,1 6,2 6,3; r C B W P 2,2 S; p 0 0 2 2 2 1 4 S 2,1 2,4 2,5 3,0 4,1 4,2 5,0 5,2 5,4 6,3 T 1,5 2,3 3,2 3,3 4,0; p 1 0 2 0 2 3 3 S 0,1 0,2 1,0 1,1 1,2 1,3 1,4 2,0 3,4 5,5 6,4 T 0,0 0,3 3,1 6,5; p 2 0 2 4 2 1 1 S 0,4 1,6 4,3 4,4 5,1 5,3 5,6 6,0 6,1 T 0,5 3,5 3,6 4,5 6,2;";
        String find[] =a.split(";");
        System.out.println(find.length);
    }

}
