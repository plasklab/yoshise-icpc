import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		for (int i=0; i<N; i++){
			A[i] = sc.nextInt();
		}
		for (int i=0; i<N-1; i++){
			System.out.print(A[i] + " ");
		}
		System.out.print(A[N-1]);

		int v;
		int j;
		for (int i=1; i<N; i++){
				v = A[i];
				j = i - 1;
				while (j >= 0 && A[j] > v){
				    A[j+1] = A[j];
				    j--;
					A[j+1] = v;
				}
				System.out.println();
				for (int k=0; k<N-1; k++){
					System.out.print(A[k] + " ");
				}
				System.out.print(A[N-1]);
		}
		System.out.println();
	}
}