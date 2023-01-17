package baekjoonPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class baekjoon12605 {	//단어 순서 뒤집기 문제(완)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // test_case 인자 받기
		ArrayList<String> list = new ArrayList<>(); // 모든 case를 받아올 ArrayList
		String sentence; // list 내 각각의 case 문장 받아올 변수
		sc.nextLine(); // 버퍼 비워줘야 됨 밑에 내리면 버퍼 비우는거 생각 안하고 짰다가 머리 뜨거워진 코드 있음(주석처리)
		for (int i = 0; i < N; i++) {
			list.add(sc.nextLine()); // test_case만큼 다음 열을 list에 추가
		}
		// System.out.println("list의 사이즈: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			// System.out.println("list.get()의 값: " + list.get(i));
			sentence = list.get(i); // sentence 변수에 list의 i번째에 해당하는 문장(case) 저장
			String[] sArr = sentence.split(" "); // sentence 변수에 저장된 문장을 띄워쓰기를 기준으로 분리하여 sArr 배열에 저장
			// System.out.println("sArr: " + Arrays.toString(sArr));
			System.out.print("Case #" + (i + 1) + ":"); // case 제목
			for (int j = sArr.length - 1; j >= 0; j--) {
				System.out.print(" " + sArr[j]);
			} // for문 끝(각 케이스 값 출력)
			System.out.println();
		}

//		for (int test_case = 1; test_case <= N; test_case++) {
//			String sentence = sc.nextLine(); // 다음열 sentence 변수에 저장
//			sc.nextLine();
//			String[] sArr = sentence.split(" ");// sentence 변수에 저장돼있는 문장 띄워쓰기로 분리해서 sArr 배열에 저장
//			ArrayList<String> reverseArr = new ArrayList<>();// sArr 배열의 순서 바꿔서 넣을 ArrayList
//			System.out.print("Case #" + test_case + ":");
//			if (sArr.length != 1) {
//				for (int i = sArr.length - 1; i >= 0; i--) {
//					reverseArr.add(sArr[i]);
//				} // for문 끝 (sArr 뒤에서부터 reverseArr에 추가)
//				for (int i = 0; i < reverseArr.size(); i++) {
//					sc.nextLine();
//					System.out.print(" " + reverseArr.get(i));
//				} // for문 끝 (reverseArr 출력)
//			} else {
//				System.out.print(" " + sArr[0]);
//			}
//		} // test_case for문 끝
	}
}
