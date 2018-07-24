import java.util.Scanner;

public class Main {
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] A = new int[n];
		int max = 100000*100000;
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int ans = solve(n, k, A);	
		System.out.println(ans);
		
	}
	public static int check(int p, int n, int k, int A[]){
		int i = 0;
		for(int j =0; j<k; j++){
			int s = 0;
			while(s + A[i] <= p){
				s += A[i];
				i++;
				if (i==n) return n;
			}
		}
		return i;	
	}
	
	public static int solve(int n, int k, int A[]){
		int left = 0;
		int right = 100000 * 100000;
		int mid;
		while (right-left > 1){
			mid = (right + left) / 2;
			int v = check(mid, n, k, A);
			if (v>=n) {
				right=mid;
			} else {
				left = mid;
			}
		}
		return right;
	}
}
