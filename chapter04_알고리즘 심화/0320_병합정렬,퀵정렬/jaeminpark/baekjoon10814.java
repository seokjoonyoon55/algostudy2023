package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Map<Integer, String> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, "") + st.nextToken() + " ");
			if(!list.contains(key)) {
				list.add(key);
			}
		}
			
		Collections.sort(list);
		
		for(int i : list) {
			String[] str = map.get(i).split(" ");
			for(int j = 0; j<str.length; j++) {
				sb.append(i).append(" ");
				if(!str[j].equals(" ")) {
					sb.append(str[j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}