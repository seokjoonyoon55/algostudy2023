package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BAEK3584 {
	static int T,N,parentNode;
	static List<List<Integer>> trees;
	static int[] parent;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			trees = new ArrayList<>();
			visit = new boolean[N+1];
			parent = new int[N+1];
			for (int i = 0; i <= N; i++) {
				trees.add(new ArrayList<>());
			}
			int p = 0;
			int c = 0;
			for (int i = 0; i < N; i++) {
				String[] link = br.readLine().split(" ");
				p = Integer.parseInt(link[0]);
				c = Integer.parseInt(link[1]);
				if (i != N-1) {
					trees.get(p).add(c);
					//trees.get(c).add(p);
					parent[c] = p;
				}
			}
			//System.out.println(trees);
			parentNode = p;
			find(p, c);
		}
	}
	public static void find (int node1, int node2) {
        visit[node1] = true;
        if (node1==node2) {
        	if(parentNode == 0) System.out.println(node1);
        	else System.out.print(parentNode);
            return;
        }
        else {
        	if (trees.get(node1).size() >= 1) {
        		for (int i = 0; i < trees.get(node1).size(); i++) {
        			 int newNode = trees.get(node1).get(i);
        			 if (!visit[newNode]) find(newNode, node2);
        		}
        	}
//            // 크기가 2일 때는 자식이 1명 있다.
//            if (list.get(node1).size() >= 1) {
//                int newNode = list.get(node1).get(0);
//                if (!visit[newNode]) find(newNode, node2);
//            // 크기가 3일 때는 자식이 2명 있다.
//            } 
//            if (list.get(node1).size() == 2) {
//                int newNode = list.get(node1).get(1);
//                if (!visit[newNode]) find(newNode, node2);
//            // 크기가 1일 때는 자식이 없다.
//            // 올라가야됨.
//            } 
            int newNode = parent[node1];
            if (!visit[newNode]) parentNode = newNode;
            if (!visit[newNode]) find(newNode, node2);
        }
    }
}
