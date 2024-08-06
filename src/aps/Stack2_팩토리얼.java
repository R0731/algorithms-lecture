package aps;

public class Stack2_팩토리얼 {
	public static void main(String[] args) {
		
		System.out.println(factorial1(10));
		
		System.out.println(factorial2(10));
	}
	
	//반복문을 이용한 팩토리얼
	static int factorial1(int N) {
		//1부터 N까지의 곱을 return
		int result = 1;
		for(int i = 1; i <= N; i++) {
			result *= i;
		}
		return result;
	}
	
	//재귀함수를 이용한 팩토리얼
	static int factorial2(int N) {
		//StackOverflowError방지를 위한 기저조건
		if(N == 0 || N == 1)
			return 1;
		//재귀파트
		return N * factorial2(N-1);
	}
}
