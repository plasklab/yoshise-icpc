import java.util.Scanner;

public class Main {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for(int i=0; i<n; i++){
			A[i]=sc.nextInt();
		}
		int q = sc.nextInt();
		int[] M = new int[q];
		for(int i=0; i<q; i++){
			M[i]=sc.nextInt();
		}
		
		for(int i=0; i<q; i++){
			if(solve(n, 0, M[i], A) == 1){
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
	
	public static int solve(int n, int i, int m, int[] A){
		int res=0;
		if(m==0) return 1;
		if(i>=n) return 0;
		if(solve(n, i+1, m, A)==1){
			res = solve(n, i+1, m, A);
		}else if(solve(n, i+1, m-A[i], A)==1){
			res = solve(n, i+1, m-A[i], A);
		}
		return res;
	}

}
