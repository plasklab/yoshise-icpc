import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		String nf;
		nf = sc.nextLine();
		
		String[] A = nf.split(" ");
		int[] n = new int[A.length];
		int st = 0;

		for (int i=0; i<A.length; i++) {
			if(A[i].equals("+")){
				st--;
				n[st-1] = n[st-1] + n[st];
			} else if (A[i].equals("-")){
				st--;
				n[st-1] = n[st-1] - n[st];
			} else if (A[i].equals("*")){
				st--;
				n[st-1] = n[st-1] * n[st];
			} else {
				n[st] = Integer.parseInt(A[i]);
				st++;
			}
		}
		System.out.println(n[st-1]);
	}
}