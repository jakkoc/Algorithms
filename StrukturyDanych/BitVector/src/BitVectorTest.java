import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BitVectorTest {
    private static final Random random = new Random();

    @Test
    public void smallTest() {
        var input = generateRandomIntegerList(1000, 1000);
        var clone = (ArrayList<Integer>)input.clone();
        var bitVector = new BitVector();

        bitVector.addAll(input);

        var valuesNotInInput = new ArrayList<Integer>();

        for(int i = 0; i < 1000; i++) {
            if(bitVector.find(i) == -1) valuesNotInInput.add(i);
        }

        clone.removeAll(valuesNotInInput);

        assertEquals(input, clone);
    }

    @Test
    public void bigTest() {
        var input = generateRandomIntegerList(100000, 100000);
        var clone = (ArrayList<Integer>)input.clone();
        var bitVector = new BitVector();

        bitVector.addAll(input);

        var valuesNotInInput = new ArrayList<Integer>();

        for(int i = 0; i < 100000; i++) {
            if(bitVector.find(i) == -1) valuesNotInInput.add(i);
        }

        clone.removeAll(valuesNotInInput);

        assertEquals(input, clone);
    }


    private static ArrayList<Integer> generateRandomIntegerList(int size, int maxValue) {
        var result = new ArrayList<Integer>();

        for(int i = 0; i < size; i++) {
            result.add(random.nextInt(maxValue + 1));
        }

        return result;
    }
}