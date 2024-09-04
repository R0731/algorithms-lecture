package aps.알고리즘응용;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 그래프최소비용_01_크루스칼 {
    static class Edge implements Comparable<Edge>{
        int A, B, W;

        public Edge(int a, int b, int w) {
            A = a;
            B = b;
            W = w;
        }

        @Override //출력
        public String toString() {
            return "Edge{" +
                    "A=" + A +
                    ", B=" + B +
                    ", W=" + W +
                    '}';
        }

        @Override //Comparable 오름차순 정렬
        public int compareTo(Edge o) {
            return this.W - o.W;

//            return Integer.compare(this.W, o.W);
        }
    }

    static int[] p; //대표자를 저장할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        int V = sc.nextInt(); //정점의 개수(정점의 시작번호를 보고)
        int E = sc.nextInt();

        Edge[] edges = new Edge[E];

        int[][] edges2 = new int[E][3]; //[0] 시작, [1] 도착, [2] 가중치

        Arrays.sort(edges2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for(int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();

            edges[i] = new Edge(A, B, W);
        }//입력 끝

        //크루스칼 1.가중치 순으로 정렬하기

//        Comparetor를 이용한 정렬 or 클래스를 설계할 때 기준을 만들 수도 있다
//        Arrays.sort(edges, new Comparator<Edge>() {
//            @Override
//            public int compare(Edge o1, Edge o2) {
//                return o1.W - o2.W;
//            }
//        });

        Arrays.sort(edges); //클래스에 설계한 기준대로 정렬

        for(Edge e : edges){
            System.out.println(e);
        }

        //크루스칼 2.V-1개의 간선을 뽑아라(단, 사이클이 발생하지 않게)
        //상호배타집합(서로소집합, 유니온파인드) 이용
        p = new int[V]; //0번부터 시작하니까 V개

        //make-set을 통해 전체 자신을 대표로 만드는 작업을 수행
        for(int i = 0; i < V; i++){
//            makeSet(i); 굳이 메서드를 만들지 않고 반복문으로도 가능
            p[i] = i;
        }

        int ans = 0; //최소비용을 저장하기 위한 변수
        int pick = 0; //내가 뽑은 간선의 개수

        for(int i = 0; i < E; i++){
//            int x = edges[i].A;
//            int y = edges[i].B;

            //사이클이 발생하는지 검사
//            if(findSet(x) != findSet(y)){
//                //해당 블록에 들어왔다면 사이클이 아니라는 뜻
//                union(x, y);
//                ans += edges[i].W;
//                pick++;
//            }

            int px = findSet(edges[i].A);
            int py = findSet(edges[i].B);

            if(px != py){
                union(px, py);
                ans += edges[i].W;
                pick++;
            }

            if(pick == (V - 1)) break; //내가 뽑은 간선의 개수가 V-1개면 멈춤
        }//간선의 총 개수만큼 돌면서

        System.out.println(ans);

        System.out.println(Arrays.toString(p));

    }//main

    static void makeSet(int x){
        p[x] = x;
    }

    static int findSet(int x){
//        if(x == p[x]) return x;
//        return findSet(p[x]);
//        위와 같이 표현할 수도 있지만 똑같은 작업을 또 할 수 있어서 효율적이지 않다
//        아래는 패스 컴프레숀을 적용한 코드
        if(x != p[x])
            p[x] = findSet(p[x]);
        return p[x];

    }

    static void union(int x, int y){
        //x와 y가 대표자여야만 한다
//        p[findSet(y)] = findSet(x); //x그룹에 y그룹을 넣는것
        //애초에 여기 x, y의 대표를 내려보내면?
        p[y] = x;
    }

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
