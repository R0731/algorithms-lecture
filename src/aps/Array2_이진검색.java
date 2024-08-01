package aps;

import java.util.Arrays;

public class Array2_이진검색 {
	public static void main(String[] args) {
		
		int[] nums = {4, 9, 11, 23, 2, 19, 7, 30};
		Arrays.sort(nums);
		
		int result = binarySearch(nums, 11);
		System.out.println(result);
	}
	
	static int binarySearch(int[] arr, int key) {
		int left = 0; // 구간의 시작 index
		int right = arr.length - 1; // 구간의 끝 index
		
		while (left <= right) {
			int mid = (left + right) / 2; // 배열이 홀수든 짝수든 상관없음
			if(arr[mid] == key) {
				return mid;
			} else if(arr[mid] < key) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
