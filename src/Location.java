import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
//        this.exits = exits;
        if (exits != null) { //this prevents a null pointer exception, were a 'null' value to be passed as argumnet for Map
            // which would crash the program at runtime if  constructor did not account for possibility of null as map value
            this.exits = new HashMap<String, Integer>(exits);
        } else {
            this.exits = new HashMap<>(); //if null, creates map with no content
        }
        //map is now a passed parameter in constructor method
        this.exits.put("Q", 0);
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
