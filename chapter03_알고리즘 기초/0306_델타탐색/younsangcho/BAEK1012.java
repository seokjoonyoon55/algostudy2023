package algorithm_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK1012 {
    static int T,M,N,K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q;
    static boolean[][] visit;
    static int[][] map;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String[] NMK = br.readLine().split(" ");
            N = Integer.parseInt(NMK[0]);
            M = Integer.parseInt(NMK[1]);
            K = Integer.parseInt(NMK[2]);
            map = new int[N][M];
            visit = new boolean[N][M];
            
            for (int i = 0; i < K; i++) {
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                map[x][y] = 1;
            }
            
            cnt = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        // bfs 탐색 돌 때마다 cnt++
                        // 배추가 있는 무리?마다 cnt됨.
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
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
                    visit[nx][ny] = true;
//                    cnt++;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
}