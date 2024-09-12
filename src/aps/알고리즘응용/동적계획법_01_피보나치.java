package aps.알고리즘응용;

import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법_01_피보나치 {
    static int[] callFibo = new int[1000];
    static int[] memo; //계산 값을 저장하기 위한 공간 할당(memoization)
    static {
        memo = new int[1000];
        memo[0] = 0;
        memo[1] = 1;
    }//미리 static한 부분 계산

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(fibo1(N));
        System.out.println(fibo2(N));
        System.out.println(fibo3(N));
        System.out.println(Arrays.toString(callFibo));
    }

    //재귀
    private static int fibo1(int n){
        callFibo[n]++; //각 fibo1(n)이 얼마나 소환되었는지 기록
        //기저조건 n == 0 : 0을 반환 / n == 1 : 1을 반환
        if(n < 2) return n;
        return fibo1(n - 1) + fibo1(n - 2);
    }

    //memoization
    private static int fibo2(int n){
        if(n >= 2 && memo[n] == 0)
            //혹은 전체 배열을 Arrays.fill을 이용해 -1로 채우고 memo[n]이 -1인지 확인해도 ok
            memo[n] = fibo2(n - 1) + fibo2(n - 2);

        return memo[n];
    }

    //dp(동적계획법)
    private static long fibo3(int n){
        //처리할 값이 21억을 넘을 거 같다면 long 처리해야함
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

}
