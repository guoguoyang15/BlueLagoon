package comp1110.ass2;

import java.util.*;

/**
 * @author Zhou Linsheng (most methods), Zhining Zhang (part of applyMove and generateAIMove), Tyler Le (one method)
 * This class deals with all things related to moves, including checking, generating and applying valid moves.
 * This class also includes the AI move maker.
 */

public class Move {
    // @author Tyler Le
    // Checks if Move string is properly formatted
    public static boolean isMoveStringWellFormed(String moveString) {
        return moveString.matches("[S|T]\s\\d{1,2},\\d{1,2}");
    }

    // @author Zhou Linsheng
    // Checks if a move is valid
    public static boolean isMoveValid(Board b, char type, Coordinate coordinate) {
        int x = coordinate.x;
        int y = coordinate.y;
        if (b.isPhase()) { //In exploration phase
            if (type == 'S') {
                if (b.getSettlerLimit() <= b.getPlayers()[b.getTurn()].getSettlers()) {
                    return false;
                }
            } else {
                if (b.getVillageLimit() <= b.getPlayers()[b.getTurn()].getVillages()) {
                    return false;
                }
            }
        } else { //In settlement phase
            if (type == 'S') {
                if (b.getSettlerLimit() <= b.getPlayers()[b.getTurn()].getSettlers()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        // Checks whether the coordinate is out of the board
        if (!Spot.isPosInIndex(b.getSize(), x, y)) {
            return false;
        }

        if (b.isPhase()) {
            if (b.board[x][y].spotType == 0)
                return type == 'S' && b.board[x][y].occupiedByPlayer == 100;
        }
        if (b.board[x][y].occupiedByPlayer != 100) {
            return false;
        } else {
            if (x % 2 == 0) {
                if ((x - 1) >= 0 && (y + 1) <= b.getSize() - 1 && b.board[x - 1][y + 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((x + 1) <= b.getSize() - 1 && (y + 1) <= b.getSize() - 1 && b.board[x + 1][y + 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((y - 1) >= 0 && b.board[x][y - 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((x - 1) >= 0 && b.board[x - 1][y].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((x + 1) <= b.getSize() - 1 && b.board[x + 1][y].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                return (y + 1) <= b.getSize() - 2 && b.board[x][y + 1].occupiedByPlayer == b.getTurn();
            } else {
                if ((x - 1) >= 0 && (y - 1) >= 0 && b.board[x - 1][y - 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((x + 1) <= b.getSize() - 1 && (y - 1) >= 0 && b.board[x + 1][y - 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((y - 1) >= 0 && b.board[x][y - 1].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((x - 1) >= 0 && y != b.getSize() - 1 && b.getBoard()[x - 1][y].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                if ((x + 1) <= b.getSize() - 1 && y != b.getSize() - 1 && b.getBoard()[x + 1][y].occupiedByPlayer == b.getTurn()) {
                    return true;
                }
                return (y + 1) <= b.getSize() - 1 && b.getBoard()[x][y + 1].occupiedByPlayer == b.getTurn();
            }
        }
    }

    // @author Zhou Linsheng
    // Generates a set of all possible moves given a board
    public static Set<String> generateAllValidMoves(Board b) {
        Set<String> stringSet = new HashSet<String>(); // Create a new empty HashSet of move strings
        //In exploration phase
        if (b.isPhase()){
            for (int i = 0; i <= b.getSize(); i++){
                for (int j = 0; j <= b.getSize() - 1 ; j++){
                    if (i % 2 != 0 || j != b.getSize() - 1){
                        Coordinate c = new Coordinate(i, j);
                        if (isMoveValid(b,'S',c)){
                            stringSet.add("S "+c.x+","+c.y);
                        }
                        if (isMoveValid(b,'T',c)){
                            stringSet.add("T "+c.x+","+c.y);
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i <= b.getSize(); i++){
                for (int j = 0; j <= b.getSize() - 1; j++){
                    if (i % 2 != 0 || j != b.getSize() - 1){
                        if (i % 2 != 0 || j != b.getSize() - 1){
                            Coordinate c = new Coordinate(i, j);
                            if (isMoveValid(b,'S',c)){
                                stringSet.add("S "+c.x+","+c.y);
                            }
                        }
                    }
                }
            }
        }
        return stringSet;
    }

    // @author Zhou Linsheng
    // Places a piece given coordinates, and returns the new board with the piece placed
    public static String placePiece(Board b, char type, Coordinate coordinate) {
        // Change occupier
        b.getBoard()[coordinate.x][coordinate.y].occupiedByPlayer = b.getTurn();
        // Change settler or village
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
            }
            b.getBoard()[coordinate.x][coordinate.y].resources = Resource.NULL;
        }
        return b.toString();
    }

    // @author Zhining Zhang and later condensed and improved by Zhou Linsheng
    // Applies a move and returns the board after the move is made
    public static String applyMove(Board b, char type, Coordinate coordinate) {
        int turn = b.getTurn();
        String s = placePiece(b, type, coordinate);
        b = new Board(s);
        if (Board.isPhaseOver(b)) {
            String newPhase = Board.endPhase(b);
            b = new Board(newPhase);
        }
        for (int i = 0; i <= b.getPlayerNum() - 1; i++) {
            b.setTurn((turn + 1 + i) % b.getPlayerNum());
            if (Move.generateAllValidMoves(b).size() >= 1) {
                break;
            }
        }
        return b.toString();
    }

    // @author Original random move by Zhining Zhang and later given a heuristic by Zhou Linsheng
    // An improved and meaningful AI mode, not a random move
    public static String generateAIMove (Board b){
        Set<String> potentialMoves = Move.generateAllValidMoves (b);
        List<Coordinate> movesList = new ArrayList<>();
        // Add these positions to a list
        for(String s : potentialMoves) {
            String[] sp = s.split(" ");
            String[] xy = sp[1].split(",");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            Coordinate c = new Coordinate(x, y);
            movesList.add(c);
        }
        // We need an iterator to check all possible move spot in generalAllPossibleMoves Set
        for (Coordinate c : movesList){
            for (int i = 0; i <= b.getSize() - 1; i++){
                for (int j = 0; j <= b.getSize() - 1; j++){
                    if (i % 2 != 0 || j != b.getSize() - 1){
                        // If there is a resource on this spot, then AI should move a settler there
                        if (b.getBoard()[c.x][c.y].resources != Resource.NULL && b.getPlayers()[b.getTurn()].getSettlers() < b.getSettlerLimit()){
                            // Don't place a village on a stone circle
                            return "S "+c.x+","+c.y;
                        }
                    }
                }
            }
        }
        // If all possible moves don't occupy a resource spot, then randomly allocate one
        Random r = new Random();
        int n = r.nextInt(potentialMoves.size());
        List<String> stringList = new ArrayList<>();
        for (String move : Move.generateAllValidMoves(b)) {
            stringList.add(move);
        }
        return stringList.get(n);
    }
}
