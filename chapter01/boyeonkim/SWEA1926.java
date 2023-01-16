import java.util.Scanner;

public class swea04{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		for(int i = 1; i <= a; i++){
			
			String s = Integer.toString(i);
			
			if(s.contains("3") || s.contains("6") || s.contains("9")){
				s = s.replace("3", "-");
				s = s.replace("6", "-");
				s = s.replace("9", "-");
				s = s.replace("1", "");
				s = s.replace("2", "");
				s = s.replace("4", "");
				s = s.replace("5", "");
				s = s.replace("7", "");
				s = s.replace("8", "");
				s = s.replace("0", "");
				
			}
			System.out.print(s+" ");
		}
	}
}