package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK15652 {
    static int[] num, sel;
    static boolean[] visit;
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N + 1];
        visit = new boolean[N + 1];
        sel = new int[M];
        sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            num[i] = i;
        }
        combinationWithReps(1, 0);
        System.out.println(sb.toString());
    }
    
		// 같은 수를 여러 번 골라도 되지만
		// 중복은 불가능
    private static void combinationWithReps(int idx, int sidx) {
        // base case
        if(sidx == M) {
            for (int i = 0; i < sel.length; i++) {
            	sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // recursive case
        for (int i = 1; i <= N; i++) {
					// 2번째 자리 이상이고 앞자리보다 크거나 같을 때만 값 초기화
        	if (sidx > 0 && num[i] >= sel[sidx-1]) {
        		sel[sidx] = num[i];
                combinationWithReps(idx+1, sidx + 1);
        	}
					// 1번째는 그냥 재귀
        	else if (sidx == 0) {
        		sel[sidx] = num[i];
                combinationWithReps(idx+1, sidx + 1);
        	}
            
        }
    }
}