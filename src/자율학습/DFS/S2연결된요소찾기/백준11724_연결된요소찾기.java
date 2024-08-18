package 자율학습.DFS.S2연결된요소찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11724_연결된요소찾기 {
    static boolean[][] board;
    static boolean[] visited;
    static int N, M;
    static int answer;

    static void dfs(int idx){
        visited[idx] = true;

        for(int i = 1; i <= N; i++){
            if(!visited[i] && board[idx][i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer line = new StringTokenizer(br.readLine());

        N = Integer.parseInt(line.nextToken());
        M = Integer.parseInt(line.nextToken());

        board = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        //1. graph에 연결 정보 채우기
        for(int i = 0; i < M; i++){
            StringTokenizer line2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(line2.nextToken());
            int y = Integer.parseInt(line2.nextToken());
            board[x][y] = board[y][x] = true;
        }

        //2. 재귀함수 호출 - visited의 모든 값이 true가 될 때까지 반복
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        //3.출력
        System.out.println(answer);
    }
}
