package Hotel;

import Guests.Guest;
import Rooms.Bedroom;
import Rooms.Type;
import Rooms.ConferenceRoom;
import Rooms.DiningRoom;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom> diningRooms;
    private String name;

    public Hotel(String name) {
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningRooms = new ArrayList<>();
        this.name = name;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return this.bedrooms;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return this.conferenceRooms;
    }

    public ArrayList<DiningRoom> getDiningRooms() {
        return this.diningRooms;
    }

    public void addBedroom(Type type) {
        Bedroom bedroom = new Bedroom(type);
        this.bedrooms.add(bedroom);
    }


    public Bedroom findVacancy(Type type) {
        Bedroom vacantRoom = null;
        for (Bedroom room : this.bedrooms) {
            if (room.getType() == type && room.hasCapacity()) {
                return vacantRoom = room;
            }
        }
        return vacantRoom;
    }

    public void checkInGuest(Guest guest, Type type) {
        Bedroom vacantRoom = findVacancy(type);
        if (vacantRoom != null) {
            vacantRoom.checkInGuest(guest);
        }
    }

    public ArrayList<Guest> guestsInRoom(Bedroom bedroom) {
        return bedroom.getGuests();
    }

    public ArrayList<Bedroom> findAllVacantBedrooms() {
        ArrayList<Bedroom> vacantRooms = new ArrayList<>();
        for (Bedroom room : this.bedrooms) {
            if (room.hasCapacity()) {
                vacantRooms.add(room);
            }
        }
        return vacantRooms;
    }

    public ArrayList<Bedroom> findVacantBedroomsByType(Type type) {
        ArrayList<Bedroom> vacantRooms = new ArrayList<>();
        for (Bedroom room : this.bedrooms) {
            if (room.getType() == type && room.hasCapacity()) {
                vacantRooms.add(room);
            }
        }
        return vacantRooms;
    }
}