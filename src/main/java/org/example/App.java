package org.example;

import org.example.system.SystemController;
import org.example.wiseSaying.WiseSaying;
import org.example.wiseSaying.WiseSayingController;

import java.util.*;

public class App {
    SystemController systemController;
    WiseSayingController wiseSayingController;
    App() {
        this.systemController = new SystemController();
        this.wiseSayingController = new WiseSayingController();
    }
    void run() {
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령 > ");
            String command = Container.getSc().nextLine().trim();
            if(command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayingController.write();
            } else if (command.equals("목록")) {
                wiseSayingController.list();
            } else if (command.startsWith("삭제")) {
                // 삭제?id=1
                String[] commandList = command.split("\\?",2);
                // 문자열 분할 후 배열로 넣음
                // ["삭제", "id=1"]

                String actionCode = commandList[0];  // 삭제
                String[] paramsList = commandList[1].split("&");  // id=1 ....

                Map<String, String> params = new HashMap<>();

                for(String paramsRow : paramsList) {
                    String[] paramsStr = paramsRow.split("=",2);

                    String key = paramsStr[0];  // id
                    String value = paramsStr[1];  //2

                    params.put(key, value);
                }

                System.out.println("actionCode : " + actionCode);
                System.out.println("params : "+ params);

                // wiseSayingController.delete();
            }
        }
    }
}