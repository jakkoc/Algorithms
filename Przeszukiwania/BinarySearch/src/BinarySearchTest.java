import org.junit.jupiter.api.Test;

class BinarySearchTest
{
    @Test
    public void smallSortedIntegerTest()
    {
        Integer[] testArray = new Integer[1000];

        for(int i = 0 ; i < testArray.length; i++) {
            testArray[i] = i;
        }

        assert(BinarySearch.binarySearch(testArray,500) == 500);
    }

    @Test
    public void bigSortedIntegerTest() {
        Integer[] testArray = new Integer[10000000];

        for(int i = 0; i < testArray.length; i++) {
            testArray[i] = i;
        }

        assert(BinarySearch.binarySearch(testArray,333333) == 333333);
    }
}