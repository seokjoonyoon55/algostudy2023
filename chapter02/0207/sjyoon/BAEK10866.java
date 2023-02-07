package algo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BAEK10866 {
	public static void main(String[] args) {
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		Scanner sc = new Scanner(System.in);
		
		// nextInt 쓰면 다음 nextLine이 생략되어 버림
		int N = Integer.parseInt(sc.nextLine());
		
		StringBuilder sb = new StringBuilder();
		
		
		for (int i=0;i<N;i++) {
			String cm = sc.nextLine();
			
			// 반복문 앞단어 switch문으로 확인 후 연산
			switch (cm.split(" ")[0]) {
			
			case "push_front" :
				dq.addFirst(Integer.parseInt(cm.split(" ")[1]));
				break;
				
			case "push_back" :
				dq.add(Integer.parseInt(cm.split(" ")[1]));
				break;
				
			case "pop_front" :
				if (dq.isEmpty()) sb.append(-1+"\n");
				else sb.append(dq.poll()+"\n");
				break;
				
			case "pop_back" :
				if (dq.isEmpty()) sb.append(-1+"\n");
				else sb.append(dq.pollLast()+"\n");
				break;
				
			case "size" :
				sb.append(dq.size()+"\n");
				break;
			
			case "empty" :
				if (dq.isEmpty()) sb.append(1+"\n");
				else sb.append(0+"\n");
				break;
				
			case "front" :
				if (dq.isEmpty()) sb.append(-1+"\n");
				else sb.append(dq.peek()+"\n");
				break;
				
			case "back" :
				if (dq.isEmpty()) sb.append(-1+"\n");
				else sb.append(dq.peekLast()+"\n");
				break;
				
			}
		}
		sc.close();
		
		System.out.println(sb);
		
		// add() 뒤에 추가하고 true 반환		
		
		// offer() 뒤에 추가하고 true 반환		
		
		// addLast() 뒤에 추가 하지만 반환값 X		
		
		// offLast() 뒤에 추가하고 true 반환		
		
		// addFirst() 앞에 추가 하지만 반환값 X		

		// offerFirst() 앞에 추가하고 true 반환		
		
		// addAll() 리스트 계열?에서 쓸 수 있는 함수인데, 리스트계열을 변수로 받아 뒤에 추가하고 true를 반환
		
		// poll()
		
		// remove()
		
		// pollFirst()
		
		// removeFirst()
		
		// pollLast()
		
		// removeLast()
		
		
	}
}
