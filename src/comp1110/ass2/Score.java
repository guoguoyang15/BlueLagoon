package comp1110.ass2;
import java.util.*;


/**
 * @author Zhou Linsheng
 */
// This class deals with all matters related to score calculation.
public class Score {
    /**
     * @author Zhou Linsheng
     * @param b
     * @return TotalIslandScore
     */
    //Task 11 A
    public static int[] calculateTotalIslandsScore(Board b) {
        // Array of points in this part
        int[] points = new int[b.getPlayerNum()];
        for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
            //Array length of 8
            int[] occupiedIsland = new int[b.getIslandNum()];
            for (int j = 0; j <= b.getSize() - 1; j++) {
                for (int k = 0; k <= b.getSize() - 1; k++) {
                    if (b.getBoard()[j][k] != null && b.getBoard()[j][k].occupiedByPlayer == i && b.getBoard()[j][k].island != 100) {
                        occupiedIsland[b.getBoard()[j][k].island]++;
                    }
                }
            }
            // Finds the number of islands not occupied by this player
            int noZero = 0;
            for (int m = 0; m <= b.getIslandNum() - 1; m++) {
                if (occupiedIsland[m] != 0) {
                    noZero++;
                }
            }
            if (noZero >= 8) {
                points[i] = 20;
            } else if (noZero == 7) {
                points[i] = 10;
            } else {
                points[i] = 0;
            }
        }
        return points;
    }


    /**
     * @author Zhou Linsheng
     * @param b
     * @return Island Link Scores
     */
    //Task 11 B
    public static int[] calculateIslandLinksScore(Board b) {
        int[] points = new int[b.getPlayerNum()];
        for (int p = 0; p <= b.getPlayerNum() - 1; p++) {
            List<Coordinate> posList = new ArrayList<>();
            for (int j = 0; j <= b.getSize() - 1; j++) {
                for (int k = 0; k <= b.getSize() - 1; k++) {
                    if (b.getBoard()[j][k] != null && b.getBoard()[j][k].occupiedByPlayer == p) {
                        posList.add(new Coordinate(j, k));
                    }
                }
            }

            //We need to calculate all possible links of this player
            List<List<Coordinate>> linkSet = new ArrayList<>();
            if (posList.size() == 0) {
                points[p] = 0;
            } else {
                while (!posList.isEmpty()) {
                    Stack<Coordinate> posStack = new Stack<>();
                    List<Coordinate> component = new ArrayList<>();
                    posStack.push(posList.get(0));
                    posList.remove(posList.get(0));
                    while (!posStack.empty()) {
                        Coordinate g = posStack.pop();
                        component.add(g);
                        List<Coordinate> adj = Spot.getAdjacentSpots(g, posList);
                        posStack.addAll(adj);
                        posList.removeAll(adj);
                    }
                    linkSet.add(component);
                }

                // Now we know all possible links of the player in linkSet
                int maxIsland = 0;
                for (List<Coordinate> link : linkSet) {
                    // A boolean array marking which islands occupied by this link
                    int[] islandOccupied = new int[b.getIslandNum()];
                    // if a node occupies No.i island
                    for (Coordinate cord : link) {
                        // If a node occupies the *i*th island
                        if (b.getBoard()[cord.x][cord.y].island != 100) {
                            islandOccupied[b.getBoard()[cord.x][cord.y].island]++;
                        }
                    }
                    // Number of islands this link occupies
                    int thisLinkIsland = 0;
                    for (int i = 0; i <= b.getIslandNum() - 1; i++) {
                        if (islandOccupied[i] != 0) {
                            thisLinkIsland++;
                        }
                    }
                    if (thisLinkIsland > maxIsland) {
                        maxIsland = thisLinkIsland;
                    }
                }
                points[p] = maxIsland * 5;
                // In the end of a player calculation, clear spots set to empty set
                posList.clear();
            }
        }
        return points;
    }


    /**
     * @author Zhou Linsheng
     * @param b
     * @return Island Majority Scores
     */
    // Task 11 C
    public static int[] calculateIslandMajoritiesScore(Board b) {
        //Point array of this sub calculation
        int[] playerPoints = new int[b.getPlayerNum()];
        //Occupiers of a certain island
        int[] occupiers = new int[b.getPlayerNum()];
        for (int i = 0; i <= b.getIslandNum() - 1; i++) {
            for (int g = 0; g <= b.getPlayerNum() - 1; g++) {
                occupiers[g] = 0;
            }
            for (int j = 0; j <= b.getSize() - 1; j++) {
                for (int k = 0; k <= b.getSize() - 1; k++) {
                    //If this spot is not sea and occupied by a player
                    if (b.getBoard()[j][k] != null && b.getBoard()[j][k].island == i && b.getBoard()[j][k].occupiedByPlayer != 100) {
                        occupiers[b.getBoard()[j][k].occupiedByPlayer]++;
                    }
                }
            }
            //We suppose only 2 players on the board because it's easy to compare
            if (b.getPlayerNum() == 2) {
                if (occupiers[0] == 0 && occupiers[1] == 0) {
                    continue;
                }
            } else if (b.getPlayerNum() == 3) {
                if (occupiers[0] == 0 && occupiers[1] == 0 && occupiers[2] == 0) {
                    continue;
                }
            } else {
                if (occupiers[0] == 0 && occupiers[1] == 0 && occupiers[2] == 0 && occupiers[3] == 0) {
                    continue;
                }
            }
            int max = Arrays.stream(occupiers).max().getAsInt();
            int maxNum = 0;
            boolean[] maxPlayers = new boolean[b.getPlayerNum()];
            for (int y = 0; y <= maxPlayers.length - 1; y++) {
                if (occupiers[y] == max) {
                    maxPlayers[y] = true;
                    maxNum++;
                }
            }
            for (int y = 0; y <= maxPlayers.length - 1; y++) {
                if (maxPlayers[y]) {
                    playerPoints[y] += b.getWeight()[i] / maxNum;
                }
            }
        }
        //Return point array of majority criteria
        return playerPoints;
    }

    /**
     * @author Zhou Linsheng
     * @param b
     * @return Items Scores
     */
    //Task 11 D
    public static int[] calculateResourcesAndStatuettesScore(Board b) {
        int[] points = new int[b.getPlayerNum()];
        for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
            int p = 0;
            //Calculate points of these resources
            if (b.getPlayers()[i].getCoconut() >= 4) {
                p += 20;
            } else if (b.getPlayers()[i].getCoconut() == 3) {
                p += 10;
            } else if (b.getPlayers()[i].getCoconut() == 2) {
                p += 5;
            } else {
                p += 0;
            }
            if (b.getPlayers()[i].getWater() >= 4) {
                p += 20;
            } else if (b.getPlayers()[i].getWater() == 3) {
                p += 10;
            } else if (b.getPlayers()[i].getWater() == 2) {
                p += 5;
            } else {
                p += 0;
            }
            if (b.getPlayers()[i].getStone() >= 4) {
                p += 20;
            } else if (b.getPlayers()[i].getStone() == 3) {
                p += 10;
            } else if (b.getPlayers()[i].getStone() == 2) {
                p += 5;
            } else {
                p += 0;
            }
            if (b.getPlayers()[i].getBamboo() >= 4) {
                p += 20;
            } else if (b.getPlayers()[i].getBamboo() == 3) {
                p += 10;
            } else if (b.getPlayers()[i].getBamboo() == 2) {
                p += 5;
            } else {
                p += 0;
            }
            p += 4 * b.getPlayers()[i].getStatuette();
            if (b.getPlayers()[i].getBamboo() > 0 && b.getPlayers()[i].getCoconut() > 0 && b.getPlayers()[i].getWater() > 0 && b.getPlayers()[i].getStone() > 0) {
                p += 10;
            }
            points[i] = p;
        }
        return points;
    }

    /**
     * @author Zhou Linsheng
     * @param b
     * @return All scores are added up
     */
    //Task 11 E
    public static int[] calculateScores(Board b) {
        //Points array of scores
        int[] scores = new int[b.getPlayerNum()];
        int[] majority = calculateIslandMajoritiesScore(b);
        int[] link = calculateIslandLinksScore(b);
        int[] resources = calculateResourcesAndStatuettesScore(b);
        int[] islands = calculateTotalIslandsScore(b);

        //Add current`points to this player
        for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
            scores[i] += majority[i] + link[i] + resources[i] + islands[i];
        }
        return scores;
    }
}