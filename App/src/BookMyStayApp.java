import java.util.Scanner;

public class BookMyStayApp{

    public static void main(String[] args) {

        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue queue = new BookingRequestQueue();

        // Setup inventory (important!)
        inventory.addRooms("Single", 2);
        inventory.addRooms("Double", 2);
        inventory.addRooms("Suite", 1);

        try {
            // Take input
            System.out.print("Enter guest name: ");
            String name = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // VALIDATION STEP
            validator.validate(name, roomType, inventory);

            // If valid → create reservation
            Reservation reservation = new Reservation(name, roomType);

            // Add to queue
            queue.addRequest(reservation);

            System.out.println("Booking request accepted.");

        } catch (InvalidBookingException e) {

            // Graceful failure
            System.out.println("Booking failed: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}