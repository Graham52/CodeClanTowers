package Rooms;

public enum Type {
    DOUBLE(2, 85),
    SINGLE(1, 60);

    private int capacity;
    private int value;

    Type(int capacity, int value) {
        this.value = value;
        this.capacity = capacity;
    }

    public int getValue() {
        return this.value;
    }

    public int getCapacity() {
        return this.capacity;
    }
}