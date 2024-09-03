package aps.알고리즘응용;

import java.util.*;

public class 그래프탐색_02_BFS {

    //따옴표 쓰고 복붙하면 자동으로 처리 완료
    static String input ="7 9\n" +
            "1 2\n" +
            "1 3\n" +
            "1 6\n" +
            "2 4\n" +
            "2 7\n" +
            "3 4\n" +
            "4 7\n" +
            "5 6\n" +
            "5 7\n";

    static int V, E; //정점의 갯수, 간선의 갯수
    static List<Integer>[] adj; //인접리스트
    static boolean[] visited; //방문체크

    //방향이 없는 무향 그래프, 가중치가 없는 그래프의 경우
    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        V = sc.nextInt();
        E = sc.nextInt();

        adj = new ArrayList[V + 1]; //배열만 만든 거고 안에 리스트 생성은 X
        visited = new boolean[V + 1];
        for(int i = 1; i <= V; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            adj[A].add(B); //무향이니까 양쪽에
            adj[B].add(A);
        }//간선입력 완료

        bfs(1);

    }//main

    //v : 시작 정점
    private static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();

        q.add(v); //시작 정점을 큐에 넣는다
        visited[v] = true; //시작 정점 방문 체크

        //큐가 공백상태가 아니면 돌겠다
        while(!q.isEmpty()){
            int curr = q.poll(); //정점 하나를 꺼내고
            System.out.println(curr);

            //curr과 인접하면서 방문하지 않은 친구를 방문할 거야
            for(int w : adj[curr]){
                //인접 리스트는 나와 연결되어 있는 친구만 들어있으므로 굳이 인접 조건을 넣을 필요는 없다
                if(!visited[w]){
                    q.add(w);
                    visited[w] = true;
                }
            }

//            위와 동일
//            for(int i = 0; i < adj[curr].size(); i++){
//                int w = adj[curr].get(i);
//            }

        }
    }//bfs
}
