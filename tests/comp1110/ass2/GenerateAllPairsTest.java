package comp1110.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
public class GenerateAllPairsTest {
    @Test
    public void testAllGameStates(){
        // Guard against case where true returned by default for everything
        testTrue(allGames.get(0).get(1));
        for (List<String> game : allGames) {
            for (int line = 0; line < game.size(); line += 2) {
                testFalse(game.get(line));
            }
        }
    }

    @Test
    public void testAllMoves(){
        // Guard against case where false returned by default for everything
        testFalse("");
        for (List<String> game : allGames) {
            for (int line = 1; line < game.size(); line += 2) {
                testTrue(game.get(line));
            }
        }
    }

    @Test
    public void testMissingCharacters(){
        // Guard against case where false returned by default for everything
        testTrue(allGames.get(0).get(1));
        for (List<String> game : allGames) {
            for (int line = 1; line < game.size(); line += 2) {
                for (int i = 0; i < game.get(line).length(); i++) {
                    if(!Character.isDigit(game.get(line).charAt(i))){
                        testFalse(game.get(line).substring(0,i) + game.get(line).substring(i+1));
                    }
                }
            }
        }
    }

    @Test
    public void testExtraSpaces(){
        // Guard against case where false returned by default for everything
        testTrue(allGames.get(0).get(1));
        for (List<String> game : allGames) {
            for (int line = 1; line < game.size(); line += 2) {
                String tooManySpaces = String.join(" ".repeat(line + 1), game.get(line).split(" "));
                testFalse(tooManySpaces);
            }
        }
    }

    @Test
    public void testWrongCharacters(){
        // Guard against case where false returned by default for everything
        testTrue(allGames.get(0).get(1));
        for (List<String> game : allGames) {
            for (int line = 1; line < game.size(); line += 2) {
                for (int i = 0; i < game.get(line).length(); i++) {
                    char character = game.get(line).charAt(i);
                    if (!Character.isDigit(character)) {
                        testFalse(game.get(line).substring(0,i) + (char) (character + 2) + game.get(line).substring(i+1));
                        testFalse(game.get(line).substring(0,i) + (char) (character - 2) + game.get(line).substring(i+1));
                    }
                }
            }
        }
    }

    @Test
    public void testReplacedDigit(){
        // Guard against case where false returned by default for everything
        testTrue(allGames.get(0).get(1));
        for (List<String> game : allGames) {
            for (int line = 1; line < game.size(); line += 2) {
                for (int i = 0; i < game.get(line).length(); i++) {
                    char character = game.get(line).charAt(i);
                    if (Character.isDigit(character)) {
                        testFalse(game.get(line).substring(0,i) + (char) ('a' + ((i + line) % 26)) + game.get(line).substring(i+1));
                        testFalse(game.get(line).substring(0,i) + (char) ('A' + ((i + line) % 26)) + game.get(line).substring(i+1));
                    }
                }
            }
        }
    }
}
