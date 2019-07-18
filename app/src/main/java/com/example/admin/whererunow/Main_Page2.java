package com.example.admin.whererunow;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main_Page2 extends Fragment
{

    private ListView appointment_list;

    public Main_Page2()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.main_page2, container, false);

        appointment_list = (ListView) view.findViewById(R.id.appointment_list);
        ImageButton button = (ImageButton) view.findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Appointment_add.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        // listview 연결
        appointment_list = (ListView) view.findViewById(R.id.appointment_list);

        // 아이템 추가 및 어댑터 등록
        setAppointment_list();
        return view;
    }

    private void setAppointment_list() {

        Appointment_add_Adapter appointment_add_adapter = new Appointment_add_Adapter();

        appointment_add_adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.appointment), "10월 16일 월요일", "11:30AM", "조별모임");
        appointment_add_adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.appointment), "10월 17일 화요일", "03:00PM", "조별모임");
        appointment_add_adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.appointment), "10월 18일 수요일", "04:30PM", "스터디");
        appointment_add_adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.appointment), "10월 18일 수요일", "08:30PM", "합주");

        // 리스트뷰에 어댑터 등록
        appointment_list.setAdapter(appointment_add_adapter);

        //OnItemClickListener 추가
        appointment_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PromiseDetail.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

    }
}