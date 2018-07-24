import java.util.Scanner;
public class Main {
	static Node r;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x;
		String com;
		int cnt=0;
		for(int i=0; i<n; i++){
			com = sc.next();
			if(com.equals("insert")){
				x = sc.nextInt();
				insert(new Node(x, null, null, null));
				
			} else if (com.equals("find")){
				x = sc.nextInt();
				if(find(r, x) != null) System.out.println("yes");
				else System.out.println("no");
				
			} else if (com.equals("delete")){
				x = sc.nextInt();
				treeDelete(find(r, x));
				
			} else if (com.equals("print")){
				inorder(r);
				System.out.println();
				preorder(r);
				System.out.println();
			}
		}
	}
	
	static Node treeMinimum(Node x){
		while( x.l != null) x = x.l;
		return x;
	}
	
	static Node treeSuccessor(Node x){
		if (x.r != null) return treeMinimum(x.r);
		Node y = x.p;
		while(y != null && x == y.r) {
			x = y;
			y = y.p;
		}
		return y;
	}
	
	static void treeDelete(Node z) {
		Node y;
		Node x;
		
		if(z.l == null || z.r == null) y=z;
		else y = treeSuccessor(z);
		
		if(y.l != null){
			x = y.l;
		} else {
			x = y.r;
		}
		
		if (x != null) {
			x.p = y.p;
		}
		
		if (y.p == null){
			r = x;
		} else {
			if (y == y.p.l){
				y.p.l = x;
			} else {
				y.p.r = x;
			}
		}
		
		if (y != z) {
			z.key = y.key;
		}
	}
	
	static Node find(Node u, int k){
		while (u != null && k != u.key){
			if(k < u.key) u = u.l;
			else u = u.r;
		}
		return u;
	}
	
	static void insert(Node z){
		Node y = null;
		Node x = r;
		
		while (x != null){
			y = x;
			if (z.key < x.key){
				x =  x.l;
			} else {
				x = x.r;
			}
		}
		z.p = y;
		
		if (y == null){
			r = z;
		} else {
			if(z.key < y.key){
				y.l = z;
			} else {
				y.r = z;
			}
		}
	}

	static void inorder(Node u){
		if (u == null) return;
		inorder(u.l);
		System.out.print(" " + u.key);
		inorder(u.r);
	}
	static void preorder(Node u) {
		if (u == null) return;
		System.out.print(" " + u.key);
		preorder(u.l);
		preorder(u.r);
	}
}


class Node {
    int key;
    Node p = null;
	Node l = null;
	Node r = null;
    public Node(int key, Node p,Node l, Node r) {
    	this.key = key;
        this.l = l;
        this.r = r;
        this.p = p;
    }
}