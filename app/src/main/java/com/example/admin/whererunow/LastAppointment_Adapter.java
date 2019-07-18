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

public class LastAppointment_Adapter extends BaseAdapter {

    //아이템을 세트로 담기 위한 어레이
    private ArrayList<LastAppointment_Item> last_appointment_items = new ArrayList<>();

    @Override
    public int getCount() {
        return last_appointment_items.size();
    }

    @Override
    public LastAppointment_Item getItem(int position) {
        return last_appointment_items.get(position);
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
            convertView = inflater.inflate(R.layout.last_appointment_listview, parent, false);
        }

        ImageView last_appointment_img = (ImageView) convertView.findViewById(R.id.last_appointment_img);
        TextView last_appointment_date = (TextView) convertView.findViewById(R.id.last_appointment_date);
        TextView last_appointment_time = (TextView) convertView.findViewById(R.id.last_appointment_time);
        TextView last_appointment_title = (TextView) convertView.findViewById(R.id.last_appointment_title);

        LastAppointment_Item last_Appointment_Item = getItem(position);

        last_appointment_img.setImageDrawable(last_Appointment_Item.getIcon());
        last_appointment_date.setText(last_Appointment_Item.getLastAppointmentDate());
        last_appointment_time.setText(last_Appointment_Item.getLastAppointmentTime());
        last_appointment_title.setText(last_Appointment_Item.getLastAppointmentTitle());

        return convertView;
    }

    public void addItem(Drawable img, String last_appointment_date, String last_appointment_time,String last_appointment_title) {
        LastAppointment_Item last_appointment_item = new LastAppointment_Item();

        // Appointment_add_Item에 아이템을 setting한다.
        last_appointment_item.setIcon(img);
        last_appointment_item.setLastAppointmentDate(last_appointment_date);
        last_appointment_item.setLastAppointmentTime(last_appointment_time);
        last_appointment_item.setLastAppointmentTitle(last_appointment_title);

        last_appointment_items.add(last_appointment_item);
    }
}
