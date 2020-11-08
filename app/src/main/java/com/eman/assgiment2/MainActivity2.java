package com.eman.assgiment2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static java.lang.Integer.*;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        TextView txtShowMass = findViewById(R.id.result);

        // String msg=intent.getStringExtra("data");
        String[] msg = intent.getStringArrayExtra("data");
        double result=getBMI(msg[1], msg[2]);
        String s = "  your BMI :" +String.format("%.3f",result)+" ";
        if(result != -1) {
            String state=getState(result);
            txtShowMass.setText("   Hello, " + msg[0] + " ^-^  \n  " + " your higth :" + msg[1] + "  meter .\n  " + " your weight :" + msg[2] + "  Kg . \n  " + " gender :" + msg[3] + ". \n  " +
                    s + ".\n  "+"  your State :" +state+  " .\n  ");
        }
        else { txtShowMass.setText("error : you shoud enter the full information ");}
    }
    private double getBMI(String higth,String weight){

        try {
            double h = Double.parseDouble(higth) /100;
            double w = Double.parseDouble(weight);
            if (h != 0) {
                return (w / (h * h));
            }
        }
        catch (Exception e){
            return -1;
        }
        return -1;
    }

    private String getState(double BMI){

        if ( BMI <= 19) {
            return " Underweight ";
        } else if ( 19 < BMI && BMI <= 25) {
            return " Normal";
        } else if ( 25 < BMI && BMI <= 30) {
            return " OverWeight";
        } else if ( BMI > 30) {
            return " Obese ";
        } else {
            throw new IllegalStateException("Unexpected value: " + BMI);

    }
}

    public void BackToFirstActivity(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("Timer","");
        startActivity(intent);
    }
}