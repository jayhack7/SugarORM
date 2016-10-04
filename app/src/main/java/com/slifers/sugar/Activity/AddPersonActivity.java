package com.slifers.sugar.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.slifers.sugar.DTO.Person;
import com.slifers.sugar.sugarorm.R;

public class AddPersonActivity extends AppCompatActivity {

    EditText txtname, txtage;
    Button btnAddPerson, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        AddControls();
        AddEvents();
    }


    private void AddControls() {
        txtname = (EditText) findViewById(R.id.txtname);
        txtage = (EditText) findViewById(R.id.txtage);
        btnAddPerson = (Button) findViewById(R.id.btnAdd);
        btnCancel = (Button) findViewById(R.id.btnCancel);
    }

    //Set sự kiện cho các controls.
    private void AddEvents() {
        btnAddPerson.setOnClickListener(onClickListener);
        btnCancel.setOnClickListener(onClickListener);
    }

    //Xử lý sự kiện click cho các controls.
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAdd:
                    Person Person = new Person(txtname.getText().toString(), txtage.getText().toString());
                    Person.save();
                    Toast.makeText(AddPersonActivity.this, "Successful", Toast.LENGTH_LONG).show();
                    finish();
                    break;
                case R.id.btnCancel:
                    finish();
                    break;
            }
        }
    };
}
