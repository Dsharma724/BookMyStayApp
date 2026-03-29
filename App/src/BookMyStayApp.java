public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        // Step 1: Create inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Create queue
        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single")); // NOTE: matches expected output
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Step 3: Allocation service
        RoomAllocationService allocator = new RoomAllocationService();

        // Step 4: Process queue (FIFO)
        while (queue.hasPendingRequests()) {
            Reservation request = queue.getNextRequest();
            allocator.allocateRoom(request, inventory);
        }
    }
}