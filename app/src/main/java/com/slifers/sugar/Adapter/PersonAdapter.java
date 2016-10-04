package com.slifers.sugar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.slifers.sugar.DTO.Person;
import com.slifers.sugar.sugarorm.R;

import java.util.List;

/**
 * Created by Don on 4/11/16.
 */
public class PersonAdapter extends ArrayAdapter<Person> {

    private List<Person> lstPerson;

    public PersonAdapter(Context context, List<Person> list) {
        super(context, 0, list);
        lstPerson = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person Person = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        TextView itemId = (TextView) convertView.findViewById(R.id.itemId);
        TextView itemName = (TextView) convertView.findViewById(R.id.itemName);

        itemId.setText(Person.getname());
        itemName.setText(Person.getage());
        return convertView;
    }

}
