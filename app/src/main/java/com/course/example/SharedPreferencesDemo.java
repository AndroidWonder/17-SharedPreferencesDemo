/*
 * User enters name, password, age. They are stored as shared preferences.
 * If correct password, an activity is started that reads preferences.
 * If incorrect password, a different activity is started.
 */

//
package com.course.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Intent;
import android.view.View;

public class SharedPreferencesDemo extends Activity implements View.OnClickListener {
 
	private EditText editName, editPassword, editAge;
	private Button button;
	private SharedPreferences SPrefs;
    private boolean login = false;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editName =  (EditText)findViewById(R.id.EditText01);
        editPassword =  (EditText)findViewById(R.id.EditText02);
        editAge =  (EditText)findViewById(R.id.EditText03);
        button = (Button)findViewById(R.id.Button01);

        button.setOnClickListener(this);

    }
    	//when button clicked, store data from UI as shared preferences values
        public void onClick(View view) { 
        	       
        SPrefs = getSharedPreferences("MySPrefs", 0);
        SharedPreferences.Editor editor = SPrefs.edit();

        editor.putString("name", editName.getText().toString());
        String password = editPassword.getText().toString();
        editor.putString("password", password);
        editor.putInt("age",
                Integer.parseInt(editAge.getText().toString()));

        //check for correct password
        if (password.equals("Hello") ) {
            login = true;
            editor.putBoolean("login", true);}
            else
            editor.putBoolean("login", false);
        editor.commit();
        
        //clear EditText widgets
        editName.setText("");
        editPassword.setText("");
        editAge.setText("");
        
        
        //test for valid login
        Intent intent;
        if ((login)) {
        	intent = new Intent(this, pass.class);
        } else {
        	intent = new Intent(this, fail.class);
        }
        
        startActivity(intent);
        	
    
    }
}