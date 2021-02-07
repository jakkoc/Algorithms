import java.util.Objects;

public class MaximumConsistentSubarray
{
    //Checks all possible consistent subarray, thus achieving O(n^2) time complexity
    public static Subarray bruteMaximumConsistentSubarray(int[] array) {
        long maximumSum = Long.MIN_VALUE;
        long currentSum;
        int startingIndex = 0;
        int endingIndex = 0;

        for(int i = 0; i < array.length; i++) {
            currentSum = 0;
            for(int j = i; j < array.length; j++) {
                currentSum += array[j];
                if(currentSum > maximumSum) {
                    maximumSum = currentSum;
                    startingIndex = i;
                    endingIndex = j;
                }
            }
        }

        return new Subarray(startingIndex,endingIndex,maximumSum);
    }

    //Checks three possible scenarios - maximum subarray is completely in left subarray, it is crossing the middle or it is completely in right subarray
    //Using divide and conquer, it achieves time complexity of O(nlogn)
    public static Subarray divideAndConquerMaximumConsistentSubarray(int[] array) {
        return maximumConsistentSubarray(array,0,array.length - 1);
    }

    private static Subarray maximumConsistentSubarray(int[] array,int low,int high) {
        if(low == high) return new Subarray(low,high,array[low]);

        int mid = (low + high)/2;

        Subarray maximumLeftSubarray = maximumConsistentSubarray(array,low,mid);
        Subarray maximumCrossingSubarray = findMaximumCrossingSubarray(array,low,mid,high);
        Subarray maximumRightSubarray = maximumConsistentSubarray(array,mid + 1,high);

        if(maximumLeftSubarray.getSum() > maximumCrossingSubarray.getSum() && maximumLeftSubarray.getSum() > maximumRightSubarray.getSum()) return maximumLeftSubarray;
        else if(maximumCrossingSubarray.getSum() > maximumLeftSubarray.getSum() && maximumCrossingSubarray.getSum() > maximumRightSubarray.getSum()) return maximumCrossingSubarray;
        else return maximumRightSubarray;
    }

    private static Subarray findMaximumCrossingSubarray(int[] array,int low,int mid,int high) {
        long leftSum = Long.MIN_VALUE;
        long currentSum = 0;
        int leftIndex = mid;

        for(int i = mid;i >= low; i--) {
            currentSum += array[i];

            if(currentSum > leftSum) {
                leftSum = currentSum;
                leftIndex = i;
            }
        }

        long rightSum = Long.MIN_VALUE;
        currentSum = 0;
        int rightIndex = mid;

        for(int i = mid + 1; i <= high; i++) {
            currentSum += array[i];
            if(currentSum > rightSum) {
                rightSum = currentSum;
                rightIndex = i;
            }
        }

        return new Subarray(leftIndex,rightIndex,leftSum + rightSum);
    }


    static class Subarray {
        private int startingIndex;
        private int endingIndex;
        private long sum;

        public Subarray(int startingIndex,int endingIndex,long sum) {
            this.startingIndex = startingIndex;
            this.endingIndex = endingIndex;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d,%d]",startingIndex,endingIndex,sum);
        }

        @Override
        public boolean equals(Object otherObject) {
            if(otherObject == null) return false;
            if(getClass() != otherObject.getClass()) return false;
            Subarray otherSubarray = (Subarray) otherObject;

            return startingIndex == otherSubarray.startingIndex && endingIndex == otherSubarray.endingIndex && otherSubarray.sum == sum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(startingIndex,endingIndex,sum);
        }

         public int getStartingIndex()
         {
             return startingIndex;
         }

         public int getEndingIndex()
         {
             return endingIndex;
         }

         public long getSum()
         {
             return sum;
         }
     }
}
