package com.example.bai1;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText editA ;
    EditText editB ;
    TextView txkq ;
    Button btAdd, btSub,btMul ,btDiv, btUC ,btExit;
    int a ,b;
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

        btAdd = findViewById(R.id.btAdd);
        btSub = findViewById(R.id.btSub);
        btMul = findViewById (R.id.btMul);
        btDiv = findViewById(R.id.btDiv);
        btUC = findViewById(R.id.btUC);
        btExit = findViewById (R.id.btExit);

        editB = (EditText) findViewById(R.id.editB);
        editA = (EditText) findViewById(R.id.editA);
        txkq = findViewById(R.id.txkq);



        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkEmpty()){
                    return;
                }
                asign();
                int kq =a+b;
                setText(kq);
            }
        });
        btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkEmpty()){
                    return;
                }
                asign();
                int kq =a-b;
                setText(kq);
            }
        }); btMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkEmpty()){
                    return;
                }
                asign();
                int kq =a*b;
                setText(kq);
            }
        }); btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkEmpty()){
                    return;
                }
                asign();
                int kq =a/b;
                setText(kq);
            }
        }); btUC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkEmpty()){
                    return;
                }
                asign();
                int kq = a%b;
               setText(kq);
            }
        }); btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void asign(){
            a = Integer.parseInt(editA.getText().toString());
            b = Integer.parseInt(editB.getText().toString());
    }
    private Boolean checkEmpty(){
        if(editA.getText().toString().isEmpty() || editB.getText().toString().isEmpty()){
            Snackbar.make(findViewById(R.id.main), "Vui lòng nhập đầy đủ", Snackbar.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void setText(int kq){
        txkq.setText(String.valueOf(kq));
    }

}