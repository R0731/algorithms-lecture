package LinkedList;

class Node{
    String data;
    Node link;
}

class SinglyLinkedList{
    Node head;
    int size;

    SinglyLinkedList(){
        head = new Node();
    }

    void addData(int i, String data){
        if(i < 0 || i > size) {
            System.out.println("접근 불가");
            return;
        }

        size++;

        Node newNode = new Node();
        newNode.data = data;

        Node curr = head;
        for(int k = 0; k < i; k++){
            curr = curr.link;
        }

        newNode.link = curr.link;
        curr.link = newNode;
    }

    void removeData(int i){

        if(i < 0 || i > size){
            System.out.println("접근불가");
             return;
        }

        size--;

        Node curr = head;
        for(int k = 0; k < i; k++){
            curr = curr.link;
        }

        curr.link = curr.link.link;
    }

}

public class SinglyList {
    public static void main(String[] args) {

    }



}
