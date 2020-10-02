package outLab2;

/**
 * This file creates a bin object with a bin number, capacity, occupancy, and remaining.
 * @author Ara Megerdichian
 *
 */
public class Bin {

	// Fields
    private int bin_number;
    private int capacity;
    private int occupancy;
    private int remaining;

    /**
     * This constructs a bin.
     * @param number An integer numbering the bins as they're created.
     * @param capacity An integer that represents the total capacity the bin can hold.
     * @param occupancy An integer that represents the amount currently in the bin.
     */
    public Bin(int number, int capacity, int occupancy) {
        this.bin_number = number;
        this.capacity = capacity;
        this.occupancy = occupancy;
        this.remaining = capacity - occupancy;
    }

    /**
     * This constructs a base case empty bin.
     */
    public Bin() {
        this.bin_number = -1;
        this.capacity = -1;
        this.occupancy = -1;
        this.remaining = -1;
    }

    /**
     * This method gives us the number of the current bin.
     * @return An integer bin number.
     */
    public int getBin_number() {
        return bin_number;
    }

    /**
     * This method gives us the current bin capacity.
     * @return An integer capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * This method gives us the current bin occupancy.
     * @return An integer occupancy.
     */
    public int getOccupancy() {
        return occupancy;
    }

    /**
     * This method gives us the amount remaining in the current bin.
     * @return An integer remaining.
     */
    public int getRemaining() {
        return remaining;
    }

    /**
     * This method is a setter that allows us the set each bin number.
     * We do this to keep track of the order in which they're created.
     * @param bin_number An integer bin number.
     */
    public void setBin_number(int bin_number) {
        this.bin_number = bin_number;
    }

    /**
     * This method allows us to set the capacity of our bin.
     * @param capacity An integer capacity.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * This method let's us set the current occupancy of the bin.
     * @param occupancy An integer occupancy.
     */
    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    /**
     * This method sets the remaining value of the current bin.
     * @param remaining An integer remaining.
     */
    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    /*
     * This method overrides the default toString method to help format our output in a more
     * readable way.  
     */
    @Override
    public String toString() {
        return ("\nBin Number:" + bin_number + " Occupancy:"  + occupancy + " Remaining:" + remaining);
    }
}

