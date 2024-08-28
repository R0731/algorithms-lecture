package aps.알고리즘응용;

public class 거듭제곱01_반복문 {
    public static void main(String[] args) {
        int C = 2;
        int N = 10;

        System.out.println(pow(C, N));
        System.out.println(pow2(C, N));
    }
    
    //for문
    private static int pow(int C, int N){
        int result = 1;
        for(int i = 1; i <= N; i++){
            result *= C;
        }
        return  result;
    }
    
    //재귀
    private static int pow2(int C, int N){
        if(N == 1)
            return C;
        
        return C * pow2(C, N - 1);
    }
}
