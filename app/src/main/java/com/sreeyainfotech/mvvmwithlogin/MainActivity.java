package com.sreeyainfotech.mvvmwithlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login=(Button)findViewById(R.id.login);
        login.setOnClickListener(this);

        Button list=(Button)findViewById(R.id.list);
        list.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.login:
                Intent login_intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login_intent);
                break;

            case R.id.list:
                Intent list_intent=new Intent(MainActivity.this, ListActivity.class);
                startActivity(list_intent);
                break;
        }
    }
}
