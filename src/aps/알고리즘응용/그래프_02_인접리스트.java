package aps.알고리즘응용;

import java.util.*;

public class 그래프_02_인접리스트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //V, E의 개수를 준다
        int V = sc.nextInt(); //정점의 개수 (0 or 1로 시작-문제를 보고 판단)
        int E = sc.nextInt(); //간선의 개수

        List<Integer>[] adjList = new ArrayList[V];
        Map<Integer, List<Integer>> adjList3 = new HashMap<>(); //이런 방법도 있다

        //기본적으로 전부 생성(초기화)을 해주어야 nullPointerException이 발생하지 않는다
        for(int i = 0; i < V; i++){
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt(); //두개의 정점이 주어진다

            //가중치를 같이 저장하고 싶다면 1. 클래스를 정의해서 넣던가 2.int[]이용해서 넣던지
            adjList[A].add(B);
            adjList[B].add(A);
        }

        /*인접행렬 vs 인접리스트
        1. 만약 정점이 100만개인데 간선이 100개인 것처럼 간선의 수가 정점에 비해 월등하게 적을 때 배열은 100만*100만의 크기를 만들어야 하지만
        인접리스트를 사용하면 메모리를 절약할 수 있다
        2. 인접한 값(임의의 A B의 연결)을 찾을 때 배열에서는 바로 찾을 수 있지만, 인접리스트는 인접한 값을 찾을 때 다른 값을 계속 뒤져봐야 하기 때문에
        인접리스트가 시간이 훨씬 많이 걸린다.
        */
    }
}
