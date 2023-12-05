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
            Request request = new Request(command);
            // 명령에 입력한 문자열이 Request 생성자 함수 매개변수로 들어감
            // 들어간 단어는 Request 내에서 ?를 기준으로 문자열로 나뉘어 배열에 들어감
            // 배열의 0번째 인덱스가 actionCode 이며, (종료,등록,목록,삭제...등)
            // getActionCode() 메서드로 해당 단어를 return한다

            switch (request.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.delete(request);
                    break;
            }
        }
    }
}
