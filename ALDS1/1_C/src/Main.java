import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void  main (String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String wdn = br.readLine();
		int N = Integer.parseInt(wdn);
		int ans = N;
		int num = 0;

		for (int i=0; i< N; i++) {
			String wdnum = br.readLine();
			num = Integer.parseInt(wdnum);
			if (num == 2){
				continue;
			}
			else if (num % 2 ==0){
				ans--;
				continue;
			}
			for (int j=3; j<=Math.sqrt(num); j+=2){
				if (num%j==0) {
					ans--;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}