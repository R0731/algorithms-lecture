package 자율학습.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S3_1260_DFS와BFS {

    static int N, M, V;
    static boolean[][] graph;
    static ArrayList<Integer> queue; //bfs용
    static boolean[] visited;

    private static void dfs(int idx){
        visited[idx] = true;
        System.out.println(idx + " ");

        for(int i = 1; i <= N; i++){
            if(!visited[i] && graph[idx][i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(){
        //bfs 시작 전 초기화 작업
        queue = new ArrayList<>();
        visited = new boolean[N + 1];

        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty()){
            int idx = queue.remove(0); //queue에서 가장 앞에 있는 녀석을 꺼내와서 idx에 담겠다
            System.out.println(idx + " ");

            for(int i = 1; i <= N; i++){
                if(!visited[i] && graph[idx][i]) {
                    queue.add(i); //i번 노드를 queue에 담겠다
                    visited[i] = true;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());


        //1. 그래프 만들기
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        //2. dfs
        dfs(V);
        System.out.println();

        //3. bfs
        bfs();
    }
}
