package com.name.COMP304_Assignment.Exercise1;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.name.COMP304_Assignment.CustomArrayAdapter;
import com.name.COMP304_Assignment.R;

import java.util.ArrayList;
import java.util.List;

public class Exercise1Activity extends AppCompatActivity implements View.OnClickListener {

    private String lineStroke = null;
    private String colorCode;
    private Button btnTop, btnBottom, btnRight, btnLeft, btnClear;
    private CanvasView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        init();
        setLineStrokeSpinner();
        setRadioGroupData();

    }

    private void init() {
        customCanvas = findViewById(R.id.canvas);
        btnTop = findViewById(R.id.btnTop);
        btnTop.setOnClickListener(this);
        btnBottom = findViewById(R.id.btnBottom);
        btnBottom.setOnClickListener(this);
        btnLeft = findViewById(R.id.btnLeft);
        btnLeft.setOnClickListener(this);
        btnRight = findViewById(R.id.btnRight);
        btnRight.setOnClickListener(this);
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }

    private void setRadioGroupData() {
        RadioGroup radioGroupColor = findViewById(R.id.radioGroupColor);

        radioGroupColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.radioRed) {
                    colorCode = "#FF0000";
                } else if (checkedId == R.id.radioGreen) {
                    colorCode = "#008000";
                } else if (checkedId == R.id.radioPink) {
                    colorCode = "#FFC0CB";
                }
            }
        });
    }

    private void setLineStrokeSpinner() {
        List<String> strExerciseList = new ArrayList<>();
        strExerciseList.add("8");
        strExerciseList.add("10");
        strExerciseList.add("15");
        strExerciseList.add("18");
        strExerciseList.add("20");
        Spinner spinnerOfferType = findViewById(R.id.spinnerLineStroke);
        CustomArrayAdapter adapter = new CustomArrayAdapter(this,
                R.layout.spinneritem, strExerciseList);
        spinnerOfferType.setAdapter(adapter);
        spinnerOfferType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lineStroke = ((TextView) view.findViewById(R.id.offer_type_txt)).getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        Paint mPaint=new Paint();
        switch (v.getId()) {
            case R.id.btnRight:
                mPaint.setColor(Color.parseColor(colorCode));
                mPaint.setStyle(Paint.Style.STROKE);
                // Line width in pixels
                mPaint.setStrokeWidth(Float.parseFloat(lineStroke));
                customCanvas.drawLineCanvas(mPaint,0,0,10,10);
                break;
            case R.id.btnLeft:
                break;
            case R.id.btnTop:
                break;
            case R.id.btnBottom:
                break;
            case R.id.btnClear:
                customCanvas.clearCanvas();
                break;
            default:
                break;
        }
    }



}
