package 자율학습.DFS.S2알고리즘수업깊이우선탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 백준24479_알고리즘수업깊이우선탐색1 {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean [] visited;
    static int [] answer;
    static int order; //방문 순서를 나타낼 변수

    static void dfs(int idx){
        visited[idx] = true;
        answer[idx] = order;
        order++;

        for(int i = 0; i < graph[idx].size(); i++){
            int next = graph[idx].get(i);
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //정점의 수가 최대 10만이기 때문에 배열 대신 Arraylist를 사용
        graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        answer = new int[N + 1];
        order = 1;

        //1. 그래프 만들기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        //2. 오름차순 정렬
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        //3. DFS
        dfs(R);

        //4. 출력
        for(int i = 1; i <= N; i++){
            System.out.println(answer[i]);
        }
    }
}
