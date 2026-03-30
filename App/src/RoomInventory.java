import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * CLASS - RoomInventory
 * ============================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * @version 3.1
 */
public class RoomInventory {

    // Key = Room Type, Value = Available Count
    private Map<String, Integer> roomAvailability;

    /**
     * Constructor initializes inventory
     */
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }
    public int getAvailableRooms(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }
    public void addRooms(String roomType, int count) {
        int current = roomAvailability.getOrDefault(roomType, 0);
        roomAvailability.put(roomType, current + count);
    }


    /**
     * Initialize default room availability
     */
    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    /**
     * Get full availability map
     */
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    /**
     * Update availability
     */
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}