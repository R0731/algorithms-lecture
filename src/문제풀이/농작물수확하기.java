package 문제풀이;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 농작물수확하기 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input (35).txt"));

        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){

            int N = sc.nextInt();

            int[][] board = new int[N][N];

            for(int r = 0; r < N; r++){
                String line = sc.next();
                for(int c = 0; c < N; c++){
                    board[r][c] = line.charAt(c) - '0';
                }
            }

            int start = N / 2;
            int end = N / 2;
            int sum = 0;

            for(int r = 0; r < N; r++) {
                for (int c = start; c <= end; c++) {
                    sum += board[r][c];
                }
                if(r < N / 2) {
                    start--;
                    end++;
                }else{
                    start++;
                    end--;
                }
            }

            System.out.println("#" + test_case + " " + sum);

        }
    }
}
