public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking History and Reporting");

        // Create booking history
        BookingHistory history = new BookingHistory();

        // Assume these were confirmed (from UC6)
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add to history
        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        // Generate report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}