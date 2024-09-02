package aps.알고리즘응용;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_03_간선배열 {

    static class Edge{
        int A, B, W;

        public Edge(int a, int b, int w) {
            A = a;
            B = b;
            W = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "A=" + A +
                    ", B=" + B +
                    ", W=" + W +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //V, E의 개수를 준다
        int V = sc.nextInt(); //정점의 개수 (0 or 1로 시작-문제를 보고 판단)
        int E = sc.nextInt(); //간선의 개수

        Edge[] edges = new Edge[E]; //객체 배열

        for(int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();

            edges[i] = new Edge(A, B, W);
        }

        ///////////////////////////////////////////////

        List<Edge> edges2 = new ArrayList<>();
        for(int i = 0; i < E; i++){
            edges2.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        //////////////////////////////////////////////////////
//       굳이 객체를 만들지 않고 배열을 이용해도 되잖아
        int[][] edges3 = new int[E][3];
        for(int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();

            edges3[i][0] = A; //시작정점
            edges3[i][1] = B; //도착정점
            edges3[i][2] = W; //가중치
        }
    }
}
