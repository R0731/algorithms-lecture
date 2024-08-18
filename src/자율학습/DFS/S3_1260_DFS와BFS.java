package 자율학습.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S3_1260_DFS와BFS {

    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited1;
    static boolean[] visited2;
    static int[] answer1;
    static int[] answer2;
    static int order1;
    static int order2;

    static void dfs(int idx){
        visited1[idx] = true;
        answer1[idx] = order1;
        order1++;

        for(int i = 1; i <= graph[idx].size(); i++){
            int next = graph[idx].get(i);
            if(!visited1[i]){
                dfs(next);
            }
        }
    }

    static void bfs(int idx){
        visited2[idx] = true;
        answer2[idx] = order2;
        order2++;

        for(int i = 1; i <= )
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        V = Integer.parseInt(st1.nextToken());

        //1. 그래프 만들기
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        visited1 = new boolean[N + 1];
        visited2 = new boolean[N + 1];

        answer1 = new int[N + 1];
        answer2 = new int[N + 1];

        for(int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        //2. 오름차순 정렬
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        order1 = 1;
        //3. dfs
        dfs(V);

        //4. bfs
    }
}
