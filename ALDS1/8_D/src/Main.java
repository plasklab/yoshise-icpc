import java.util.Scanner;
public class Main {
	static Node r;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x;
		int y;
		String com;
		int cnt=0;
		for(int i=0; i<n; i++){
			com = sc.next();
			if(com.equals("insert")){
				x = sc.nextInt();
				y = sc.nextInt();
				r = insert(r, x, y);
				
			} else if (com.equals("find")){
				x = sc.nextInt();
				if(find(r, x) != null) System.out.println("yes");
				else System.out.println("no");
				
			} else if (com.equals("delete")){
				x = sc.nextInt();
				r = delete(r, x);
				
			} else if (com.equals("print")){
				inorder(r);
				System.out.println();
				preorder(r);
				System.out.println();
			}
		}
	}
	
	static Node delete(Node t, int key){
		if (t == null) return null;
		if (key < t.key) t.l = delete(t.l, key);
		else if (key > t.key) t.r = delete(t.r, key);
		else return _delete(t, key);
		return t;
	}
	
	static Node _delete(Node t, int key){
		if (t.l == null && t.r == null) return null;
		else if (t.l == null) t = leftRotate(t);
		else if (t.r == null) t = rightRotate(t);
		else {
			if (t.l.priority > t.r.priority) t = rightRotate(t);
			else t = leftRotate(t);
		}
		return delete(t, key);
	}
	
	
	static Node find(Node u, int k){
		while (u != null && k != u.key){
			if(k < u.key) u = u.l;
			else u = u.r;
		}
		return u;
	}
	
	static Node insert(Node t, int key, int priority){
		if (t == null) return new Node(key, null, null ,null, priority);
		if (key == t.key) return t;
		if (key < t.key){
			t.l = insert(t.l, key, priority);
			if (t.priority < t.l.priority) t = rightRotate(t);
		} else {
			t.r = insert(t.r, key, priority);
			if (t.priority < t.r.priority) t = leftRotate(t);
		}
		return t;
	}
	
	static Node rightRotate(Node t){
		Node s = t.l;
		t.l = s.r;
		s.r = t;
		return s;
	}
	
	static Node leftRotate(Node t){
		Node s = t.r;
		t.r = s.l;
		s.l = t;
		return s;
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
	int priority;
    public Node(int key, Node p, Node l, Node r, int priority) {
    	this.key = key;
        this.l = l;
        this.r = r;
        this.p = p;
        this.priority = priority;
    }
}