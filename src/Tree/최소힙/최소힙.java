package Tree.최소힙;

public class 최소힙 {

    static int[] heap = new int[100];
    static int heapSize = 0;

    public static void main(String[] args) {

        heapPush(20);
        heapPush(19);
        heapPush(28);
        heapPush(-5);
        heapPush(40);
        heapPush(-18);
        
        int size = heapSize; //heapPop을 하면 heapSize가 변하기 때문에 미리 변수로 지정해준다

        for(int i = 0; i < size; i++){
            int popItem = heapPop();
            System.out.println(popItem);
        }

    }

    //swap
    static void swap(int i, int j){
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    //삽입 연산
    static void heapPush(int data){
        //1. 완전이진트리 마지막에 data에 추가
        heap[++heapSize] = data;

        int p = heapSize / 2; //부모
        int ch = heapSize; //자식

        //재귀함수도 가능하지만 여기서는 while문을 사용한다
        while(ch != 1 && heap[p] > heap[ch]){
            //2. 부모와 비교해서 자식이 더 작으면 swap
            swap(p, ch);

            //3. swap 이stp,후의 인덱스 갱신
            ch = p;
            p = ch / 2;
        }
    }

    //삭제 연산
    static int heapPop(){
        //1. 루트에 있는 데이터 저장
        int popItem = heap[1];

        //2. 마지막 노드를 루트로 옮긴다.
        heap[1] = heap[heapSize--]; //heapSize값을 사용하고 --

        //3. 자식과 부모 비교하여 swap 반복
        //자식이 부모보다 작으면 swap
        //자식이 둘 이상이면 더 작은 쪽과 swap
        int p = 1;
        int ch = p * 2;

        if(ch + 1 <= heapSize && heap[ch] > heap[ch + 1]){
            ch++; //자식끼리 비교하여 오른쪽 자식이 더 작으면 오른쪽 자식을 가리키도록 함
        }

        while (ch <= heapSize && heap[ch] < heap[p]){
            swap(p, ch);

            //4. swap 이후 인덱스 갱신
            p = ch;
            ch = p * 2;

            if(ch + 1 <= heapSize && heap[ch] > heap[ch + 1]){
                ch++;
            }
        }

        return popItem;
    }

}
