package com.example.roomie.LocalDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationsDB {

    private static List<String> locations = new ArrayList<>();

    static {
        locations.add("Location: Joburg\nArea: Newtown\nBuilding name: Central");
        locations.add("Location: PTA\nArea: Hatfield\nBuilding name: North");
        locations.add("Location: CPT\nArea: Camps Bay\nBuilding name: North");
        locations.add("Location: Joburg\nArea: Braam\nBuilding name: West");
    }

    public static List<String> getArea(String location){
        if(location.equals("PTA")){
            return Arrays.asList("Hatfield", "Centurion", "Temba");
        } else if(location.equals("CPT")){
            return Arrays.asList("Camps Bay", "Hout Bay", "Sea Point");
        }
        return Arrays.asList("Newtown", "Braam", "Marshaltown");
    }

    public static void addUserLocation(String location){
        locations.add(location);
    }

    public static List<String> getUserLocations(){
        return locations;
    }

}
