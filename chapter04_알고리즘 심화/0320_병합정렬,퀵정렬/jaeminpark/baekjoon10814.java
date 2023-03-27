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
<<<<<<< HEAD
		List<Integer> arr = new ArrayList<>();
=======
		List<Integer> list = new ArrayList<>();
>>>>>>> 6b8551601c79cffff8274856f3b176f23bdd274d
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, "") + st.nextToken() + " ");
<<<<<<< HEAD
			if(!arr.contains(key)) {
				arr.add(key);
			}
		}
			
		Collections.sort(arr);
		
		for(int i : arr) {
=======
			if(!list.contains(key)) {
				list.add(key);
			}
		}
			
		Collections.sort(list);
		
		for(int i : list) {
>>>>>>> 6b8551601c79cffff8274856f3b176f23bdd274d
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