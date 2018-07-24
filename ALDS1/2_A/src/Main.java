import java.util.Scanner;

public class Main {
	
	public static void  main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[]  A = new String[N];
		String[] resultArray;
		int[][]  a = new int[N][2];
		int tmp;
		int num;
		int count = 0;
		for (int i=0; i<N; i++) {
			A[i] = sc.next();
			resultArray = A[i].split("");
			num = Integer.parseInt(resultArray[1]);
			a[i][1] = num;
			a[i][0] = i;
		}
		for (int i=0; i<N; i++){
			for (int j=N-1; j>0; j--){
				if(a[j][1] < a[j-1][1]) {
					tmp = a[j][0];
					num = a[j][1];
					a[j][0] = a[j-1][0];
					a[j][1] = a[j-1][1];
					a[j-1][0] = tmp;
					a[j-1][1] = num;
					count++;
				}
			}
		}
		
		for (int i=0; i<N-1; i++) {
			System.out.print(a[i][0] + " ");
		}
		System.out.println(a[N-1][0]);
		System.out.println(count);
	}
}
