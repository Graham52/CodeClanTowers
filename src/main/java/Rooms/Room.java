package Rooms;
import java.util.ArrayList;
import Guests.Guest;

public abstract class Room {
    private int capacity;
    private ArrayList<Guest> guests;

    public Room(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<Guest> getGuests() {
        return this.guests;
    }

    public void checkInGuest(Guest guest) {
        this.guests.add(guest);
    }

    public void checkOutGuest(Guest guest) {
        this.guests.remove(guest);
    }

    public boolean hasCapacity() {
        return this.guests.size() < this.capacity;
    }


}
