import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
	public static void main(String arg[]) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		List<String> list = new ArrayList<String>();
		String N = br.readLine();
		int n = Integer.parseInt(N);
		String wo;
		for (int i=0; i<n; i++){
			wo = br.readLine();
			String[] sta = wo.split(" ");
			if(sta[0].equals("insert")){
				insert(list, sta[1]);
			}else{
				find(list, sta[1]);
			}
		}		
	}
	
	public static void insert(List<String> list, String sta){
		list.add(sta);
	}
	
	public static void find(List<String> list, String wo){
		if(list.contains(wo)==true){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
}
