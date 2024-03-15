import java.util.*;

// Movie class to represent each movie
class Movie {
    private String title;
    private String description;
    private int availableSeats;

    public Movie(String title, String description, int availableSeats) {
        this.title = title;
        this.description = description;
        this.availableSeats = availableSeats;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        } else {
            System.out.println("Sorry, no available seats for this movie.");
        }
    }
}

// Theater class to manage movies and bookings
class Theater {
    private List<Movie> movies;

    public Theater() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void displayMovies() {
        System.out.println("Available Movies:");
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            System.out.println((i + 1) + ". " + movie.getTitle());
        }
    }

    public void displayMovieDetails(int index) {
        Movie movie = movies.get(index);
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Description: " + movie.getDescription());
        System.out.println("Available Seats: " + movie.getAvailableSeats());
    }

    public boolean bookTicket(int movieIndex) {
        if (movieIndex >= 0 && movieIndex < movies.size()) {
            Movie selectedMovie = movies.get(movieIndex);
            selectedMovie.bookSeat();
            return true;
        } else {
            System.out.println("Invalid movie selection.");
            return false;
        }
    }
}

// Main class to drive the program
public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Theater theater = new Theater();

        // Add sample movies
        theater.addMovie(new Movie("ADIPURUSH", "SPIRITUAL", 100));
        theater.addMovie(new Movie("KASHMIR_FILES", "REALITY", 80));
        theater.addMovie(new Movie("SPECIAL_OPS", "THRILL", 120));

        // Display available movies
        theater.displayMovies();

        // User selects a movie
        System.out.println("Enter the number of the movie you want to watch:");
        int selectedMovieIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        theater.displayMovieDetails(selectedMovieIndex);

        // Book tickets
        System.out.println("Do you want to book a ticket? (Y/N)");
        String choice = scanner.nextLine().toUpperCase();
        if (choice.equals("Y")) {
            if (theater.bookTicket(selectedMovieIndex)) {
                System.out.println("Ticket booked successfully!");
            } else {
                System.out.println("Ticket booking failed.");
            }
        } else {
            System.out.println("Thank you for visiting!");
        }

        scanner.close();
    }
}
