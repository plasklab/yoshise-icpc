import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		Stack S1 = new Stack();
		String ch;
		int sum = 0;
		for (int i=0;; i++){
			ch = sc.next();
			if(ch == "\\"){
				S1.push(i);
			}else if(ch="/" && S1.size() > 0){
				int j = S1.pop();
				sum += i - j;
				int a = i - j;
				while (S2.size() > 0 && S2.top().first > j){
					a += S2.top().second; S2.pop();
				}
				S2.push(make_pair(j, a));
			}
		}
		
	}
}
