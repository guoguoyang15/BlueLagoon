package comp1110.ass2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

import static comp1110.ass2.Coordinate.generateAllCoordinates;



@Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
public class GenerateAllCoordinatesTest {
    @Test
    public void checkThrow() {
        Assertions.assertThrows(Exception.class, () -> generateAllCoordinates(-1) );
    }

    @Test
    public void checkTrueEven() throws Exception {
        Coordinate[] evenArray = new Coordinate[12];
        evenArray[0] = new Coordinate(0, 0);
        evenArray[1] = new Coordinate(0, 1);
        evenArray[2] = new Coordinate(0, 2);
        evenArray[3] = new Coordinate(0, 3);
        evenArray[4] = new Coordinate(0, 4);
        evenArray[5] = new Coordinate(0, 5);
        evenArray[6] = new Coordinate(0, 6);
        evenArray[7] = new Coordinate(0, 7);
        evenArray[8] = new Coordinate(0, 8);
        evenArray[9] = new Coordinate(0, 9);
        evenArray[10] = new Coordinate(0, 10);
        evenArray[11] = new Coordinate(0, 11);

        Assertions. assertArrayEquals(evenArray, generateAllCoordinates(0));
    }

    @Test
    public void checkTrueOdd() throws Exception {
        Coordinate[] oddArray = new Coordinate[25];
        oddArray[0] = new Coordinate(0, 0);
        oddArray[1] = new Coordinate(0, 1);
        oddArray[2] = new Coordinate(0, 2);
        oddArray[3] = new Coordinate(0, 3);
        oddArray[4] = new Coordinate(0, 4);
        oddArray[5] = new Coordinate(0, 5);
        oddArray[6] = new Coordinate(0, 6);
        oddArray[7] = new Coordinate(0, 7);
        oddArray[8] = new Coordinate(0, 8);
        oddArray[9] = new Coordinate(0, 9);
        oddArray[10] = new Coordinate(0, 10);
        oddArray[11] = new Coordinate(0, 11);
        oddArray[12] = new Coordinate(1, 0);
        oddArray[13] = new Coordinate(1, 1);
        oddArray[14] = new Coordinate(1, 2);
        oddArray[15] = new Coordinate(1, 3);
        oddArray[16] = new Coordinate(1, 4);
        oddArray[17] = new Coordinate(1, 5);
        oddArray[18] = new Coordinate(1, 6);
        oddArray[19] = new Coordinate(1, 7);
        oddArray[20] = new Coordinate(1, 8);
        oddArray[21] = new Coordinate(1, 9);
        oddArray[22] = new Coordinate(1, 10);
        oddArray[23] = new Coordinate(1, 11);
        oddArray[24] = new Coordinate(1, 12);

        Assertions.assertArrayEquals(oddArray, generateAllCoordinates(1));
    }
}
