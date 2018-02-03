package com.example.slmns.beeradviser;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends Activity {
    BeerExpert beerExpert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

    }


    // Call when user clicks the button
    public void OnClickFindBeer(View view) {

        // Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);

        // Get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        // Get the selected item in the spinner
        String BeerType = String.valueOf(color.getSelectedItem());

        // Display the selected item
       // brands.setText(BeerType); DELETE IF YOU WANT

        // Get recommendations from BeerExpert class
        List<String> brandList = beerExpert.getBrands(BeerType);

        StringBuilder brandsFormatted = new StringBuilder();

        for (String brand : brandList) {
            brandsFormatted.append(brand).append('\n');
            // Build a string displaying each brand on a new line.
            // BuildString allow you to save and display more than one string.
        }

        // Display the Beers

        brands.setText(brandsFormatted);

        Log.d("MINE", "Clicked on FindBeer Button");

    }
}
