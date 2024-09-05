package aps.알고리즘응용;

import java.util.Arrays;
import java.util.Scanner;

public class 프림_01_반복문 {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        int V = sc.nextInt(); //정점의 번호 0번부터 시작
        int E = sc.nextInt(); //간선의 수

        //인접행렬 방식으로
        int[][] adjArr = new int[V][V];

        for(int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();

            adjArr[A][B] = adjArr[B][A] = W; //무향
        }//입력 끝

        //방문체크
        boolean[] visited = new boolean[V]; //해당 정점 뽑았다
        int[] p = new int[V]; //내 부모는... 사용하지 않을 거라면 굳이 작성하지 않아도 ok
        int[] dist = new int[V]; //아까 key라고 표현했던 내가 선택한 간선의 가중치

        //프림 1.초기화
        for(int i = 0; i < V; i++){
            p[i] = -1; //0번 정점도 사용하니까 나올 수 없는 숫자로
            dist[i] = INF; //최소값을 선택해야 하므로 최대값으로 초기화
        }

        //프림 2.시작정점 결정
        dist[0] = 0;

        //프림 3.가중치 배열을 돌면서 가장 값이 낮고 방문하지 않은 것을 골라서 체크
        for(int i = 0; i < V - 1; i++){ //어차피 마지막은 그냥 뽑혀나오기 때문에 V-1을 하였으나 V로 하여도 무관
            int min = INF;
            int idx = -1;
            //방문하지 않았으면서 가장 작은 값 가져오기
            for(int j = 0; j < V; j++){
                if(!visited[j] && dist[j] < min){
                    min = dist[j];
                    idx = j;
                }
            }//해당 반복문이 종료가 되면... idx는 방문하지 않은 가장 작은 값을 가지고 있음
            visited[idx] = true;

            //방문하지 않았고 갱신할 수 있다면 전부 갱신(idx)
            for(int j = 0; j < V; j++){
                if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]){
                    dist[j] = adjArr[idx][j];
                    p[j] = idx; //필요시
                }
            }
        }//끝

        int ans = 0;
        for(int i = 0; i < V; i++){
            ans += dist[i];
        }

        System.out.println(ans);

    }//main

    static String input = "7 11\n" +
            "0 1 32\n" +
            "0 2 31\n" +
            "0 5 60\n" +
            "0 6 51\n" +
            "1 2 21\n" +
            "2 4 46\n" +
            "2 6 25\n" +
            "3 4 34\n" +
            "3 5 18\n" +
            "4 5 40\n" +
            "4 6 51\n";
}