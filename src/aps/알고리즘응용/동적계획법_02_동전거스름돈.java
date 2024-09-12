package aps.알고리즘응용;

import java.util.Scanner;

public class 동적계획법_02_동전거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int money = sc.nextInt(); //해당 거스름돈의 최소 동전 개수
        int[] dp = new int[money + 1];

        //1, 4, 6원을 고민하려고 함
        for(int i = 1; i <= money; i++){
            int minCnt = Integer.MAX_VALUE;
            minCnt = Math.min(minCnt, dp[i - 1] + 1);

            if(i >= 4) minCnt = Math.min(minCnt, dp[i - 4] + 1);
            if(i >= 6) minCnt = Math.min(minCnt, dp[i - 6] + 1);
            dp[i] = minCnt;
        }//동전 전부 고려

        System.out.println(dp[money]);
    }//main
}
