package 문제풀이;

import java.util.Arrays;
import java.util.Scanner;

public class 보호필름 {
    static int D, W, K; //D 행 3 - 13, W 열 1- 20, K 통과기준 1 - D
    static int[][] film; //보호필름 저장
    static int ans; //정답(최소투약횟수)
    static int[] A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            film = new int[D][W];
            A = new int[W]; //이미 0으로 초기화 완료
            B = new int[W];
            Arrays.fill(B, 1);

            for(int i = 0; i < D; i++){
                for(int j = 0; j < W; j++){
                    film[i][j] = sc.nextInt();
                }
            }//보호입력 완료

            ans = K; //통과기준인 K만큼 쏠 수 있으므로

            makefilm(0, 0);

            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main

    //idx : 현재 약을 주입하려는 행
    //cnt : 약품을 주입 횟수
    private static void makefilm(int idx, int cnt) {
        //백트래킹 가지치기
        if(isOk()) { //백트래킹 1. 0행에서 해봤더니 괜찮아 더 실행할 필요 x
            ans = Math.min(ans, cnt);
            return;
        }

        if(ans < cnt) return; //백트래킹 2. 이미 나는 더 작은 수를 가지고 있으므로 더 큰 값은 실행할 필요 없음

        if(idx == D) {
            return;
        }

        //원상복구를 위한 복제배열 생성
        int[] tmp = film[idx];

        //1. 주입 X
        makefilm(idx + 1, cnt);
        //2. 주입 A
//        yak(idx, 0);
        film[idx] = A;
        makefilm(idx + 1, cnt + 1);
        //3. 주입 B
//        yak(idx, 1);
        film[idx] = B;
        makefilm(idx + 1, cnt + 1);

        //원상복구
        film[idx] = tmp;

    }//makefilm

    private static void yak(int r, int drug){
        for(int i = 0; i < W; i++){
            film[r][i] = drug;
        }
    }//yak

    //모든 열이 연속된 특성이 K개인가?
    private static boolean isOk(){
        //열을 고정시킨 상태에서 검사를 할 거야
        for(int c = 0; c < W; c++){
            boolean flag = false;
            int cnt = 1;
            for(int r = 1; r < D; r++){
                if(film[r][c] == film[r - 1][c]) cnt++; //이전의 나와 같다면 카운트
                else cnt = 1;

                if(cnt >= K){
                    flag = true;
                    break;
                }
            }//해당 열 검사 완료
            if(!flag) return false; //해당 열이 통과하지 못했으므로 이후는 볼 필요 없음
        }//모든 열 검사 완료
        return true;
    }//isOk

