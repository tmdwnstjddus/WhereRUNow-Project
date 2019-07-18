package com.example.admin.whererunow;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


//회원가입 요청을보내는 클래스

public class RegisterRequest extends StringRequest{
    final static private String URL = "http://61.245.230.40/join.php";
    private Map<String,String> parameters;

    public RegisterRequest(String id, String password, String passwordchk, String name, int phonenumber, Response.Listener<String> listener){

        //해당 URL에 parameters 의 값을 post 방식으로 보낸다(숨겨서)
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("id",id);
        parameters.put("password",password);
        parameters.put("passwordchk",passwordchk);
        parameters.put("name",name);
        parameters.put("phonenumber",phonenumber +"");
    }

    @Override
    public  Map<String ,String > getParams(){
        return parameters;
    }
}
