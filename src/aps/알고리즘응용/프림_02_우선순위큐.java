package aps.알고리즘응용;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 프림_02_우선순위큐 {
    static class Edge implements Comparable<Edge>{
        int A, B, W;

        public Edge(int a, int b, int w) {
            A = a;
            B = b;
            W = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.W - o.W;
        }
    }
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        int V = sc.nextInt(); //정점의 번호 0번부터 시작
        int E = sc.nextInt(); //간선의 수

        //인접리스트 방식
        List<Edge>[] adjList = new ArrayList[V];

        for(int i = 0; i < V; i++){
            adjList[i] = new ArrayList<>();
        }//실제 생성까지

        for(int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();

            adjList[A].add(new Edge(A, B, W)); //무향
            adjList[B].add(new Edge(B, A, W));
        }//입력 끝

        //방문체크
        boolean[] visited = new boolean[V]; //해당 정점 뽑았다

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited[0] = true;

        int ans = 0;

        int pick = 1;

        //1번 방식
//        for(int i = 0; i < adjList[0].size(); i++){
//            pq.add(adjList[0].get(i));
//        }
//        //2번 방식
//        for(Edge e : adjList[0]){
//            pq.add(e);
//        }
        //3번 방식
         pq.addAll(adjList[0]);
        //1, 2, 3번 방식이 모두 똑같이 동작한다

        while(pick != V){
            Edge e = pq.poll();
            if(visited[e.B]) continue; //이미 뽑은 친구라면 continue

            ans += e.W; //비용추가
            visited[e.B] = true;
            pick++;

            pq.addAll(adjList[e.B]);
        }

        System.out.println(ans);

    }//main

    static String input = "7 11\n" +
            "0 1 32\n" +
            "0 2 31\n" +
            "0 5 60\n" +
            "0 6 51\n" +
            "1 2 21\n" +
            "2 4 46\n" +
            "2 6 25\n" +
            "3 4 34\n" +
            "3 5 18\n" +
            "4 5 40\n" +
            "4 6 51\n";
}
