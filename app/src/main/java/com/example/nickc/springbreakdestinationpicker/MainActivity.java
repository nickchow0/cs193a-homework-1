package com.example.nickc.springbreakdestinationpicker;

import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void continent (View view) {
        ListView list = (ListView) findViewById(R.id.listView);

        if (view.getId() == R.id.AfricaButton){
            readFromTextFile(list, "africa.txt");
        }
        else if (view.getId() == R.id.AsiaButton) {
            readFromTextFile(list, "asia.txt");
        }
        else if (view.getId() == R.id.OceaniaButton) {
            readFromTextFile(list, "oceania.txt");
        }
        else if (view.getId() == R.id.EuropeButton) {
            readFromTextFile(list, "europe.txt");
        }
        else if (view.getId() == R.id.NAButton) {
            readFromTextFile(list, "northAmerica.txt");
        } else {
            readFromTextFile(list, "southAmerica.txt");
        }
    }

    public void readFromTextFile(ListView list, String file) {
        try
        {
            AssetManager am = getAssets();
            InputStream is = am.open(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            List<String> countries = new ArrayList<String>();
            String line;
            while ((line = reader.readLine()) != null) {
                countries.add(line);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, countries);
            // Assign adapter to ListView
            list.setAdapter(adapter);
        }
        catch (Exception e)
        {
            Toast.makeText(this, "file not found", Toast.LENGTH_SHORT).show();
        }
    }
}
