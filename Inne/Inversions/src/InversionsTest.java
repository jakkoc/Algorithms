import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InversionsTest
{
    @Test
    public void smallIntegerInversionsTest() {
        Integer[] testArray = {2,3,8,6,1};

        assert(Inversions.numberOfInversions(testArray) == 5);
    }

    @Test
    public void bigIntegerInversionTest() {
        Integer[] testArray = new Integer[10000];
        for(int i = 0; i < testArray.length; i++) {
            testArray[i] = testArray.length - i;
        }

        assert(Inversions.numberOfInversions(testArray) == 5000 * 9999);
    }
}