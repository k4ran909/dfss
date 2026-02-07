package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private Button buttonCheck;
    private TextView textViewOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = findViewById(R.id.editTextNumber);
        buttonCheck = findViewById(R.id.buttonCheck);
        textViewOutput = findViewById(R.id.textViewOutput);
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPrimeNumber();
            }
        });
    }
    private void checkPrimeNumber() {
        String input = editTextNumber.getText().toString().trim();

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            long number = Long.parseLong(input);
            if (number < 0) {
                textViewOutput.setText("Please enter a positive number");
                return;
            }
            if (isPrime(number)) {
                textViewOutput.setText(number + " is a PRIME number");
                textViewOutput.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            } else {
                textViewOutput.setText(number + " is NOT a prime number ");
                textViewOutput.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean isPrime(long number) {

        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (long i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
