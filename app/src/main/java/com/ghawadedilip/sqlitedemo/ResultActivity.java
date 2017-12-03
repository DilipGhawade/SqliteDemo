package com.ghawadedilip.sqlitedemo;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
  RecyclerAdapter adapter;
  RecyclerView recyclerView;
  RecyclerView.LayoutManager layoutManager;
  DatabaseHelper databaseHelper;
  List<DataModel> userlist;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);

    recyclerView = findViewById(R.id.recyclerview);
    userlist = new ArrayList<>();
    adapter = new RecyclerAdapter(userlist);

    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setHasFixedSize(true);
    recyclerView.setAdapter(adapter);

    databaseHelper = new DatabaseHelper(this);

    getdataFromSQLite();

  }


  public void getdataFromSQLite()
  {
    new AsyncTask<Void, Void, Void>() {
      @Override
      protected Void doInBackground(Void... params) {
        userlist.clear();
        userlist.addAll(databaseHelper.getAllRegisterUser());

        return null;
      }

      @Override
      protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        adapter.notifyDataSetChanged();
      }
    }.execute();
  }
}



