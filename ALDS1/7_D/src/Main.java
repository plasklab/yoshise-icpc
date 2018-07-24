import java.util.Scanner;

public class Main {
	
	static int pos=0;
	static int c=0;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k;
		int[] pre = new int[n];
		int[] in = new int[n];
		int[] post = new int[n];
		
		
		for (int i=0; i<n; i++){
			pre[i] = sc.nextInt();
		}
		
		for (int i=0; i<n; i++){
			in[i] = sc.nextInt();
		}
		solve(n, pre, in, post);
	}
	
	static void rec(int n, int l, int r, int[] pre, int[] in, int[] post) {
		if (l >= r) return;
		int cnt=n;
		int root = pre[pos];
		pos++;
		for(int i=0; i<n; i++){
			if(in[i]==root) cnt=i;
		}
		rec(n, l, cnt, pre, in, post);
		rec(n, cnt + 1, r, pre, in, post);
		post[c] = root;
		c++;
		
		
	}
	
	static void solve(int n, int[] pre, int[] in, int[] post){
		pos = 0;
		rec(n, 0, n, pre, in, post);
		for (int i=0; i<n-1; i++){
			System.out.print(post[i] + " ");
		}
		System.out.println(post[n-1]);
		
		
	}
}
