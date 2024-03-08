package com.example.mad_t2;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_temp;
    RadioButton rb_cel;
    RadioButton rb_far;
    Button btn_calc;
    TextView tv_temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        rb_cel = findViewById(R.id.rb_cel);
        rb_far = findViewById(R.id.rb_far);
        btn_calc = findViewById(R.id.btn_calc);
        tv_temp = findViewById(R.id.tv_temp);
    }

    @Override
    protected void onResume() {

        super.onResume();
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        Calculation calc = new Calculation();

        String value = et_temp.getText().toString();

        if (TextUtils.isEmpty(value)) {
            Toast.makeText(this, "Please add a value", Toast.LENGTH_LONG).show();
        } else {
            float temp = Float.parseFloat(value);
            if (rb_cel.isChecked()) {
                temp = calc.convertCelciusToFahrenhite(temp);
            } else if (rb_far.isChecked()) {
                temp = calc.convertFahrenhiteToCelcius(temp);
            } else {
                Toast.makeText(this, "Please select a button", Toast.LENGTH_LONG).show();
                temp = 0.0f;
            }
            tv_temp.setText(new Float(temp).toString());
        }
    }
}