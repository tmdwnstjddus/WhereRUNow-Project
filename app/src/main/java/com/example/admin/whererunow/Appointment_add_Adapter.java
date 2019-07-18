package com.example.admin.whererunow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Appointment_add_Adapter extends BaseAdapter {

    //아이템을 세트로 담기 위한 어레이
    private ArrayList<Appointment_add_Item> appointment_add_items = new ArrayList<>();

    @Override
    public int getCount() {
        return appointment_add_items.size();
    }

    @Override
    public Appointment_add_Item getItem(int position) {
        return appointment_add_items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.appointment_listview_item, parent, false);
        }

        ImageView appointment_img = (ImageView) convertView.findViewById(R.id.appointment_img);
        TextView appointment_date = (TextView) convertView.findViewById(R.id.appointment_date);
        TextView appointment_time = (TextView) convertView.findViewById(R.id.appointment_time);
        TextView appointment_title = (TextView) convertView.findViewById(R.id.appointment_title);

        Appointment_add_Item appointment_add_item = getItem(position);

        appointment_img.setImageDrawable(appointment_add_item.getIcon());
        appointment_date.setText(appointment_add_item.getAppointmentDate());
        appointment_time.setText(appointment_add_item.getAppointmentTime());
        appointment_title.setText(appointment_add_item.getAppointmentTitle());

        return convertView;
    }

    public void addItem(Drawable img, String appointment_date, String appointment_time,String appointment_title) {
        Appointment_add_Item appointment_add_item = new Appointment_add_Item();

        // Appointment_add_Item에 아이템을 setting한다.
        appointment_add_item.setIcon(img);
        appointment_add_item.setAppointmentDate(appointment_date);
        appointment_add_item.setAppointmentTime(appointment_time);
        appointment_add_item.setAppointmentTitle(appointment_title);

        appointment_add_items.add(appointment_add_item);
    }
}