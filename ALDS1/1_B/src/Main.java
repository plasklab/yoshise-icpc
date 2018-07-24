import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int tmp;
		
		if (x<=y) {
			tmp = x;
			x = y;
			y = tmp;
		}
		
		while (y > 0) {
			x = x % y;
			tmp = x;
			x = y;
			y = tmp;
		}
		
		System.out.println(x);
		
	}
}
