import java.util.ArrayList;

public class MaxHeap {

    ArrayList<Integer> items;

    public MaxHeap() {
        items = new ArrayList<>();
        items.add(null);
    }

    public void insert (int value){

        // 1. 원소를 맨 끝에 추가
        items.add(value);

        int curIdx = items.size()-1;

        while(curIdx != 1){ //root node 전에 닿을 때까지

            // 부모 노드랑 비교해서
            int parentIdx = curIdx / 2;

            // 현재 노드가 부모노드보다 크다면
            if (items.get(curIdx) > items.get(parentIdx)){

                int temp = items.get(curIdx);
                items.set(curIdx,items.get(parentIdx));
                items.set(parentIdx,temp);
                curIdx = parentIdx;
            } else {
                break;
            }
        }

    }
}

class MaxHeapInsert {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(9);
        System.out.println(maxHeap.items); // [null, 9, 4, 2, 3] 가 출력되어야 합니다!
    }
}