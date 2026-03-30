public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        // Setup inventory
        RoomInventory inventory = new RoomInventory();

        // Initial booking already happened (simulate)
        String reservationId = "Single-1";
        String roomType = "Single";

        // Cancellation service
        CancellationService cancellationService = new CancellationService();

        // Register booking
        cancellationService.registerBooking(reservationId, roomType);

        // Cancel booking
        cancellationService.cancelBooking(reservationId, inventory);

        // Show rollback history
        cancellationService.showRollbackHistory();

        // Show updated inventory
        int updated = inventory.getRoomAvailability().get("Single");
        System.out.println("\nUpdated Single Room Availability: " + updated);
    }
}