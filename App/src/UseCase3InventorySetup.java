/**
 * ============================================================
 * MAIN CLASS - UseCase3InventorySetup
 * ============================================================
 *
 * Demonstrates centralized inventory management
 *
 * @version 3.1
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        // Room objects (reuse from UC2)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Display data
        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Single") + "\n");

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Double") + "\n");

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Suite"));
    }
}