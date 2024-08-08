package aps;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_큐API {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        //삽입
        q.add(1); //추가될 수 없으면 예외 발생 => 프로그램 멈춤
        q.offer(1); //추가될 수 없으면 return false

        System.out.println(q);

        //삭제
        q.remove(); //삭제될 수 없으면 예외 발생
        q.poll(); //삭제될 수 없으면 return null;

        System.out.println(q);

        //q.remove();
        q.poll();

        System.out.println("동작 완료");

        //조회
        q.element(); //예외 발생
        q.peek(); //return null;
    }
}
