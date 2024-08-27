package aps.알고리즘응용;

import java.util.Arrays;

public class 조합_02_재귀함수반복문 {
    static String[] 재료 = {"상추", "패티", "토마토", "치즈"};
    static int N, R; //N : 재료의 수, R : 내가 뽑고 싶은 재료의 수
    static String[] sel; //뽑은 재료를 저장할 배열

    public static void main(String[] args) {

    }

    private static void combination(int idx, int sidx){
        //기저조건
        if(sidx == R) {
            //모든 재료를 전부 다 뽑았다
            System.out.println(Arrays.toString(sel));
            return;
        }
        //내가 이미 범위를 정해두고 반복문을 돌릴 거니까 N의 범위를 또 지정할 필요가 없음

        //재귀부분
        for(int i = idx; i < N - R + sidx; i++){
            sel[sidx] = 재료[i]; //재료 뽑았다
            combination(i + 1, sidx + 1);
        }
    }
}
