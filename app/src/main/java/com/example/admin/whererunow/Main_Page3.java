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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main_Page3 extends Fragment
{


    private ListView last_appointment_listview;

    public Main_Page3()
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
        View view = inflater.inflate(R.layout.main_page3,container,false);



        // listview 연결
        last_appointment_listview = (ListView) view.findViewById(R.id.last_appointment_listview);
        // 아이템 추가 및 어댑터 등록
        setLastAppointment_list();

        return view;
    }

    private void setLastAppointment_list() {

        LastAppointment_Adapter last_appointment_adapter = new LastAppointment_Adapter();

        last_appointment_adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.re_btn), "10월 16일 월요일" , "11:30AM", "조별모임");
        last_appointment_adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.re_btn), "10월 17일 화요일" , "03:00PM", "조별모임");
        last_appointment_adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.re_btn), "10월 18일 수요일" , "04:30PM", "스터디");
        last_appointment_adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.re_btn), "10월 18일 수요일" , "08:30PM", "합주");

        // 리스트뷰에 어댑터 등록
        last_appointment_listview.setAdapter(last_appointment_adapter);

        //OnItemClickListener 추가
        last_appointment_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //갱신 페이지로 바꿔야합니다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                Intent intent = new Intent(getActivity(),PromiseDetail.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

    }
}