    static String input = "10\n" +
            "6 8 3\n" +
            "0 0 1 0 1 0 0 1\n" +
            "0 1 0 0 0 1 1 1\n" +
            "0 1 1 1 0 0 0 0\n" +
            "1 1 1 1 0 0 0 1\n" +
            "0 1 1 0 1 0 0 1\n" +
            "1 0 1 0 1 1 0 1\n" +
            "6 8 3\n" +
            "1 1 1 1 0 0 1 0\n" +
            "0 0 1 1 0 1 0 1\n" +
            "1 1 1 1 0 0 1 0\n" +
            "1 1 1 0 0 1 1 0\n" +
            "1 1 0 1 1 1 1 0\n" +
            "1 1 1 0 0 1 1 0\n" +
            "6 8 4\n" +
            "1 1 0 0 0 1 1 0\n" +
            "1 0 1 0 0 1 1 1\n" +
            "0 1 0 0 1 1 0 0\n" +
            "1 0 1 0 0 0 0 0\n" +
            "1 1 0 0 0 0 0 0\n" +
            "1 0 0 0 1 1 1 1\n" +
            "6 4 4\n" +
            "1 1 0 0\n" +
            "0 1 0 1\n" +
            "0 0 0 1\n" +
            "1 1 1 1\n" +
            "1 1 0 1\n" +
            "1 0 1 0\n" +
            "6 10 3\n" +
            "0 1 0 0 0 1 0 0 1 1\n" +
            "0 1 1 0 0 1 0 0 1 0\n" +
            "0 1 0 0 1 0 1 1 1 1\n" +
            "0 0 0 0 0 1 1 1 1 0\n" +
            "0 1 0 0 1 1 1 1 1 1\n" +
            "1 0 0 0 1 1 0 0 1 1\n" +
            "6 6 5\n" +
            "0 0 0 0 0 0\n" +
            "0 0 0 0 0 0\n" +
            "0 0 0 0 0 0\n" +
            "0 0 0 0 0 0\n" +
            "0 0 0 0 0 0\n" +
            "0 0 0 0 0 0\n" +
            "6 6 4\n" +
            "1 1 1 1 1 1\n" +
            "0 0 0 0 0 1\n" +
            "0 1 1 1 0 1\n" +
            "0 1 0 1 0 1\n" +
            "0 1 0 0 0 1\n" +
            "0 1 1 1 1 1\n" +
            "8 15 3\n" +
            "0 1 1 0 0 1 1 0 1 1 0 0 0 0 0\n" +
            "1 0 0 0 1 1 0 0 0 0 0 1 0 1 1\n" +
            "1 1 0 1 0 1 0 1 0 1 0 1 0 0 0\n" +
            "0 1 1 1 0 0 1 0 0 0 0 1 0 0 0\n" +
            "0 0 0 0 0 0 1 0 0 0 1 1 0 0 1\n" +
            "1 0 1 0 0 1 0 1 1 1 1 0 1 1 1\n" +
            "0 0 0 0 0 1 1 1 0 0 0 0 0 1 0\n" +
            "0 0 1 0 1 1 0 1 1 0 0 0 1 0 0\n" +
            "10 20 4\n" +
            "1 0 1 1 1 1 1 1 1 1 0 0 1 1 1 0 1 1 0 1\n" +
            "1 1 0 1 1 1 0 0 1 0 0 0 1 1 1 1 0 0 1 0\n" +
            "1 1 0 1 1 0 0 0 1 1 1 1 1 0 0 1 1 0 1 0\n" +
            "0 0 0 1 1 0 0 0 0 1 0 0 1 0 1 1 1 0 1 0\n" +
            "0 1 1 0 1 0 1 0 1 0 0 1 0 0 0 0 1 1 1 1\n" +
            "1 0 1 0 1 0 1 1 0 0 0 0 1 1 1 0 0 0 0 0\n" +
            "0 1 0 0 1 1 0 0 0 0 0 1 1 0 0 1 1 0 1 1\n" +
            "1 0 0 0 0 1 0 1 1 0 1 1 0 1 0 0 1 1 1 0\n" +
            "0 1 1 0 0 1 0 1 0 0 0 0 0 0 0 1 1 1 0 1\n" +
            "0 0 0 0 0 0 1 1 0 0 1 1 0 0 0 0 0 0 1 0\n" +
            "13 20 5\n" +
            "1 1 0 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 0 0\n" +
            "1 1 1 1 0 1 0 1 0 0 0 0 1 0 0 0 0 1 0 0\n" +
            "1 0 1 0 1 1 0 1 0 1 1 0 0 0 0 1 1 0 1 0\n" +
            "0 0 1 1 0 1 1 0 1 0 0 1 1 0 0 0 1 1 1 1\n" +
            "0 0 1 0 0 1 0 0 1 0 0 0 0 1 0 0 0 0 1 1\n" +
            "0 0 1 0 0 0 0 0 0 0 0 0 1 1 1 0 0 1 0 1\n" +
            "0 0 0 1 0 0 0 0 0 0 1 1 0 0 0 1 0 0 1 0\n" +
            "1 1 1 0 0 0 1 0 0 1 1 1 0 1 0 1 0 0 1 1\n" +
            "0 1 1 1 1 0 0 0 1 1 0 1 0 0 0 0 1 0 0 1\n" +
            "0 0 0 0 1 0 1 0 0 0 1 0 0 0 0 1 1 1 1 1\n" +
            "0 1 0 0 1 1 0 0 1 0 0 0 0 1 0 1 0 0 1 0\n" +
            "0 0 1 1 0 0 1 0 0 0 1 0 1 1 0 1 1 1 0 0\n" +
            "0 0 0 1 0 0 1 0 0 0 1 0 1 1 0 0 1 0 1 0\n";
}
