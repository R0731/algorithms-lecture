package aps;

import java.util.Arrays;

public class Queue_우선순위큐1차원배열 {
//삽입정렬을 활용해 우선순위큐1차원배열을 만들어보자

    static int[] queue = new int[100];
    static int front = -1;
    static int rear = -1;

    public static void main(String[] args) {
        enQueue(10);
        enQueue(12);
        enQueue(8);
        enQueue(2);
        enQueue(35);

        System.out.println(deQueue());
        System.out.println(deQueue());
        System.out.println(deQueue());

    }

    //삽입
    static void enQueue(int data) {
        int i = ++rear;
        int j;
        for (j = i - 1; j >= 0 && queue[j] > data; j--) {
            queue[j + 1] = queue[j];
        }
        queue[j + 1] = data;
    }

    //삭제
    static int deQueue() {
        return queue[++front];
    }

}

