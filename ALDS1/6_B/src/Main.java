import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		int q=0;
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		q = partition(A, 0, n-1);
		for(int i=0; i<n-1; i++){
			if(i==q){
				System.out.print("[" +A[i] + "] ");
			}else{
				System.out.print(A[i] + " ");
			}
		}
		System.out.println(A[n-1]);
	}
	
	static int partition(int[] A, int p, int r){
		int x = A[r];
		int i = p-1;
		int tmp;
		for (int j = p; j<r; j++){
			if(A[j] <= x){
				i++;
				tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		tmp = A[i+1];
		A[i+1] = A[r];
		A[r] = tmp;
		return i+1;
	}
}
