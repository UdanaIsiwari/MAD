package com.example.mad_t5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_t5.database.DBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et_userName;
    EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_userName = findViewById(R.id.et_userName);
        et_password = findViewById(R.id.et_password);
    }

    public void saveUser(View view){
        String userName = et_userName.getText().toString();
        String password = et_password.getText().toString();

        DBHelper dbHelper = new DBHelper(this);

        if(userName.isEmpty()||password.isEmpty()){
            Toast.makeText(this,"Enter values", Toast.LENGTH_SHORT).show();
        }else{
            long inserted = dbHelper.addInfo(userName,password);

            if(inserted > 0){
                Toast.makeText(this,"Data Inserted Successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void viewAll(View view){
        DBHelper dbHelper = new DBHelper(this);
        List info = dbHelper.readAll();

        String[] infoArray = (String[]) info.toArray(new String[0]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Users Details");

        builder.setItems(infoArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}