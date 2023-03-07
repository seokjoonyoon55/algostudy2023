package algorithm_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BAEK2178 {
    static int M,N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q;
    static boolean[][] visit;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
                             
        System.out.println(map[N-1][M-1]);
    }
    public static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new int[] {x, y});
        visit[x][y] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (!visit[nx][ny] && map[nx][ny] == 1) {
                	// 델타탐색 하기 전 값에 +1 한 값을 계속해서 더해주면
                	// 제일 끝 행과 열에는 몇 칸을 이동했는지 초기화된다.
                    map[nx][ny] = map[cur[0]][cur[1]] + 1;
                    visit[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
}