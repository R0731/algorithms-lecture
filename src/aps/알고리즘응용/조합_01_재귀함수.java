package aps.알고리즘응용;

import java.util.Arrays;

public class 조합_01_재귀함수 {
    static String[] 재료 = {"상추", "패티", "토마토", "치즈"};
    static int N, R; //N : 재료의 수, R : 내가 뽑고 싶은 재료의 수
    static String[] sel; //뽑은 재료를 저장할 배열
    
    public static void main(String[] args) {
        N = 재료.length;
        R = 2;
        sel = new String[R];

        combination(0, 0);
    }

    //idx : 재료의 인덱스
    //sidx : 내가 뽑은 재료의 인덱스
    private static void combination(int idx, int sidx){
        //기저조건
        if(sidx == R) {
            //모든 재료를 전부 다 뽑았다
            System.out.println(Arrays.toString(sel));
            return;
        }
        if(idx == N){ //어차피 위에서 완벽한 햄버거는 다 만들어지므로 여기는 재료가 부족한 친구들만 도달함
            return;
        }

        //재귀부분
        //해당 idx번째 재료를 사용했는지 안했는지
        sel[sidx] = 재료[idx];
        combination(idx + 1, sidx + 1);

        //sel[sidx] = null; //재료를 사용하지 않았음 : 나중에 덮어써버리므로 필요 없는 코드
        combination(idx + 1, sidx); //햄버거의 실제 재료를 아직 사용하지 않았으므로 sidx는 그대로
    }
}
