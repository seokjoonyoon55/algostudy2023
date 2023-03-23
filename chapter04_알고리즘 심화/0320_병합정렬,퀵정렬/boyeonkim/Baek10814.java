package barkingdog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		// 객체 배열 생성
		Person[] p = new Person[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			// 입력한 나이, 이름을 객체에 저장
			p[i] = new Person(age, name);
		}
		
		// Comparator의 compare 메소드 사용
		// o1 - o2의 값이 양수라면 두 객체의 위치를 바꿈
		Arrays.sort(p, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		
		// 객체 배열의 객체를 출력하면 해당 인덱스 객체의 toString()이 출력됨
		// Person 클래스에서 만들어진 N줄 하나로 합치기
		for(int i = 0; i < N; i++) {
			sb.append(p[i]);
		}
		// 값 출력
		System.out.println(sb);
	}
	
	// Person 클래스
	public static class Person{
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		// 나이, 이름 사이에 공백 추가하고 개행
		public String toString() {
			return age + " " + name + "\n";
		}
	}
}
