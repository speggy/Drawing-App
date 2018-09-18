package com.corbinmcguire.corbinmcguire_homework1;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.graphics.Color.green;
import static android.graphics.Color.rgb;

public class PaintColorPicker extends AppCompatActivity {

    Button colorPickerBackButton;
    SeekBar redSeekBar;
    SeekBar greenSeekBar;
    SeekBar blueSeekBar;
    TextView colorView;
    TextView redTextView;
    TextView greenTextView;
    TextView blueTextView;

    int redValue;
    int greenValue;
    int blueValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_color_picker);

        /*
        Wire up all tools
         */
        colorPickerBackButton = findViewById(R.id.colorPickerBackButton);
        redSeekBar = findViewById(R.id.redSeekBar);
        greenSeekBar = findViewById(R.id.greenSeekBar);
        blueSeekBar = findViewById(R.id.blueSeekBar);
        colorView = findViewById(R.id.colorView);
        redTextView = findViewById(R.id.redTextView);
        greenTextView = findViewById(R.id.greenTextView);
        blueTextView = findViewById(R.id.blueTextView);

        /*
        Wire up the back button for the color picker.
        //TODO Figure out a way to keep the selected color between activities
         */
        colorPickerBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaintColorPicker.this.finish();
            }
        });

        /*
        Code for the red seek bar
         */
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                redTextView.setText("RED: " + redSeekBar.getProgress());
                redSeekBar.setMax(255);
                redValue = redSeekBar.getProgress();
                setColorViewColor(redValue, greenValue, blueValue, colorView);
            }
        });

        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                greenTextView.setText("GREEN: " + greenSeekBar.getProgress());
                greenSeekBar.setMax(255);
                greenValue = greenSeekBar.getProgress();
                setColorViewColor(redValue, greenValue, blueValue, colorView);
            }
        });

        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                blueTextView.setText("BLUE: " + blueSeekBar.getProgress());
                blueSeekBar.setMax(255);
                blueValue = blueSeekBar.getProgress();
                setColorViewColor(redValue, greenValue, blueValue, colorView);
            }
        });

    }
    public void setColorViewColor(int redValue, int greenValue, int blueValue, TextView colorView)
    {
        // reflect the color chosen by the user.
        colorView.setBackgroundColor(rgb(redValue, greenValue, blueValue));

        // pass the chosen color to the brush to be drawn
        Intent passColor = new Intent();
        passColor.putExtra("rgbValues", rgb(redValue, greenValue, blueValue));
    }
}
