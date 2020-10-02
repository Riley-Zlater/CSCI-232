package outLab2;

public class Bin {

    private int bin_number;
    private int capacity;
    private int occupancy;
    private int remaining;

    public Bin(int number, int capacity, int occupancy) {
        this.bin_number = number;
        this.capacity = capacity;
        this.occupancy = occupancy;
        this.remaining = capacity - occupancy;
    }

    public Bin() {
        this.bin_number = -1;
        this.capacity = -1;
        this.occupancy = -1;
        this.remaining = -1;
    }

    public int getBin_number() {
        return bin_number;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setBin_number(int bin_number) {
        this.bin_number = bin_number;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public String toString() {
        return ("\nBin Number:" + bin_number + " Occupancy:"  + occupancy + " Remaining:" + remaining);
    }
}
