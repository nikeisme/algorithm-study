import java.util.ArrayList;

// 맥스 힙 원소 제거
public class MaxHeap2 {

    ArrayList<Integer> items;

    public MaxHeap2 () {

        items = new ArrayList<>();
        items.add(null);

    }

    public void insert (int value) { // 맥스 힙 원소 추가

        items.add(value);
        int curIdx = items.size() - 1;

        while (curIdx != 1) {

            int curVal = items.get(curIdx);
            int parentIdx = curIdx / 2;
            int parentVal = items.get(parentIdx);

            if (curVal > parentVal) {

                int tempVal = curVal;
                items.set(curIdx, parentVal);
                items.set(parentIdx, tempVal);

                curIdx = parentIdx;

            } else {
                break;
            }

        }
    }


    public int delete(){    // 맥스 힙 원소 제거
//        1. 루트 노드의 원소와 맨 끝 노드의 원소 값 교체
//        2. 교체된 맨 끝의 노드는 따로 보관 why? 이따 return 값으로 반환해야함.
//        3. 맨 끝의 노드까지 도돨할때 까지
//                교체된 루트 노드는 왼쪽 자식 / 오른쪽 자식과 비교하여 더 큰 자식과 변경
//        4. 다시 또다른 자식 노드와 비교
//                왼쪽 자식 / 오른쪽 자식 비교하여 더 큰 자식과 변경
//        5. 가장 아래 노드에 도달하면 멈춤
//                6. 2번에서 제거한 원래 루트 노드 반환 값으로 처리
        int temp = items.get(1);
        items.set(1,items.get(items.size()-1));
        items.set(items.size()-1,temp);

        int prevMax = items.remove(items.size()-1);
        int curIdx = 1;

        while(curIdx <= items.size()-1) {

            int leftIdx = curIdx * 2;
            int rightIdx = curIdx * 2 + 1;
            int maxIdx = curIdx;

            if (leftIdx <= items.size() - 1 && items.get(leftIdx) > items.get(maxIdx)) {
                maxIdx = leftIdx;
            }

            if (rightIdx <= items.size() - 1 && items.get(rightIdx) > items.get(maxIdx)) {
                maxIdx = rightIdx;
            }

            if (maxIdx == curIdx) {
                break;
            }

            temp = items.get(curIdx);
            items.set(curIdx, items.get(maxIdx));
            items.set(maxIdx, curIdx);
        }
        return prevMax;
    }
}

class MaxHeapDelete {
    public static void main(String[] args) {
        MaxHeap2 maxHeap = new MaxHeap2();
        maxHeap.insert(8);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(2);
        maxHeap.insert(5);
        maxHeap.insert(4);
        System.out.println(maxHeap.items); // [null, 8, 6, 7, 2, 5, 4]
        System.out.println(maxHeap.delete()); // 8 을 반환해야 합니다!
        System.out.println(maxHeap.items); // [null, 7, 6, 4, 2, 5]
    }
}
