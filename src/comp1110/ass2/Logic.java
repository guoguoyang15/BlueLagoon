package comp1110.ass2;

import java.util.*;

/**
 * @author Zhou Linsheng
 */
public class Logic {
    //Task 3
    public static boolean isStateStringWellFormed1(String stateString) {
        // Written by Tyler and edited by Zhining
        String[] parts = stateString.split(";");
        // Separate strings into arrays of strings with the split function, using ";"
        if (parts[0].matches("a\\s[0-9]*[1-9][0-9]*\\s[1-9]")) {
            // Check if the game arrangement declaration is correct by means of regular expressions
            if (parts[1].matches("\\sc\\s\\d\\s[E|S]")) {
                for (int i = 2; i < parts.length; i++) {
                    // Iterate through the array to check if it is correct
                    if (parts[i].startsWith(" i")) {
                        if (parts[i].matches("\\si\\s[0-9]*[1-9][0-9]*\\s(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})")) {
                        } else {
                            return false;
                        }
                    }
                    // Checks if Stones Statement is formatted correctly.
                    else if (parts[i].startsWith(" s")) {
                        if (parts[i].matches("\\ss\\s(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})")) {
                        } else {
                            return false;
                        }
                    }
                    // Checks if Unclaimed Resources and Statuettes Statement is formatted correctly.
                    else if (parts[i].startsWith(" r")) {
                        if (parts[i].matches("\\sr\\sC\\s(\\d{1,2},\\d{1,2}\\s)*B\\s(\\d{1,2},\\d{1,2}\\s)*W\\s(\\d{1,2},\\d{1,2}\\s)*P\\s(\\d{1,2},\\d{1,2}\\s)*S(\\s)??(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})*")) {
                        } else {
                            return false;
                        }
                    }
                    // Checks if Player Statement is formatted correctly.
                    else if (parts[i].startsWith(" p")) {
                        if (parts[i].matches("\\sp\\s\\d\\s\\d{1,3}\\s(\\d\\s){5}S\\s(\\d{1,2},\\d{1,2}\\s)*T(\\s)??(\\d{1,2},\\d{1,2}\\s)*(\\d{1,2},\\d{1,2})*")) {
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                // Returns false if any errors are detected.
                return (stateString.endsWith(";"));
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //Task 4
    public static boolean isMoveStringWellFormed1(String moveString) {
        // Written by Tyler
        // Checks if Move string is properly formatted
        return moveString.matches("[S|T]\s\\d{1,2},\\d{1,2}");
    }

    //Task 6
    public static String distributeResources1(String stateString) {
        //add a space at front to make sure that for every statement, the second char of the substring is the type of statement
        //stateString = " " + stateString;
        String[] statement = stateString.split(";");
        String target = null;
        for (int i = 0; i < statement.length - 1; i++) {
            if (statement[i].startsWith(" s")) {
                target = statement[i];
                break;
            }
        }
        //First use target to intercept a string starting with s
        target = target.replace(" s ", "");
        //Cut out the extraneous characters at the beginning
        String[] stoneCircle = target.split(" ");
        //Separating out sequential characters in a string
        String[] random = new String[32];
        //Also set up a new array of strings
        Random r = new Random();
        int[] a = new int[32];
        int rand;
        for (int i = 0; i < 32; i++) {
            do {
                rand = r.nextInt(32);
                if (a[rand] == 0) {
                    a[rand] = i;
                    break;
                }
            } while (true);
        }
        for (int i = 0; i < 32; i++) {
            random[i] = stoneCircle[a[i]];
        }
        // Randomize an array from 0 to 31 and record the new data into a new string
        String C = random[0] + " " + random[1] + " " + random[2] + " " + random[3] + " " + random[4] + " " + random[5] + " ";
        String B = random[6] + " " + random[7] + " " + random[8] + " " + random[9] + " " + random[10] + " " + random[11] + " ";
        String W = random[12] + " " + random[13] + " " + random[14] + " " + random[15] + " " + random[16] + " " + random[17] + " ";
        String P = random[18] + " " + random[19] + " " + random[20] + " " + random[21] + " " + random[22] + " " + random[23] + " ";
        String S = random[24] + " " + random[25] + " " + random[26] + " " + random[27] + " " + random[28] + " " + random[29] + " " + random[30] + " " + random[31];
        //Start with a string representation of the individual resources
        String replaceString = " r C " + C + "B " + B + "W " + W + "P " + P + "S " + S;
        //Direct string addition, first with a separate string resource declaration

        for (int i = 0; i < statement.length; i++) {
            if (statement[i].startsWith(" r")) {
                stateString = stateString.replace(statement[i], replaceString);
            }
        }

        return stateString;
    }

    public static boolean isPosInIndex(int size, int x, int y) {
        if (x < 0 || x >= size) {
            return false;
        } else {
            if (x % 2 == 0) {
                if (y < 0 || y > size - 2)
                    return false;
            } else {
                if (y < 0 || y > size - 1)
                    return false;
            }
        }
        return true;
    }

    //Task 7
    public static boolean isMoveValid1(Board b, char type, Coordinate coordinate) {
        if (b.isPhase()) {//In exploration phase
            if (type == 'S') {
                if (b.getSettlerLimit() <= b.getPlayers()[b.getTurn()].getSettlers()) {
                    return false;
                }
            } else {
                if (b.getVillageLimit() <= b.getPlayers()[b.getTurn()].getVillages()) {
                    return false;
                }
            }
        } else {//In settlement phase
            if (type == 'S') {
                if (b.getSettlerLimit() <= b.getPlayers()[b.getTurn()].getSettlers()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        //whether the coordinate is out of the board
        if (!isPosInIndex(b.getSize(), coordinate.x, coordinate.y)) {
            return false;
        }

        if (b.isPhase()) {
            if (b.getBoard()[coordinate.x][coordinate.y].spotType == 0)
                return type == 'S' && b.getBoard()[coordinate.x][coordinate.y].occupiedByPlayer == 100;
        }
        if (b.getBoard()[coordinate.x][coordinate.y].occupiedByPlayer != 100) {
            return false;
        } else {
            if (coordinate.x % 2 == 0) {
                if ((coordinate.x - 1) >= 0 && (coordinate.y + 1) <= b.getSize() - 1 && b.getBoard()[coordinate.x - 1][coordinate.y + 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((coordinate.x + 1) <= b.getSize() - 1 && (coordinate.y + 1) <= b.getSize() - 1 && b.getBoard()[coordinate.x + 1][coordinate.y + 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((coordinate.y - 1) >= 0 && b.getBoard()[coordinate.x][coordinate.y - 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((coordinate.x - 1) >= 0 && b.getBoard()[coordinate.x - 1][coordinate.y].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((coordinate.x + 1) <= b.getSize() - 1 && b.getBoard()[coordinate.x + 1][coordinate.y].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((coordinate.y + 1) <= b.getSize() - 2 && b.getBoard()[coordinate.x][coordinate.y + 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                return false;
            } else {
                if ((coordinate.x - 1) >= 0 && (coordinate.y - 1) >= 0 && b.getBoard()[coordinate.x - 1][coordinate.y - 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((coordinate.x + 1) <= b.getSize() - 1 && (coordinate.y - 1) >= 0 && b.getBoard()[coordinate.x + 1][coordinate.y - 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((coordinate.y - 1) >= 0 && b.getBoard()[coordinate.x][coordinate.y - 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((coordinate.x - 1) >= 0 && coordinate.y != b.getSize() - 1 && b.getBoard()[coordinate.x - 1][coordinate.y].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((coordinate.x + 1) <= b.getSize() - 1 && coordinate.y != b.getSize() - 1 && b.getBoard()[coordinate.x + 1][coordinate.y].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((coordinate.y + 1) <= b.getSize() - 1 && b.getBoard()[coordinate.x][coordinate.y + 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                return false;
            }
        }
    }

    //Task 8
    public static Set<String> generateAllValidMoves1(Board b) {
        Set<String> stringSet = new HashSet<String>();//Create a new empty HashSet of movestrings
        boolean firstStep = b.getPlayers()[b.getTurn()].getSettlers() == 0 && b.getPlayers()[b.getTurn()].getVillages() == 0;
        boolean canMoveSettler = false;//if this player can move settlers in this phase
        boolean canMoveVillage = false;//if this player can move villages in this phase+
        if (b.isPhase()) {//in phase 1
            if (b.getPlayers()[b.getTurn()].getSettlers() < b.getSettlerLimit()) {
                canMoveSettler = true;
            }
            if (b.getPlayers()[b.getTurn()].getVillages() < b.getVillageLimit()) {
                canMoveVillage = true;
            }
        } else {//in phase 2
            if (b.getPlayers()[b.getTurn()].getSettlers() < b.getSettlerLimit()) {
                canMoveSettler = true;
            }
            canMoveVillage = false;
        }
        if (b.isPhase() == false || !firstStep) {
            if (b.isPhase()) {
                for (int i = 0; i <= b.getSize() - 1; i++) {
                    for (int j = 0; j <= b.getSize() - 1; j++) {
                        if (isPosInIndex(b.getSize(), i, j)) {
                            if (b.getBoard()[i][j].spotType == 0 && b.getBoard()[i][j].occupiedByPlayer == 100) //This sea spot isn't occupied by any player
                                if (canMoveSettler)
                                    stringSet.add("S " + i + "," + j);
                            if (b.getBoard()[i][j].spotType != 1 || b.getBoard()[i][j].occupiedByPlayer != 100)
                                continue;
                            if (i % 2 != 1) {
                                if (isPosInIndex(b.getSize(), i - 1, j + 1) && b.getBoard()[i - 1][j + 1].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                                if (isPosInIndex(b.getSize(), i + 1, j + 1) && b.getBoard()[i + 1][j + 1].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                                if (isPosInIndex(b.getSize(), i, j - 1) && b.getBoard()[i][j - 1].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                                if (isPosInIndex(b.getSize(), i - 1, j) && b.getBoard()[i - 1][j].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                                if (isPosInIndex(b.getSize(), i + 1, j) && b.getBoard()[i + 1][j].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                                if (isPosInIndex(b.getSize(), i, j + 1) && b.getBoard()[i][j + 1].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                            } else {
                                if (isPosInIndex(b.getSize(), i - 1, j - 1) && b.getBoard()[i - 1][j - 1].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                                if (isPosInIndex(b.getSize(), i + 1, j - 1) && b.getBoard()[i + 1][j - 1].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                                if (isPosInIndex(b.getSize(), i, j - 1) && b.getBoard()[i][j - 1].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                                if (isPosInIndex(b.getSize(), i - 1, j) && b.getBoard()[i - 1][j].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                                if (isPosInIndex(b.getSize(), i + 1, j) && b.getBoard()[i + 1][j].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                                if (isPosInIndex(b.getSize(), i, j + 1) && b.getBoard()[i][j + 1].occupiedByPlayer == b.getTurn()) {
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                    if (canMoveVillage)
                                        stringSet.add("T " + i + "," + j);
                                }
                            }
                        }
                    }
                }
            } else {
                for (int i = 0; i <= b.getSize() - 1; i++) {
                    for (int j = 0; j <= b.getSize() - 1; j++) {
                        if (isPosInIndex(b.getSize(), i, j)) if (b.getBoard()[i][j].occupiedByPlayer == 100) {
                            if (i % 2 == 1) {
                                if (isPosInIndex(b.getSize(), i - 1, j - 1) && b.getBoard()[i - 1][j - 1].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                if (isPosInIndex(b.getSize(), i + 1, j - 1) && b.getBoard()[i + 1][j - 1].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                if (isPosInIndex(b.getSize(), i, j - 1) && b.getBoard()[i][j - 1].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                if (isPosInIndex(b.getSize(), i - 1, j) && b.getBoard()[i - 1][j].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                if (isPosInIndex(b.getSize(), i + 1, j) && b.getBoard()[i + 1][j].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                if (isPosInIndex(b.getSize(), i, j + 1) && b.getBoard()[i][j + 1].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                            } else {
                                if (isPosInIndex(b.getSize(), i - 1, j + 1) && b.getBoard()[i - 1][j + 1].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                if (isPosInIndex(b.getSize(), i + 1, j + 1) && b.getBoard()[i + 1][j + 1].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                if (isPosInIndex(b.getSize(), i, j - 1) && b.getBoard()[i][j - 1].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                if (isPosInIndex(b.getSize(), i - 1, j) && b.getBoard()[i - 1][j].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                if (isPosInIndex(b.getSize(), i + 1, j) && b.getBoard()[i + 1][j].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                                if (isPosInIndex(b.getSize(), i, j + 1) && b.getBoard()[i][j + 1].occupiedByPlayer == b.getTurn())
                                    if (canMoveSettler)
                                        stringSet.add("S " + i + "," + j);
                            }
                        }
                    }
                }
            }
            return stringSet;
            // FIXME Task 8
        } else {
            for (int i = 0; i <= b.getSize() - 1; i++)
                for (int j = 0; j <= b.getSize() - 1; j++)
                    if (isPosInIndex(b.getSize(), i, j))
                        if (b.getBoard()[i][j].spotType == 0 && b.getBoard()[i][j].occupiedByPlayer == 100) //This sea spot isn't occupied by any player
                            stringSet.add("S " + i + "," + j);
            return stringSet;
        }
    }

    //Task 9
    public static boolean isPhaseOver1(Board b) {
        //Count the number of resources collected by all players
        int allResources = 0;
        for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
            allResources += b.getPlayers()[i].getBamboo() + b.getPlayers()[i].getCoconut() + b.getPlayers()[i].getWater() + b.getPlayers()[i].getStone();
        }
        boolean collectedAll = allResources == 24;
        int noMoves = 0;
        for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
            b.setTurn(i);
            if (generateAllValidMoves1(b).size() == 0) {
                noMoves++;
            }
        }
        return collectedAll || noMoves == b.getPlayerNum();
    }

    //Zhou Linsheng(u7630421) completes the following function to sort positions in state string
    public static boolean comparePos(String pos1, String pos2) {
        String[] posString1 = pos1.split(",");
        String[] posString2 = pos2.split(",");
        int x1 = Integer.parseInt(posString1[0]);
        int y1 = Integer.parseInt(posString1[1]);
        int x2 = Integer.parseInt(posString2[0]);
        int y2 = Integer.parseInt(posString2[1]);
        if (x1 > x2) {
            return true;
        } else if (x1 < x2) {
            return false;
        } else {
            return y1 > y2;
        }
    }

    //Task 11 A
    public static int[] calculateTotalIslandsScore1(Board b) {
        //Array of points in this part
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
            //number of islands not occupied by this player
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

    //Zhou Linsheng(u7630421) adds ifAdjacent to examine if two spots next to each other
    //ifAdjacent is to judge if the two coordinates are next to each other
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

    //Task 11 B
    public static int[] calculateIslandLinksScore1(Board b) {
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
                        List<Coordinate> adj = getAdjacentSpots(g, posList);
                        posStack.addAll(adj);
                        posList.removeAll(adj);
                    }
                    linkSet.add(component);
                }

                //Now we know all possible links of the player in linkSet
                int maxIsland = 0;
                for (List<Coordinate> link : linkSet) {
                    //A boolean array marking which islands occupied by this link
                    int[] islandOccupied = new int[b.getIslandNum()];
                    //if a node occupies No.i island
                    for (Coordinate cord : link) {
                        //if a node occupies No.i island
                        if (b.getBoard()[cord.x][cord.y].island != 100) {
                            islandOccupied[b.getBoard()[cord.x][cord.y].island]++;
                        }
                    }
                    //Number of islands this link occupies
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
                //In the end of a player calculation, clear spots set to empty set
                posList.clear();
            }
        }
        return points;
    }

    //Zhou Linsheng added this function to return a list of all adjacent position of a player given a certain spot
    public static List<Coordinate> getAdjacentSpots(Coordinate cord, List<Coordinate> listSet) {
        List<Coordinate> adj = new ArrayList<>();
        for (Coordinate cc : listSet) {
            if (ifAdjacent(cord.x, cord.y, cc.x, cc.y)) {
                adj.add(cc);
            }
        }
        return adj;
    }

    //Task 11 C
    public static int[] calculateIslandMajoritiesScore1(Board b) {
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

    //Task 11 D
    public static int[] calculateResourcesAndStatuettesScore1(Board b) {
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

    //Task 11 E
    public static int[] calculateScores1(Board b) {
        //Points array of scores
        int[] scores = new int[b.getPlayerNum()];
        int[] majority = calculateIslandMajoritiesScore1(b);
        int[] link = calculateIslandLinksScore1(b);
        int[] resources = calculateResourcesAndStatuettesScore1(b);
        int[] islands = calculateTotalIslandsScore1(b);

        //Add current`points to this player
        for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
            scores[i] += majority[i] + link[i] + resources[i] + islands[i];
        }
        return scores;
    }

    //Task 12
    public static String endPhase1(Board b) {
        if (b.isPhase()) {
            b.setPhase(false);
            //Calculate current points of players
            int[] points = calculateScores1(b);
            for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
                b.getPlayers()[i].setScore(b.getPlayers()[i].getScore() + points[i]);
                b.getPlayers()[i].setCoconut(0);
                b.getPlayers()[i].setBamboo(0);
                b.getPlayers()[i].setWater(0);
                b.getPlayers()[i].setStone(0);
                b.getPlayers()[i].setStatuette(0);
            }
            for (int j = 0; j <= b.getSize() - 1; j++) {
                for (int k = 0; k <= b.getSize() - 1; k++) {
                    if (b.getBoard()[j][k] != null) {
                        if (b.getBoard()[j][k].occupiedByPlayer != 100) {
                            if (b.getBoard()[j][k].settlerOrVillage == Spot.SettlerOrVillage.SETTLER) {
                                b.getBoard()[j][k].occupiedByPlayer = 100;
                                b.getBoard()[j][k].settlerOrVillage = Spot.SettlerOrVillage.NULL;
                            }
                            if (b.getBoard()[j][k].settlerOrVillage == Spot.SettlerOrVillage.VILLAGE && b.getBoard()[j][k].circle) {
                                b.getBoard()[j][k].occupiedByPlayer = 100;
                                b.getBoard()[j][k].settlerOrVillage = Spot.SettlerOrVillage.NULL;
                            }
                        }
                    }
                }
            }
            String s = b.toString();
            return distributeResources1(s);

        } else {
            //Calculate current points of players
            int[] points = calculateScores1(b);
            for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
                b.getPlayers()[i].setScore(b.getPlayers()[i].getScore() + points[i]);
            }
        }
        return b.toString();
    }

    //Task 13
    public static String applyMove(Board b, char type, Coordinate coordinate) {
        int turn = b.getTurn();
        String s = placePiece1(b, type, coordinate);
        b = new Board(s);
        if (isPhaseOver1(b)) {
            String newphase=endPhase1(b);
            b=new Board(newphase);
        }
        for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
            b.setTurn((turn + 1 + i) % b.getPlayerNum());
            if (generateAllValidMoves1(b).size() >= 1) {
                break;
            }
        }
        return b.toString();
    }

    //Task 10
    public static String placePiece1(Board b, char type, Coordinate coordinate) {
        //Change occupier
        b.getBoard()[coordinate.x][coordinate.y].occupiedByPlayer = b.getTurn();
        //Change settler or village
        if (type == 'S') {
            b.getBoard()[coordinate.x][coordinate.y].settlerOrVillage = Spot.SettlerOrVillage.SETTLER;
        } else {
            b.getBoard()[coordinate.x][coordinate.y].settlerOrVillage = Spot.SettlerOrVillage.VILLAGE;
        }
        if (b.getBoard()[coordinate.x][coordinate.y].resources != Resource.NULL) {
            if (b.getBoard()[coordinate.x][coordinate.y].resources == Resource.COCONUT) {
                int n = b.getPlayers()[b.getTurn()].getCoconut();
                b.getPlayers()[b.getTurn()].setCoconut(n + 1);
            } else if (b.getBoard()[coordinate.x][coordinate.y].resources == Resource.BAMBOO) {
                int n = b.getPlayers()[b.getTurn()].getBamboo();
                b.getPlayers()[b.getTurn()].setBamboo(n + 1);
            } else if (b.getBoard()[coordinate.x][coordinate.y].resources == Resource.WATER) {
                int n = b.getPlayers()[b.getTurn()].getWater();
                b.getPlayers()[b.getTurn()].setWater(n + 1);
            } else if (b.getBoard()[coordinate.x][coordinate.y].resources == Resource.PRECIOUSSTONE) {
                int n = b.getPlayers()[b.getTurn()].getStone();
                b.getPlayers()[b.getTurn()].setStone(n + 1);
            } else if (b.getBoard()[coordinate.x][coordinate.y].resources == Resource.STATUETTE) {
                int n = b.getPlayers()[b.getTurn()].getStatuette();
                b.getPlayers()[b.getTurn()].setStatuette(n + 1);
            } else {
            }
            b.getBoard()[coordinate.x][coordinate.y].resources = Resource.NULL;
        }
        return b.toString();
    }
    //Task 16
    public static String generateAIMove1 (Board b){
        Set<String> potentialMoves=generateAllValidMoves1(b);
        List<Coordinate> movesList=new ArrayList<>();
        for(String s:potentialMoves){
            String[] sp=s.split(" ");
            String[] xy=sp[1].split(",");
            int x=Integer.parseInt(xy[0]);
            int y=Integer.parseInt(xy[1]);
            Coordinate c=new Coordinate(x,y);
            movesList.add(c);
        }
        //we need an iterator to check all possible move spot in generalAllPossibleMoves Set
        for(Coordinate c:movesList){
            for(int i=0;i<=b.getSize()-1;i++){
                for(int j=0;j<=b.getSize()-1;j++){
                    if(i%2!=0||j!=b.getSize()-1){
                        //If there is a resource spot on this spot , then AI should move a settler there
                        if(b.getBoard()[c.x][c.y].resources!=Resource.NULL&&b.getPlayers()[b.getTurn()].getSettlers()<b.getSettlerLimit()){
                            //Don't move a village on a stone circle
                            return "S "+c.x+","+c.y;
                        }
                    }
                }
            }
        }
        //if all possible moves don't occupy a resource spot, then randomly allocate one
        Random r = new Random();
        int n = r.nextInt(potentialMoves.size());
        List<String> stringList = new ArrayList<>();
        for (String move : generateAllValidMoves1(b)) {
            stringList.add(move);
        }
        return stringList.get(n);

    }

}