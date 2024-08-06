package aps;

public class Stack_FunctionCall {
	public static void main(String[] args) {
		System.out.println("main 호출");
		
		func1();
		
		System.out.println("main 종료");
	}
	
	public static void func1() {
		System.out.println("func1 호출");
		func2();
		String name = "Kim"; //지역 변수이기 때문에 각각의 scope에 생성되어 변수 이름이 중복되어도 호출 가능하다.
		System.out.println(name);
		System.out.println("func1 종료");
	}
	
	public static void func2() {
		System.out.println("func2 호출");
		String name = "Lee";
		System.out.println(name);
		func3();
		System.out.println("func2 종료");
	}

	public static void func3() {
		System.out.println("func3 호출");
		
		System.out.println("func3 종료");
	}
}
