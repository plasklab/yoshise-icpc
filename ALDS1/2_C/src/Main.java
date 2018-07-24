import java.util.Arrays;
import java.util.Scanner; 

public class Main {
	
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[]  a = new String[N];
		String[] resultArray;
		int minj = 0;
		int[][] A = new int[N][2];
		int[][] B = new int[N][2];
		int tmp = 0;
		int num = 0;
		
		for(int i=0; i<N; i++){
			a[i] = sc.next();
			resultArray = a[i].split("");
			num = Integer.parseInt(resultArray[1]);
			A[i][0] = i;
			A[i][1] = num;
			B[i][0] = A[i][0];
			B[i][1] = A[i][1];
		}
		
		/*Bubble*/
		for (int i=0; i<N; i++){
			for (int j=N-1; j>0; j--){
				if(B[j][1] < B[j-1][1]) {
					tmp = B[j][0];
					num = B[j][1];
					B[j][0] = B[j-1][0];
					B[j][1] = B[j-1][1];
					B[j-1][0] = tmp;
					B[j-1][1] = num;
				}
			}
		}
		for(int i=0; i<N; i++){
			if(i<N-1){
				System.out.print(a[B[i][0]] + " ");
			}else{
				System.out.println(a[B[i][0]]);
			}
		}
		System.out.println("Stable");
		
		/*Selection*/
		for(int i=0; i<N; i++){
			minj = i;
			for(int j=i; j<N; j++){
				if(A[j][1] < A[minj][1]){
					minj = j;
				}
			}
			if(A[i][1]!=A[minj][1]){
				tmp = A[i][0];
				num = A[i][1];
				A[i][0] = A[minj][0];
				A[i][1] = A[minj][1];
				A[minj][0] = tmp;
				A[minj][1] = num;
			}
		}
		for(int i=0; i<N; i++){
			if(i<N-1) {
				System.out.print(a[A[i][0]] + " ");
			}else{
				System.out.println(a[A[i][0]]);
			}
		}
		for(int i=0; i<N; i++){
			if(A[i][0]!=B[i][0]) {
				System.out.println("Not stable");
				break;
			}else if(A[i][0]==B[i][0] && i !=N-1){
				continue;
			}else{
				System.out.println("Stable");
			}
		}
	}
}
