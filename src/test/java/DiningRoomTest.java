import Guests.Guest;
import Rooms.DiningRoom;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {
    DiningRoom room;
    Guest guest;

    @Before
    public void before() {
        this.room = new DiningRoom("New York", 50);
        this.guest = new Guest("Jane Doe");
    }

    @Test
    public void hasName() {
        assertEquals("New York", room.getName());
    }

    @Test
    public void hasCapacity() {
        assertEquals(50, room.getCapacity());
    }

    @Test
    public void hasGuestList() {
        assertEquals(0, room.getGuests().size());
    }

    @Test
    public void canAddGuest() {
        room.checkInGuest(guest);
        assertEquals(1, room.getGuests().size());
    }

    @Test
    public void canCheckOutGuest() {
        room.checkInGuest(guest);
        assertEquals(1, room.getGuests().size());
        room.checkOutGuest(guest);
        assertEquals(0, room.getGuests().size());
    }

    @Test
    public void doesHaveCapacity() {
        assertEquals(true, room.hasCapacity());
    }


}