package baekjoon_03_Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class baekjoon5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 양쪽 대괄호 없애기 위한 StringBuilder
		StringBuilder sbd = new StringBuilder();
		// 최종 답안 제출할 StringBuilder
		StringBuilder sb = new StringBuilder();
		// 숫자들 받아서 저장할 덱
		Deque<Integer> dq = new LinkedList<>();
		// 숫자 개수 저장할 변수
		int n;
		// isEmpty인데 D 해서 에러 유발할 경우 카운트(boolean)
		int cnt;
		// first/last R 나올때마다 뒤에 지울지 앞에 지울지, 앞부터 출력할지 뒤부터 출력할지 결정할 변수
		// true /false
		boolean fl = true;
		// 테스트 케이스 저장할 변수
		int t = Integer.parseInt(br.readLine());

		loop: for (int i = 0; i < t; i++) {
			// 테스트케이스마다 초기화
			fl = true;
			cnt = 0;
			sbd.setLength(0);

			// R/D ac로 문자열 나눠서 한글자씩 저장
			String[] ac = br.readLine().split("");

			// 숫자 개수 n
			n = Integer.parseInt(br.readLine());

			// 이상한 문자 포함되어 있으므로 StringBuilder로 받아서 앞뒤 [] 없애주기
			sbd.append(br.readLine());
			sbd.deleteCharAt(0);
			sbd.deleteCharAt(sbd.length() - 1);

			// StringBuilder로 받은거 ,기준으로 나눠서 str에 저장
			String[] str = sbd.toString().split(",");

			// 아무것도 없는데("") str.length 치면 1 나와서 조건 이렇게 함
			if (!str[0].equals("")) {
				for (int j = 0; j < str.length; j++) {
					dq.offer(Integer.parseInt(str[j]));
				}
			}

			// ac 함수 실행
			for (int j = 0; j < ac.length; j++) {
				if (ac[j].equals("R")) {
					// R이 나오면 실제로 뒤집진 않고 뒤를 지울지 앞을 지울지만 결정
					if (fl) {
						fl = false;
					} else {
						fl = true;
					}
				} else if (ac[j].equals("D")) {
					// 아무것도 없는데 지우는 함수 들어오면 cnt 1개 늘리고 break;
					if (dq.isEmpty()) {
						cnt++;
						break;
					} else {
						// 참이면 앞부터 지우고 거짓이면 뒤부터 지우기
						if (fl) {
							dq.removeFirst();
						} else {
							dq.removeLast();
						}
					}
				}
			}

			// dq에 아무것도 없는데 지웠을 경우 처음으로 돌아가서 다음 테스트 케이스 실행
			if (cnt != 0) {
				sb.append("error").append("\n");
				continue loop;
			} else {
				// 출력 형식 지키기 위함
				sb.append("[");
				// 참이면 앞부터 sb에 쌓고 거짓이면 뒤부터 sb에 쌓기
				if (fl) {
					// 출력 형식 맞추기 위해 한개 남겨 놓고 remove
					// 1 초과라고 한 이유는 D가 딱 맞게 떨어졌을 수도 있으므로(dq의 개수만큼 딱 D가 들어왔다면)
					while (dq.size() > 1) {
						sb.append(dq.removeFirst()).append(",");
					}
				} else {
					// 출력 형식 맞추기 위해 한개 남겨 놓고 remove
					while (dq.size() > 1) {
						sb.append(dq.removeLast()).append(",");
					}
				}
				// D 가 딱 맞게 떨어졌다면(dq의 개수만큼 딱 D가 들어왔다면) 마지막 한개 뺄 필요 없이 배열 모양만 출력
				if (!dq.isEmpty()) {
					sb.append(dq.remove());
				}
				// 출력 형식 맞추기 위함
				sb.append("]").append("\n");
			}

		} // for문 끝

		// 출력
		System.out.println(sb);
	}

}
