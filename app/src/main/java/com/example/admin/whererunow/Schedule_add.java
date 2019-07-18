package com.example.admin.whererunow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Schedule_add extends AppCompatActivity {

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
        setContentView(R.layout.activity_schedule_add);

        //약속 년도 선택
        spinner1 = (Spinner) findViewById(R.id.yearSpinner);
        adapter1 = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        //약속 월 선택
        spinner2 = (Spinner) findViewById(R.id.monthSpinner);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        //약속 일 선택
        spinner3 = (Spinner) findViewById(R.id.daySpinner);
        adapter3 = ArrayAdapter.createFromResource(this, R.array.day, android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        //약속 시간 선택
        spinner4 = (Spinner) findViewById(R.id.hourSpinner);
        adapter4 = ArrayAdapter.createFromResource(this, R.array.hour, android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        //약속 분 선택
        spinner5 = (Spinner) findViewById(R.id.minuteSpinner);
        adapter5 = ArrayAdapter.createFromResource(this, R.array.minute, android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);

        //약속 년도 선택
        spinner1 = (Spinner) findViewById(R.id.yearSpinner2);
        adapter1 = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        //약속 월 선택
        spinner2 = (Spinner) findViewById(R.id.monthSpinner2);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        //약속 일 선택
        spinner3 = (Spinner) findViewById(R.id.daySpinner2);
        adapter3 = ArrayAdapter.createFromResource(this, R.array.day, android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        //약속 시간 선택
        spinner4 = (Spinner) findViewById(R.id.hourSpinner2);
        adapter4 = ArrayAdapter.createFromResource(this, R.array.hour, android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        //약속 분 선택
        spinner5 = (Spinner) findViewById(R.id.minuteSpinner2);
        adapter5 = ArrayAdapter.createFromResource(this, R.array.minute, android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);

        //뒤로가기 버튼 클릭시 메인엑티비티로 이동
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Schedule_add.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //저장 버튼 클릭시 저장후 메인엑티비티로 이동
        ImageButton okButton = (ImageButton) findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Schedule_add.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}