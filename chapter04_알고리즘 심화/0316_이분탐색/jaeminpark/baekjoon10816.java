package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int num;
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] numArr = new int[M];
		for (int i = 0; i < M; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<M; i++) {
			if(map.containsKey(numArr[i])) {
				sb.append(map.get(numArr[i])).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
		
	}

}
