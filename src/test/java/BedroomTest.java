import Guests.Guest;
import Rooms.Bedroom;
import Rooms.Type;
import Rooms.Type;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BedroomTest {
    Bedroom room;
    Guest guest;

    @Before
    public void before() {
        this.room = new Bedroom(Type.SINGLE);
        this.guest = new Guest("Bob Marley");
    }

    @Test
    public void hasCapacity() {
        assertEquals(4, room.getCapacity());
    }

    @Test
    public void hasGuestList() {
        ArrayList<Guest> guests = new ArrayList<>();
        assertEquals(guests, room.getGuests());
    }

    @Test
    public void canAddGuest() {
        room.checkInGuestForLengthOfTime(guest, 3);
        assertEquals(1, room.getGuests().size());
        assertEquals(3, room.getCurrentGuestStayLength());
    }

    @Test
    public void canGetCost() {
        assertEquals(30, room.getCost());
    }

    @Test
    public void hasType() {
        assertEquals(Type.SINGLE, room.getType());
    }

    @Test
    public void hasCurrentGuestStayLength() {
        assertEquals(0, room.getCurrentGuestStayLength());
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