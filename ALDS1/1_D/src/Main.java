import java.util.Scanner;

public class Main {
	
	public static void  main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = -999999999;
		int num;
		int sans;
		int minn = sc.nextInt();
		
		for (int i=0; i<N-1; i++) {
			num = sc.nextInt();
			sans = num - minn;
			if(ans < sans) ans = sans;
			if(minn > num) minn = num;
		}
		System.out.println(ans);
	}
}
