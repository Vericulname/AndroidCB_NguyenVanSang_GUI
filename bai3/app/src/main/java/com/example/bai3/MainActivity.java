package com.example.bai3;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableRow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cal();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
    private void cal(){
        TableRow clickable = findViewById(R.id.TblRbt);

        EditText editHeight = findViewById(R.id.EditHeight);
        EditText editWeight = findViewById(R.id.editWeight);

        EditText editBMi = findViewById(R.id.editBMi);
        EditText editResult = findViewById(R.id.editResult);

        clickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double W;
                double H;
                double BMI;

                if (editHeight.getText().toString().isEmpty() || editWeight.getText().toString().isEmpty())
                    Snackbar.make(view,"Vui lòng nhập đầy đủ thông tin",Snackbar.LENGTH_LONG).show();
                else {
                W = assign(editWeight.getText().toString());
                H = assign(editHeight.getText().toString());


                BMI = W/(H*H);

                DecimalFormat df = new DecimalFormat("0.0");
                setText(editBMi,df.format(BMI));
                setText(editResult,result(BMI));
                }
            }
        });


    }

    private String result(double bmi){
        if (bmi < 18) return "Thiếu cân";
        if (bmi < 25) return "Bình thường";
        if (bmi < 30) return "Béo phì cấp 1";
        if (bmi < 35) return "Béo phì cấp 2";
        return "Béo phì cấp 3";

    }
    private double assign(String info){
        if (String.valueOf(info).isEmpty()) return -1;
        return Double.parseDouble(info);
    }
    private void setText(EditText edit, String text){
        edit.setText(text);
    }
}