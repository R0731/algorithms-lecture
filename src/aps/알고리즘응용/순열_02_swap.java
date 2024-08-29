package aps.알고리즘응용;

import java.util.Arrays;

public class 순열_02_swap {
    static int[] nums;
    static int N;

    public static void main(String[] args) {
        nums = new int[]{0, 1, 2};

        N = nums.length;

        perm(0);
    }//main

    //idx : 현재 판단 위치
    private static void perm(int idx){
        //기저조건
        //if(visited == (1<<N)-1) return; 이 코드도 가능
        if(idx == N){
            System.out.println(Arrays.toString(nums));
            return;
        }

        //재귀부분
        for(int i = idx; i < N; i++){
            swap(i, idx);
            perm(idx + 1);
            swap(i, idx); //다음 과정을 위해서 원상 복구
        }
    }

    //바꾸고 싶은 배열이 static하게 선언되어있으니 위치 2개만 인자로 보냄
    private static void swap(int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
