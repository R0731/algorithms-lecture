package aps.알고리즘응용;

import java.util.Arrays;

public class 병합정렬01 {
    static int[] arr = {69, 10, 3, 8, 2, 16};
    static int N = arr.length;
    static int[] tmp = new int[N];

    public static void main(String[] args) {
        mergeSort(0, N - 1);
        System.out.println(Arrays.toString(arr));
    }

    //left : 구간의 시작 위치 / right : 구간의 끝
    private static void mergeSort(int left, int right){
        if(left < right){ //조건에 해당할 때만 재귀 호출 : 아직 쪼갤 것이 남아있다
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right){
        int L = left; //왼쪽구간의 시작 포인트
        int R = mid + 1; //오른쪽 구간의 시작 포인트

        int idx = left; //tmp 배열의 인덱스

        //아직 왼쪽도 오른쪽도 끝에 도달하지 않았다(=아직 정렬할 게 남았다)
        while(L <= mid && R <= right){
            if(arr[L] <= arr[R]){
                tmp[idx] = arr[L];
                idx++;
                L++;
            }else{
                tmp[idx] = arr[R];
                idx++;
                R++;
            }
        }

        //왼쪽 구간에 값이 남았어
        if(L <= mid){
            for(int i = L; i <= mid; i++){
                tmp[idx++] = arr[i];
            }
        }
        //오른쪽 구간에 값이 남았어
            else{
                for(int i = R; i <= right; i++){
                    tmp[idx++] = arr[i];
                }
            }

        //원본 배열에 반영
        for(int i = left; i <= right; i++){
            arr[i] = tmp[i];
        }
    }
}
