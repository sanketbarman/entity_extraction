package com.example.entityextraction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.mlkit.nl.entityextraction.EntityExtraction;
import com.google.mlkit.nl.entityextraction.EntityExtractor;
import com.google.mlkit.nl.entityextraction.EntityExtractorOptions;


public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launch_entity_activity(View view) {
        //Log.d(LOG_TAG, "Button clicked!");
        Intent intent=new Intent(this,Entity_Activity.class);
        startActivity(intent);
    }

    EntityExtractor entityExtractor = EntityExtraction.getClient(
            new EntityExtractorOptions.Builder(EntityExtractorOptions.ENGLISH).build());

    Button extractionButton = findViewById(R.id.button);

    extractionButton.setOnClickListener(
    {
        entityExtractor
                .downloadModelIfNeeded()
                .onSuccessTask(ignored -> entityExtractor.annotate(getEntityExtractionParams(input)))
                .addOnSuccessListener(
                        aVoid -> {

                        })
                .addOnFailureListener(
                        exception -> {

                        });

    }
            )
}