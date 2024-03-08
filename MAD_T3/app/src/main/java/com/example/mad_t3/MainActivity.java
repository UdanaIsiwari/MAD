package com.example.mad_t3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etn_num1;
    EditText etn_num2;
    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn_num1 = findViewById((R.id.etn_num1));
        etn_num2 = findViewById(R.id.etn_num2);
        btn_ok = findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                openSecondAct();
            }
        });
    }

    //navigation
    public  void openSecondAct(){
        Intent intent = new Intent(this,calculator.class);

        String num1 = etn_num1.getText().toString();
        String num2 = etn_num2.getText().toString();

        intent.putExtra("n1",num1);
        intent.putExtra("n2",num2);

        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.custome_toast,findViewById(R.id.tv_toast));

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setView(layout);
        toast.show();

        startActivity(intent);
    }
}