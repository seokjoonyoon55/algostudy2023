import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK11403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = br.read();
		boolean[][] arr = new boolean[N][N];
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if (br.read()==1) {
					arr[i][j] = true;
				}
			}
		}
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				int isTrue;
				
				
				
				System.out.print(isTrue+" ");
			}
			System.out.println();
		}
	}
		
	
}
