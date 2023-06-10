package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Toolbar toolbar;
    private EditText editTextUnits;
    private EditText editTextRebate;
    private TextView textViewTotalCharges;
    private TextView textViewFinalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = (Button)findViewById(R.id.btnabout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,about.class);
                startActivity(intent);
            }
        });
        editTextUnits = findViewById(R.id.editTextUnits);
        editTextRebate = findViewById(R.id.editTextRebate);
        textViewTotalCharges = findViewById(R.id.textViewTotalCharges);
        textViewFinalCost = findViewById(R.id.textViewFinalCost);

        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextUnits.length()==0){
                    editTextUnits.setError("Enter Value");
                } else if (editTextRebate.length()==0){
                    editTextUnits.setError("Enter Value of Percentage");
                } else {
                    Toast.makeText(MainActivity.this, "Recode added", Toast.LENGTH_SHORT).show();
                }
                calculateBill();

            }
        });
    }

    private void calculateBill() {
        int units = Integer.parseInt(editTextUnits.getText().toString());
        double rebate = Double.parseDouble(editTextRebate.getText().toString()) / 100;

        double totalCharges = 0.0;

        if (units <= 200) {
            totalCharges = units * 0.218;
        } else if (units <= 300) {
            totalCharges = (200 * 0.218) + ((units - 200) * 0.334);
        } else if (units <= 600) {
            totalCharges = (200 * 0.218) + (100 * 0.334) + ((units - 300) * 0.516);
        } else {
            totalCharges = (200 * 0.218) + (100 * 0.334) + (300 * 0.516) + ((units - 600) * 0.546);
        }

        double finalCost = totalCharges - (totalCharges * rebate);

        textViewTotalCharges.setText("Total Charges: RM " + String.format("%.2f", totalCharges));
        textViewFinalCost.setText("Final Cost: RM " + String.format("%.2f", finalCost));
    }
}
