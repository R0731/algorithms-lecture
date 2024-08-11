package 자율학습;

public class 순열 {
    public static void main(String[] args) {
        char[] data = {'a', 'b', 'c', 'd'};

        permute(data, 0);
    }

    public static void permute(char[] data, int start){
        if(start == data.length) {
            //배열의 현재 상태 출력
            printArray(data);
        }else{
            for(int i = start; i < data.length; i++){
                //현재 위치와 i 위치의 요소 교환
                swap(data, start, i);
                //재귀 호출로 다음 위치로 이동
                permute(data, start+1);
                //다시 원래 상태로 되돌리기 위해 교환 취소
                swap(data, start, i);
            }
        }
    }

    //배열의 두 요소를 교환하는 함수
    private static void swap(char[] data, int i, int j){
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //배열을 출력하는 함수
    private static void printArray(char[] data){
        for(char c : data){
            System.out.print(c + " ");
        }
        System.out.println();
    }

}
