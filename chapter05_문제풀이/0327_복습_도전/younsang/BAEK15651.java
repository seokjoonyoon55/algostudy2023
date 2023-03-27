package baekjoon;

//코드 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK15651 {
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
 
 private static void combinationWithReps(int idx, int sidx) {
     // base case
     if(sidx == M) {
         for (int i = 0; i < sel.length; i++) {
         	sb.append(sel[i]).append(" ");
         }
         sb.append("\n");
         return;
     }
     
     //if(idx == N) return;
     
     // recursive case
				// 일반 조합과 달리 중복이 허용되는 조합 알고리즘
     for (int i = 1; i <= N; i++) {
         sel[sidx] = num[i];
         combinationWithReps(idx + 1, sidx + 1);
     }
 }
}