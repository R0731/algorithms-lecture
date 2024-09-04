package aps.알고리즘응용;

import java.util.Scanner;

public class 그래프탐색_01_DFS {

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
    static int[][] odj; //인접행렬
    static boolean[] visited; //방문체크

    //방향이 없는 무향 그래프, 가중치가 없는 그래프의 경우
    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        V = sc.nextInt();
        E = sc.nextInt();

        odj = new int[V + 1][V + 1]; //시작 정점의 번호가 1번부터 시작한다
        visited = new boolean[V + 1];

        for(int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            odj[A][B] = odj[B][A] = 1; //무향이니까
        }//간선입력 완료

        dfs(1);

    }//main

    //v : 현재 내가 있는 정점
    private static void dfs(int v){
        visited[v] = true;
        System.out.println(v);

        //나와 인접하면서 방문하지 않은 정점을 방문하겠다
        for(int i = 1; i <= V; i++){
            //방문한 적 있는지 && 인접한지
            if(!visited[i] && odj[v][i] == 1){
                dfs(i);
            }
        }
    }//dfs
}
