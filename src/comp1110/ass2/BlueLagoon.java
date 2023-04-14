package comp1110.ass2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class BlueLagoon {
    // The Game Strings for five maps have been created for you.
    // They have only been encoded for two players. However, they are
    // easily extendable to more by adding additional player statements.
    public static final String DEFAULT_GAME = "a 13 2; c 0 E; i 6 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 1,4 2,0 2,1; i 6 0,5 0,6 0,7 1,6 1,7 1,8 2,6 2,7 2,8 3,7 3,8; i 6 7,12 8,11 9,11 9,12 10,10 10,11 11,10 11,11 11,12 12,10 12,11; i 8 0,9 0,10 0,11 1,10 1,11 1,12 2,10 2,11 3,10 3,11 3,12 4,10 4,11 5,11 5,12; i 8 4,0 5,0 5,1 6,0 6,1 7,0 7,1 7,2 8,0 8,1 8,2 9,0 9,1 9,2; i 8 10,3 10,4 11,0 11,1 11,2 11,3 11,4 11,5 12,0 12,1 12,2 12,3 12,4 12,5; i 10 3,3 3,4 3,5 4,2 4,3 4,4 4,5 5,3 5,4 5,5 5,6 6,3 6,4 6,5 6,6 7,4 7,5 7,6 8,4 8,5; i 10 5,8 5,9 6,8 6,9 7,8 7,9 7,10 8,7 8,8 8,9 9,7 9,8 9,9 10,6 10,7 10,8 11,7 11,8 12,7 12,8; s 0,0 0,5 0,9 1,4 1,8 1,12 2,1 3,5 3,7 3,10 3,12 4,0 4,2 5,9 5,11 6,3 6,6 7,0 7,8 7,12 8,2 8,5 9,0 9,9 10,3 10,6 10,10 11,0 11,5 12,2 12,8 12,11; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T;";
    public static final String WHEELS_GAME = "a 13 2; c 0 E; i 5 0,1 0,2 0,3 0,4 1,1 1,5 2,0 2,5 3,0 3,6 4,0 4,5 5,1 5,5 6,1 6,2 6,3 6,4; i 5 0,8 0,9 0,10 1,8 1,11 2,7 2,11 3,8 3,11 4,8 4,9 4,10; i 7 8,8 8,9 8,10 9,8 9,11 10,7 10,11 11,8 11,11 12,8 12,9 12,10; i 7 10,0 10,1 10,4 10,5 11,0 11,2 11,3 11,4 11,6 12,0 12,1 12,4 12,5; i 9 2,2 2,3 3,2 3,4 4,2 4,3; i 9 2,9; i 9 6,6 6,7 6,8 6,9 6,10 6,11 7,6 8,0 8,1 8,2 8,3 8,4 8,5; i 9 10,9; s 0,1 0,4 0,10 2,2 2,3 2,9 2,11 3,0 3,2 3,4 3,6 4,2 4,3 4,10 6,1 6,4 6,6 6,11 8,0 8,5 8,8 8,10 10,0 10,5 10,7 10,9 10,11 11,3 12,1 12,4 12,8 12,10; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T;";
    public static final String FACE_GAME = "a 13 2; c 0 E; i 6 0,0 0,1 0,2 0,3 0,4 0,5 0,6 0,7 0,8 0,9 0,10 0,11 1,0 1,12 2,0 2,11 3,0 3,12 4,0 4,11 5,0 5,12 6,0 6,11 7,0 7,12 8,0 8,11 9,0 9,12 10,0 10,11 11,0 11,12 12,0 12,1 12,2 12,3 12,4 12,5 12,6 12,7 12,8 12,9 12,10 12,11; i 6 2,4 2,5 2,6 2,7; i 9 4,4 4,5 4,6 4,7; i 9 6,5 6,6 7,5 7,7 8,5 8,6; i 12 2,2 3,2 3,3 4,2 5,2 5,3 6,2 7,2 7,3; i 12 2,9 3,9 3,10 4,9 5,9 5,10 6,9 7,9 7,10; i 12 9,2 9,10 10,2 10,3 10,4 10,5 10,6 10,7 10,8 10,9; s 0,3 0,8 1,0 1,12 2,2 2,4 2,7 2,9 4,2 4,5 4,6 4,9 5,0 5,12 6,2 6,5 6,6 6,9 8,0 8,5 8,6 8,11 9,2 9,10 10,3 10,5 10,6 10,8 11,0 11,12 12,4 12,7; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T;";
    public static final String SIDES_GAME = "a 7 2; c 0 E; i 4 0,0 0,1 0,2 0,3 1,0 1,1 1,2 1,3 2,0 2,1 2,2 2,3 3,0 3,1 3,2 3,3 4,0 4,1 4,2 4,3 5,0 5,1 5,2 5,3 6,0 6,1 6,2 6,3; i 20 0,5 1,5 1,6 2,5 3,5 3,6 4,5 5,5 5,6 6,5; s 0,0 0,1 0,2 0,3 1,1 1,2 1,3 1,5 1,6 2,0 2,1 2,2 2,3 3,0 3,1 3,2 3,3 3,5 3,6 4,0 4,1 4,2 4,3 5,1 5,2 5,3 5,5 5,6 6,0 6,1 6,2 6,3; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T;";
    public static final String SPACE_INVADERS_GAME = "a 23 2; c 0 E; i 6 0,2 0,7 1,3 1,7 2,2 2,3 2,4 2,5 2,6 2,7 3,2 3,4 3,5 3,6 3,8 4,0 4,1 4,2 4,3 4,4 4,5 4,6 4,7 4,8 4,9 5,0 5,1 5,3 5,4 5,5 5,6 5,7 5,9 5,10 6,0 6,2 6,7 6,9 7,3 7,4 7,6 7,7; i 6 0,14 0,19 1,15 1,19 2,14 2,15 2,16 2,17 2,18 2,19 3,14 3,16 3,17 3,18 3,20 4,12 4,13 4,14 4,15 4,16 4,17 4,18 4,19 4,20 4,21 5,12 5,13 5,15 5,16 5,17 5,18 5,19 5,21 5,22 6,12 6,14 6,19 6,21 7,15 7,16 7,18 7,19; i 6 17,9 18,8 18,9 19,6 19,7 19,8 19,9 19,10 19,11 19,12 20,5 20,6 20,7 20,8 20,9 20,10 20,11 20,12 21,5 21,6 21,7 21,8 21,9 21,10 21,11 21,12 21,13 22,5 22,6 22,7 22,8 22,9 22,10 22,11 22,12; i 8 12,3 12,5 13,3 13,4 13,5 13,6 14,1 14,2 14,3 14,4 14,5 15,1 15,2 15,3 16,1 16,2; i 8 12,17 12,18 12,19 13,17 13,18 13,19 13,20 14,17 14,18 14,19 14,20 15,19 15,20 15,21 16,19 16,20; i 8 13,14 14,13 14,14 15,13 15,14 15,15 16,13 16,14; i 8 14,7 15,7 15,8 16,7; i 10 8,9 9,9 10,9 11,9; i 10 8,12 9,13 10,12 11,13; i 10 9,1 10,1 11,1 12,1; i 10 9,22 10,21 11,22 12,21; i 10 13,10 14,10 15,10; i 10 17,0 18,0 19,0 20,0; i 10 17,16 18,16 19,16 20,16; s 0,2 0,7 0,14 0,19 3,5 3,17 6,0 6,9 6,12 6,21 7,4 7,6 7,16 7,18 11,9 11,13 12,1 12,19 12,21 13,10 15,2 15,8 15,14 15,20 17,9 18,8 18,9 20,0 20,16 21,6 21,9 21,12; r C B W P S; p 0 0 0 0 0 0 0 S T; p 1 0 0 0 0 0 0 S T;";

    /**
     * Check if the string encoding of the game state is well-formed.
     * Note that this does not mean checking that the state is valid
     * (represents a state that players could reach in game play),
     * only that the string representation is syntactically well-formed.
     * <p>
     * A description of the state string will be included in README.md
     * in an update of the project after D2B is complete.
     *
     * @param moveString a string representing a game state
     * @return true if stateString is well-formed and false otherwise
     */

    public static boolean isStateStringWellFormed(String stateString) {
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
                    }
                    else {
                        return false;
                    }
                }
                // Returns false if any errors are detected.
                return (stateString.endsWith(";"));
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }

    }

    /**
     * Check if the string encoding of the move is syntactically well-formed.
     * <p>
     * A description of the move string will be included in README.md
     * in an update of the project after D2B is complete.
     *
     * @param moveString a string representing a player's move
     * @return true if moveString is well-formed and false otherwise
     */

    public static boolean isMoveStringWellFormed(String moveString) {
        // Checks if Move string is properly formatted
        if (moveString.matches("[S|T]\s\\d{1,2},\\d{1,2}")) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Given a state string which is yet to have resources distributed amongst the stone circles,
     * randomly distribute the resources and statuettes between all the stone circles.
     * <p>
     * There will always be exactly 32 stone circles.
     * <p>
     * The resources and statuettes to be distributed are:
     * - 6 coconuts
     * - 6 bamboo
     * - 6 water
     * - 6 precious stones
     * - 8 statuettes
     * <p>
     * The distribution must be random.
     *
     * @param stateString a string representing a game state without resources distributed
     * @return a string of the game state with resources randomly distributed
     */

    public static String distributeResources(String stateString) {
        //add a space at front to make shre that for every statement, the second char of the substring is the type of statement
        stateString = " " + stateString;
        String[] statement = stateString.split(";");
        //store the index of stonecirlce statement
        int stoneCircle = 0;
        //store the index of resource statement
        int resource = 0;
        //search for the index of two statements
        for (int i = 0; i <= statement.length - 1; i++) {
            if (statement[i].charAt(1) == 's') {
                stoneCircle = i;
            }
            if (statement[i].charAt(1) == 'r') {
                resource = i;
            }
        }

        //store the coordinates of 32 stonecircles
        Coordinate[] coordinate = new Coordinate[32];
        String[] stoneCoorString = statement[stoneCircle].split(" ");
        int x;
        int y;
        for (int i = 0; i <= 31; i++) {
            String[] xy = stoneCoorString[i + 2].split(",");//stoneCoorString[0]="" and stoneCoorString[1]="s"
            x = Integer.parseInt(xy[0]);
            y = Integer.parseInt(xy[1]);
            coordinate[i] = new Coordinate(x, y);
        }
        //coordinates of resources
        Coordinate[] bamboo = new Coordinate[6];
        Coordinate[] coconut = new Coordinate[6];
        Coordinate[] water = new Coordinate[6];
        Coordinate[] preciousStone = new Coordinate[6];
        Coordinate[] statuette = new Coordinate[8];
        //numbers of resources allocated
        int b = 0;
        int c = 0;
        int w = 0;
        int p = 0;
        int s = 0;
        //index is the total number of resources allocated
        int index = 0;
        Random random = new Random();
        //store the coordinates of stonecircles which have been occupied, true for occupation
        int[] flag = new int[32];
        while (index <= 31) {
            int i = random.nextInt(16);
            if (i == 0 || i == 1 || i == 2) {
                if (b <= 5) {
                    int r = random.nextInt(32);
                    //if true and occupied, then search for another position which have yet been occupied. When false(not occupied), exit loop
                    while (flag[r] == 1) {
                        r = random.nextInt(32);
                    }
                    bamboo[b] = coordinate[r];
                    b++;
                    index++;
                    //set the coordinate of this stonecircle as occupied
                    flag[r] = 1;
                }
            } else if (i == 3 || i == 4 || i == 5) {
                if (c <= 5) {
                    int r = random.nextInt(32);
                    while (flag[r] == 1) {
                        r = random.nextInt(32);
                    }
                    coconut[c] = coordinate[r];
                    c++;
                    index++;
                    flag[r] = 1;
                }
            } else if (i == 6 || i == 7 || i == 8) {
                if (w <= 5) {
                    int r = random.nextInt(32);
                    while (flag[r] == 1) {
                        r = random.nextInt(32);
                    }
                    water[w] = coordinate[r];
                    w++;
                    index++;
                    flag[r] = 1;
                }
            } else if (i == 9 || i == 10 || i == 11) {
                if (p <= 5) {
                    int r = random.nextInt(32);
                    while (flag[r] == 1) {
                        r = random.nextInt(32);
                    }
                    preciousStone[p] = coordinate[r];
                    p++;
                    index++;
                    flag[r] = 1;
                }
            } else {
                if (s <= 7) {
                    int r = random.nextInt(32);
                    while (flag[r] == 1) {
                        r = random.nextInt(32);
                    }
                    statuette[s] = coordinate[r];
                    s++;
                    index++;
                    flag[r] = 1;
                }
            }
        }
        //create a new statement of resources
        statement[resource] = " r";
        statement[resource] += " " + "C";
        for (int j = 0; j <= 5; j++) {
            statement[resource] += " " + coconut[j].x + "," + coconut[j].y;
        }
        statement[resource] += " " + "B";
        for (int j = 0; j <= 5; j++) {
            statement[resource] += " " + bamboo[j].x + "," + bamboo[j].y;
        }
        statement[resource] += " " + "W";
        for (int j = 0; j <= 5; j++) {
            statement[resource] += " " + water[j].x + "," + water[j].y;
        }
        statement[resource] += " " + "P";
        for (int j = 0; j <= 5; j++) {
            statement[resource] += " " + preciousStone[j].x + "," + preciousStone[j].y;
        }
        statement[resource] += " " + "S";
        for (int j = 0; j <= 7; j++) {
            statement[resource] += " " + statuette[j].x + "," + statuette[j].y;
        }
        statement[resource] += ";";
        //delete the first space of the arrangement statement
        statement[0] = statement[0].substring(1, statement[0].length());
        //assembly all statements
        String after = "";
        for (int k = 0; k <= statement.length - 1; k++) {
            if (k == resource) {
                after += statement[resource];
            } else {
                after += statement[k] + ";";
            }
        }
        return after; // FIXME Task 6
    }

    /**
     * Given a state string and a move string, determine if the move is
     * valid for the current player.
     * <p>
     * For a move to be valid, the player must have enough pieces left to
     * play the move. The following conditions for each phase must also
     * be held.
     * <p>
     * In the Exploration Phase, the move must either be:
     * - A settler placed on any unoccupied sea space
     * - A settler or a village placed on any unoccupied land space
     * adjacent to one of the player's pieces.
     * <p>
     * In the Settlement Phase, the move must be:
     * - Only a settler placed on an unoccupied space adjacent to
     * one of the player's pieces.
     * Importantly, players can now only play on the sea if it is
     * adjacent to a piece they already own.
     *
     * @param stateString a string representing a game state
     * @param moveString  a string representing the current player's move
     * @return true if the current player can make the move and false otherwise
     */
    public static boolean isMoveValid(String stateString, String moveString) {
        stateString = " " + stateString;
        String[] statement = stateString.split(";");
        char turn = statement[1].charAt(3);//which player is moving
        char phase = statement[1].charAt(statement[1].length() - 1);//which phase, E(xpolaration) or S(ettlement)
        int playerStringNum = 0;//the statue of this player is stored in which statement
        for (int i = 2; i <= statement.length - 1; i++) {
            if (statement[i].charAt(1) == 'p') {
                if (statement[i].charAt(3) == turn) {//this player's status string
                    playerStringNum = i;
                    break;
                }
            }
        }

        //check how many villages and settlers the player have on board
        String[] playerStatus = statement[playerStringNum].split(" ");
        int settlerNum = 0;
        int villageNum = 0;
        for (int j = 0; j <= playerStatus.length - 1; j++) {
            if (playerStatus[j].equals("S")) {
                while (!playerStatus[j + 1].equals("T")) {
                    settlerNum++;
                    j++;
                }
            }
            if (playerStatus[j].equals("T")) {
                while (j + 1 <= playerStatus.length - 1) {
                    villageNum++;
                    j++;
                }
            }
        }
        //check the limit for settlers and villages for each player
        char playerNumber = statement[0].charAt(statement[0].length() - 1);
        int settlerLimit;
        if (playerNumber == '2') {
            settlerLimit = 30;
        } else if (playerNumber == '3') {
            settlerLimit = 25;
        } else {
            settlerLimit = 20;
        }
        int villageLimit = 5;

        //check if the player is able to place items
        if (phase == 'E') {//in phase 1
            if (moveString.charAt(0) == 'S') {
                if (settlerLimit <= settlerNum) {
                    return false;
                }
            } else {
                if (villageLimit <= villageNum) {
                    return false;
                }
            }
        } else {//in phase 2
            if (moveString.charAt(0) == 'S') {
                if (settlerLimit <= settlerNum) {
                    return false;
                }
            } else {
                return false;//because in settlement phase, player cannot place villages anymore
            }
        }

        //check if the move is beyond the scale of the map
        String[] arrangement = statement[0].split(" ");
        int size = Integer.parseInt(arrangement[2]);
        String[] move = moveString.split(" ");

        String[] moveXY = move[1].split(",");
        int x = Integer.parseInt(moveXY[0]);
        int y = Integer.parseInt(moveXY[1]);
        if (x < 0 || x >= size) {
            return false;
        } else {
            if (x % 2 == 0) {
                if (y < 0 || y > size - 2) {
                    return false;
                }
            } else {
                if (y < 0 || y > size - 1) {
                    return false;
                }
            }
        }
        //set up a map of spots
        Spot[][] spots = new Spot[size][size];
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                spots[i][j] = new Spot();
            }
        }

        String[] land;
        String[] landXY;
        int landx;
        int landy;
        //initialize land spots on the map
        for (int i = 0; i <= statement.length - 1; i++) {
            //when this statement is island string
            if (statement[i].charAt(1) == 'i') {
                land = statement[i].split(" ");
                for (int j = 3; j <= land.length - 1; j++) {//land[0]="",land[1]="i",land[2]="6/8/10"
                    landXY = land[j].split(",");
                    landx = Integer.parseInt(landXY[0]);
                    landy = Integer.parseInt(landXY[1]);
                    spots[landx][landy].spotType = 1;

                }
            }
            if (statement[i].charAt(1) == 'p') {
                String[] playerPositions = statement[i].split(" ");
                int whichplayer = Integer.parseInt(playerPositions[2]);//which player occupies these following spots
                for (int j = 0; j <= playerPositions.length - 1; j++) {
                    if (playerPositions[j].equals("S")) {
                        while (!playerPositions[j + 1].equals("T")) {
                            String[] setPos = playerPositions[j + 1].split(",");
                            int setx = Integer.parseInt(setPos[0]);
                            int sety = Integer.parseInt(setPos[1]);
                            spots[setx][sety].occupiedByPlayer = whichplayer;
                            j++;
                        }
                    }
                    if (playerPositions[j].equals("T")) {
                        while (j + 1 <= playerPositions.length - 1) {
                            String[] vilPos = playerPositions[j + 1].split(",");
                            int vilx = Integer.parseInt(vilPos[0]);
                            int vily = Integer.parseInt(vilPos[1]);
                            spots[vilx][vily].occupiedByPlayer = whichplayer;
                            j++;
                        }
                    }
                }
            }
        }
        int player = (int) turn - 48;
        System.out.println(player);
        System.out.println(x + "," + y);
        System.out.println(spots[x][y].spotType);
        System.out.println(moveString.substring(0, 1));
        System.out.println(spots[3][7].occupiedByPlayer);
        System.out.println(settlerNum + "," + villageNum);
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                if (spots[i][j].occupiedByPlayer == player) {
                    System.out.println(i + "," + j);
                }
            }
        }
        System.out.println("");
        //check if there are the player's own areas in adjacent spots


        if (phase == 'E') {
            if (spots[x][y].spotType == 0) {
                if (moveString.charAt(0) == 'S' && spots[x][y].occupiedByPlayer == 100) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        if(spots[x][y].occupiedByPlayer==100){
            if(x%2==1){
                if((x-1)>=0&&(y-1)>=0&&spots[x-1][y-1].occupiedByPlayer==player){
                    System.out.println(1);
                    return true;
                }
                if ((x+1)<=size-1&&(y-1)>=0&&spots[x+1][y-1].occupiedByPlayer==player) {
                    System.out.println(2);
                    return true;
                }
                if ((y-1)>=0&&spots[x][y-1].occupiedByPlayer==player) {
                    System.out.println(3);
                    return true;
                }
                if ((x-1)>=0&&spots[x-1][y].occupiedByPlayer==player) {
                    System.out.println(4);
                    return true;
                }
                if ((x+1)<=size-1&&spots[x+1][y].occupiedByPlayer==player) {
                    System.out.println(5);
                    return true;
                }
                if ((y+1)<=size-1&&spots[x][y+1].occupiedByPlayer==player) {
                    System.out.println(6);
                    return true;
                }

                return false;
            } else  {
                if((x-1)>=0&&(y+1)<=size-1&&spots[x-1][y+1].occupiedByPlayer==player){
                    System.out.println(1);
                    return true;
                }
                if ((x+1)<=size-1&&(y+1)<=size-1&&spots[x+1][y+1].occupiedByPlayer==player) {
                    System.out.println(2);
                    return true;
                }
                if ((y-1)>=0&&spots[x][y-1].occupiedByPlayer==player) {
                    System.out.println(3);
                    return true;
                }
                if ((x-1)>=0&&spots[x-1][y].occupiedByPlayer==player) {
                    System.out.println(4);
                    return true;
                }
                if ((x+1)<=size-1&&spots[x+1][y].occupiedByPlayer==player) {
                    System.out.println(5);
                    return true;
                }
                if ((y+1)<=size-1&&spots[x][y+1].occupiedByPlayer==player) {
                    System.out.println(6);
                    return true;
                }

                return false;
            }

        }else {
            return false;
        }


        //return true; // FIXME Task 7
    }

    public static boolean isPosInIndex(int size, int x, int y) {
        if (x < 0 || x >= size) {
            return false;
        } else {
            if (x % 2 == 0) {
                if (y < 0 || y > size - 2) {
                    return false;
                }
            } else {
                if (y < 0 || y > size - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Given a state string, generate a set containing all move strings playable
     * by the current player.
     * <p>
     * A move is playable if it is valid.
     *
     * @param stateString a string representing a game state
     * @return a set of strings representing all moves the current player can play
     */
    public static Set<String> generateAllValidMoves(String stateString) {
        Set<String> stringSet = new HashSet<String>();//Create a new empty HashSet of movestrings

        stateString = " " + stateString;
        String[] statement = stateString.split(";");
        char turn = statement[1].charAt(3);//which player is moving
        char phase = statement[1].charAt(statement[1].length() - 1);//which phase, E(xpolaration) or S(ettlement)
        int playerStringNum = 0;//the statue of this player is stored in which statement
        for (int i = 2; i <= statement.length - 1; i++) {
            if (statement[i].charAt(1) == 'p') {
                if (statement[i].charAt(3) == turn) {//this player's status string
                    playerStringNum = i;
                    break;
                }
            }
        }

        //check how many villages and settlers the player have on board
        String[] playerStatus = statement[playerStringNum].split(" ");
        int settlerNum = 0;
        int villageNum = 0;
        for (int j = 0; j <= playerStatus.length - 1; j++) {
            if (playerStatus[j].equals("S")) {
                while (!playerStatus[j + 1].equals("T")) {
                    settlerNum++;
                    j++;
                }
            }
            if (playerStatus[j].equals("T")) {
                while (j + 1 <= playerStatus.length - 1) {
                    villageNum++;
                    j++;
                }
            }
        }

        //check if this is the first step of this player, so possible moves can only be settler on sea area.
        boolean firstStep = false;
        if (settlerNum == 0 && villageNum == 0) {
            firstStep = true;
        }

        //check the limit for settlers and villages for each player
        char playerNumber = statement[0].charAt(statement[0].length() - 1);
        int settlerLimit;
        if (playerNumber == '2') {
            settlerLimit = 30;
        } else if (playerNumber == '3') {
            settlerLimit = 25;
        } else {
            settlerLimit = 20;
        }
        int villageLimit = 5;

        boolean canMoveSettler = false;//if this player can move settlers in this phase
        boolean canMoveVillage = false;//if this player can move villages in this phase+
        if (phase == 'E') {//in phase 1
            if (settlerNum < settlerLimit) {
                canMoveSettler = true;
            }
            if (villageNum < villageLimit) {
                canMoveVillage = true;
            }
        } else {//in phase 2
            if (settlerNum < settlerLimit) {
                canMoveSettler = true;
            }
            canMoveVillage = false;
        }

        //Get the size of the map
        String[] arrangement = statement[0].split(" ");
        int size = Integer.parseInt(arrangement[2]);

        //set up a map of spots
        Spot[][] spots = new Spot[size][size];
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                spots[i][j] = new Spot();
            }
        }

        String[] land;
        String[] landXY;
        int landx;
        int landy;
        //initialize land spots on the map
        for (int i = 0; i <= statement.length - 1; i++) {
            //when this statement is island string
            if (statement[i].charAt(1) == 'i') {
                land = statement[i].split(" ");
                for (int j = 3; j <= land.length - 1; j++) {//land[0]="",land[1]="i",land[2]="6/8/10"
                    landXY = land[j].split(",");
                    landx = Integer.parseInt(landXY[0]);
                    landy = Integer.parseInt(landXY[1]);
                    spots[landx][landy].spotType = 1;

                }
            }
            if (statement[i].charAt(1) == 'p') {
                String[] playerPositions = statement[i].split(" ");
                int whichplayer = Integer.parseInt(playerPositions[2]);//which player occupies these following spots
                for (int j = 0; j <= playerPositions.length - 1; j++) {
                    if (playerPositions[j].equals("S")) {
                        while (!playerPositions[j + 1].equals("T")) {
                            String[] setPos = playerPositions[j + 1].split(",");
                            int setx = Integer.parseInt(setPos[0]);
                            int sety = Integer.parseInt(setPos[1]);
                            spots[setx][sety].occupiedByPlayer = whichplayer;
                            j++;
                        }
                    }
                    if (playerPositions[j].equals("T")) {
                        while (j + 1 <= playerPositions.length - 1) {
                            String[] vilPos = playerPositions[j + 1].split(",");
                            int vilx = Integer.parseInt(vilPos[0]);
                            int vily = Integer.parseInt(vilPos[1]);
                            spots[vilx][vily].occupiedByPlayer = whichplayer;
                            j++;
                        }
                    }
                }
            }
        }
        //ID of this player
        int player = (int) turn - 48;

        //Generate movestrings
        if (phase == 'E' && firstStep) {
            for (int i = 0; i <= size - 1; i++) {
                for (int j = 0; j <= size - 1; j++) {
                    if (isPosInIndex(size, i, j)) {
                        if (spots[i][j].spotType == 0 && spots[i][j].occupiedByPlayer == 100) {//This sea spot isn't occupied by any player
                            stringSet.add("S " + i + "," + j);
                        }
                    }
                }
            }
            return stringSet;
        } else {
            if (phase == 'E') {
                for (int i = 0; i <= size - 1; i++) {
                    for (int j = 0; j <= size - 1; j++) {
                        if (isPosInIndex(size, i, j)) {
                            if (spots[i][j].spotType == 0 && spots[i][j].occupiedByPlayer == 100) {//This sea spot isn't occupied by any player
                                if (canMoveSettler) {
                                    stringSet.add("S " + i + "," + j);
                                }
                            }
                            if (spots[i][j].spotType == 1 && spots[i][j].occupiedByPlayer == 100) {
                                if (i % 2 == 1) {
                                    if (isPosInIndex(size, i - 1, j - 1) && spots[i - 1][j - 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i + 1, j - 1) && spots[i + 1][j - 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i, j - 1) && spots[i][j - 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i - 1, j) && spots[i - 1][j].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i + 1, j) && spots[i + 1][j].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i, j + 1) && spots[i][j + 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                } else {
                                    if (isPosInIndex(size, i - 1, j + 1) && spots[i - 1][j + 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i + 1, j + 1) && spots[i + 1][j + 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i, j - 1) && spots[i][j - 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i - 1, j) && spots[i - 1][j].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i + 1, j) && spots[i + 1][j].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i, j + 1) && spots[i][j + 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                        if (canMoveVillage) {
                                            stringSet.add("T " + i + "," + j);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return stringSet;
            } else {
                for (int i = 0; i <= size - 1; i++) {
                    for (int j = 0; j <= size - 1; j++) {
                        if (isPosInIndex(size, i, j)) {
                            if (spots[i][j].occupiedByPlayer == 100) {
                                if (i % 2 == 1) {
                                    if (isPosInIndex(size, i - 1, j - 1) && spots[i - 1][j - 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i + 1, j - 1) && spots[i + 1][j - 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i, j - 1) && spots[i][j - 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i - 1, j) && spots[i - 1][j].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i + 1, j) && spots[i + 1][j].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i, j + 1) && spots[i][j + 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                } else {
                                    if (isPosInIndex(size, i - 1, j + 1) && spots[i - 1][j + 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i + 1, j + 1) && spots[i + 1][j + 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i, j - 1) && spots[i][j - 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i - 1, j) && spots[i - 1][j].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i + 1, j) && spots[i + 1][j].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                    if (isPosInIndex(size, i, j + 1) && spots[i][j + 1].occupiedByPlayer == player) {
                                        if (canMoveSettler) {
                                            stringSet.add("S " + i + "," + j);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return stringSet;
            }


            //return stringSet; // FIXME Task 8
        }
    }

    /**
     * Given a state string, determine whether it represents an end of phase state.
     * <p>
     * A phase is over when either of the following conditions hold:
     * - All resources (not including statuettes) have been collected.
     * - No player has any remaining valid moves.
     *
     * @param stateString a string representing a game state
     * @return true if the state is at the end of either phase and false otherwise
     */
    public static boolean isPhaseOver(String stateString) {
        return false; // FIXME Task 9
    }

    /**
     * Given a state string and a move string, place the piece associated with the
     * move on the board. Ensure the player collects any corresponding resource or
     * statuettes.
     * <p>
     * Do not handle switching to the next player here.
     *
     * @param stateString a string representing a game state
     * @param moveString  a string representing the current player's move
     * @return a new state string achieved by placing the move on the board
     */
    public static String placePiece(String stateString, String moveString) {
        return ""; // FIXME Task 10
    }

    /**
     * Given a state string, calculate the "Islands" portion of the score for
     * each player as if it were the end of a phase. The return value is an
     * integer array sorted by player number containing the calculated score
     * for the respective player.
     * <p>
     * The "Islands" portion is calculated for each player as follows:
     * - If the player has pieces on 8 or more islands, they score 20 points.
     * - If the player has pieces on 7 islands, they score 10 points.
     * - No points are scored otherwise.
     *
     * @param stateString a string representing a game state
     * @return an integer array containing the calculated "Islands" portion of
     * the score for each player
     */
    public static int[] calculateTotalIslandsScore(String stateString) {
        return new int[]{0, 0}; // FIXME Task 11
    }

    /**
     * Given a state string, calculate the "Links" portion of the score for
     * each player as if it were the end of a phase. The return value is an
     * integer array sorted by player number containing the calculated score
     * for the respective player.
     * <p>
     * Players earn points for their chain of pieces that links the most
     * islands. For each island linked by this chain, they score 5 points.
     * <p>
     * Note the chain needn't be a single path. For instance, if the chain
     * splits into three or more sections, all of those sections are counted
     * towards the total.
     *
     * @param stateString a string representing a game state
     * @return an integer array containing the calculated "Links" portion of
     * the score for each player
     */
    public static int[] calculateIslandLinksScore(String stateString) {
        return new int[]{0, 0}; // FIXME Task 11
    }

    /**
     * Given a state string, calculate the "Majorities" portion of the score for
     * each player as if it were the end of a phase. The return value is an
     * integer array sorted by player number containing the calculated score
     * for the respective player.
     * <p>
     * The "Majorities" portion is calculated for each island as follows:
     * - The player with the most pieces on the island scores the number
     * of points that island is worth.
     * - In the event of a tie for pieces on an island, those points are
     * divided evenly between those players rounding down. For example,
     * if two players tied for an island worth 7 points, they would
     * receive 3 points each.
     * - No points are awarded for islands without any pieces.
     *
     * @param stateString a string representing a game state
     * @return an integer array containing the calculated "Majorities" portion
     * of the score for each player
     */
    public static int[] calculateIslandMajoritiesScore(String stateString) {
        return new int[]{0, 0}; // FIXME Task 11
    }

    /**
     * Given a state string, calculate the "Resources" and "Statuettes" portions
     * of the score for each player as if it were the end of a phase. The return
     * value is an integer array sorted by player number containing the calculated
     * score for the respective player.
     * <p>
     * Note that statuettes are not resources.
     * <p>
     * In the below "matching" means a set of the same resources.
     * <p>
     * The "Resources" portion is calculated for each player as follows:
     * - For each set of 4+ matching resources, 20 points are scored.
     * - For each set of exactly 3 matching resources, 10 points are scored.
     * - For each set of exactly 2 matching resources, 5 points are scored.
     * - If they have all four resource types, 10 points are scored.
     * <p>
     * The "Statuettes" portion is calculated for each player as follows:
     * - A player is awarded 4 points per statuette in their possession.
     *
     * @param stateString a string representing a game state
     * @return an integer array containing the calculated "Resources" and "Statuettes"
     * portions of the score for each player
     */
    public static int[] calculateResourcesAndStatuettesScore(String stateString) {
        return new int[]{0, 0}; // FIXME Task 11
    }

    /**
     * Given a state string, calculate the scores for each player as if it were
     * the end of a phase. The return value is an integer array sorted by player
     * number containing the calculated score for the respective player.
     * <p>
     * It is recommended to use the other scoring functions to assist with this
     * task.
     *
     * @param stateString a string representing a game state
     * @return an integer array containing the calculated scores for each player
     */
    public static int[] calculateScores(String stateString) {
        return new int[]{0, 0}; // FIXME Task 11
    }

    /**
     * Given a state string representing an end of phase state, return a new state
     * achieved by following the end of phase rules. Do not move to the next player
     * here.
     * <p>
     * In the Exploration Phase, this means:
     * - The score is tallied for each player.
     * - All pieces are removed from the board excluding villages not on stone circles.
     * - All resources and statuettes remaining on the board are removed. All resources are then
     * randomly redistributed between the stone circles.
     * <p>
     * In the Settlement Phase, this means:
     * - Only the score is tallied and added on for each player.
     *
     * @param stateString a string representing a game state at the end of a phase
     * @return a string representing the new state achieved by following the end of phase rules
     */
    public static String endPhase(String stateString) {
        return ""; // FIXME Task 12
    }

    /**
     * Given a state string and a move string, apply the move to the board.
     * <p>
     * If the move ends the phase, apply the end of phase rules.
     * <p>
     * Advance current player to the next player in turn order that has a valid
     * move they can make.
     *
     * @param stateString a string representing a game state
     * @param moveString  a string representing the current player's move
     * @return a string representing the new state after the move is applied to the board
     */
    public static String applyMove(String stateString, String moveString) {
        return ""; // FIXME Task 13
    }

    /**
     * Given a state string, returns a valid move generated by your AI.
     * <p>
     * As a hint, generateAllValidMoves() may prove a useful starting point,
     * maybe if you could use some form of heuristic to see which of these
     * moves is best?
     * <p>
     * Your AI should perform better than randomly generating moves,
     * see how good you can make it!
     *
     * @param stateString a string representing a game state
     * @return a move string generated by an AI
     */
    public static String generateAIMove(String stateString) {
        return ""; // FIXME Task 16
    }
}
