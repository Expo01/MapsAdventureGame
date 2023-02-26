import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();
    //locations map accepts Location instance as value, consisting of locationID and description

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        //note autoboxing of Integer
        //new location generated
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

      //while the Location class has a map of exits, not key/values have been put into the map. this content only loops
        // through the locations created in the 'locations' map. The result is that we can go directly from any location,
        //to any location, which doesn't reflect real life where areas between areas must be traversed and some ways you
        //aren't allowed backwards like airport security
        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) {
                break;
            }

            loc = scanner.nextInt();
            if(!locations.containsKey(loc)) {
                System.out.println("You cannot go in that direction");
            }
        }

    }
}
