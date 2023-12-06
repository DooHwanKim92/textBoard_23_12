package org.example.wiseSaying;

import org.example.Container;
import org.example.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    Scanner sc;
    int lastId = 1;
    List<WiseSaying> wiseSayingList = new ArrayList<>();
    public WiseSayingController() {
        sc = Container.getSc();
    }
    public void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying ws = new WiseSaying(lastId,content,author);

        wiseSayingList.add(ws);

        System.out.println(lastId + "번 명언이 등록되었습니다.");
        lastId++;
    }
    public void list() {
        System.out.println("  번호  /  작가  /  명언  ");
        System.out.println("-------------------------");
        for (WiseSaying ws : wiseSayingList) {
            System.out.println(ws.getId() + " / " + ws.getAuthor() + " / " + ws.getContent());
        }
    }
    public void delete(Request request) {
        int id = _getIntParam(request.getParams("id"));
        // 입력된 id의 value를 정수 형태로 반환받는 메서드
        // 삭제?id=2 를 입력했다고 했을 때, 상기 함수에서 반환하는 값은 2이다.

        WiseSaying ws = _getFindById(id);
        // WiseSaying 객체는 id, content, author 값을 가지고 있지
        // 배열에 저장되어 있는 명언 목록 객체 중 id 값이 2인 객체를 ws 변수에 대입
        if (ws == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        wiseSayingList.remove(ws);
        // id,명언,작가는 wiseSayingList라는 가변 배열에 저장되어 있음
        // 있다면 해당 명언 목록이 담긴 객체를 삭제 remove(ws);

        System.out.println(id + "번 명언이 삭제되었습니다.");
    }
    public int _getIntParam(String id) {
        int defaultValue = -1;
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("id는 정수만 입력이 가능합니다.");
            return defaultValue;
        }
    }
    private WiseSaying _getFindById(int id) {
        for (int i = 0; i < wiseSayingList.size(); i++) {
            if(wiseSayingList.get(i).getId() == id) {
                return wiseSayingList.get(i);
            }
        }
        return null;
    }
    public void modify(Request request) {
        int id = _getIntParam(request.getParams("id"));

        WiseSaying ws = _getFindById(id);

        if (ws == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        // 위쪽 부분은 delete와 똑같음

        System.out.println("기존 명언 : " + ws.getContent());
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine().trim();
        // 기존 명언 재정의
        System.out.println("기존 작가 : " + ws.getAuthor());
        System.out.print("작가 : ");
        String author = Container.getSc().nextLine().trim();
        // 기존 작가 재정의

        ws.setContent(content);
        ws.setAuthor(author);
        // WiseSaying 객체에 setter 메서드 추가하여 매개변수로 전달

        System.out.println(id + "번 명언이 수정되었습니다.");
    }
}
