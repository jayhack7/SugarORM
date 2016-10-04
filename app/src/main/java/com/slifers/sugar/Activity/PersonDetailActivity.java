package com.slifers.sugar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.slifers.sugar.Adapter.SinhVienAdapter;
import com.slifers.sugar.DTO.Person;
import com.slifers.sugar.DTO.SinhVien;
import com.slifers.sugar.sugarorm.R;

import java.util.ArrayList;
import java.util.List;

public class PersonDetailActivity extends AppCompatActivity {

    EditText txtname, txtage;
    List<SinhVien> lstSinhVien;
    ListView lsvSinhVienInPerson;
    Button btnOK, btnCancel;
    Person Person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        //Lấy mã lớp từ bundle.
        Intent callerIntent = getIntent();
        Bundle packageFromCaller = callerIntent.getBundleExtra("bundlePerson");
        Long id = packageFromCaller.getLong("id");
        Person = Person.findById(Person.class, id);

        txtname = (EditText) findViewById(R.id.txtname);
        txtage = (EditText) findViewById(R.id.txtage);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        lsvSinhVienInPerson = (ListView) findViewById(R.id.lsvSinhVienInPerson);

        //Gán mã lớp, tên lớp vào EditText.
        txtname.setText(Person.getname());
        txtage.setText(Person.getage());

        //Tìm các sinh viên với mã lớp đã chọn.
        lstSinhVien = new ArrayList<>();
        lstSinhVien = SinhVien.find(SinhVien.class, "Person = ?", String.valueOf(Person.getId()));
        SinhVienAdapter adapter = new SinhVienAdapter(this, lstSinhVien);
        lsvSinhVienInPerson.setAdapter(adapter);

        AddEvents();
    }

    //Set sự kiện cho các Controls.
    private void AddEvents() {
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person.setage(txtage.getText().toString());
                Person.save();
                Intent refresh = new Intent(PersonDetailActivity.this, ListPersonActivity.class);
                startActivity(refresh);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent refresh = new Intent(PersonDetailActivity.this, ListPersonActivity.class);
                startActivity(refresh);
                finish();
            }
        });
    }
}
