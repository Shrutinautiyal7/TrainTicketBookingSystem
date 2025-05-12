import java.util.*;

class Train {
    int trainNumber;
    String trainName;
    String source;
    String destination;
    int availableSeats;

    public Train(int trainNumber, String trainName, String source, String destination, int availableSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public void displayTrain() {
        System.out.println("Train No: " + trainNumber + ", Name: " + trainName +
                ", From: " + source + " To: " + destination +
                ", Available Seats: " + availableSeats);
    }
}

class Booking {
    String passengerName;
    int trainNumber;

    public Booking(String passengerName, int trainNumber) {
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
    }

    public void displayBooking() {
        System.out.println("Passenger: " + passengerName + ", Train No: " + trainNumber);
    }
}

public class TrainTicketBookingSystem {
    static ArrayList<Train> trains = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some sample trains
        trains.add(new Train(101, "Express A", "CityX", "CityY", 5));
        trains.add(new Train(102, "Express B", "CityY", "CityZ", 3));
        trains.add(new Train(103, "Express C", "CityX", "CityZ", 10));

        int choice;
        do {
            System.out.println("\n--- Train Ticket Booking System ---");
            System.out.println("1. View Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewTrains();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    public static void viewTrains() {
        System.out.println("\n--- Available Trains ---");
        for (Train train : trains) {
            train.displayTrain();
        }
    }

    public static void bookTicket() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter Train Number to book: ");
        int trainNo = sc.nextInt();
        sc.nextLine(); // consume newline

        for (Train train : trains) {
            if (train.trainNumber == trainNo) {
                if (train.availableSeats > 0) {
                    train.availableSeats--;
                    bookings.add(new Booking(name, trainNo));
                    System.out.println("Ticket booked successfully!");
                } else {
                    System.out.println("Sorry, no seats available on this train.");
                }
                return;
            }
        }
        System.out.println("Train not found.");
    }

    public static void viewBookings() {
        System.out.println("\n--- Booked Tickets ---");
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (Booking booking : bookings) {
                booking.displayBooking();
            }
        }
    }
}
