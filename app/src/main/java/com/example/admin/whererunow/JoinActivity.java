package com.example.admin.whererunow;

import android.app.AlertDialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class JoinActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private boolean validate = false; //아이디 중복확인

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final EditText passwordchkText = (EditText) findViewById(R.id.passwordchkText);
        final EditText nameText = (EditText) findViewById(R.id.nameText);
        final EditText phonenumberText = (EditText) findViewById(R.id.phonenumberText);

        //아이디 중복확인 체크
        final Button validateButton = (Button) findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id = idText.getText().toString();
                if (validate) {
                    return;
                }
                if (id.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("아이디는 빈 칸일 수 없습니다")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.")
                                        .setPositiveButton("확인", null)
                                        .create();
                                dialog.show();
                                idText.setEnabled(false);
                                validate= true;
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                dialog = builder.setMessage("이미 사용중인 아이디입니다.")
                                        .setNegativeButton("확인", null)
                                        .create();
                                dialog.show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                ValidateRequest validateRequest = new ValidateRequest(id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(JoinActivity.this);
                queue.add(validateRequest);
            }
        });


        Button registerButton = (Button) findViewById(R.id.registerButton2);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 이메일 입력 확인
                if (idText.length() == 0) {
                    Toast.makeText(JoinActivity.this, "아이디를 입력하세요!", Toast.LENGTH_SHORT).show();
                    idText.requestFocus();
                    return;
                }

                // 비밀번호 입력 확인
                if (passwordText.getText().toString().length() == 0) {
                    Toast.makeText(JoinActivity.this, "비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    passwordText.requestFocus();
                    return;
                }

                // 비밀번호 확인 입력 확인
                if (passwordchkText.getText().toString().length() == 0) {
                    Toast.makeText(JoinActivity.this, "비밀번호 확인을 입력하세요!", Toast.LENGTH_SHORT).show();
                    passwordchkText.requestFocus();
                    return;
                }

                // 비밀번호 일치 확인
                if (!passwordText.getText().toString().equals(passwordchkText.getText().toString())) {
                    Toast.makeText(JoinActivity.this, "비밀번호가 일치하지 않습니다!", Toast.LENGTH_SHORT).show();
                    passwordText.setText("");
                    passwordchkText.setText("");
                    passwordText.requestFocus();
                    return;
                }
                // 이름 입력 확인
                if (nameText.length() == 0) {
                    Toast.makeText(JoinActivity.this, "이름을 입력하세요!", Toast.LENGTH_SHORT).show();
                    nameText.requestFocus();
                    return;
                }
                // 전화번호 입력 확인
                if (phonenumberText.length() == 0) {
                    Toast.makeText(JoinActivity.this, "나이를 입력하세요!", Toast.LENGTH_SHORT).show();
                    phonenumberText.requestFocus();
                    return;
                }


                String id = idText.getText().toString();
                String password = passwordText.getText().toString();
                String passwordchk = passwordchkText.getText().toString();
                String name = nameText.getText().toString();
                int phonenumber = Integer.parseInt(phonenumberText.getText().toString());

                if(!validate)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("먼저 중복 체크를 해주세요.")
                            .setNegativeButton("확인", null)
                            .create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Toast.makeText(JoinActivity.this, "회원가입에 성공했습니다.!", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(JoinActivity.this, "회원가입에 실패했습니다.!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(id,password,passwordchk,name,phonenumber, responseListener);
                RequestQueue queue = Volley.newRequestQueue(JoinActivity.this);
                queue.add(registerRequest);
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        if(dialog !=null)
        {
            dialog.dismiss();
            dialog = null;
        }
    }


        //정보 제공 동의(필수)의 빈 체크박스 클릭시 체크박스가 채워짐

    public void onClick1(View view) {
        findViewById(R.id.checkboxBtn).setVisibility(View.GONE);
        findViewById(R.id.checkboxBtn2).setVisibility(View.VISIBLE);

    }

    //정보 제공 동의(필수)의 채워진 체크박스 클릭시 체크박스가 비워짐
    public void onClick2(View view) {
        findViewById(R.id.checkboxBtn2).setVisibility(View.GONE);
        findViewById(R.id.checkboxBtn).setVisibility(View.VISIBLE);

    }

    //위치 제공 동의(필수)의 빈 체크박스 클릭시 체크박스가 채워짐
    public void onClick3(View view) {
        findViewById(R.id.checkboxBtn3).setVisibility(View.GONE);
        findViewById(R.id.checkboxBtn4).setVisibility(View.VISIBLE);

    }

    //위치 제공 동의(필수)의 채워진 체크박스 클릭시 체크박스가 비워짐
    public void onClick4(View view) {
        findViewById(R.id.checkboxBtn4).setVisibility(View.GONE);
        findViewById(R.id.checkboxBtn3).setVisibility(View.VISIBLE);

    }

    //푸시 알림 설정(선택)의 빈 체크박스 클릭시 체크박스가 채워짐
    public void onClick5(View view) {
        findViewById(R.id.checkboxBtn5).setVisibility(View.GONE);
        findViewById(R.id.checkboxBtn6).setVisibility(View.VISIBLE);

    }

    //푸시 알림 설정(선택)의 채워진 체크박스 클릭시 체크박스가 비워짐
    public void onClick6(View view) {
        findViewById(R.id.checkboxBtn6).setVisibility(View.GONE);
        findViewById(R.id.checkboxBtn5).setVisibility(View.VISIBLE);

    }
}