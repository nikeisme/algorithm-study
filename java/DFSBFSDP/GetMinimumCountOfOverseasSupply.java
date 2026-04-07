package DFSBFSDP;

import java.util.PriorityQueue;
import java.util.Collections;

class GetMinimumCountOfOverseasSupply {
    private static int ramenStock = 4;
    private static int[] supplyDates = {4, 10, 15};
    private static int[] supplySupplies = {20, 5, 10};
    private static int supplyRecoverK = 30;

    public static int getMinimumCountOfOverseasSupply(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int lastAddedDateIndex=0;

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        while (stock <= k) {
            while (lastAddedDateIndex < dates.length && dates[lastAddedDateIndex] <= stock) {
                maxheap.offer(supplies[lastAddedDateIndex]); // 실패시, false 반환 (add는 예외 발생)
                lastAddedDateIndex++;
            }

            answer++; // 공급 횟수 증가
            int heappop = maxheap.poll(); // maxHeap에서 가장 큰 값(식량) 꺼내기
            stock += heappop; // 현재 식량에 꺼낸 식량 추가
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumCountOfOverseasSupply(ramenStock, supplyDates, supplySupplies, supplyRecoverK));
        System.out.println("정답 = 2 / 현재 풀이 값 = " +
                getMinimumCountOfOverseasSupply(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30));
        System.out.println("정답 = 4 / 현재 풀이 값 = " +
                getMinimumCountOfOverseasSupply(4, new int[]{4, 10, 15, 20}, new int[]{20, 5, 10, 5}, 40));
        System.out.println("정답 = 1 / 현재 풀이 값 = " +
                getMinimumCountOfOverseasSupply(2, new int[]{1, 10}, new int[]{10, 100}, 11));
    }
}