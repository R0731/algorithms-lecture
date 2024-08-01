package aps;

import java.util.Arrays;

public class Array2_선택정렬 {
	public static void main(String[] args) {
		int[] nums = {4, 9, 11, 23, 2, 19, 7, 77};
		
		selectionSort(nums);
		
		System.out.println(Arrays.toString(nums));
	}
	
	static void selectionSort(int[] arr) {
		// 싸이클 횟수 : 배열길이 - 1
		for(int i = 0; i < arr.length; i++) {
			// 최솟값의 인덱스를 저장할 변수
			int minIdx = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			// i와 minIdx의 위치 변경(swap)
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
	}
}
