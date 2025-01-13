import java.util.Scanner;
import org.fusesource.jansi.Ansi;


public class ZoneTimeConverter {

    public static void main(String[] args) {
        System.out.println(Ansi.ansi().fgBrightMagenta().a("We only support KSA, USA, and Italy.").reset());
        Scanner user = new Scanner(System.in);

        // Input current hour and minute
        System.out.print("Enter your current hour (0-23): ");
        int hours = user.nextInt();

        System.out.print(Ansi.ansi().fgBrightCyan().a("Enter your current minute (0-59): ").reset());
        int minutes = user.nextInt();

        // Input for current location
        System.out.println("Your current location (1 = KSA, 2 = USA, 3 = Italy): ");
        int currentLocation = user.nextInt();

        // Input for target location
        System.out.println("Convert to location (1 = KSA, 2 = USA, 3 = Italy): ");
        int targetLocation = user.nextInt();

        int timeDifference = 0;

        // Calculate the time difference
        if (currentLocation == 1 && targetLocation == 2) { // KSA to USA
            timeDifference = -8;
        } else if (currentLocation == 1 && targetLocation == 3) { // KSA to Italy
            timeDifference = -2;
        } else if (currentLocation == 2 && targetLocation == 1) { // USA to KSA
            timeDifference = 8;
        } else if (currentLocation == 2 && targetLocation == 3) { // USA to Italy
            timeDifference = 6;
        } else if (currentLocation == 3 && targetLocation == 1) { // Italy to KSA
            timeDifference = 2;
        } else if (currentLocation == 3 && targetLocation == 2) { // Italy to USA
            timeDifference = -6;
        } else if (currentLocation == targetLocation) {
            System.out.println(Ansi.ansi().fgBrightCyan().a("The time is the same in the selected locations.").reset());
            return;
        } else {
            System.out.println("Invalid locations. Please enter 1 (KSA), 2 (USA), or 3 (Italy).");
            return;
        }

        // Final time based on the time difference
        int convertedHours = hours + timeDifference;
        //  converted time
        System.out.print(Ansi.ansi().fgBrightBlue().a("The converted time is: " + convertedHours + ":" + minutes).reset());
    }
}