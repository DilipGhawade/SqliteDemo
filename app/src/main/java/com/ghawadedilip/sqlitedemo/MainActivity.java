package com.ghawadedilip.sqlitedemo;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  EditText edtname,edtemail,edtmobno,edtpassword,edtcity,edtaddress;
  Button button;
  DatabaseHelper databaseHelper;
  SQLiteDatabase db;
  Context context = this;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    edtname =  findViewById(R.id.edt_username);
    edtemail = findViewById(R.id.edt_email);
    edtpassword = findViewById(R.id.edt_password);
    edtcity = findViewById(R.id.edt_city);
    edtaddress = findViewById(R.id.edt_address);
    edtmobno  = findViewById(R.id.edt_mobno);

    button = findViewById(R.id.btn_register);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        registerUser();

      }
    });


  }
  public void registerUser()
  {
    String name = edtname.getText().toString();
    String email = edtemail.getText().toString();
    String mobno = edtmobno.getText().toString();
    String password = edtpassword.getText().toString();
    String address = edtaddress.getText().toString();
    String city=edtcity.getText().toString();
    databaseHelper = new DatabaseHelper(context);
    db=databaseHelper.getWritableDatabase();
    databaseHelper.registerUser(name,email,password,address,mobno,city,db);
    Toast.makeText(this,"Registrtion is Successfull",Toast.LENGTH_LONG).show();

  }

}
