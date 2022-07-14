import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    public static void main(String[] args) {
        Logger.getInstance().log("Managing hotel...");

        // create hotel rooms
        HotelRoomInterface rm101 = new HotelRoom(101);
        HotelRoomInterface rm102 = new HotelRoom(102);
        HotelRoomInterface rm103 = new HotelRoom(103);
        HotelRoomInterface rm104 = new HotelRoom(104);

        HotelRoomInterface rm201 = new HotelRoom(201);
        HotelRoomInterface rm202 = new HotelRoom(202);
        HotelRoomInterface rm203 = new HotelRoom(203);
        HotelRoomInterface rm204 = new HotelRoom(204);

        // create hotel floors
        HotelFloor fl1 = new HotelFloor();
        HotelFloor fl2 = new HotelFloor();

        // add hotel rooms to hotel floors
        fl1.addHotelRoom(rm101);
        fl1.addHotelRoom(rm102);
        fl1.addHotelRoom(rm103);
        fl1.addHotelRoom(rm104);
        fl2.addHotelRoom(rm201);
        fl2.addHotelRoom(rm202);
        fl2.addHotelRoom(rm203);
        fl2.addHotelRoom(rm204);
        // take actions on rooms and floors and examine your output to ensure you implemented the desired
        // behaviors
        rm101.book("James");
        rm102.book("Jason");
        rm103.book("Mark");
        rm201.book("Joy");
        rm203.book("Layia");
        rm204.book("Jacob");
        rm102.clean();
        rm103.clean();
        rm203.clean();
        fl1.clean();
        fl2.clean();
        fl1.book("President Obama");
        fl1.clean();
    }
}

interface HotelRoomInterface {
    void book(String guestName);
    void clean();
}

class HotelRoom implements HotelRoomInterface {
    private String guestName;
    private int roomNumber;

    public HotelRoom(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void book(String guestName) {
        Logger.getInstance().log("Booked a room for " + guestName + " in room: " + roomNumber);
        this.guestName = guestName;
    }

    public void clean() {
        Logger.getInstance().log("Cleaned room: " + roomNumber);
    }
}

class HotelFloor implements HotelRoomInterface {
    private List<HotelRoomInterface> hotelRooms = new ArrayList<HotelRoomInterface>();

    public void book(String guestName) {
        hotelRooms.forEach(child -> {
            child.book(guestName);
        });
    }
    public void clean() {
        Logger.getInstance().log("Cleaning Entire Floor...");
        hotelRooms.forEach(child -> child.clean());
    }

    public void addHotelRoom(HotelRoomInterface hotelRoom) {
        hotelRooms.add(hotelRoom);
    }

}
