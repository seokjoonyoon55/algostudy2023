package study0130;

import java.util.Scanner;

//스택 안쓰고 푼 것
public class Baek9012_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트케이스 입력받음
		int T = sc.nextInt();
		int status=0; //쌓여있는 (의 갯수

		String indata;//문자열 읽어와서 저장

		for (int tc = 0; tc < T; tc++) {
			status=0;
			indata = sc.next();
			//문자열 길이만큼 반복
			for (int i = 0; i < indata.length(); i++) {
				// ( :  (갯수++  ) :  (갯수--
				if (indata.charAt(i) == '(') status++;
				else status--;
				
				if(status<0) break;	//지울 (가 없어서 -로 내려가면 무조건 불균형이므로 탐색 멈추고 탈출.
			}
			
			//VPS면 무조건 size==0. 0이 아니라면 끝까지 했는데 남아있거나, 중간 탈출해서 음수로 내려갔거나 둘 중 하나이기 때문에.
			if (status==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}
