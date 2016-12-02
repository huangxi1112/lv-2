package com.example.alienware.review;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import SQLite.Manager;
import SQLite.Person;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button=(Button)findViewById(R.id.button);
        Button button2=(Button)findViewById(R.id.button2);
        final EditText name=(EditText)findViewById(R.id.editText);
        final EditText number=(EditText)findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
                Main2Activity.this.finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           String mname=name.getText().toString().trim();
                String mnumber=number.getText().toString().trim();
                Manager manager=new Manager(Main2Activity.this);
                Person person=new Person();
                person.setName(mname);
                person.setNumber(mnumber);
                manager.addPerson(person);
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
                Main2Activity.this.finish();
            }
        });
    }

}
