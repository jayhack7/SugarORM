package com.slifers.sugar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.slifers.sugar.sugarorm.R;
import com.slifers.sugar.DTO.SinhVien;

import java.util.List;

/**
 * Created by Don on 4/11/16.
 */
public class SinhVienAdapter extends ArrayAdapter<SinhVien> {

    private List<SinhVien> lstSinhVien;

    public SinhVienAdapter(Context context, List<SinhVien> list) {
        super(context, 0, list);
        lstSinhVien = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        SinhVien sv = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population
        TextView itemId = (TextView) convertView.findViewById(R.id.itemId);
        TextView itemName = (TextView) convertView.findViewById(R.id.itemName);
        // Populate the data into the template view using the data object
        itemId.setText(sv.getMssv());
        itemName.setText(sv.getHoTen());
        // Return the completed view to render on screen
        return convertView;
    }

}
