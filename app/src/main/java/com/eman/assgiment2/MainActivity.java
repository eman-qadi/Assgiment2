package com.eman.assgiment2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.InspectableProperty;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String NAME="NAME";
    public static final String HIGTH="HIGTH";
    public static final String WEIGHT="WEIGHT";
    public static final String GENDER="GENDER";

    private EditText name;
    private EditText higth;
    private EditText weight;
    private Spinner gender;

    // to save data
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name =findViewById(R.id.nameAnser);
        higth=findViewById(R.id.higthawnser);
        weight=findViewById(R.id.weigthAwnser2);
        gender=findViewById(R.id.spinner);

        setupSharedPrefs();
        checkPrefs();
    }
    private void checkPrefs() {

            String Name=preferences.getString(NAME,"");
            String Higth=preferences.getString(HIGTH,"");
            String Weight=preferences.getString(WEIGHT,"");
            String Gender=preferences.getString(GENDER,"");
            if(Gender.equals("male")) {
                name.setText(Name);
                higth.setText(Higth);
                weight.setText(Weight);
                gender.setSelection(0);
            }
            else{
                name.setText(Name);
                higth.setText(Higth);
                weight.setText(Weight);
                gender.setSelection(1);
            }
    }
    private void setupSharedPrefs() {
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View view) {
        // do it to save data on shared ...
        String nameres = name.getText().toString();
        String higthres = higth.getText().toString();
        String weightres = weight.getText().toString();
        String genderres = gender.getTransitionName();
        editor.putString(NAME,nameres);
        editor.putString(HIGTH,higthres);
        editor.putString(WEIGHT,weightres);
        editor.putString(GENDER,genderres);
        editor.commit();
        String mass = " Done";
        Toast.makeText(this,mass,Toast.LENGTH_SHORT).show();
    }
    public void onClick2(View view) {
        // her calculate the BMI and give the report if you overwigth ,underwigth,normal
        //and give some advance to be better
        String nameres = name.getText().toString();
        String higthres = higth.getText().toString();
        String weightres = weight.getText().toString();
        String genderres = gender.getSelectedItem().toString();
        String [] dat ={nameres,higthres,weightres,genderres};
        //to send the data to next Activity
        Intent intent=new Intent(this,MainActivity2.class);
        intent.putExtra("data",dat);
        startActivity(intent);
    }
    public void onClick3(View view) {
        //to send the data to next Activity
        Intent intent=new Intent(this,MainActivity3.class);
        intent.putExtra("Timer","");
        startActivity(intent);
    }
}