package com.example.mad_t3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculator extends AppCompatActivity {

    TextView tv_number1;
    TextView tv_number2;
    TextView tv_ans;
    Button btn_add;
    Button btn_subtract;
    Button btn_multiply;
    Button btn_divide;

    String num1;
    String num2;

    int number1;
    int number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tv_number1 = findViewById(R.id.tv_number1);
        tv_number2 = findViewById(R.id.tv_number2);
        tv_ans = findViewById(R.id.tv_ans);
        btn_add = findViewById(R.id.btn_add);
        btn_subtract = findViewById(R.id.btn_subtract);
        btn_multiply = findViewById((R.id.btn_multiply));
        btn_divide = findViewById(R.id.btn_divide);

        Intent intent = getIntent();
        num1 = intent.getStringExtra("n1");
        num2 = intent.getStringExtra("n2");

        tv_number1.setText(num1);
        tv_number2.setText(num2);

        number1 = Integer.parseInt(num1);
        number2 = Integer.parseInt(num2);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
        btn_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtract();
            }
        });
        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiply();
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                divide();
            }
        });

    }

    public void add(){

        tv_ans.setText(num1 + " + " + num2 + " = " + (number1 + number2));
    }

    public void subtract(){

        tv_ans.setText(num1 + " - " + num2 + " = " + (number1 - number2));
    }

    public void multiply(){

        tv_ans.setText(num1 + " * " + num2 + " = " + (number1 * number2));
    }

    public void divide(){

        tv_ans.setText(num1 + " / " + num2 + " = " + (number1 / number2));
    }
}