package com.example.admin.whererunow;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


//현재 회원가입이 가능한지 체크할 수 있는 클래스 ( 중복체크확인)

public class ValidateRequest extends StringRequest{
    final static private String URL = "http://61.245.230.40/validate.php";
    private Map<String,String> parameters;

    public ValidateRequest(String id,  Response.Listener<String> listener){

        //해당 URL에 parameters 의 값을 post 방식으로 보낸다(숨겨서)
        //id 부분만 보내서 확인한다.
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("id",id);
    }

    @Override
    public  Map<String ,String > getParams(){
        return parameters;
    }
}
