package aps.알고리즘응용;

public class 거듭제곱02_분할정복 {
    static int N;

    public static void main(String[] args) {
        int C = 2;
        int N = 10;
    }

    private static int pow(int C, int N){
        //기저조건
        if(N == 1) return C;

        //재귀부분 : 짝수인 경우 / 홀수인 경우
        if(N % 2 == 0){
            return pow(C, N / 2) * pow(C, N / 2);
        }else{
            return pow(C, (N - 1) / 2) * pow(C, (N - 1) / 2) * C;
        }

    }

    private static int pow2(int C, int N){
        //기저조건
        if(N == 1) return C;

        //재귀부분 : 짝수인 경우 / 홀수인 경우
        if(N % 2 == 0){
            int tmp = pow2(C, N / 2); //임시 변수를 사용해 이전에 구했던 값을 다시 구하지 않고 재사용
            return tmp * tmp;
        }else{
            int tmp = pow2(C, (N - 1) / 2);
            return tmp * tmp * C;
        }

    }

}
