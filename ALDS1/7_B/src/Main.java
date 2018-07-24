import java.util.Scanner;

public class Main {
	static int NIL = -1;
	static int MAX = 100005;
	static Node[] T = new Node[MAX];
	static int n;
	static int[] D = new int[MAX];
	static int[] H = new int[MAX];
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int v = 0;
		int l = 0;
		int r = 0;
		int root = 0;
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++){
			T[i] = new Node(NIL, NIL, NIL);
		}
		for(int i=0; i<n; i++){
			v = sc.nextInt();
			l = sc.nextInt();
			r = sc.nextInt();
			T[v].setL(l);
			T[v].setR(r);
			if (l != NIL) T[l].setP(v);
			if (r != NIL) T[r].setP(v);
		}
		sc.close();
		
		for(int i=0; i<n; i++) {
			if(T[i].getP() == NIL) root = i;
		}
		
		setDepth(root, 0);
		setHeight(root);
		
		for(int i=0; i<n; i++){
			print(i);
		}
	}
	
	static void setDepth(int u, int d){
		if(u == NIL) return;
		D[u] = d;
		setDepth(T[u].getL(), d + 1);
		setDepth(T[u].getR(), d + 1);
	}
	
	static int setHeight(int u){
		int h1 = 0;
		int h2 = 0;
		if (T[u].getL() != NIL) h1 = setHeight(T[u].getL()) + 1;
		if (T[u].getR() != NIL) h2 = setHeight(T[u].getR()) + 1;
		if(h1>h2){
			return H[u] = h1;
		}else{
			return H[u] = h2;
		}
	}
	
	static int getSibling(int u) {
		if (T[u].getP() == NIL) return NIL;
		if (T[T[u].getP()].getL() != u && T[T[u].getP()].getL() != NIL)
			return T[T[u].getP()].getL();
		if (T[T[u].getP()].getR() != u && T[T[u].getP()].getR() != NIL)
			return T[T[u].getP()].getR();
		return NIL;
	}
	
	static void print (int u){
		System.out.print("node " + u);
		System.out.print(": parent = " + T[u].getP());
		System.out.print(", sibling = " +getSibling(u));
		int deg = 0;
		if (T[u].getL() != NIL) deg++;
		if (T[u].getR() != NIL) deg++;
		System.out.print(", degree = " + deg);
		System.out.print(", depth = " + D[u]);
		System.out.print(", height = " + H[u]);
		
		if (T[u].getP() == NIL) {
			System.out.println(", root");
		} else if (T[u].getL() == NIL && T[u].getR() ==NIL){
			System.out.println(", leaf");
		} else {
			System.out.println(", internal node");
		}
	}
}

class Node {
    private int p, l ,r;
    public Node(int p, int l, int r) {
        this.p = p;
        this.l = l;
        this.r = r;
    }
    int getP() {
        return p;
    }
    int getL() {
        return l;
    }
    int getR() {
        return r;
    }
    void setR(int r) {
        this.r = r;
    }
    void setL(int l) {
        this.l = l;
    }
    void setP(int p) {
        this.p = p;
    }
}
