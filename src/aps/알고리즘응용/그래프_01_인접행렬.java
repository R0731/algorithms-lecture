package aps.알고리즘응용;

import java.util.Scanner;

public class 그래프_01_인접행렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //V, E의 개수를 준다
        int V = sc.nextInt(); //정점의 개수 (0 or 1로 시작-문제를 보고 판단)
        int E = sc.nextInt(); //간선의 개수

        int[][] adjArr = new int[V][V]; //만약 시작 정점이 1이라면 [V + 1][V + 1]

        for(int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt(); //두개의 정점이 주어진다
            int W = sc.nextInt(); //가중치가 있다면 입력 값은 세 개

            adjArr[A][B] = 1; //가중치가 있다면 1을 없다면 W 저장하겠다
            adjArr[B][A] = 1; //만약 무향이라면 반대의 경우도 같이 작성해주어야 함

//            adjArr[A][B] = adjArr[B][A] = W; 대입 연산자는 오른쪽부터 대입

        }//E개의 간선을 입력 받을 반복문
    }
}
