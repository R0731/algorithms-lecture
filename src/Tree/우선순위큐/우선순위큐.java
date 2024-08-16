package Tree.우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;

class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    //o : 상대방
    //(나, 상대방)
    public int compareTo(Person o) {
        /*
        compareTo는 -1(음수), 0, 1(양수) 셋 중 하나를 리턴
        0 : 동일하다
        1 : (나와 상대방의) 위치를 바꾼다
        -1 : 위치를 바꾸지 않는다
         */

//        if(this.age == o.age)
//            return 0;
//        if(this.age > o.age)
//            return 1;
//        return -1;

//        위의 if문 대신 아래처럼 간단하게 정렬기준을 만들어줄 수 있다
        return this.age - o.age;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class 우선순위큐 {
    public static void main(String[] args) {
        //우선순위큐는 기본적으로 최소힙으로 구현이 된다
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(-10);
        pq.add(40);

        while(!pq.isEmpty()) {
            int data = pq.poll();
            System.out.println(data);
        }
        
        //Comperator나 Collection을 사용해 정렬 순서를 바꿀 수 있다
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        pq2.add(10);
        pq2.add(20);
        pq2.add(30);
        pq2.add(-10);
        pq2.add(40);

        while(!pq2.isEmpty()) {
            int data = pq2.poll();
            System.out.println(data);
        }

        //정렬 기준을 정해주지 않으면 우선순위큐는 관리를 하지 못해 런타임 에러가 나게 된다
        //따라서 클래스에 Comparable나 Comparator를 만들어서 관리해준다
//        PriorityQueue<Person> personPQ = new PriorityQueue<Person>(new PersonComparator());

        //메서드 하나만 정의하는 경우에는 아래처럼 람다식을 이용할 수 있다.
        PriorityQueue<Person> personPQ = new PriorityQueue<>((p1, p2) -> {return p2.age - p1.age;});

        personPQ.add(new Person("루나", 3));
        personPQ.add(new Person("데이지", 1));
        personPQ.add(new Person("맥스", 8));

        while(!personPQ.isEmpty()) {
            Person p = personPQ.poll();
            System.out.println(p);
        }

    }
}
