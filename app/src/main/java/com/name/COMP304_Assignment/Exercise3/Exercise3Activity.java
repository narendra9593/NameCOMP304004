package com.name.COMP304_Assignment.Exercise3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

public class Exercise3Activity extends AppCompatActivity {

    private Exercise3Animation mrunner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startAnimation();
    }

    @Override
    public void onPause() {
        super.onPause();
        // Stop animation if going into background
        mrunner.stopLooper();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Resume animation
        startAnimation();
    }

    // Method to start the animation

    private void startAnimation(){
        // Instantiate the class MotionRunner to define the entry screen display
        mrunner = new Exercise3Animation(this);
        mrunner.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(mrunner);
    }
}
