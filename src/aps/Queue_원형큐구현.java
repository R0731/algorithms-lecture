package aps;

import java.util.Arrays;

public class Queue_원형큐구현 {

    //배열의 한 칸은 항상 비워둘 것이기 때문에 배열크기N-1, 데이터를 3개 담을 수 있다
    static String[] queue = new String[4];
    //정수의 초기값 0으로 세팅
    static int front, rear;
    static int N = queue.length;
    static int size;

    public static void main(String[] args) {

        enQueue("루나");
        enQueue("데이지");
        enQueue("맥스");
        enQueue("토끼");

        System.out.println(size());
        System.out.println(Arrays.toString(queue));

        deQueue();
        deQueue();
        deQueue();
        deQueue();
        enQueue("햄스터");
        enQueue("고양이");
        enQueue("토끼");

        System.out.println();
        enQueue("사자");

        System.out.println(size());
        System.out.println(Arrays.toString(queue));

    }

    //포화상태 확인
    static boolean isFull() {
        //이대로 하면 front가 0, rear가 3인 경우(front가 rear의 위치보다 앞에 있는 경우) 문제가 생기게 된다
        //return front - rear == 1;
        //음수가 나오면 제대로 계산이 되지 않으므로 앞에 배열 크기를 더해서 음수가 나오는 걸 방지해준다
        return (N + front - rear) % N == 1;
    }

    //공백상태 확인
    static boolean isEmpty() {
        //front와 rear가 같은 지 확인
        return front == rear;
    }

    //삽입
    static void enQueue(String data) {
        if(isFull()){
            System.out.println("큐가 가득 찼습니다.");
            return;
        }

        size++;
        rear = (rear + 1) % N; // rear를 올려주고
        queue[rear] = data; //rear를 이용해 데이터 삽입
    }

    //삭제
    static String deQueue() {
        if(isEmpty()){
            System.out.println("큐가 비어있습니다.");
            return null;
        }

        size--;
        front = (front + 1) % N; //front를 올려주고
        String item = queue[front];
        queue[front] = null; //데이터를 가져온 칸 비워주기
        return item; //front가 가리키는 위치를 리턴
    }

    //조회
    static String Qpeek() {
        if(isEmpty()){
            System.out.println("큐가 비어있습니다.");
            return null;
        }

        return queue[(front + 1) % N];
    }

    //데이터 개수
    static int size() {
        //return (N + rear - front) % N;
        //size 변수를 이용해 구현할 수도 있다.
        return size;
    }
}
