import org.junit.Before;
import org.junit.Test;

import Guests.Guest;
import Rooms.ConferenceRoom;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {
    ConferenceRoom room;
    Guest guest;

    @Before
    public void before() {
        this.room = new ConferenceRoom("Manhattan", 85, 30);
        this.guest = new Guest("Jane Doe");
    }

    @Test
    public void hasCapacity() {
        assertEquals(85, room.getCapacity());
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
    public void hasName() {
        assertEquals("Manhattan", room.getName());
    }

    @Test
    public void canGetCost() {
        assertEquals(30, room.getCost());
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