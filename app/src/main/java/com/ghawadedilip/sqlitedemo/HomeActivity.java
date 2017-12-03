package com.ghawadedilip.sqlitedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
  Button btnaddusr,btnshowuser;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    btnaddusr = findViewById(R.id.btn_adduser);
    btnshowuser = findViewById(R.id.btn_userlist);
    btnaddusr.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(HomeActivity.this,MainActivity.class);
        startActivity(i);
        finish();
      }
    });

    btnshowuser.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(HomeActivity.this,ResultActivity.class);
        startActivity(i);
        finish();
      }
    });
  }
}
