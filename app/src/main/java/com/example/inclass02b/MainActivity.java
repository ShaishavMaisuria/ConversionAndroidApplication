package com.example.inclass02b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userValue=findViewById(R.id.editTextNumberSigned);
        TextView convertedValue=findViewById(R.id.textViewConvert);

        radioGroup= findViewById(R.id.radioGroup);
        findViewById(R.id.buttonConvert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedID = radioGroup.getCheckedRadioButtonId();
                if(checkedID==R.id.radioButtonToMeters){
                    try {
                        Double convertedMeters = Double.parseDouble(userValue.getText().toString()) * 0.0254;
                        convertedValue.setText(String.valueOf(convertedMeters) + new String(" Meters"));
                    }catch (Exception e){
                        userValue.setText(new String(""));
                        convertedValue.setText(new String("Please enter Valid Number"));
                        }
                }else if(checkedID==R.id.radioButtonToFeet){
                    try{
                    Double convertedMeters=Double.parseDouble( userValue.getText().toString()) * 0.083333;
                    convertedValue.setText(String.valueOf(convertedMeters)+new String(" Feet"));
                }catch (Exception e){

                    userValue.setText(new String(""));
                    convertedValue.setText(new String("Please enter Valid Number"));
                }
                }else if(checkedID==R.id.radioButtonToMiles){
                        try{
                    Double convertedMeters=Double.parseDouble( userValue.getText().toString()) * 0.00001578;
                    convertedValue.setText(String.valueOf(convertedMeters)+new String(" Miles"));
            }catch (Exception e){
                userValue.setText(new String(""));
                convertedValue.setText(new String("Please enter Valid Number"));
            }
                }else if(checkedID==R.id.radioButtonClearAll){
                        try{
                    userValue.setText(new String(""));
                    convertedValue.setText(new String(""));
        }catch (Exception e){
            userValue.setText(new String(""));
            convertedValue.setText(new String("Please enter Valid Number"));
        }
                }
            }
        });
    }
}