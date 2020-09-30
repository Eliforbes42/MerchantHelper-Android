package ef.finderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.view.View;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.FinderApp.MESSAGE";
    //public static final String EXTRA_MESSAGE2 = "com.example.FinderApp.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.FinderApp.MESSAGE1";
    String[] outpostList = new String[]{
        "Ancient Spire Outpost", "Dagger Tooth Outpost",
        "Galleon's Grave Outpost", "Golden Sands Outpost",
        "Plunder Outpost", "Sanctuary Outpost"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner staticSpinner = (Spinner) findViewById(R.id.static_spinner);
        // Create an ArrayAdapter using the string array and a default spinner
        //ArrayAdapter<String> staticAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, outpostList);

        // Specify the layout to use when the list of choices appears
        //staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Apply adapter->spinner
        //staticSpinner.setAdapter(staticAdapter);

        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, outpostList);

        dynamicSpinner.setAdapter(adapter);
        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String res = parent.getItemAtPosition(position).toString();
                for(Location isle : DisplayMessageActivity.islandList.outposts){
                    if(res == isle.name)
                    {
                        EditText locale = (EditText) findViewById(R.id.editText);
                        locale.setText(isle.fullRowCol);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText editText = (EditText) findViewById(R.id.editText); //Location
        String message = editText.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.editText2);  //Animal Id's
        String message2 = editText2.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_MESSAGE2, message2);
        startActivity(intent);
    }

    public void needChicken(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String ids;
        boolean res;
        EditText idsEditText = (EditText)findViewById(R.id.editText2);
        if(res = (!idsEditText.getText().toString().matches("")))
            ids = idsEditText.getText().toString();
        else
            ids = "";

        if(!ids.contains("1") && res)//if animal not selected, add to selection
        {
            //if(res)//existing id-string, add comma
                ids = ids.concat(",1");

        }
        else if(!ids.contains("1") && !res)
            ids = ids.concat("1");
        if(res)
            intent.removeExtra(EXTRA_MESSAGE2);
        intent.putExtra(EXTRA_MESSAGE2, ids);
        idsEditText.setText(intent.getStringExtra(EXTRA_MESSAGE2));
    }
    public void needPig(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String ids;
        boolean res;
        EditText idsEditText = (EditText)findViewById(R.id.editText2);
        if(res = (!idsEditText.getText().toString().matches("")))
            ids = idsEditText.getText().toString();
        else
            ids = "";
        if(!ids.contains("2") && res)//if animal not selected, add to selection
        {
            //if(res)//existing id-string, add comma
            ids = ids.concat(",2");
        }
        else if(!ids.contains("2") && !res)
            ids = ids.concat("2");
        if(res)
            intent.removeExtra(EXTRA_MESSAGE2);
        intent.putExtra(EXTRA_MESSAGE2, ids);
        idsEditText.setText(intent.getStringExtra(EXTRA_MESSAGE2));
    }
    public void needSnek(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String ids;
        boolean res;
        EditText idsEditText = (EditText)findViewById(R.id.editText2);
        if(res = (!idsEditText.getText().toString().matches("")))
            ids = idsEditText.getText().toString();
        else
            ids = "";
        if(!ids.contains("3") && res)//if animal not selected, add to selection
        {
            //if(res)//existing id-string, add comma
            ids = ids.concat(",3");

        }
        else if(!ids.contains("3") && !res)
            ids = ids.concat("3");
        if(res)
            intent.removeExtra(EXTRA_MESSAGE2);
        intent.putExtra(EXTRA_MESSAGE2, ids);
        idsEditText.setText(intent.getStringExtra(EXTRA_MESSAGE2));
    }
    public void needGp(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String ids;
        boolean res;
        EditText idsEditText = (EditText)findViewById(R.id.editText2);
        if(res = (!idsEditText.getText().toString().matches("")))
            ids = idsEditText.getText().toString();
        else
            ids = "";
        if(!ids.contains("4") && res)//if animal not selected, add to selection
        {
            //if(res)//existing id-string, add comma
            ids = ids.concat(",4");

        }
        else if(!ids.contains("4") && !res)
            ids = ids.concat("4");
        if(res)
            intent.removeExtra(EXTRA_MESSAGE2);
        intent.putExtra(EXTRA_MESSAGE2, ids);
        idsEditText.setText(intent.getStringExtra(EXTRA_MESSAGE2));
    }
}
