package 문제풀이;

import java.util.Scanner;

public class 등산로조성 {
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1}; //상하좌우
    static int N, K, maxH, ans;
    static int[][] mountain;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            N = sc.nextInt(); //3 ~~ 8
            K = sc.nextInt(); //1 ~~ 5
            maxH = 0; //1 ~ 20
            ans = 0; //등산로길이
            mountain = new int[N][N];
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    mountain[i][j] = sc.nextInt();
                    if(maxH < mountain[i][j]) maxH = mountain[i][j];
                }
            }//입력 받으면서 최대 높이 찾기

            //가장 높은 봉우리에서 등산로 조성 시작
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mountain[i][j] == maxH) {
                        work(i, j, 1, true); //공사시작
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main

    //r, c : 현재 좌표, dist : 지금까지의 공사 길이, skill : 공사를 할 수 있는가
    private static void work(int r, int c, int dist, boolean skill){
            if(dist > ans) ans = dist;

            visited[r][c] = true; //방문했고
            /////////////////////////////////////////
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                //경계를 벗어나거나 이미 방문한 곳이라면 쳐내기
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                //1.다음 좌표의 높이가 내 높이보다 낮다
                if(mountain[r][c] > mountain[nr][nc])
                    work(nr, nc, dist + 1, skill);
                //2.다음 좌표의 높이가 나와 같거나 높다
                else if(skill && mountain[r][c] > mountain[nr][nc] - K){
                    int tmp = mountain[nr][nc];//원상복구 기록
                    mountain[nr][nc] = mountain[r][c] - 1;
                    work(nr, nc, dist + 1, false);
                    mountain[nr][nc] = tmp; //원상복구
            }

            /////////////////////////////////////////
            visited[r][c] = false; //원상복구

        }
    }//skill

    static String input = "10\n" +
            "5 1\n" +
            "9 3 2 3 2\n" +
            "6 3 1 7 5\n" +
            "3 4 8 9 9\n" +
            "2 3 7 7 7\n" +
            "7 6 5 5 8\n" +
            "3 2\n" +
            "1 2 1\n" +
            "2 1 2\n" +
            "1 2 1\n" +
            "5 2\n" +
            "9 3 2 3 2\n" +
            "6 3 1 7 5\n" +
            "3 4 8 9 9\n" +
            "2 3 7 7 7\n" +
            "7 6 5 5 8\n" +
            "4 4\n" +
            "8 3 9 5\n" +
            "4 6 8 5\n" +
            "8 1 5 1\n" +
            "4 9 5 5\n" +
            "4 1\n" +
            "6 6 1 7\n" +
            "3 6 6 1\n" +
            "2 4 2 4\n" +
            "7 1 3 4\n" +
            "5 5\n" +
            "18 18 1 8 18\n" +
            "17 7 2 7 2\n" +
            "17 8 7 4 3\n" +
            "17 9 6 5 16\n" +
            "18 10 17 13 18\n" +
            "6 4\n" +
            "12 3 12 10 2 2\n" +
            "13 7 13 3 11 6\n" +
            "2 2 6 5 13 9\n" +
            "1 12 5 4 10 5\n" +
            "11 10 12 8 2 6\n" +
            "13 13 7 4 11 7\n" +
            "7 3\n" +
            "16 10 14 14 15 14 14\n" +
            "15 7 12 2 6 4 9\n" +
            "10 4 11 4 6 1 1\n" +
            "16 4 1 1 13 9 14\n" +
            "3 12 16 14 8 13 9\n" +
            "3 4 17 15 12 15 1\n" +
            "6 6 13 6 6 17 12\n" +
            "8 5\n" +
            "2 3 4 5 4 3 2 1\n" +
            "3 4 5 6 5 4 3 2\n" +
            "4 5 6 7 6 5 4 3\n" +
            "5 6 7 8 7 6 5 4\n" +
            "6 7 8 9 8 7 6 5\n" +
            "5 6 7 8 7 6 5 4\n" +
            "4 5 6 7 6 5 4 3\n" +
            "3 4 5 6 5 4 3 2\n" +
            "8 2\n" +
            "5 20 15 11 1 17 10 14\n" +
            "1 1 11 16 1 14 7 5\n" +
            "17 2 3 4 5 13 19 20\n" +
            "6 18 5 16 6 7 8 5\n" +
            "10 4 5 4 9 2 10 16\n" +
            "2 7 16 5 8 9 10 11\n" +
            "12 19 18 8 7 11 15 12\n" +
            "1 20 18 17 16 15 14 13\n";
}
