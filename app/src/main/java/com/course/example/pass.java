//access restricted to valid login

package com.course.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import android.content.SharedPreferences;
import android.content.Intent;

public class pass extends Activity {
 
	private TextView text; 
	private SharedPreferences SPrefs;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_in);
        
        text =  (TextView)findViewById(R.id.TextView20);

        //access shared preferences
        SPrefs = getSharedPreferences("MySPrefs", 0);
        String str = SPrefs.getString("name", "Foobar");

        text.setText("Welcome, " + str);                    	
        
    }
}