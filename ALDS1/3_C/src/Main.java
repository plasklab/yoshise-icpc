import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static Node ci = new Node(-1, null, null);

	public static void main(String arg[]) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String N = null;
		try{
			N = br.readLine();
		}catch(Exception e){
			System.out.println(e);
		}
		int n = Integer.parseInt(N);
		int key;
		String Com;
		String[] com;
		
		
		init();
		for(int i=0; i<n; i++){
			Com = br.readLine();
			com = Com.split(" ");
			if(com[0].equals("insert")){
				//com = Com.split(" ");
				key = Integer.parseInt(com[1]);
				insert(key);
			}else if(com[0].equals("deleteFirst")){
				deleteFL(ci.p);
			}else if(com[0].equals("deleteLast")){
				deleteFL(ci.n);
			}else{
				//com = Com.split(" ");
				//System.out.println(com[1]);
				key = Integer.parseInt(com[1]);
				deleat(key, ci.p);
			}
		}
		
		print(ci.p);
	}
	
	static void init(){
		ci.p = ci;
		ci.n = ci;
	}
	
	static void deleat(int de, Node x){
		while (x != ci){
			if(de == x.key) {
				x.p.n = x.n;
				x.n.p = x.p;
				return;
			}
			x = x.p;
		}
		/*
		if(de == x.key) {
			x.p.n = x.n;
			x.n.p = x.p;
			return;
		} else if(ci.key == x.key){
			return;
		}
		deleat(de, x.p);
		*/
	}
	
	static void deleteFL(Node x){
		if(x != ci){
			x.p.n = x.n;
			x.n.p = x.p;
		}
	}
	
	static void insert(int key) {
		Node x = new Node(key, null, null);
		ci.p.n = x;
		x.p = ci.p;
		x.n = ci;
		ci.p = x;
	}
	
	static void print(Node u) {
		if (u.key == ci.key) return;
		if (u != ci.n){
			System.out.print(u.key + " ");
		} else {
			System.out.println(u.key);
		}
		print(u.p);
	}
}

class Node {
	int key;
    Node n = null;
    Node p = null;
    public Node(int key, Node n, Node p) {
        this.key = key;
        this.n = n;
        this.p = p;
    }
}
