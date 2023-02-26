import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        //exits created for each location object to create acceptable pathways from location to location

        locations.get(1).addExit("W", 2); //since location 1 is the start, can go anywhere
        //note that the key is a string and returns a value of an int which java will read as the new location
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
//        locations.get(1).addExit("Q", 0);
        //to avoid redundancy, all "Q", 0 key/value pairs have been removed and instead created as part of the map for
        //each Location instance when the instance is created
        //note this is interesting what the entire instance and is retrieved AND its map is retrieved, NEITHER of which
        //have a variable name. This could be useful for the EMR project both with organizing and with traversing the EMR
        //as a user

        locations.get(2).addExit("N", 5); //not bi-directional, must go north
//        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
//        locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
//        locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
//        locations.get(5).addExit("Q", 0);

        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits(); // this returns a copy of the exits map
            // for each Location instance
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) { //for loop prints all available exists within the Location instance's map
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase(); //user states direction they want to go

            if(exits.containsKey(direction)) { //if the copy of the Location instance's map contains the user input
                loc = exits.get(direction); // cardinal direction is the key and returns the key's value, which is an int

                //now that 'loc' int variable is redefined, we go back to the top of the loop, use the loc value to search
                //the 'locations' map for the int type key, then retrieve the instance of Location associated with that key
                // and get its field value for description

            } else {
                System.out.println("You cannot go in that direction");
            }
        }

    }
}
