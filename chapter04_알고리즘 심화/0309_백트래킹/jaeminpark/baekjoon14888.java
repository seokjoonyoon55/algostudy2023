package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon14888 {

	static int N;
	static int[] nums;
	static int[] cals;
	static int[] calsCnt;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		// bt 안에서 들어갈 연산자 결정할 배열
		cals = new int[N - 1];
		calsCnt = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			calsCnt[i] = Integer.parseInt(st.nextToken());
		}
		bt(0);
		System.out.println(max);
		System.out.println(min);
	}

	static void bt(int depth) {
		if (depth == N - 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(nums[i]).append(" ");
				if (i != N - 1) {
					if (cals[i] == 0) {
						sb.append("+").append(" ");
					} else if (cals[i] == 1) {
						sb.append("-").append(" ");
					} else if (cals[i] == 2) {
						sb.append("*").append(" ");
					} else if (cals[i] == 3) {
						sb.append("/").append(" ");
					}
				}
			}
			String[] fix = sb.toString().split(" ");
			Stack<String> stack = new Stack<>();
			// 후위 표기식 만들기
			String postfix = "";
			for (int i = 0; i < fix.length; i++) {
				String s = fix[i];
				if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
					if (stack.isEmpty()) {
						stack.push(s);
					} else {
						switch (s) {
						case "+":
							postfix += stack.pop() + " ";
							stack.push(s);
							break;
						case "-":
							postfix += stack.pop() + " ";
							stack.push(s);
							break;
						case "*":
							if (stack.peek() == "+" || stack.peek() == "-") {
								stack.push(s);
							} else {
								postfix += stack.pop() + " ";
								stack.push(s);
							}
							break;
						case "/":
							if (stack.peek() == "+" || stack.peek() == "-") {
								stack.push(s);
							} else {
								postfix += stack.pop() + " ";
								stack.push(s);
							}
							break;
						}
					}
				} else {
					postfix += s + " ";
				}
			}
			while (!stack.isEmpty()) {
				postfix += stack.pop();
			}
			// 후위표기식 이용해서 계산하기
			String[] postFix = postfix.split(" ");
			Stack<Integer> numStack = new Stack<>();
			for (int i = 0; i < postFix.length; i++) {
				String s = postFix[i];
				if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
					switch (s) {
					case "+":
						numStack.push(numStack.pop() + numStack.pop());
						break;
					case "-":
						numStack.push(-numStack.pop() + numStack.pop());
						break;
					case "*":
						numStack.push(numStack.pop() * numStack.pop());
						break;
					case "/":
						int firstPop = numStack.pop();
						int secondPop = numStack.pop();
						numStack.push(secondPop / firstPop);
						break;
					}
				} else {
					numStack.push(Integer.parseInt(s));
				}
			}
			// 최댓값 최솟값 갱신
			if (max < numStack.peek()) {
				max = numStack.peek();
			}
			if (min > numStack.peek()) {
				min = numStack.peek();
			}
			return;
		}
		// 연산자 조합 정하기
		for (int i = 0; i < 4; i++) {
			if (calsCnt[i] != 0) {
				cals[depth] = i;
				calsCnt[i]--;
				bt(depth + 1);
				calsCnt[i]++;
			}
		}
	}
}	
