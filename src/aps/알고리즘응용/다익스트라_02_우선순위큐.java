package aps.알고리즘응용;

import java.util.*;

public class 다익스트라_02_우선순위큐 {
    //직접 작성해보기
    static class Edge implements Comparable<Edge>{
        int V, W;

        public Edge(int v, int w) {
            V = v;
            W = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.W - o.W;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int V, E;

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        V = sc.nextInt();
        E = sc.nextInt();

        List<Edge>[] adjList = new ArrayList[V];
        for(int i = 0; i < V; i++){
            adjList[i] = new ArrayList<>();
        }

        int[] dist = new int[V];
        Arrays.fill(dist, INF);

        for(int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();

            adjList[A].add(new Edge(B, W));
        }//입력 끝

        boolean[] visited = new boolean[V];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited[0] = true;

        int ans = 1;

        int pick = 1;

        pq.addAll(adjList[0]);

        while(pick != V){
            Edge e = pq.poll();
            if(visited[e.V]) continue;

            ans += e.W;
            visited[e.V] = true;
            pick++;

            for(int i = 0; i < adjList[e.V].size(); i++){
                if(adjList[e.V].get(i).W > e.W + adjList[e.V].get(i).W){

                }
            }
//            pq.addAll(adjList[e.B]);
        }

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
