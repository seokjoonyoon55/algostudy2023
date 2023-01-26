package algorithm;
import java.util.Scanner;
public class BaekJoon4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		
		for(int i = 0; i < C; i++) {
			int[] N = new int[sc.nextInt()];
			int sum = 0; // 점수합 초기화
			int avg = 0; // 평균값 초기화
			int cnt = 0; // 평균 이상 학생 수
			float best = 0; // 평균 이상 학생 평균
			
			for(int j = 0; j < N.length; j++) {
				N[j] = sc.nextInt(); // 배열에 점수 입력
				sum += N[j];
			}
			avg = sum / N.length;
			
			for(int k = 0; k < N.length; k++) {
				if(N[k] > avg) {
					cnt++;
				}
			}
			best = (float)cnt/N.length * 100; // 정수를 실수로 변환
			System.out.println(String.format("%.3f", best)+"%"); // 소수점 셋째자리까지
		}
	}
}
