package ef.finderapp;

import java.util.ArrayList;
import java.util.Arrays;

public class Islands {
    private static Islands theInstance = null;
    public Fort[] forts;
    public Location[] locations;
    public Location[] outposts;
    //private Islands Constructor - called from getInstance()
    private Islands() {
        forts = new Fort[]
                {
                        new Fort('K',9, "Hidden Spring Keep"), new Fort('C',7, "Keel Haul Fort"),
                        new Fort('O',6,"Kraken Watchtower"), new Fort('J',21,"Lost Gold Fort"),
                        new Fort('P',17,"Old Boot Fort"), new Fort('U',5,"Shark Fin Camp"),
                        new Fort('E',17,"Sailor's Knot Stronghold"), new Fort('U',11,"Skull Keep"),
                        new Fort('S',22,"The Crow's Nest Fortress")
                };
        locations = new Location[]
                {
                        new Location('T', 19, "Barnacle Cay", new ArrayList<Animal>( Arrays.asList(new Chicken())) ),
                        new Location('T', 3, "Black Sands Atoll", new ArrayList<Animal>(Arrays.asList( new Snek())) ),
                        new Location('X', 5, "Black Water Enclave", new ArrayList<Animal>(Arrays.asList(new Chicken())) ),
                        new Location('S', 6, "Blind Man's Lagoon", new ArrayList<Animal>(Arrays.asList(new Pig())) ),
                        new Location('N', 25, "Booty Location", new ArrayList<Animal>(Arrays.asList(new Snek())) ),
                        new Location('H', 5, "Boulder Cay", new ArrayList<Animal>(Arrays.asList(new Pig())) ),

                        new Location('H', 11, "Cannon Cove", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Pig())) ),
                        new Location('M', 16, "Castaway Isle", new ArrayList<Animal>(Arrays.asList(new Snek())) ),
                        new Location('K', 19, "Chicken Isle", new ArrayList<Animal>(Arrays.asList(new Chicken())) ),
                        new Location('B', 10, "Crescent Isle", new ArrayList<Animal>(Arrays.asList(new Pig(), new Snek())) ),
                        new Location('Q', 19, "Crook's Hollow", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Snek())) ),
                        new Location('Q', 22, "Cutlass Cay", new ArrayList<Animal>(Arrays.asList(new Snek())) ),

                        new Location('U', 24, "Devil's Ridge", new ArrayList<Animal>(Arrays.asList(new Pig(), new Snek())) ),
                        new Location('E', 21, "Discovery Ridge", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Snek())) ),

                        new Location('K', 17, "Fools Lagoon", new ArrayList<Animal>(Arrays.asList(new Pig())) ),

                        new Location('S', 10, "Isle of Last Words", new ArrayList<Animal>(Arrays.asList(new Snek())) ),

                        new Location('X', 15, "Kraken's Fall", new ArrayList<Animal>(Arrays.asList(new Pig(), new Snek())) ),

                        new Location('D', 15, "Lagoon of Whispers", new ArrayList<Animal>(Arrays.asList(new Snek())) ),
                        new Location('Y', 13, "Liar's Backbone", new ArrayList<Animal>(Arrays.asList(new Snek())) ),
                        new Location('J', 6, "Lone Cove", new ArrayList<Animal>(Arrays.asList(new Pig(), new Snek())) ),
                        new Location('I', 9, "Lonely Isle", new ArrayList<Animal>(Arrays.asList(new Snek())) ),
                        new Location('L', 25, "Lookout Point", new ArrayList<Animal>(Arrays.asList(new Pig())) ),

                        new Location('V', 3, "Marauder's Arch", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Snek())) ),
                        new Location('B', 16, "Mermaid's Hideaway", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Pig())) ),
                        new Location('R', 24, "Mutineer Rock", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Pig())) ),

                        new Location('Q', 4, "Old Faithful Isle", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Pig())) ),
                        new Location('G', 23, "Old Salts Atoll", new ArrayList<Animal>(Arrays.asList(new Chicken())) ),

                        new Location('O', 21, "Paradise Spring", new ArrayList<Animal>(Arrays.asList(new Pig())) ),
                        new Location('K', 4, "Picaroon Palms", new ArrayList<Animal>(Arrays.asList(new Snek())) ),
                        new Location('V', 6, "Plunderer's Plight", new ArrayList<Animal>(Arrays.asList(new Pig())) ),
                        new Location('H', 19, "Plunder Valley", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Pig())) ),

                        new Location('D', 9, "Rapier Cay", new ArrayList<Animal>(Arrays.asList(new Chicken())) ),
                        new Location('J', 11, "Rum Runner Isle", new ArrayList<Animal>(Arrays.asList(new Pig())) ),

                        new Location('B', 4, "Sailor's Bounty", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Pig())) ),
                        new Location('I', 3, "Salty Sands", new ArrayList<Animal>(Arrays.asList(new Chicken())) ),
                        new Location('D', 5, "Sandy Shallows", new ArrayList<Animal>(Arrays.asList(new Snek())) ),
                        new Location('N', 4, "Scurvy Location", new ArrayList<Animal>(Arrays.asList(new Chicken())) ),
                        new Location('B', 13, "Sea Dog's Rest", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Pig()))  ),
                        new Location('I', 24, "Shark Bait Cove", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Pig())) ),
                        new Location('U', 15, "Shark Tooth Key", new ArrayList<Animal>(Arrays.asList(new Chicken()))  ),
                        new Location('Q', 12, "Shipwreck Bay", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Pig())) ),
                        new Location('V', 13, "Shiver Retreat", new ArrayList<Animal>(Arrays.asList(new Chicken())) ),
                        new Location('F', 3, "Smuggler's Bay", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Snek())) ),
                        new Location('N', 19, "Snake Location", new ArrayList<Animal>(Arrays.asList(new Pig(), new Snek())) ),

                        new Location('T', 13, "The Crooked Masts", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Snek())) ),
                        new Location('T', 8, "The Sunken Grove", new ArrayList<Animal>(Arrays.asList(new Pig(), new Snek())) ),
                        new Location('P', 25, "Thieves Haven", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Pig())) ),
                        new Location('W', 11, "Tri-Rock Isle", new ArrayList<Animal>(Arrays.asList(new Chicken())) ),
                        new Location('I', 11, "Twin Groves", new ArrayList<Animal>(Arrays.asList(new Chicken())) ),

                        new Location('G', 15, "Wanderer's Refuge", new ArrayList<Animal>(Arrays.asList(new Chicken(), new Snek())))
                };
        outposts = new Location[]
                {
                        new Location('V', 21, "Ancient Spire Outpost", null ),
                        new Location('Q', 8, "Dagger Tooth Outpost", null ),
                        new Location('X', 9, "Galleon's Grave Outpost", null ),
                        new Location('D', 12, "Golden Sands Outpost", null ),
                        new Location('M', 22, "Plunder Outpost", null ),
                        new Location('G', 7, "Sanctuary Outpost", null ),
                };
    }

    //static method to get the instance
    public static Islands getInstance(){
        if(theInstance == null)
            theInstance = new Islands();

        return theInstance;
    }
}
