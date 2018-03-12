package Rooms;

import Guests.Guest;

public class Bedroom extends Room{
    private Type type;
    private int cost;
    private int currentGuestStayLength;

    public Bedroom(Type type) {
        super(type.getCapacity());
        this.type = type;
        this.cost = type.getValue();
        this.currentGuestStayLength = 0;
    }

    public int getCost() {
        return this.cost;
    }

    public Type getType() {
        return this.type;
    }

    public int getCurrentGuestStayLength() {
        return  this.currentGuestStayLength;
    }

    public void checkInGuestForLengthOfTime(Guest guest, int stayLength) {
        this.checkInGuest(guest);
        this.currentGuestStayLength = stayLength;
    }
}