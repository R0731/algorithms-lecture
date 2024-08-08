package aps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int no;
    String name;
    int myChu;

    public Person(int no, String name, int myChu) {
        this.no = no;
        this.name = name;
        this.myChu = myChu;
    }
}




public class Queue_마이쮸 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Person> q = new LinkedList<>();

        //전체 마이쮸 개수
        int N = 20;

        int pNum = 1;

        q.add((new Person(pNum++, "Kim", 1)));

        while(N > 0) {
            //큐에서 한명이 빠져나와서 마이쮸를 가져간다
            Person person = q.poll();
            N -= person.myChu;
            System.out.println(person.name + "님이 마이쮸를 " + person.myChu + "개 가져갔습니다.");
            System.out.println("남은 마이쮸는 " + N + "개");

            if(N <= 0) {
                System.out.println(person.name + "님이 마지막 마이쮸를 가져갔습니다.");
                break;
            }

            person.myChu++;
            //가져갈 수 있는 개수를 늘리고 삽입
            q.add(person);

            //새 멤버 추가
            String newMember = sc.next();
            System.out.println(newMember + "님이 새로 줄을 섭니다.");
            q.add(new Person(pNum++, newMember, 1));
            System.out.println(newMember);
        }



    }
}
