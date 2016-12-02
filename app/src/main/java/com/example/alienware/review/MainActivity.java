package com.example.alienware.review;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import SQLite.DBHelper;

import SQLite.Person;

public class MainActivity extends AppCompatActivity {
    private MyAdapter myAdapter;
   private RecyclerView recyclerView;
    private ArrayList<Person> persons=new ArrayList<Person>();
public DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          dbHelper=new DBHelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycl_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter=new MyAdapter(persons);

                recyclerView.setAdapter(myAdapter);
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query("person",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String name=cursor.getString(1);
            String number=cursor.getString(2);
            Person person=new Person(name,number);
            persons.add(person);
        }
        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                MainActivity.this.finish();
            }
        });

    }}




