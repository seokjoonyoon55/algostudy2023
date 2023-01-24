package baekjoonPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class baekjoon4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 변수 선언
		int C = sc.nextInt(); // 테스트 케이스 저장할 변수
		int N; // 각 테스트 케이스마다 존재하는 학생의 수를 받아와서 저장할 변수
		int sum; // 각 테스트 케이스에서 학생들이 맞은 점수들의 합을 저장할 변수 -> for문 돌릴 때마다 초기화 필요
		double avg; // 각 테스트 케이스에서 학생들이 맞은 점수들의 평균을 저장할 변수 -> 마찬가지로 for문 돌릴 때마다 초기화 필요
		double cnt; // 평균을 넘는 학생들의 수를 저장할 변수
		double rate; // 점수가 평균을 넘는 학생들의 비율을 저장할 변수
		String round; // 점수가 평균을 넘는 학생들의 비율(퍼센트)을 반올림해서 저장할 변수

		ArrayList<Integer> scores = new ArrayList<>(); // 학생들의 점수들을 모아놓을 ArrayList
		ArrayList<String> rateList = new ArrayList<>(); // 모든 테스트 케이스의 결과(round)를 모아놓은 ArrayList(%도 붙여야 돼서 String값)

		for (int i = 0; i < C; i++) {
			N = sc.nextInt();
			// 초기화
			sum = 0;
			avg = 0;
			cnt = 0;
			scores.clear();
			for (int j = 0; j < N; j++) { // scores ArrayList에 값을 받아와서 저장
				scores.add(sc.nextInt());
			}
			for (int j = 0; j < scores.size(); j++) {
				sum += scores.get(j); // scores ArrayList의 합을 구하기
			}
			avg = ((double) (sum)) / scores.size(); // scores ArrayLit의 평균을 구해서 avg 변수에 저장(명시적 형변환)
			for (int j = 0; j < scores.size(); j++) {
				if (scores.get(j) > avg) // for문을 돌려서 평균보다 큰 점수가 scores ArrayList에 있을 때마다 cnt 증가
					cnt++;
			}
			rate = cnt / scores.size();
			round = String.format("%.3f", rate * 100); // String.format 이용해서 소수점3자리까지 반올림
			rateList.add(round + "%");
		}
		for (int i = 0; i < rateList.size(); i++) {
			System.out.println(rateList.get(i));
		}
	}
}
