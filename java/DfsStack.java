
import java.util.*;

class DfsStack {
    // 위의 그래프를 예시로 삼아서 인접 리스트 방식으로 표현했습니다!
    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    static {
        graph.put(1, Arrays.asList(2, 5, 9));
        graph.put(2, Arrays.asList(1, 3));
        graph.put(3, Arrays.asList(2, 4));
        graph.put(4, Arrays.asList(3));
        graph.put(5, Arrays.asList(1, 6, 8));
        graph.put(6, Arrays.asList(5, 7));
        graph.put(7, Arrays.asList(6));
        graph.put(8, Arrays.asList(5));
        graph.put(9, Arrays.asList(1, 10));
        graph.put(10, Arrays.asList(9));
    }

    public static List<Integer> dfsStack(Map<Integer, List<Integer>> adjacentGraph, int startNode) {
        Stack<Integer> stack = new Stack<>(); // 방문한 노드 생성
        stack.push(startNode); // 시작 노드를 스택에 넣음 → stack: [1]
        List<Integer> visited = new ArrayList<>(); // 방문한 노드를 순서대로 저장

        while (!stack.isEmpty()) { // 스택이 빌 때까지 반복 (더 방문할 노드가 없으면 종료)
            int currentNode = stack.pop(); // 스택 맨 위 노드를 꺼냄 (가장 최근에 발견한 노드)
            visited.add(currentNode); // 현재 노드를 방문 처리

            // 이미 방문한 노드면 스킵 (재귀 DFS와 달리 스택엔 중복이 들어올 수 있음)
            for (int adjacentNode : adjacentGraph.get(currentNode)) {
                if (!visited.contains(adjacentNode)) {
                    stack.push(adjacentNode); // 방문 안 한 인접 노드만 스택에 추가
                }
            }
        }
        return visited;  // 방문한 노드 순서 반환
    }

    public static void main(String[] args) {
        System.out.println(dfsStack(graph, 1)); // 1 이 시작노드입니다!
        // [1, 9, 10, 5, 8, 6, 7, 2, 3, 4] 이 출력되어야 합니다!
    }
}