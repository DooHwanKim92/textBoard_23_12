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
        int id = -1;
        try {
            id = Integer.parseInt(request.getParams("id"));
        } catch (NumberFormatException e) {
            System.out.println("id는 정수만 이력이 가능합니다.");
            return;
        }

        System.out.println(id + "번 명언이 삭제되었습니다.");
    }
}
