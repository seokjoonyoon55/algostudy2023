// 달팽이 숫자
// D2
import java.util.*;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            arr[0][0] = 1;
            
            int x = 0, y = 0;
            int num = 1, cnt = N - 1;
            
            while(true) {
            	if (num == N*N) break;
                if (num == 1) {
                	for (int i = 0; i < cnt; i++) arr[x][++y] = ++num;
                }
                for (int i = 0; i < cnt; i++ ) arr[++x][y] = ++num;
                for (int i = 0; i < cnt; i++ ) arr[x][--y] = ++num;
				cnt--;
                for (int i = 0; i < cnt; i++ ) arr[--x][y] = ++num;
                for (int i = 0; i < cnt; i++ ) arr[x][++y] = ++num;
                cnt--;
            }
            System.out.println("#" + test_case);
            for (int[] ele : arr) {
                for (int i : ele) System.out.print(i + " ");
                System.out.println();
            }
		}
	}
}