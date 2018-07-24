import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] a = new double[2];
		double[] b = new double[2];
		
		a[0] = 0;
		a[1] = 0;
		b[0] = 100;
		b[1] = 0;
		double z = 1;
		System.out.printf("%.8f %.8f", a[0], a[1]);
		System.out.println();
		koch(n, a, b);
		System.out.printf("%.8f %.8f", b[0], b[1]);
		System.out.println();
		
	}
	
	public static void koch(int n, double[] a, double[] b){
		if(n == 0) return;
		
		double[] s = new double[2];
		double[] t = new double[2];
		double[] u = new double[2];
		double th = Math.PI * 60.0 / 180.0;
		
		s[0] = (2.0 * a[0] + 1.0 * b[0]) / 3.0;
		s[1] = (2.0 * a[1] + 1.0 * b[1]) / 3.0;
		t[0] = (1.0 * a[0] + 2.0 * b[0]) / 3.0;
		t[1] = (1.0 * a[1] + 2.0 * b[1]) / 3.0;
		u[0] = (t[0] - s[0]) * Math.cos(th) - (t[1] - s[1]) * Math.sin(th) + s[0];
		u[1] = (t[0] - s[0]) * Math.sin(th) + (t[1] - s[1]) * Math.cos(th) + s[1];
		
		koch(n - 1, a, s);
		System.out.printf("%.8f %.8f", s[0], s[1]);
		System.out.println();
		koch(n - 1, s, u);
		System.out.printf("%.8f %.8f", u[0], u[1]);
		System.out.println();
		koch(n - 1, u, t);
		System.out.printf("%.8f %.8f", t[0], t[1]);
		System.out.println();
		koch(n - 1, t, b);
	}

}
