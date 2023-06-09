package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class about extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        btn = findViewById(R.id.btn8);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(about.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Populate UI elements with developers' details, information, copyright statement, and website URL
        TextView developersTextView = findViewById(R.id.developersTextView);
        TextView copyrightTextView = findViewById(R.id.copyrightTextView);
        TextView websiteTextView = findViewById(R.id.websiteTextView);

        // Set text or any other necessary actions

        // Make the website URL clickable
        websiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the URL in a browser
                Uri websiteUri = Uri.parse("https://github.com/SyafiqahAzizan/ElectricityBillCalculator");
                Intent intent = new Intent(Intent.ACTION_VIEW, websiteUri);
                startActivity(intent);
            }
        });
    }
}
