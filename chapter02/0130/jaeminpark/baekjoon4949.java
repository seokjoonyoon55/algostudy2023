package baekjoon_02_Silver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baekjoon4949 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		List<String> g = new ArrayList<>();
		List<String> list = new ArrayList<>();
		List<String> answer = new ArrayList<>();
		boolean innerFlag;
		while (true) {

			// 스트링빌더 초기화
			sb.setLength(0);

			// g 리스트 초기화
			g.clear();

			innerFlag = true;
			// .이 나올때까지 스트링빌터 sb에 이어서 문자열 추가(띄워쓰기도)
			while (innerFlag) {
				String str = sc.nextLine();
				if (!str.contains(".")) {
					sb.append(str);
				} else {
					sb.append(str);
					innerFlag = false;
				}
			}
//			System.out.println(sb);
			// sb 쪼개서 배열 sentence 만들기
			String[] sentence = sb.toString().split("");

			// 메소드 사용을 위해 gList에 추가
			for (int i = 0; i < sentence.length; i++) {
				g.add(sentence[i]);
			}
//			System.out.println(g);
			// 만약 첫번째 글자가 .이면서 사이즈가 하나면 끝
			if (g.get(0).equals(".") && g.size() == 1) {
				break;

				// else문 여기부터 문장분석
			} else {
				// 괄호가 없다면 균형잡힌 문장 -> YES
				if (g.indexOf("(") == -1 && g.indexOf(")") == -1 && g.indexOf("[") == -1 && g.indexOf("]") == -1) {
					answer.add("yes");

					// 괄호가 있을 경우
				} else {

					// list 비우기
					list.clear();
					int index = 0;
					for (int i = 0; i < g.size(); i++) {
						// 괄호일 경우에만 따지기
						if (g.get(i).equals("(") || g.get(i).equals("[") || g.get(i).equals(")")
								|| g.get(i).equals("]")) {
							// 여는 괄호가 있을 경우 list에 추가
							if (g.get(i).equals("(") || g.get(i).equals("[")) {
								list.add(g.get(i));

								// 닫는 소괄호가 나올 경우
							} else if (g.get(i).equals(")")) {
								// list에 여는 소괄호가 없거나, 리스트의 마지막이 여는 대괄호일경우 -> 균형안잡힌 문장 NO
								if (list.indexOf("(") == -1 || list.get(list.size() - 1).equals("[")) {
									break;
									// 리스트의 마지막 인덱스가 여는 소괄호일 경우 -> 둘이 짝이 맞으니까 같이 없애기
								} else {
									list.remove(list.size() - 1);
								}

								// 닫는 대괄호가 나올 경우
							} else if (g.get(i).equals("]")) {
								// list에 여는 대괄호가 없거나, 리스트의 마지막이 여는 소괄호일 경우 -> 균형안잡힌 문장 NO
								if (list.indexOf("[") == -1 || list.get(list.size() - 1).equals("(")) {
									break;
									// else는 리스트의 마지막 인덱스가 여는 대괄호일 경우 -> 둘이 짝이 맞으니까 같이 없애기
								} else {
									list.remove(list.size() - 1);
								}
							}
						}
						// i를 따로 index에 저장해서 for문이 다 돌았는지 중간에 break 됐는지 판별해서 밑에 answer에 답 yes 추가 여부 결정
						index++;
						
					}

					// g 리스트 다 돌렸는데 안에 남는게 없으면 다 짝맞게 없어졌다는 거니까 균형잡힌 문장 -> YES
					if (list.size() == 0 && index == g.size()) {
						answer.add("yes");
					} else if (list.size() != 0 || index != g.size()) {
						answer.add("no");
					}
				} // else문 끝
			}
		}

		// 출력
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
}
