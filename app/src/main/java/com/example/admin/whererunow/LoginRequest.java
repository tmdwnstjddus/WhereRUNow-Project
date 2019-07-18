package com.example.admin.whererunow;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest{
    final static private String URL = "http://61.245.230.40/login.php";
    private Map<String,String> parameters;

    public LoginRequest(String id, String password, Response.Listener<String>listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("id",id);
        parameters.put("password",password);
    }

    @Override
    public  Map<String ,String > getParams(){
        return parameters;
    }
}
