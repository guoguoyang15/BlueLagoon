package comp1110.ass2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class IsPosIndexTest {
    @Test
    void testOnBoard(){
        for(int i=0;i<=12;i++){
            if(i%2==0){
                assertFalse(Spot.isPosInIndex(13,i,12),"Pay Attention to even rows!");
            }else {
                assertTrue(Spot.isPosInIndex(13,i,12),"Pay Attention to odd rows!");
            }
        }
        for(int i=0;i<=22;i++){
            if(i%2==0){
                assertFalse(Spot.isPosInIndex(23,i,22),"Pay Attention to even rows!");
            }else {
                assertTrue(Spot.isPosInIndex(23,i,22),"Pay Attention to odd rows!");
            }
        }

    }

}
