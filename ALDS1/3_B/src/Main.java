import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new ArrayDeque<Integer>();
		Queue<String> name = new ArrayDeque<String>();
		int N = sc.nextInt();
		int q = sc.nextInt();
		int tlen = 0;
		for (int i=0; i<N; i++) {
			name.add(sc.next());
			queue.add(sc.nextInt());
		}
		
		while (queue.size()!=0) {
			
			if (queue.element() > q){
				tlen += q;
				queue.add(queue.element() - q);
				queue.remove();
				name.add(name.element());
				name.remove();
			} else {
				tlen += queue.element();
				System.out.println(name.element()+" "+tlen);
				queue.remove();
				name.remove();
			}
		}
	}	
}
