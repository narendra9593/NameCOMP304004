package com.name.COMP304_Assignment.Exercise1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.name.COMP304_Assignment.R;

public class Exercise1Activity extends AppCompatActivity {
    private Context mContext;
    private Resources mResources;
    private FrameLayout mFrameLayout;
    private Button mButton;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);

        // Get the application context
        mContext = getApplicationContext();

        // Get the Resources
        mResources = getResources();

        // Get the widgets reference from XML layout
        mFrameLayout = findViewById(R.id.frameLayout);
//        mButton = (Button) findViewById(R.id.btn);
//        mImageView = (ImageView) findViewById(R.id.iv);

        // Set a click listener for Button widget
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize a new Bitmap object
                Bitmap bitmap = Bitmap.createBitmap(
                        500, // Width
                        300, // Height
                        Bitmap.Config.ARGB_8888 // Config
                );

                // Initialize a new Canvas instance
                Canvas canvas = new Canvas(bitmap);

                // Draw a solid color on the canvas as background
                canvas.drawColor(Color.LTGRAY);

                // Initialize a new Paint instance to draw the line
                Paint paint = new Paint();
                // Line color
                paint.setColor(Color.RED);
                paint.setStyle(Paint.Style.STROKE);
                // Line width in pixels
                paint.setStrokeWidth(8);
                paint.setAntiAlias(true);

                // Set a pixels value to offset the line from canvas edge
                int offset = 50;

                /*
                    public void drawLine (float startX, float startY, float stopX, float stopY, Paint paint)
                        Draw a line segment with the specified start and stop x,y coordinates, using
                        the specified paint.

                        Note that since a line is always "framed", the Style is ignored in the paint.

                        Degenerate lines (length is 0) will not be drawn.

                    Parameters
                        startX : The x-coordinate of the start point of the line
                        startY : The y-coordinate of the start point of the line
                        paint : The paint used to draw the line

                */

                // Draw a line on canvas at the center position
                canvas.drawLine(
                        offset, // startX
                        canvas.getHeight() / 2, // startY
                        canvas.getWidth() - offset, // stopX
                        canvas.getHeight() / 2, // stopY
                        paint // Paint
                );

                // Display the newly created bitmap on app interface
                mImageView.setImageBitmap(bitmap);
            }
        });
    }
}
