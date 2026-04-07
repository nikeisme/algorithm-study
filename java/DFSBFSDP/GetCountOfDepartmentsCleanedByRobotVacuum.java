package DFSBFSDP;

import java.util.*;

/*
지도의 각 칸은 (r,c)
r은 북쪽으로 떨어진 칸의 갯수
c는 서쪽으로 떨어진 칸의 갯수
*       r    c
*   북  -1    0
*   동   0    1
*   남   1    0
*   서   0   -1
*
* 좌표 (r,c)
* 방향  d : 0 -> 북, 1 -> 동, 2 -> 남, 3 -> 서
* */


class GetCountOfDepartmentsCleanedByRobotVacuum {
    private static int currentR = 7;
    private static int currentC = 4;
    private static int currentD = 0;
    private static int[][] currentRoomMap = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    // 북 동 남 서
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static int getDIndexWhenRotateToLeft(int d) { // 좌회전
        return (d + 3) % 4;
    }

    public static int getDIndexWhenGoBack(int d) { // 후진
        return (d + 2) % 4;
    }


    public static int getCountOfDepartmentsCleanedByRobotVacuum(int r, int c, int d, int[][] roomMap) {

        int n = roomMap.length; // x의 길이?
        int m = roomMap[0].length; // y의 길이
        int countOfDepartmentsCleaned = 1; // 청소한 칸의 개수

        roomMap[r][c]=2; // 청소 완료 = 2
        Queue<int[]> queue = new LinkedList<>(); // 큐 선언
        queue.offer(new int[]{r,c,d}); // 루트 노드를 큐에 담는다.

        while(!queue.isEmpty()) { // 큐가 비어있지 않는 동안
            int[] current = queue.poll();
            r = current[0];
            c = current[1];
            d = current[2];
            int tempD = d; // 바라보는 방향


            for (int i=0; i<4; i++){     // 동서남북

                // 1.현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
                tempD = getDIndexWhenRotateToLeft(tempD); // 북 -> 서
                int newR = r+dr[tempD];
                int newC = c+dc[tempD];

                // #a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
                if ( 0<= newR && newR < n && 0<= newC && newC < m && roomMap[newR][newC] == 0 ){
                    countOfDepartmentsCleaned ++;   // 청소 횟수 1 증가
                    roomMap[newR][newC] = 2;        // 청소 완료 표시
                    queue.offer(new int[]{newR, newC, tempD});  // 새로운 위치에서 또 이동해야함
                    break;
                    // c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
                } else if (i==3) {
                    tempD = getDIndexWhenGoBack(d);
                    newR = r + dr[tempD];
                    newC = c + dc[tempD];

                    // d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                    if (0 <= newR && newR < n && 0 <= newC && newC < m && roomMap[newR][newC] != 1) {
                        queue.offer(new int[]{newR, newC, d}); // 원래 바라보던 방향 유지
                    } else {
                        return countOfDepartmentsCleaned;
                    }
                }
            }
        }
        return countOfDepartmentsCleaned;
    }

    public static void main(String[] args) {
        // 57 가 출력되어야 합니다!
        System.out.println(getCountOfDepartmentsCleanedByRobotVacuum(currentR, currentC, currentD, currentRoomMap));
    }
}
