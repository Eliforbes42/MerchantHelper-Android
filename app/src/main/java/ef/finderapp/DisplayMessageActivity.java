package ef.finderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DisplayMessageActivity extends AppCompatActivity {
    boolean tryParseInt(String val){
        try{
            Integer.parseInt(val);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static Islands islandList = Islands.getInstance(); //use Singleton

    public String HasAnimals(String animalIds, String userLocation){
        String[] ids = animalIds.split(",");
        ArrayList<Integer> choices = new ArrayList<Integer>(ids.length);
        ArrayList<Location> possibilities = new ArrayList<>();
        int parseVal = 0;
        for (String cmd : ids)
        {
            if(tryParseInt(cmd)) {
                parseVal = Integer.parseInt(cmd);
                choices.add(parseVal);
            }
        }

        for (Location isle : islandList.locations) {
            switch (ids.length) {
                case 1:
                    if (isle.HasAnimal(AnimalFactory.getAnimal(choices.get(0))))
                        possibilities.add(isle);
                    break;
                case 2:
                    if (isle.HasAnimal(AnimalFactory.getAnimal(choices.get(0)))
                            && isle.HasAnimal(AnimalFactory.getAnimal(choices.get(1))))
                        possibilities.add(isle);
                    break;
                case 3: //New - Unstable/Unreliable -vvvvvvvvvvvvvvvvvvvvv//
                    if (isle.HasAnimal(AnimalFactory.getAnimal(choices.get(0)))
                        && isle.HasAnimal(AnimalFactory.getAnimal(choices.get(1))))
                    possibilities.add(isle);
                    break;
                default: break; //unsupported #
            }
        }
        //return false;
        String newUserLocation;
        if ('a' <= userLocation.charAt(0) && userLocation.charAt(0) <= 'z')
            newUserLocation = Character.toString((char)(userLocation.charAt(0) - 'a' + 'A'))
                    + userLocation.substring(1); //handle lowerCase
        else newUserLocation = userLocation;

        int curRow = (userLocation.charAt(0) - 'A');
        int curCol = 0;
        double dist = 0.0,
                minDist = Double.MAX_VALUE-1;
        Location junk, extra;
        if(tryParseInt(userLocation.substring(1))) {
            curCol = Integer.parseInt(userLocation.substring(1));
        }//int.TryParse(userLocation.substring(1), out curCol);
        Map<Double, Location> distances = new HashMap<Double, Location>();
        for (Location poss : possibilities){
            dist = Math.sqrt(Math.pow((poss.row - curRow), 2) + Math.pow((poss.col - curCol), 2));
            if (dist < minDist)
                minDist = dist;
            if (!distances.containsKey(dist))
                distances.put(dist,poss);
        }
        if (distances.containsKey(minDist))
        {
            if(ids.length != 3) //if nothing left to process
                return (distances.get(minDist).name + " - " + distances.get(minDist).fullRowCol);
            else{
                extra = distances.get(minDist);
                String newAnimalIds = animalIds.substring(4); //1,2,3
                return (extra.name + " - " + extra.fullRowCol) + "\n" + HasAnimals(newAnimalIds, extra.fullRowCol);
            }
        }
        else
            return null;
    }

    public String HasGp(String curLocale)
    {
        int curRow = (curLocale.charAt(0) - 'A');
        int curCol = 0;
        double dist = 0.0,
                minDist = Double.MAX_VALUE - 1;
        Fort junk, minDistFort = null;

        if(tryParseInt(curLocale.substring(1)))
            curCol = Integer.parseInt(curLocale.substring(1));

        Map<Double, Fort> distances = new HashMap<Double, Fort>();

        for (Fort poss : islandList.forts)
        {
            dist = Math.sqrt(Math.pow((poss.row - curRow), 2) + Math.pow((poss.col - curCol), 2));
            if (dist < minDist)
            {
                minDist = dist;
                minDistFort = poss;
            }
            if (!distances.containsKey(dist))
                distances.put(dist, poss);
        }

        return (minDistFort.name + " - " + minDistFort.fullRowCol);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Get the Intent that initiated activity - extract string
        Intent intent = getIntent();
        String locale = intent.getStringExtra(MainActivity.EXTRA_MESSAGE); //get Locale input
        String animalIds = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2); //get Animals Input

        boolean needGP = false;

        if(animalIds.contains(",4")){ //case: middle || last item
            needGP = true; //check ",4" first because "4" is sub-case
            animalIds = animalIds.replace(",4", "");
        }
        else if(animalIds.contains("4,")){ //case: first item
            needGP = true;
            animalIds = animalIds.replace("4,", "");
        }
        else if(animalIds.contains("4")){ //case: only item
            needGP = true;
            animalIds = animalIds.replace("4", "");
        }//remove 4||,4||4, from string -- not valid animal id

        String res = HasAnimals(animalIds, locale);
        //Capture the layout's TextView --> Set text to message String
        TextView textView = findViewById(R.id.textView3);
        textView.setText("-Closest island-\n"+res);


        if(needGP){
            TextView gpView = findViewById(R.id.textViewGP);
            String gpRes = HasGp(locale);
            gpView.setText("-Closest fort-\n" + gpRes); //pre-formatted in HasGp()
        }
    }
}
