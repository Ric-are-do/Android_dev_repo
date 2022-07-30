package com.example.setup_project;

// log in page with splash screen
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText Username, Password,Email ;
Button Submit;
String SavedUser, SavedPassword, SavedEmail;
Boolean Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Assigning the buttons to variables that I will use to access them
        Button btnSignup = (Button)findViewById(R.id.button2);
        Button btnLogin = (Button)findViewById(R.id.button);
        Submit = (Button)findViewById(R.id.button3);
        //end of buttons casting

        // Assigning values in text fields for name , email and Password
        Username = (EditText) findViewById(R.id.editTextTextPersonName);
        Password = (EditText) findViewById(R.id.editTextTextPassword);
        Email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        // end of field casting

        //Hide all fields
        HideAll();

        // onclick event for sign Up
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // need to set a boolean to see if user selected sing up or log in
                Login = (false);
               // Log.d("Persistance" , "Boolean variable is False");

                HideAll();
                ShowSignIn();
            }
        });

        // onclick event for login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Login = (true);
               // Log.d("Persistance" , "Boolean variable is true");
                HideAll();
                ShowLogIn();
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Username.getText().toString().isEmpty() || Password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enterr fields", Toast.LENGTH_SHORT).show();
                } else {


                    if (Login == Boolean.TRUE) {
                        LogInCredentials();
                    } else {
                        SignUpCredentials();
                    }

                }
            }
        });



        //Todo Add a variable that stores the users password
        //Todo add a toast message informing the user of their decision
        //todo Look at string manipulation for the entry


    }// end of ocreate
    // method for when user clicks sign in to unhide fields
    public void ShowSignIn(){

        Username.setVisibility(View.VISIBLE);
        Password.setVisibility(View.VISIBLE);
        Email.setVisibility(View.VISIBLE);
        Submit.setVisibility(View.VISIBLE);
        

    };

    // Method for when user clicks log in to unhide fields
    public void ShowLogIn(){

        Username.setVisibility(View.VISIBLE);
        Password.setVisibility(View.VISIBLE);
        Submit.setVisibility(View.VISIBLE);

    };

    public void HideAll(){
        Username.setVisibility(View.INVISIBLE);
        Password.setVisibility(View.INVISIBLE);
        Email.setVisibility(View.INVISIBLE);
        Submit.setVisibility(View.INVISIBLE);
    }

    public void SignUpCredentials(){
        SavedUser =  Username.getText().toString();
        SavedPassword = Password.getText().toString();
        SavedEmail = Email.getText().toString();

        if (Username.getText().toString().isEmpty() || Password.getText().toString().isEmpty() || Email.getText().toString().isEmpty()){
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Welcome " + SavedUser  , Toast.LENGTH_SHORT).show();
            //Todo navigate user to the first page of the application
            // Create a shared Prefernece for Username , PW and email

            //Shared Prefence to store password
            SharedPreferences.Editor editor = getSharedPreferences("MYSP", MODE_PRIVATE).edit();
            editor.putString("Key1" ,  SavedUser);
            editor.putString("Key2" ,  SavedPassword);
            editor.putString("Key3" ,  SavedEmail);
            editor.commit();
        }

       };

    // Log in functionality thats compared against the details when signted up
    public void LogInCredentials() {

        // Getting shared Preferences
        SharedPreferences recover = getSharedPreferences("MYSP", MODE_PRIVATE);
        String UN = recover.getString("Key1", "NOT DEFINED");
        //Log.d("Persistance" , "Shared Pref is   " + UN);
        String PW = recover.getString("Key2", "NOT DEFINED");
        //Log.d("Persistance" , "shared pref is  " + PW);



        String UserNameAttempt = Username.getText().toString();
        //Log.d("Persistance" , "attempt entered is  " + UserNameAttempt);
        String PasswrodAttempt = Password.getText().toString();
        //Log.d("Persistance" , "attempt entered is  " + PasswrodAttempt);

        // compare username user entered against username they added when they signed in
        if (UserNameAttempt.equals(UN) && PasswrodAttempt.equals(PW)) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Incorrect Credentials", Toast.LENGTH_LONG).show();
            // so that we know what the password is
            Toast.makeText(this, "UN = " + UN , Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "PW = " + PW, Toast.LENGTH_SHORT).show();


            // set fields blank
           // Username.setText("");
           // Password.setText("");
        }//else{
          //  Toast.makeText(this, "Welcome" + UserNameAttempt, Toast.LENGTH_LONG).show();
        //}



    }


}// end of class