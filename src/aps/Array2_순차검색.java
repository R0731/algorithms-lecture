package aps;

import java.util.Arrays;

public class Array2_순차검색 {
	public static void main(String[] args) {
		int[] arr = {4, 9, 11, 23, 2, 19, 7};
		int key = 7;
		int result = searchForNoSort(arr, key);
		int result2 = searchWhileNoSort(arr, key);
		//int result4 = searchWhileSort(arr, key);
		System.out.println(result);
		System.out.println(result2);
		
		Arrays.sort(arr);
		int result3 = searchForSort(arr, 11);
		
		System.out.println(result3);
		
	}
	
	// 찾고자하는 key의 index를 return
	static int searchForNoSort(int[] arr, int key) { // 메인 메서드는 static이므로 메인에서 직접 호출하려면 마찬가지로 static 함수여야 함
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		// 찾지 못했을 때
		return -1;
	}
	
	static int searchWhileNoSort(int[] arr, int key) {
		int i = 0;
		while(i < arr.length) {
			if(arr[i] == key) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	static int searchForSort(int[] arr, int key) {
		for(int i = 0; i < arr.length; i++) {
		if(arr[i] == key) {
			return i;
		}else if(arr[i] > key) {
			return -1;
		}
	}
		return -1;
	}
	
	static int searchWhileSort(int[] arr, int key) {
		int i = 0;
		
		return -1;
	}
}
