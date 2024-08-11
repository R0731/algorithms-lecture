package 자율학습;

import java.util.Arrays;

public class 순열2 {
    public static void main(String[] args) {
        char[] data = {'a', 'b', 'c', 'd'};

        permute(data, 0);

        System.out.println("원본 배열 : " + Arrays.toString(data));
    }

    static void permute(char[]data, int start){
        if(start == data.length){
            System.out.println(Arrays.toString(data));
        }else{
            for(int i = start; i < data.length; i++){
                swap(data, start, i);
                permute(data, start+1);
                swap(data, start, i);
            }
        }
    }

    static void swap(char[] data, int i, int j){
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
