package 자율학습;

import java.util.Scanner;

public class DFS_백준2606_바이러스 {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

    public static void dfs(int idx){
        answer++;
        visited[idx] = true;
        for(int i = 1; i <= N; i++){
            if(!visited[i] && graph[idx][i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        //1.그래프 정보 입력
        int x, y;
        for(int i = 0; i < M; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            graph[x][y] = graph[y][x] = true;
        }

        //2.dfs 및 결과 출력
        dfs(1);

        System.out.println(answer - 1); //1을 빼는 이유는 가장 첫 노드인 1번 노드를 빼야 하기 때문
    }
}
