package com.corbinmcguire.corbinmcguire_homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.byox.drawview.views.DrawView;

public class DrawingBoard extends AppCompatActivity {

    private DrawView colorMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_board);

        /*
        Wire up all tools
         */
        Button returnButton = findViewById(R.id.returnButton);
        Button clearButton = findViewById(R.id.clearButton);
        Button colorPickerButton = findViewById(R.id.colorPickerButton);
        colorMe = findViewById(R.id.draw_view);

        /*
        Return to the main activity
         */
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawingBoard.this.finish();
            }
        });

        /*
        Takes user to custom drawing color screen
         */
        colorPickerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(DrawingBoard.this, PaintColorPicker.class));
            }

        });

        // Set the clear button to wipe the screen
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorMe.restartDrawing();
            }
        });

        // Set up functionality for drawView
        colorMe.setOnDrawViewListener(new DrawView.OnDrawViewListener() {
            @Override
            public void onStartDrawing() {
                // Get color from PaintColorPicker
                Intent receiveBrushColor = getIntent();
                int brushColor = receiveBrushColor.getIntExtra("rgbValues", 0);
                // Set the new brush color
                colorMe.setDrawColor(brushColor);

            }

            @Override
            public void onEndDrawing() {

            }

            @Override
            public void onClearDrawing() {

            }

            @Override
            public void onRequestText() {

            }

            @Override
            public void onAllMovesPainted() {

            }
        });

    }

}
