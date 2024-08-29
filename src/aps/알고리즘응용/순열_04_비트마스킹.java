package aps.알고리즘응용;

import java.util.Arrays;

public class 순열_04_비트마스킹 {
    static int[] nums;
    static int N;
    //추가적인 공간 필요
    static int[] result;

    public static void main(String[] args) {
        nums = new int[]{0, 1, 2};
        N = nums.length;
        result = new int[N];

        perm(0, 0);

    }//main

    //idx : 결과 배열에 저장할 위치
    //visited : 사용한 원소를 기록하기 위한 정수
    private static void perm(int idx, int visited){
        //기저조건
        if(idx == N){
            System.out.println(Arrays.toString(result));
            return;
        }

        //재귀부분
        for(int i = 0; i < N; i++){
            if((visited & (1 << i)) != 0) continue;

            result[idx] = nums[i];
            perm(idx + 1, visited | (1 << i));
        }

    }

}
