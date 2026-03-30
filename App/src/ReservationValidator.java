import java.util.*;

public class ReservationValidator {

    private static final Set<String> VALID_ROOM_TYPES =
            new HashSet<>(Arrays.asList("Single", "Double", "Suite"));

    public void validate(String guestName,
                         String roomType,
                         RoomInventory inventory)
            throws InvalidBookingException {

        // Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Validate room type
        if (!VALID_ROOM_TYPES.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        // Validate inventory availability
        int available = inventory.getAvailableRooms(roomType);

        if (available <= 0) {
            throw new InvalidBookingException(
                    "No rooms available for type: " + roomType
            );
        }
    }
}