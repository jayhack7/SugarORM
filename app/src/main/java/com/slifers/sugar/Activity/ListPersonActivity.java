package com.slifers.sugar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.slifers.sugar.Adapter.PersonAdapter;
import com.slifers.sugar.DTO.Person;
import com.slifers.sugar.DTO.SinhVien;
import com.slifers.sugar.sugarorm.R;

import java.util.ArrayList;
import java.util.List;

public class ListPersonActivity extends AppCompatActivity {

    ListView lsvPerson;
    List<Person> lstPerson;
    PersonAdapter adapter;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, Menu.FIRST, 0, "Delete");
    }

    //Xử lý sự kiện xóa.
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case Menu.FIRST:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                Person Person = adapter.getItem(info.position);
                SinhVien.deleteAll(SinhVien.class, "Person = ?", String.valueOf(Person.getId()));
                Person.delete();
                return true;
        }
        return super.onContextItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_person);

        AddControls();
        AddEvents();

        lstPerson = new ArrayList<>();
        lstPerson = Person.listAll(Person.class);
        adapter = new PersonAdapter(this, lstPerson);
        lsvPerson.setAdapter(adapter);

        //Show contextMenu.
        registerForContextMenu(lsvPerson);
    }

    private void AddControls() {
        lsvPerson = (ListView) findViewById(R.id.lsvPerson);
    }

    private void AddEvents() {
        lsvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person Person = adapter.getItem(position);
                Intent intent = new Intent(ListPersonActivity.this, PersonDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putLong("id", Person.getId());
                intent.putExtra("bundlePerson", bundle);
                startActivity(intent);
                finish();
            }
        });
    }
}
