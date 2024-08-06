package aps;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack2_계산기 {
	public static void main(String[] args) {
		
		String expression = "(3+5)*8";
		
		String postfix = infixToPostfix(expression);
		System.out.println(postfix);
		
		int result = evalPostfix(postfix);
		
		
	}
	
	static Map<Character, Integer> m = new HashMap<>();
	
	static {
		m.put('+', 1);
		m.put('*', 2);
		m.put('-', 1);
		m.put('/', 2);
	}
	
	//중위표기식을 후위표기식으로 변환해보자
	static String infixToPostfix(String infix) {
		
		//Map을 이용해 연산자에 우선순위 부여
		//그런데 Map을 메소드 안에 만들면 Map은 이 메소드의 지역변수이기 때문에 호출 될 때마다 Map이 새로 만들어지게 된다.
		//그래서 static 전역변수로 만들어주는게 훨씬 실용적이다.
//		Map<Character, Integer> m = new HashMap<>();
//		m.put('+', 1);
//		m.put('*', 2);
//		m.put('-', 1);
//		m.put('/', 2);
//		m.put('(', 0);
		
		String postfix = ""; //결과가 담길 변수
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < infix.length(); i++){
			char c = infix.charAt(i);
			
			//피연산자가 나오면 바로 출력
			//한자릿수 계산기
			if('0' <= c && c <= '9') {
				postfix += c;
			}else if(c == '(') {
				//여는 괄호는 스택에 push
				stack.push(c);
			}else if(c == ')') {
				//닫는 괄호는 여는 괄호가 나올 때까지 pop
				char popItem = stack.pop();
				while(popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			}else{
				//연산자 스택의 마지막에 우선순위가 낮은 연산자가 올 때까지 pop
				while(!stack.isEmpty() && //스택이 비어있지 않고
						stack.peek() != '(' && //스택에서 가져온 게 여는 괄호가 아니고
						m.get(stack.peek()) >= m.get(c)){//픽해온 것이 지금 비교하는 것보다 우선순위가 높으면
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
		}
		
		//스택 비워주기
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}
	
	//후위표기식으로 바꾼 결과를 계산해보자
	static int evalPostfix(String postfix) {
		
		Stack<Integer> s = new Stack<>();
		
		for(int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if ('0' <= c && c <= '9') {
				s.push(c - '0');//정수로 바꾸기 위해 0을 빼주자
			}else {
				int num2 = s.pop(); //첫번째로 pop한 숫자가 계산식 뒤쪽에 와야 하니까
				int num1 = s.pop();
				int result;
				
				if(c == '+') {
					result = num1 + num2;
				}else if(c == '-') {
					result = num1 - num2;
				}else if(c == '*') {
					result = num1 * num2;
				}else{
					result = num1 / num2;	
				}
				
				s.push(result);
			}
		}
		return s.pop();
	}
	
}

	
