package org.example;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String actionCode;
    private Map<String, String> params = new HashMap<>();
    public Request(String command) {
        String[] commandList = command.split("\\?",2);

        actionCode = commandList[0];  // 삭제

        if (commandList.length == 1) return;

        String[] paramsList = commandList[1].split("&");  // id=1 ....

        for(String paramsRow : paramsList) {
            String[] paramsStr = paramsRow.split("=",2);
            // '=' 을 기준으로 문자열을 '2'개로 나눈다.
            if (paramsStr.length == 1) return;

            String key = paramsStr[0];  // id
            String value = paramsStr[1];  // 2

            params.put(key, value);
        }
//        System.out.println("actionCode : " + actionCode);
//        System.out.println("params : "+ params);
    }
    public String getActionCode() {
        return actionCode;
    }
    public String getParams(String key) {
        return params.get(key);
    }
}
