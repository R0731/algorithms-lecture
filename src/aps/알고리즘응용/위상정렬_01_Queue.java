package aps.알고리즘응용;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬_01_Queue {
    static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
    static int V, E;
    static int[][] adjArr;
    static int[] degree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(input);
        V = sc.nextInt(); //정점의 개수(1번부터 시작)
        E = sc.nextInt(); //간선의 개수
        adjArr = new int[V + 1][V + 1];
        degree = new int[V + 1]; //진입차수를 저장할 배열

        for(int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();

            adjArr[A][B] = 1; //가중치 없으므로 1로 표기
            degree[B]++; //A에서 B로 연결이므로 B의 진입차수 증가
        }//입력 완료

        //위상정렬 큐 1. 진입차수가 0인 친구들을 모두 넣기
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < V + 1; i++){
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        //위상정렬 큐 2. 큐가 공백 상태가 될 때까지 진행
        //간선을 제거하고 진입차수가 0이 되면 새롭게 큐에 넣는다
        while(!queue.isEmpty()){
            int curr = queue.poll();
            sb.append(cook[curr]).append("\n");

            //무향에서는 인덱스의 순서가 중요하지 않았으나 유향이므로 인덱스의 순서 중요
            for(int i = 1; i < V + 1; i++){
                if(adjArr[curr][i] == 1){
                    degree[i]--;
                    adjArr[curr][i] = 0; //현재 상황에서는 어차피 다시 건드리지 않을 것이므로 생략 가능
                    //만약 이번에 i 정점의 진입차수가 0이 되었다면...
                    if(degree[i] == 0)
                        queue.add(i);
                }
            }
        }//while

        System.out.println(sb);
    }
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

