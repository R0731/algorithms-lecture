package 자율학습.조합;

import java.util.Arrays;
import java.util.Scanner;

public class 조합 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        comb(0, 1);
    }

    private static void comb(int idx, int start_num) {
//        System.out.println(idx+","+start_num);
        if(idx == M){
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i=start_num; i<=N; i++){
            arr[idx] = i;
            comb(idx+1, i+1);
        }
    }
}
