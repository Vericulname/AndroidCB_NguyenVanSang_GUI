package com.example.ba2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    float C ,F ;

    Button CtoF, FtoC, clear;

    EditText editC;
    EditText editF;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        convert();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void convert(){
         editC = (EditText) findViewById(R.id.editC);
         editF = (EditText) findViewById(R.id.editF);

        CtoF = findViewById(R.id.CtoF);
        FtoC = findViewById(R.id.FtoC);
        clear = findViewById(R.id.btClear);

        CtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                C = Float.parseFloat(editC.getText().toString());
                float kq = C * 9/5+32;
                setText(String.valueOf(kq),editF);
            }
        });

        FtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                F = Float.parseFloat(editF.getText().toString());
                float kq = (F-32)*5/9 ;
                setText(String.valueOf(kq),editC);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(String.valueOf(0),editC);
                setText(String.valueOf(0),editF);
            }
        });
    }
    private void setText(String kq, EditText edit){
        edit.setText(kq);
    }

}