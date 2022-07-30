package com.example.setup_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    Double value1 = 0.0, value2 = 0.0;
    EditText field1 , field2;
    TextView DisplayResult;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        // todo
        // Assign the fields to variables and store them

         field1 = (EditText) findViewById(R.id.editTextNumberDecimal);
         field2 = (EditText) findViewById(R.id.editTextNumberDecimal2);

        //Assign the operators to variables
        Button btnMultiply = (Button) findViewById(R.id.button4);
        Button btnDivide = (Button) findViewById(R.id.button5);
        Button btnAdd =  (Button) findViewById(R.id.button6);
        Button btnSubtract = (Button) findViewById(R.id.button7);
        Button Clear = (Button) findViewById(R.id.button9);


        // Get the text view where the result will display

        DisplayResult = (TextView) findViewById(R.id.textView4);


        //create functionality that recognize which button the user pressed.
        //use switch statemnet to decide which  entry the user has




    } // end on create


    public void add(View View){
        if (field1.getText().toString().isEmpty()||field2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please complete all fields ", Toast.LENGTH_SHORT).show();
        }else {
            value1 = Double.parseDouble(field1.getText().toString());
            value2 = Double.parseDouble(field2.getText().toString());
            DisplayResult.setText(String.valueOf(value1 + value2));
            Log.d("msg", String.valueOf(value1 + value2));
        }

    };

    public void minus(View View){
        if (field1.getText().toString().isEmpty()||field2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please complete all fields ", Toast.LENGTH_SHORT).show();
        }else {
            value1 = Double.parseDouble(field1.getText().toString());
            value2 = Double.parseDouble(field2.getText().toString());
            DisplayResult.setText(String.valueOf(value1 - value2));

        }
    };

    public void multiply(View View) {
        if (field1.getText().toString().isEmpty() || field2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please complete all fields ", Toast.LENGTH_SHORT).show();
        } else {
            value1 = Double.parseDouble(field1.getText().toString());
            value2 = Double.parseDouble(field2.getText().toString());
            DisplayResult.setText(String.valueOf(value1 * value2));

        }
    };

    public void divide(View View) {
        if (field1.getText().toString().isEmpty() || field2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please complete all fields ", Toast.LENGTH_SHORT).show();
        } else {
            value1 = Double.parseDouble(field1.getText().toString());
            value2 = Double.parseDouble(field2.getText().toString());
            DisplayResult.setText(String.valueOf(value1 / value2));

        }
    };
    public void clear(View View){
        field1.setText(null);
        field2.setText(null);


    }



}; // end Class

