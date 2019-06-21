package com.name.COMP304_Assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.name.COMP304_Assignment.Exercise1.Exercise1Activity;
import com.name.COMP304_Assignment.Exercise2.Exercise2Activity;
import com.name.COMP304_Assignment.Exercise3.Exercise3Activity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private boolean userIsInteracting;
    private int check = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<String> strExerciseList = new ArrayList<>();
        strExerciseList.add("Exercise 1");
        strExerciseList.add("Exercise 2");
        strExerciseList.add("Exercise 3");

        Spinner spinnerOfferType = findViewById(R.id.spinnerOfferType);
        CustomArrayAdapter adapter = new CustomArrayAdapter(this,
                R.layout.spinneritem, strExerciseList);
        spinnerOfferType.setAdapter(adapter);
        spinnerOfferType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
               /* String item = ((TextView)view.findViewById(R.id.offer_type_txt)).getText().toString();
                selectedOffer.setText(item);*/
//                if(++check > 1) {
                    Intent intent = null;
                    switch (pos) {
                        case 0:
                            intent = new Intent(MainActivity.this, Exercise1Activity.class);
                            break;
                        case 1:
                            intent = new Intent(MainActivity.this, Exercise2Activity.class);
                            break;
                        case 2:
                            intent = new Intent(MainActivity.this, Exercise3Activity.class);
                            break;
                        default:
                            intent = new Intent(MainActivity.this, Exercise1Activity.class);
                            break;
                    }
                    startActivity(intent);
//                }
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

   /* @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        userIsInteracting = true;
    }*/
}
