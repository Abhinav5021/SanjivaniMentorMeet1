package com.kulswaminitech.sanjivanimentormeet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddBatchActivity extends AppCompatActivity {
AppCompatButton AddBatch;
AppCompatEditText batchId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_batch);
        AddBatch=findViewById(R.id.AddBatch);
        batchId=findViewById(R.id.batchId);
        AddBatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String batchName=batchId.getText().toString();

            }
        });
    }
}