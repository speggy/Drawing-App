package com.corbinmcguire.corbinmcguire_homework1;

import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.lang.Object.*;


import java.util.Random;

import static android.graphics.Color.rgb;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Wire up all tools
         */
        final Button changeColorButton = findViewById(R.id.changeColorButton);
        final Button canvasButton = findViewById((R.id.canvasButton));
        final EditText changeColorText = findViewById(R.id.colorChangeTextField);
        final TextView showColor = findViewById(R.id.showColor);

        /*
        Color Changer Button functionality
         */
        changeColorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Random rndColor = new Random();
                // Generate random values for RGB
                int r = rndColor.nextInt(256);
                int g = rndColor.nextInt(256);
                int b = rndColor.nextInt(256);

                changeColorText.setTextColor(rgb(r,g,b)); // Change the text color from the random values
                String hex = String.format("#%02X%02X%02X", r, g,b); // Convert the RGB values to a hex value
                showColor.setText("COLOR: " + r + "r, " + g + "g, " + b + "b, " + hex); // Display the color codes
            }
        });

        /*
        Takes user the drawing board activity
         */
        canvasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DrawingBoard.class));
            }
        });



    }
}
