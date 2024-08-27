package aps.알고리즘응용;

public class 부분집합_02_비트마스킹 {
    static String[] 재료 = {"단무지", "햄", "오이", "시금치"};
    static int N = 4; //재료의 수
    static int[] sel = new int[N]; //해당 인덱스의 재료를 사용했는지의 유무를 저장하는 배열

    public static void main(String[] args) {

        //2**N(2의 N승 만큼 반복한다)
        for(int i = 0; i < (1 << N); i++){ //i가 하나의 김밥 종류다
            //재료 확인 for문
            String tmp = "김밥 : ";
            for(int j = 0; j < N; j++){ //j는 재료의 인덱스다
                //i로 앤퍼센트 연산
                if((i & (1 << j)) != 0) {
                    //해당 재료가 있어요
                    tmp += 재료[j];
                }
            }//재료 확인 끝
            System.out.println(tmp);
        }
    }
}
