package com.example.admin.whererunow;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;


public class Appointment_add extends AppCompatActivity {
    private ArrayAdapter adapter1;
    private ArrayAdapter adapter2;
    private ArrayAdapter adapter3;
    private ArrayAdapter adapter4;
    private ArrayAdapter adapter5;

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appintment__add);

        //약속 년도 선택
        spinner1 = (Spinner)findViewById(R.id.yearSpinner);
        adapter1 = ArrayAdapter.createFromResource(this,R.array.year, android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        //약속 월 선택
        spinner2 = (Spinner)findViewById(R.id.monthSpinner);
        adapter2 = ArrayAdapter.createFromResource(this,R.array.month, android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        //약속 일 선택
        spinner3 = (Spinner)findViewById(R.id.daySpinner);
        adapter3 = ArrayAdapter.createFromResource(this,R.array.day, android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        //약속 시간 선택
        spinner4 = (Spinner)findViewById(R.id.hourSpinner);
        adapter4 = ArrayAdapter.createFromResource(this,R.array.hour, android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        //약속 분 선택
        spinner5 = (Spinner)findViewById(R.id.minuteSpinner);
        adapter5 = ArrayAdapter.createFromResource(this,R.array.minute, android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);

        //뒤로가기 버튼 클릭시 메인엑티비티로 이동
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Appointment_add.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    //약속 15분 전 자동 위치 전송(선택)의 빈 체크박스 클릭시 체크박스가 채워짐
    public void onClick1(View view) {
        findViewById(R.id.checkboxBtn).setVisibility(View.GONE);
        findViewById(R.id.checkboxBtn2).setVisibility(View.VISIBLE);

    }

    //약속 15분 전 자동 위치 전송(선택)의 채워진 체크박스 클릭시 체크박스가 비워짐
    public void onClick2(View view) {
        findViewById(R.id.checkboxBtn2).setVisibility(View.GONE);
        findViewById(R.id.checkboxBtn).setVisibility(View.VISIBLE);

    }

    //개인 정보 제공 동의(선택)의 빈 체크박스 클릭시 체크박스가 채워짐
    public void onClick3(View view) {
        findViewById(R.id.checkboxBtn3).setVisibility(View.GONE);
        findViewById(R.id.checkboxBtn4).setVisibility(View.VISIBLE);

    }

    //개인 정보 제공 동의(선택)의 채워진 체크박스 클릭시 체크박스가 비워짐
    public void onClick4(View view) {
        findViewById(R.id.checkboxBtn4).setVisibility(View.GONE);
        findViewById(R.id.checkboxBtn3).setVisibility(View.VISIBLE);
    }
}
