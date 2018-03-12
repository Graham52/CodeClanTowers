package Rooms;

public class ConferenceRoom extends Room{
    private int cost;
    private String name;

    public ConferenceRoom(String name, int capacity, int cost) {
        super(capacity);
        this.cost = cost;
        this.name = name;
    }

    public int getCost() {
        return this.cost;
    }

    public String getName() {
        return this.name;
    }
}