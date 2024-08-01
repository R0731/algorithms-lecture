package aps;

import java.util.Arrays;

public class String_문자열뒤집기 {
	public static void main(String[] args) {
		
		String str = new String("algorithm"); 
		
		char[] charArr = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			charArr[i] = str.charAt(i);
		}
		
		System.out.println(Arrays.toString(charArr));
		
		// 1. 새로운 배열을 만들어서 뒤집기
		
		char[] nextArr = new char[charArr.length];
		
		// 원본 배열을 정방향 순회하면서 새 배열의 뒤에서부터 써주기
		for(int i = 0; i < charArr.length; i++) {
			nextArr[(charArr.length-1)-i] = charArr[i];
		}
		
		System.out.println(Arrays.toString(nextArr));
		
		// 2. 원본 배열에서 swap
		
		char[] charArr2 = str.toCharArray(); // 문자열을 문자 하나씩 분리해서 배열로 만들어주는 메서드
		
		// char를 문자열로 합치는 방법
		String nextStr = " ";
		
		for(int i = 0; i < charArr2.length; i++) {
			nextStr += charArr2[i];
		}
		// 하지만 이 방법을 사용하면 문자열을 더하는 과정이 반복될 때마다 새로운 문자열 객체가 생성된다.
		System.out.println(nextStr);
		
		for(int i = 0; i < charArr2.length/2; i++) {
			char tmp = charArr2[i];
			charArr2[i] = charArr2[charArr2.length-1-i];
			charArr2[charArr2.length-1-i] = tmp;
		}
		
		System.out.println(Arrays.toString(charArr2));
		
	}
}
