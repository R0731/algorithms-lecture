package linkedList_double;

//같은 패키지 안에 동일한 class정의가 불가능하여 따로 패키지를 만들었다.
class Node{
    String data;
    Node prev;
    Node next;
}

class DoublyLinkedList{
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList(){
        head = new Node();
        tail = new Node();
        head.next = tail; //head와 tail 더미를 만들어서 서로 연결된 상태로 구현
        tail.prev = head;
    }

    //삽입
    void addData(int i, String data){
        //0 : 제일 앞에 삽입
        //size : 제일 뒤에 삽입
        if(i < 0 || i > size){
            System.out.println("삽입할 수 없는 범위입니다.");
            return;
        }

        size++;

        //삽입 위치 앞의 노드를 찾는다
        Node curr = head;

        for(int k = 0; k < i; k++){
            curr = curr.next;
        }

        //새 노드 만들어주기
        Node newNode = new Node();
        newNode.data = data;

        //새 노드 연결해주기
        newNode.next = curr.next;
        newNode.prev = curr;

        //기존 노드 연결 재구성
        curr.next.prev = newNode;
        curr.next = newNode;
    }

    //삭제
    void removeData(int i){
        //0 : 제일 앞의 데이터 삭제
        //size - 1 : 제일 뒤의 데이터 삭제

        if(i < -0 || i >= size){
            System.out.println("삭제할 수 없는 범위입니다.");
            return;
        }

        size--;

        //삭제할 위치를 찾기
        //rmNode는 지역변수이므로 메서드 리턴과 동시에 접근불가 : GC가 냠
        Node rmNode = head.next;

        for(int k = 0; k < i; k++){
            rmNode = rmNode.next;
        }

        rmNode.prev.next = rmNode.next;
        rmNode.next.prev = rmNode.prev;

    }

    //역순으로 조회
    void printReverse(){
        Node curr = tail.prev;
        String str = "";
        while(curr != head){
            str = "<-" + curr.data + str;
            curr = curr.prev;
        }
        System.out.println(str);
    }

}



public class LinkedList_양방향연결리스트 {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addData(0, "강아지");
        list.addData(0, "토끼");
        list.addData(0, "햄스터");
        list.addData(0, "고양이");

        list.printReverse();

        list.removeData(1);
        list.printReverse();

        System.out.println(list.size);
    }
}
