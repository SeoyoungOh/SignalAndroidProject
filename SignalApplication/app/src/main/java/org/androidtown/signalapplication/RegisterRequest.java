package org.androidtown.signalapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by seoyoungoh on 2017. 11. 19..
 */

public class RegisterRequest extends StringRequest {

    final private static String URL = "http://ec2-13-124-38-242.ap-northeast-2.compute.amazonaws.com:7504/account/";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPW, String userName, String userJob, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPW", userPW);
        parameters.put("userName", userName);
        parameters.put("userJob", userJob);
        //parameters.put("userImg", userImg);

    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }

}
