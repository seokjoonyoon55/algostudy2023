package baekjoonPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int num; // numList 에서 한수인지 아닌지 판별할 숫자 저장할 변수
		String numStr; // 한수인지 아닌지 판별하기 위해 String으로 바꾼 뒤 잘라야 되는데 그거 저장할 변수
		int cnt = 1; // 1부터 N까지의 한수를 저장할 변수
		int dif; // 각 자리 숫자의 차이
		ArrayList<Integer> numList = new ArrayList<>(); // N 이하의 자연수를 저장할 ArrayList
		ArrayList<String> flagList = new ArrayList<>(); // 맨 앞 두자리의 차이와 뒷 애들의 차이가 일치하는지 여부를 저장할 ArrayList

		for (int i = 1; i <= N; i++) {
			numList.add(i);
		}
		if (numList.size() >= 100) {
			cnt = 99; // 1부터 99까지는 다 한수임 그래서 cnt를 99로 초기값을 줌
			for (int i = 99; i < numList.size(); i++) {
				flagList.clear(); // 이전 루프에서 flagList에 쌓여있는 이 전 값들 비워주기
				num = numList.get(i);
				numStr = Integer.toString(num); // num을 String화 해야 각자리수 별로 자를 수 있음
				String[] numEachArr = numStr.split(""); // num 잘라서 numEachArr에 각 자리수 저장
				dif = Integer.parseInt(numEachArr[0]) - Integer.parseInt(numEachArr[1]);// 맨 앞 자리 두자리의 차를 dif 변수에 저장
				for (int j = 0; j < numEachArr.length - 1; j++) {
					if ((Integer.parseInt(numEachArr[j]) - Integer.parseInt(numEachArr[j + 1]) == dif)) {
						flagList.add("true"); // 각 자리 수의 차가 dif와 같다면 true 저장
					} else {
						flagList.add("false"); // 다르다면 false 저장
					}
				}
				if (flagList.indexOf("false") == -1) { // index는 찾다가 없으면 -1을 반환하는데 -1 반환하면 다 true라는 거니까 등차수열
					cnt++;
				}
			}
		} else {
			cnt = N; // 1부터 99까지는 다 한수니까 그냥 N 출력해주면 됨
		}
		System.out.println(cnt);
	}

}
