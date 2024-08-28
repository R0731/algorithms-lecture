package aps.알고리즘응용;

import java.util.Arrays;

public class 이진검색02_재귀 {
    //1번 방법은 예전 기본 시간에 함

    static int[] arr = {8, 9, 17, 21, 23, 35, 88, 369};
    static int key = 19;

    public static void main(String[] args) {
        binarySearch(0, arr.length - 1);

//        Arrays.binarySearch(null, 0); 배열과 key 입력해주면 반환해준다
    }

    private static boolean binarySearch(int left, int right){
        //기저조건
        if(left > right) return false;
        //재귀부분
        int mid = (left + right) / 2;
        //같다면
        if(arr[mid] == key) return true;
        //중앙값이 크다면 -> 왼쪽구간으로
        else if(arr[mid] > key)
            return binarySearch(left, mid-1);
        //중앙값이 작다면 -> 오른쪽구간으로
        else
            return binarySearch(mid + 1, right);
    }

}
