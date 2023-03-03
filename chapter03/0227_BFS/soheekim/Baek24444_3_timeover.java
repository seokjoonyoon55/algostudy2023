package study0227;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek24444_3_timeover {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt() - 1;

		int tempA;
		int tempB;
		int temp;
		int idx;
		
		Nodebfs tempNode;
		int visitCnt=1;
		
		Queue<Integer> quu = new LinkedList<>();

		Nodebfs[] nodes = new Nodebfs[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Nodebfs();
		}

		for (int i = 0; i < M; i++) {
			tempA = sc.nextInt() - 1;
			tempB = sc.nextInt() - 1;

			nodes[tempA].linked.add(tempB);
			nodes[tempB].linked.add(tempA);
		}
		
		for(int i=0;i<N;i++) {
			Collections.sort(nodes[i].linked);
		}
		
		quu.add(R);
		
		while(!quu.isEmpty()) {
			temp=quu.poll();
			
			if(nodes[temp].order==0) {
				nodes[temp].order=visitCnt++;
				
				for(int i=0;i<nodes[temp].linked.size();i++) {
					idx=nodes[temp].linked.get(i);
					if(nodes[idx].order==0 && nodes[idx].added==false) {
						quu.add(idx);
						nodes[idx].added=true;
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.println(nodes[i].order);
		}

		sc.close();
	}
}

class Nodebfs {
	boolean added;
	int order;
	ArrayList<Integer> linked;

	Nodebfs() {
		this.added=false;
		this.order = 0;
		this.linked = new ArrayList<>();
	}
}