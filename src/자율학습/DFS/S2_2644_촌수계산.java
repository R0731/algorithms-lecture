package 자율학습.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2644_촌수계산 {
    static int n, person1, person2, m;
    static boolean[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //정보 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer line = new StringTokenizer(br.readLine());
        person1 = Integer.parseInt(line.nextToken());
        person2 = Integer.parseInt(line.nextToken());
        m = Integer.parseInt(br.readLine());

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        int x, y;
        for (int i = 0; i < m; i++) {
            line = new StringTokenizer(br.readLine());
            x = Integer.parseInt(line.nextToken());
            y = Integer.parseInt(line.nextToken());
            graph[x][y] = graph[y][x] = true;
        }
    }
}
