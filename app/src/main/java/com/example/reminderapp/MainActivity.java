package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reminderapp.R;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Spinner spinner,spinner1;
    TextView result;
    Button button;
    EditText editText;
    HashMap<String,Integer> data=new HashMap<>();
    public void onButtonPress(View view){
        String extractTextFromUser=editText.getText().toString();
        if(extractTextFromUser.equals(null) || extractTextFromUser.equals("")){
            Toast.makeText(MainActivity.this, "Enter Amount", Toast.LENGTH_SHORT).show();
        }else {
            Double valueOfText = Double.parseDouble(extractTextFromUser);
            String currentCurrencyConversionRequest = spinner.getSelectedItem().toString();
            String currentCurrencyConversionInput= spinner1.getSelectedItem().toString();
            int input=data.get(currentCurrencyConversionInput);
            int output=data.get(currentCurrencyConversionRequest);
            Double resultValue = 1.2;


            if(input==0){  //convert rupees to desired currency
                if(output==0){
                    resultValue=valueOfText;
                }
                else if(output==1){
                    resultValue=valueOfText*0.014;
                }
                else if(output==2){
                    resultValue=valueOfText*1.42;
                }
                else if(output==3){
                    resultValue=valueOfText*0.011;
                }
                else if(output==4){
                    resultValue=valueOfText*0.010;
                }
                else if(output==5){
                    resultValue=valueOfText*0.050;
                }
                else{
                    resultValue=valueOfText*1.01;
                }
            }

            else if(input==1){  //convert us dollars to desired currency
                if(output==0){
                    resultValue=valueOfText*73.16;
                }
                else if(output==1){
                    resultValue=valueOfText;
                }
                else if(output==2){
                    resultValue=valueOfText*103.78;
                }
                else if(output==3){
                    resultValue=valueOfText*0.83;
                }
                else if(output==4){
                    resultValue=valueOfText*0.74;
                }
                else if(output==5){
                    resultValue=valueOfText*3.67;
                }
                else{
                    resultValue=valueOfText*73.56;
                }
            }

            else if(input==2){  //convert yen to desired currency
                if(output==0){
                    resultValue=valueOfText*0.70;
                }
                else if(output==1){
                    resultValue=valueOfText*0.0096;
                }
                else if(output==2){
                    resultValue=valueOfText;
                }
                else if(output==3){
                    resultValue=valueOfText*0.0080;
                }
                else if(output==4){
                    resultValue=valueOfText*0.0071;
                }
                else if(output==5){
                    resultValue=valueOfText*0.035;
                }
                else{
                    resultValue=valueOfText*0.71;
                }
            }

            else if(input==3){  //convert euro to desired currency
                if(output==0){
                    resultValue=valueOfText*88.38;
                }
                else if(output==1){
                    resultValue=valueOfText*1.21;
                }
                else if(output==2){
                    resultValue=valueOfText*125.68;
                }
                else if(output==3){
                    resultValue=valueOfText;
                }
                else if(output==4){
                    resultValue=valueOfText*0.89;
                }
                else if(output==5){
                    resultValue=valueOfText*4.44;
                }
                else{
                    resultValue=valueOfText*89.07;
                }
            }

            else if(input==4){  //convert pound to desired currency
                if(output==0){
                    resultValue=valueOfText*99.42;
                }
                else if(output==1){
                    resultValue=valueOfText*1.36;
                }
                else if(output==2){
                    resultValue=valueOfText*141.22;
                }
                else if(output==3){
                    resultValue=valueOfText*1.12;
                }
                else if(output==4){
                    resultValue=valueOfText;
                }
                else if(output==5){
                    resultValue=valueOfText*4.99;
                }
                else{
                    resultValue=valueOfText*100.15;
                }
            }

            else if(input==5){  //convert dirham to desired currency
                if(output==0){
                    resultValue=valueOfText*19.92;
                }
                else if(output==1){
                    resultValue=valueOfText*0.27;
                }
                else if(output==2){
                    resultValue=valueOfText*28.28;
                }
                else if(output==3){
                    resultValue=valueOfText*0.23;
                }
                else if(output==4){
                    resultValue=valueOfText*0.20;
                }
                else if(output==5){
                    resultValue=valueOfText;
                }
                else{
                    resultValue=valueOfText*20.09;
                }
            }

            else{  //convert russian rouble to desired currency
                if(output==0){
                    resultValue=valueOfText*0.99487;
                }
                else if(output==1){
                    resultValue=valueOfText*0.014;
                }
                else if(output==2){
                    resultValue=valueOfText*1.41;
                }
                else if(output==3){
                    resultValue=valueOfText*0.011;
                }
                else if(output==4){
                    resultValue=valueOfText*0.0100;
                }
                else if(output==5){
                    resultValue=valueOfText*0.050;
                }
                else{
                    resultValue=valueOfText;
                }
            }


            resultValue = Double.parseDouble(String.format("%.2f", resultValue));
            String resultValueInString ="Amount: "+ resultValue.toString();

            result.setVisibility(View.VISIBLE);
            result.setText(resultValueInString);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        spinner1=findViewById(R.id.spinner1);
        button=findViewById(R.id.button);
        result=findViewById(R.id.resultTextView);
        editText=findViewById(R.id.editText);

        ArrayAdapter<String> currencyAdapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.currencies));
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(currencyAdapter);
        spinner1.setAdapter(currencyAdapter);

        data.put("Rupees",0);
        data.put("US Dollars",1);
        data.put("Yen",2);
        data.put("Euro",3);
        data.put("Pound",4);
        data.put("Dirham",5);
        data.put("Russian Rouble",6);

    }

}