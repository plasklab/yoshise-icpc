import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int  n = sc.nextInt();
		int[] A = new int[n+1];
		int[] B	= new int[n];
		int[] C = new int[10001];
		
		for (int i=1; i<n+1; i++){
			A[i] = sc.nextInt();
			C[A[i]]++;
		}
		for (int i=1; i<10001; i++){
			C[i] = C[i] + C[i-1];
		}
		for (int i=n; i>=1; i--){
			B[C[A[i]]-1] = A[i];
			if(C[A[i]] > 0) C[A[i]]--;
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n-1; i++) sb.append(B[i] + " ");
		sb.append(B[n-1]);
		System.out.println(sb);
	}
}
