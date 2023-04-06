import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		String gging = "않이 입력 외이레...";
		/*
		// 숫자와 부호를 넣어줄 큐 선언
		Queue<Integer> nums = new LinkedList<>();
		Queue<String> syms = new LinkedList<>();
		
		// 처음 숫자 큐에 넣기
		nums.add(sc.nextInt());
		
		// 부호 넣고 숫자 넣고
		// 다음 입력값이 없을 때까지 반복
		while (sc.hasNext()) {
			syms.add(sc.next());
			nums.add(sc.nextInt());
		}
		
		String sym;		// syms 큐에서 뽑을 값
		int sum = 0;	// 합계(출력값)
		
		// 처음 숫자는 합계에 추가
		sum += nums.poll();
		
		
		// 부호를 저장해둔 큐가 빌때까지
		// 큐에서 꺼내고 연산하기 반복
		while (!syms.isEmpty()) {
			sym = syms.poll();
			
			// 부호가 '+'라면 합계에 그냥 더하기
			if (sym == "+") {
				sum += nums.poll();
				continue;
			}
			// 부호가 '-'라면, 
			else {
				// 뒤에 따라오는 '+'들 부호 바꿔서 계산하기
				while (syms.peek() == "+") {
					syms.poll();
					sum -= nums.poll();
				}
			}
		}
		*/
		
		
		// '-' 뒤에 나오는 묶음은 더해서 한꺼번에 빼주면 됨
		// 따라서 '-'로 split 후 두번째 묶음부터는 다 빼줄거임
		
		// '-'로 split
		String[] arr = sc.next().split("-");
		
		// 출력값 초기화
		int value = 0;
		
		
		for (int i=0;i<arr.length;i++) {
			// '-'로 split 한 덩어리들 안에는 '+'만 있기 때문에
			// 각각의 덩어리들은 더해줄거임
			String[] temp = arr[i].split("\\+");
			
			int sum = 0;	// 덩어리 합
			
			for (int j=0;j<temp.length;j++) {
				sum += Integer.parseInt(temp[j]);
			}
			
			// 첫 번째 덩어리는 그대로 두고 두 번째 덩어리 부터 빼줘야 되기 때문에
			if (i == 0) {
				value += sum;
			}
			else {
				value -= sum;
			}
		}
		
		System.out.println(value);
		
		sc.close();
	}
}
