import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String roomType;
    boolean isBooked;

    Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isBooked = false;
    }
}

class Booking {
    String customerName;
    int roomNumber;

    Booking(String customerName, int roomNumber) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Add Rooms
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));

        while (true) {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();

                    bookRoom(name, roomNo);
                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel: ");
                    int cancelRoom = sc.nextInt();

                    cancelReservation(cancelRoom);
                    break;

                case 4:
                    viewBookings();
                    break;

                case 5:
                    System.out.println("Thank You For Using Hotel Reservation System");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void viewRooms() {

        System.out.println("\nRoom No\tType\t\tStatus");

        for (Room room : rooms) {

            String status;

            if (room.isBooked) {
                status = "Booked";
            } else {
                status = "Available";
            }

            System.out.println(room.roomNumber + "\t" +
                    room.roomType + "\t\t" + status);
        }
    }

    static void bookRoom(String customerName, int roomNumber) {

        for (Room room : rooms) {

            if (room.roomNumber == roomNumber) {

                if (!room.isBooked) {

                    room.isBooked = true;

                    bookings.add(new Booking(customerName, roomNumber));

                    System.out.println("Booking Successful!");
                } else {

                    System.out.println("Room Already Booked!");
                }

                return;
            }
        }

        System.out.println("Room Not Found!");
    }

    static void cancelReservation(int roomNumber) {

        for (Room room : rooms) {

            if (room.roomNumber == roomNumber) {

                if (room.isBooked) {

                    room.isBooked = false;

                    bookings.removeIf(
                            booking -> booking.roomNumber == roomNumber);

                    System.out.println("Reservation Cancelled!");
                } else {

                    System.out.println("Room is not booked.");
                }

                return;
            }
        }

        System.out.println("Room Not Found!");
    }

    static void viewBookings() {

        if (bookings.isEmpty()) {

            System.out.println("No Bookings Found!");
            return;
        }

        System.out.println("\nCustomer Name\tRoom Number");

        for (Booking booking : bookings) {

            System.out.println(booking.customerName +
                    "\t\t" + booking.roomNumber);
        }
    }
}