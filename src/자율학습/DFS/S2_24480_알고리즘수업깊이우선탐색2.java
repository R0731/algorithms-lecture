package 자율학습.DFS;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class S2_24480_알고리즘수업깊이우선탐색2 {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int order;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        answer = new int[N + 1];
        order = 1;

        //1. 그래프 만들기
        for(int i = 0; i < M; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        //2. 내림차순
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        //3. 재귀함수 호출
        dfs(R);
        
        //4. 출력
        for(int i = 1; i <= N; i++){
            System.out.println(answer[i]);
        }
    }
}
