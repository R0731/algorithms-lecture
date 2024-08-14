//package 자율학습;
//
//import java.util.LinkedList;
//import java.util.Stack;
//
//class Queue <T>{
//
//}
//
//class Graph{
//    class Node{
//        int data;
//        LinkedList<Node> adjacent;
//        boolean marked; //노드를 돌았는지 체크하기 위한 표식
//        //Node의 생성자
//        Node(int data){
//            this.data = data;
//            this.marked = false;
//            adjacent = new LinkedList<Node>();
//        }
//    }
//    Node[] nodes;
//    Graph(int size){
//        nodes = new Node[size];
//        for(int i = 0; i < size; i++){
//            nodes[i] = new Node(i);
//        }
//    }
//    void addEdge(int i1, int i2){
//        Node n1 = nodes[i1]; //데아타가 인덱스와 같으므로 받은 숫자를 인덱스로 사용가능
//        Node n2 = nodes[i2];
//        if(!n1.adjacent.contains(n2)){//두 개의 노드의 인접한 링크드리스트에 상대방이 있는지 확인하고 없을 시 추가
//            n1.adjacent.add(n2);
//        }
//        if(!n2.adjacent.contains(n1)){
//            n2.adjacent.add(n1);
//        }
//    }
//
//    void dfs(){ //dfs일단 0번부터 시작하도록
//        dfs(0);
//    }
//    void dfs(int index){ //시작 인덱스를 받아서 dfs순회 결과를 출력하게 하는 함수
//        Node root = nodes[index]; //해당 인덱스로 노드를 가져오고
//        Stack<Node> stack = new Stack<Node>(); //스택 생성
//        stack.push(root); //현재 노드 스택 추가
//        root.marked = true; //스택에 들어갔다고 추가
//
//        while(!stack.isEmpty()){ //스택에 데이타가 없을 때까지 반복
//            Node r = stack.pop();
//            for(Node n : r.adjacent){
//                if(n.marked == false){ //스택에 추가되지 않은 것만 추가
//                    n.marked = true;
//                    stack.push(n);
//                }
//            }
//            visit(r);
//        }
//    }
//
//    void bfs(){
//        bfs(0);
//    }
//
//    void bfs(int index){
//        Node root = nodes[index];
//        Queue<Node> queue = new Queue<Node>();
//        queue.enqueue(root);
//        root.marked = true;
//        while(!queue.isEmpty()){
//            Node r = queue.dequeu();
//            for(Node n : r.adjacent){
//                if(n.marked == false){
//                    n.marked = true;
//                    queue.enqueue(n);
//                }
//            }
//            visit(r);
//        }
//    }
//
//    //재귀호출을 이용한 dfs
//    void dfsR(Node r){
//       if(r == null) return;
//       r.marked = true;
//       visit(r);
//       for(Node n : r.adjacent){
//           if(n.marked == false){
//               dfsR(n);
//           }
//       }
//    }
//
//    void dfsR(int index){
//        Node r = nodes[index];
//        dfsR(r);
//    }
//
//    void visit(Node n){
//        System.out.println(n.data + " ");
//    }
//}
//
//public class DFS {
//}
