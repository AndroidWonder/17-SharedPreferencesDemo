package com.course.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import android.content.SharedPreferences;
import android.content.Intent;

public class fail extends Activity {
 
	private TextView text; 
	private SharedPreferences SPrefs;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error);
        
        text =  (TextView)findViewById(R.id.TextView10);

        //access shared preferences
        SPrefs = getSharedPreferences("MySPrefs", 0);
        String str = SPrefs.getString("name", "Foobar");

        text.setText("Invalid login, " + str + "\n" + "Try again");
        
    }
}