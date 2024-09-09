package aps.알고리즘응용;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 위상정렬_02_Stack {
    static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
    static int V, E;
    static int[][] adjArr; //인접행렬
    static int[] degree; //진입차수를 저장할 배열
    static boolean[] visited; //방문체크
    static Stack<Integer> ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);
        V = sc.nextInt(); //정점의 개수(1번부터 시작)
        E = sc.nextInt(); //간선의 개수
        adjArr = new int[V + 1][V + 1];
        degree = new int[V + 1]; //진입차수를 저장할 배열
        visited = new boolean[V + 1];
        ans = new Stack<>();

        for(int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();

            adjArr[A][B] = 1; //가중치 없으므로 1로 표기
            degree[B]++; //A에서 B로 연결이므로 B의 진입차수 증가
        }//입력 완료

        for(int i = 1; i < V + 1; i++){
            if(degree[i] == 0)
                dfs(1);
        }//위상 정렬 완료

        while(!ans.isEmpty()) {
            System.out.println(cook[ans.pop()]);
        }
    }//main

    private static void dfs(int curr){
        visited[curr] = true; //방문체크
        //방문했다고 해서 무조건 출력해서는 안된다. 아직 선행 조건이 남아있을 수 있음
        for(int i = 1; i < V + 1; i++){
            if(adjArr[curr][i] == 1 && !visited[i])
                dfs(i);
        }
        ans.push(curr); //연결되어 있는 모든 정점을 다 방문했다면 정답 스택에 넣기

    }//dfs

    static String input = "9 9\r\n"
            + "1 4\r\n"
            + "1 8\r\n"
            + "2 3\r\n"
            + "4 3\r\n"
            + "8 5\r\n"
            + "3 5\r\n"
            + "5 6\r\n"
            + "9 6\r\n"
            + "6 7\r\n"
            + "";
}
