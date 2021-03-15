import java.math.BigInteger;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

//!Stores only positive integer values!//
public class BitVector {
    private BigInteger bitVector = BigInteger.ZERO;

    /**
     * Adds all elements from the specified collection to this collection
     * @param values values to be added
     * @return true if collection have changed false otherwise
     */
    public boolean addAll(Collection<Integer> values) {
        boolean hasChanged = false;
        boolean currentStatus;

        for (var value : values) {
            currentStatus = add(value);
            if(!hasChanged && currentStatus) hasChanged = true;
        }

        return hasChanged;
    }

    /**
     * Adds element to this collection
     * @param elem value to be added
     * @return true if bitVector has changed false otherwise
     */
    public boolean add(Integer elem) {
        var key = elem.hashCode();

        if(bitVector.testBit(key)) {
            Logger.getLogger("global").log(Level.FINER, "Value already exist in this collection", elem);
            return false;
        }

        bitVector = bitVector.setBit(key);
        return true;
    }

    /**
     * Removes specified value from this collection
     * @param elem value to be removed
     * @return removed value or -1 if collection does not contain this value
     */
    public Integer remove(Integer elem) {
        var key = elem.hashCode();

        if(!bitVector.testBit(key)) {
            Logger.getLogger("global").log(Level.FINER, "Value does not exist in this collection", elem);
            return -1;
        }

        bitVector = bitVector.clearBit(key);

        return key;
    }

     /** Finds specified value in this collection
     * @param elem Element to be found
     * @return found element or -1 otherwise
     */
    public Integer find(Integer elem) {
        var key = elem.hashCode();

        if(!bitVector.testBit(key)) {
            Logger.getLogger("global").log(Level.FINER, "Value does not exist in this collection", elem);
            return -1;
        }

        return key;
    }
}
