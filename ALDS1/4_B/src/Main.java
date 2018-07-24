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
			if(binarySearch(S, key, n) == 1){
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	public static int binarySearch(int A[], int key, int n){
		int mid = 0;
		int left = 0;
		int right = n;
		while (left < right){
			mid = (left + right) / 2;
			if(A[mid]==key){
				return 1;
			} else if(key < A[mid]){
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}
