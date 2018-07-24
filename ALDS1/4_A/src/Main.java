import java.util.Scanner;

public class Main {
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int S[] = new int[n+1];
		int key = 0;
		int ans = 0;

		for(int i=0; i<n; i++){
			S[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		int T[] = new int[q];
		for(int i=0; i<q; i++){
			T[i] = sc.nextInt();
		}
		for(int i=0; i<q; i++){
			key = T[i];
			if(linearSearch(S, key, n) == 1){
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	public static int linearSearch(int A[], int key, int n){
		int i =0;
		A[n] = key;
		while (A[i] != key){
			i++;
			if(i==n) return -1;
		}
		return 1;
	}

}
