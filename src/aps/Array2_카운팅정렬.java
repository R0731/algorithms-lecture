package aps;

import java.util.Arrays;

public class Array2_카운팅정렬 {
	public static void main(String[] args) {
		int[] arr = { 4, 9, 11, 23, 2, 19, 7 };

		// 1. 원소의 범위(최댓값 K) 확인
		// 최댓값을 찾기 위해서는 충분히 작은 값으로 초기화한다음 시작.
		int K = -1; // -1로 잡아야 정수 중에 무조건 커져서 그런가???
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > K) {
				K = arr[i];
			}
		} // 와 최댓값 구햇당
		// K 최댓값: 23
		

		// 2. count 배열을 통해 원소 count
		// K가 클 수록 count 배열의 크기도 커짐
		int[] count = new int[K + 1]; // K + 1인 이유는 index가 K까지 필요하니까

		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++; // arr[i] 에 해당하는 index를 1 증가
		}

		// 3. count 배열을 누적합 배열로 만들기
		// 누적합 배열의 i번 index는 count[0]부터 count[i]을 다 더한 값
		// count 배열 : 해당 원소가 몇개 등장하는가
		// 누적합 배열 : 해당 원소가 몇번째 위치까지 있을수 있는가?
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1]; // 왜 이게 가능하지...
		}

		// 4. 원래 배열을 역방향 순회하며 정렬 후의 위치 찾아주기
		// 역방향 순회를 해야하는 이유 ? 안정 정렬
		int[] sortedArr = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			sortedArr[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		
		System.out.println(Arrays.toString(sortedArr));
	}

}


