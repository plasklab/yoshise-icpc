import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static	ArrayList<Integer> G = new ArrayList<Integer>();
	static int cnt = 0;
	
	public static void main(String arg[]) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String wdn = br.readLine();
		int N = Integer.parseInt(wdn);
		int A[] = new int[N+1];
		for (int i=0; i<N; i++){
			wdn = br.readLine();
			A[i] = Integer.parseInt(wdn);
		}
		
		shellSort(A, N);
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(G.size() + "\n");
		for (int i = G.size()-1; i>0; i--) sb.append(G.get(i) + " ");
		sb.append(G.get(0) + "\n");
		sb.append(cnt + "\n");
		
		for (int i=0; i<N-1; i++){
			sb.append(A[i] + "\n");
		}
		sb.append(A[N-1]);
		System.out.println(sb);
	}
		
	
	static void shellSort(int[] A, int n){
		for(int h = 1;;){
			if(h>n) break;
			G.add(h);
			h = 3*h + 1;
		}
		for (int i=G.size()-1; i>=0; i--){
			insertionSort(A, n, G.get(i));
		}
	}
	
	static void insertionSort(int[] A, int n, int g){
		int v;
		int j;
		for (int i=g; i<n; i++){
			v = A[i];
			j = i - g;
			while (j >= 0 && A[j] > v){
			    A[j+g] = A[j];
			    j = j - g;
				cnt++;
			}
			A[j+g] = v;
		}
	}
}