package aps;

class Node {
    String data;
    Node link;  //어떻게 이게 새 노드를 연결하는 필드로 쓰일 수 있을까?
}

class SinglyLinkedList {
    Node head; //head노드 생성
    int size;

    SinglyLinkedList() {

        head = new Node(); //생성자 안에서 head라는 변수에 새로운 노드 할당
    }

    //삽입
    void addDate(int i, String data) {
        //i인덱스 데이터 삽입
        //0이면 제일 앞에 추가
        //size와 같으면 제일 뒤에 추가
        if (0 > i || i > size) {//범위체크
            System.out.println("삽입할 위치가 잘못되었습니다.");
            return;
        }

        size++;

        //새 노드 생성
        Node newNode = new Node();
        newNode.data = data;

        //삽입할 위치 앞에 있는 노드 찾기
        Node curr = head;
        for (int k = 0; k < i; k++) {
            curr = curr.link; // 이 부분은 어떻게 연결하는 과정이 되는 걸까?
            // 그냥 다음노드로 이동.
        }

        //새 노드부터 연결
        newNode.link = curr.link;
        curr.link = newNode;

    }

    //삭제
    void removeData(int i) {
        //0번 : 제일 앞에 있는 데이터 삭제
        //size - 1 번 : 마지막 데이터 삭제

        if (0 > i || i >= size) {
            System.out.println("삭제할 수 없는 범위입니다.");
            return;
        }

        size--;

        //삭제할 노드의 앞 노드로 이동
        Node curr = head;

        for(int k = 0; k < i; k++){
            curr = curr.link;
        }

        curr.link = curr.link.link;

    }

    //조회
    void printAll(){
        Node curr = head.link;

        while(curr != null){
            System.out.println(curr.data + ">");
            curr = curr.link;
        }
            System.out.println();
    }

    //데이터 개수
}

public class LinkedList_단순연결리스트 {
    public static void main(String[] args) {
       SinglyLinkedList list = new SinglyLinkedList();

       list.addDate(0, "서울 8반 소남주");
       list.printAll();
       list.addDate(0, "서울 김서현");
       list.addDate(0, "서울 장다은");
       list.printAll();

       list.removeData(0);
       list.removeData(0);
       list.removeData(0);
       list.removeData(0);
       list.printAll();

    }
}
