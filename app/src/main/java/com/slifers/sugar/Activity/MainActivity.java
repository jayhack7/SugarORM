package com.slifers.sugar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.slifers.sugar.sugarorm.R;

public class MainActivity extends AppCompatActivity {

    Button btnAddSV, btnViewSV, btnAddPerson, btnViewPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setOnclick();
    }

    //Set sự ện cho các controls.
    private void setOnclick() {

        btnAddPerson.setOnClickListener(onClickListener);
        btnViewPerson.setOnClickListener(onClickListener);
    }

    //Gán các controls.
    private void init() {

        btnAddPerson = (Button) findViewById(R.id.btnAddPerson);
        btnViewPerson = (Button) findViewById(R.id.btnListPerson);
    }


    //Set sự kiện onclick cho các controls.
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.btnAddPerson:
                    intent = new Intent(MainActivity.this, AddPersonActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnListPerson:
                    intent = new Intent(MainActivity.this, ListPersonActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}
