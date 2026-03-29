import java.util.*;

public class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Check availability
        if (availability.get(roomType) != null && availability.get(roomType) > 0) {

            // Generate unique room ID
            String roomId = generateRoomId(roomType);

            // Store allocated ID
            allocatedRoomIds.add(roomId);

            // Track by type
            assignedRoomsByType
                    .computeIfAbsent(roomType, k -> new HashSet<>())
                    .add(roomId);

            // Decrease inventory
            inventory.updateAvailability(roomType, availability.get(roomType) - 1);

            // Confirm booking
            System.out.println(
                    "Booking confirmed for Guest: " +
                            reservation.getGuestName() +
                            ", Room ID: " +
                            roomId
            );

        } else {
            System.out.println(
                    "Booking failed for Guest: " +
                            reservation.getGuestName() +
                            " (No rooms available)"
            );
        }
    }

    private String generateRoomId(String roomType) {

        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        String roomId = roomType + "-" + count;

        // Extra safety (uniqueness check)
        while (allocatedRoomIds.contains(roomId)) {
            count++;
            roomId = roomType + "-" + count;
        }

        return roomId;
    }
}