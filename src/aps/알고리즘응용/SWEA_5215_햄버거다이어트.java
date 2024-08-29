package aps.알고리즘응용;

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
    static int N, L; //N : 재료의 개수, L : 제한 칼로리
    static int[] cals;
    static int[] scores;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            N = sc.nextInt();
            L = sc.nextInt();
            cals = new int[N];
            scores = new int[N];

            for(int i = 0; i < N; i++){
                scores[i] = sc.nextInt();
                cals[i] = sc.nextInt();
            }//input 끝

            ans = 0;

            //비트마스킹 방법도 가능하지만 이번에는...

            makeBurger(0, 0, 0);

            System.out.println("#" + tc + ans);
        }//tc
    }//main
    
    //중간 결과를 들고 다니겠다
    private static void makeBurger(int idx, int sumScore, int sumCal){
        //idx-1번째 재료까지 고려했으나 중간에 칼로리 초과하여 되돌아감
        if(sumCal > L){
            return;
        }

        //기저조건
        if(idx == N){
            //모든 재료를 전부 다 고려했음(모든 경우의 수 고려함)
            //지금 경우의 수에서 만들어진 햄버거가 베스트인지 아닌지 판단
            if(ans < sumScore)
                ans = sumScore;
            return;
        }

        //재귀부분
        //이번에 idx재료 사용했다
        makeBurger(idx + 1, sumScore + scores[idx], sumCal + cals[idx]);
        //이번에 idx재료 사용하지 않았다
        makeBurger(idx + 1, sumScore, sumCal);
    }
}
