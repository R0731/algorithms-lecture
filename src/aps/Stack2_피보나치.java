package aps;

public class Stack2_피보나치 {
	public static void main(String[] args) {
		
		System.out.println(fibonacci(45));
		
		System.out.println(fibonacci2(45));
		
		System.out.println(mFibo(45));
	}
	
	//재귀함수
	static int fibonacci(int N) {
		if(N <= 1)
			return N;
		return fibonacci(N - 2) + fibonacci(N - 1);
	}
	
	//반복문
	static int fibonacci2(int N) {
		int[] arr = new int[N + 1];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[N];
	}
	
	//다이나믹 프로그래밍 배열
	static int[] dp = new int[500];
			
	//재귀함수에서 중복 호출 문제를 해결하기 위해 Memoization을 활용해보자
	static int mFibo(int N) {
		if(N <= 1)
			return N;
		if(dp[N] > 0) //배열에 계산이 되어있으면 그 값을 꺼내쓰고 
			return dp[N];
		return dp[N] = mFibo(N - 2) + mFibo(N - 1); //아니면 새로 계산해서 저장
	}
}
