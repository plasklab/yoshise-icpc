import java.util.Scanner;

public class Main {
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n+1];
		
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		A[n] = 0;
		
		mergeSort(A, n, 0, n);
		
		System.out.print(A[0]);
		for(int i=1; i<n-1; i++){
			System.out.print(" " + A[i]);
		}
		System.out.println(" " + A[n-1]);
		System.out.println(A[n]);
		
	}
	public static void merge(int[] A, int n, int left, int mid, int right){
		int n1 = mid - left;
		int n2 = right - mid;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for(int i=0; i<n1; i++){
			L[i] = A[left+i];
		}
		for(int i=0; i<n2; i++){
			R[i] = A[mid + i];
		}
		L[n1] = 2000000000;
		R[n2] = 2000000000;
		int i = 0;
		int j = 0;
		for(int k=left; k<right; k++){
			A[n]++;
			if(L[i] <= R[j]){
				A[k] = L[i];
				i = i + 1;
			}else {
				A[k] = R[j];
				j = j + 1;
			}
		}
	}
	
	public static void mergeSort(int[] A, int n,int left, int right){
		if (left+1 < right){
			int mid = (left + right)/2;
			mergeSort(A, n,left, mid);
			mergeSort(A, n, mid, right);
			merge(A, n, left, mid, right);
		}
	}

}
