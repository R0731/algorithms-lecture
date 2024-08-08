package aps;

import java.util.Arrays;

public class Queue_삽입정렬 {
    public static void main(String[] args) {

        int[] arr = new int[]{69, 10, 30, 2, 16, 8, 31, 22};

        //삽입 정렬
        // i : 정렬되지 않은 집합의 첫번째 원소
        //arr[0] 어차피 배열된 상태라고 생각하고 시작하기 때문에 arr[1]부터 시작된다.
        for(int i = 1; i < arr.length; i++){
            int data = arr[i];
            //정렬된 집합의 뒤에서부터 비교하여 위치 찾아주기
            int j;
            for(j = i - 1; j >= 0 && arr[j] > data; j--) {
                arr[j + 1] = arr[j];
            }
            //마지막으로 비교한 원소 뒤에 넣어줘야 하기 때문에 j + 1
            arr[j + 1] = data;
            System.out.println(Arrays.toString(arr));
        }
    }
}
