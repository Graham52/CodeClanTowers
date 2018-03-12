import Guests.Guest;
import Rooms.Bedroom;
import Rooms.Type;
import Hotel.Hotel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Guest guest, guest2;

    @Before
    public void before() {
        hotel = new Hotel("The Bay Inn");
        guest = new Guest("John Doe");
        guest2 = new Guest("Jane Doe");
    }

    @Test
    public void hasBedrooms() {
        assertEquals(0, hotel.getBedrooms().size());
    }

    @Test
    public void hasConferenceRooms() {
        assertEquals(0, hotel.getConferenceRooms().size());
    }

    @Test
    public void hasDiningRooms() {
        assertEquals(0, hotel.getDiningRooms().size());
    }

    @Test
    public void hasName() {
        assertEquals("The Bay Inn", hotel.getName());
    }

    @Test
    public void canAddBedroom() {
        hotel.addBedroom(Type.DOUBLE);
        assertEquals(1, hotel.getBedrooms().size());
    }

    @Test
    public void canFindVacancy(){
        hotel.addBedroom(Type.DOUBLE);
        Bedroom vacantRoom = hotel.findVacancy(Type.DOUBLE);
        assertEquals(hotel.getBedrooms().get(0), vacantRoom);
    }

    @Test
    public void canFindFirstVacantRoom() {
        hotel.addBedroom(Type.DOUBLE);
        hotel.addBedroom(Type.DOUBLE);
        Bedroom vacantRoom = hotel.findVacancy(Type.DOUBLE);
        assertEquals(hotel.getBedrooms().get(0), vacantRoom);
    }

    @Test
    public void canFindRightTypeOfVacantRoom() {
        hotel.addBedroom(Type.SINGLE);
        hotel.addBedroom(Type.DOUBLE);
        Bedroom vacantRoom = hotel.findVacancy(Type.DOUBLE);
        assertEquals(hotel.getBedrooms().get(1), vacantRoom);
    }

    @Test
    public void guestCanCheckIntoBedroom() {
        hotel.addBedroom(Type.DOUBLE);
        hotel.checkInGuest(guest, Type.DOUBLE);
        assertEquals(hotel.getBedrooms().get(0).getGuests().get(0), guest);
    }

    @Test
    public void canFindGuestsInRoom() {
        hotel.addBedroom(Type.DOUBLE);
        hotel.checkInGuest(guest, Type.DOUBLE);
        assertEquals(guest, hotel.guestsInRoom(hotel.getBedrooms().get(0)).get(0));
    }

    @Test
    public void canFindAllVacantRooms() {
        hotel.addBedroom(Type.DOUBLE);
        hotel.addBedroom(Type.DOUBLE);
        hotel.checkInGuest(guest, Type.DOUBLE);
        hotel.checkInGuest(guest2, Type.DOUBLE);
        assertEquals(hotel.getBedrooms().get(1), hotel.findAllVacantBedrooms().get(0));
    }

    @Test
    public void canFindVacantRoomsByType() {
        hotel.addBedroom(Type.DOUBLE);
        hotel.addBedroom(Type.SINGLE);
        hotel.addBedroom(Type.DOUBLE);
        hotel.checkInGuest(guest, Type.DOUBLE);
        hotel.checkInGuest(guest2, Type.DOUBLE);
        assertEquals(hotel.getBedrooms().get(1), hotel.findVacantBedroomsByType(Type.SINGLE).get(0));
    }
}