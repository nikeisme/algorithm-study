
import java.util.*;

public class DfsRecursion {

    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static List<Integer> visited = new ArrayList<>();

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

    public static void dfsRecursion (Map<Integer, List<Integer>> adjacentGraph, int curNode, List<Integer> visitedArray)  {

        visitedArray.add(curNode);

        for (int adjacentNode : adjacentGraph.get(curNode)){
            if (!visitedArray.contains(adjacentNode)) { // 방문하지 않았다면
                dfsRecursion(adjacentGraph, adjacentNode, visitedArray);
            }
        }
    }

    public static void main(String[] args) {
        dfsRecursion(graph, 1, visited); // 1 이 시작노드입니다!
        System.out.println(visited); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] 이 출력되어야 합니다!
    }
}
