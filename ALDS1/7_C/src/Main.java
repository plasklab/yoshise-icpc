import java.util.Scanner;
public class Main {
	static int MAX = 10000;
	static int NIL = -1;
	static Node[] T = new Node[MAX];
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int v = 0;
		int l = 0;
		int r = 0;
		int root = 0;
		
		for (int i=0; i<n; i++){
			T[i] = new Node(NIL, NIL, NIL);
		}
		
		for (int i=0; i<n; i++){
			v = sc.nextInt();
			l = sc.nextInt();
			r = sc.nextInt();
			T[v].setL(l);
			T[v].setR(r);
			if(l != NIL) T[l].setP(v);
			if(r != NIL) T[r].setP(v);
		}
		
		for (int i=0; i<n; i++){
			if(T[i].getP() == NIL) root = i;
		}
		
		System.out.println("Preorder");
		preParse(root);
		System.out.println();
		System.out.println("Inorder");
		inParse(root);
		System.out.println();
		System.out.println("Postorder");
		postParse(root);
		System.out.println();
	}
	
	static void preParse(int u) {
		if (u == NIL) return;
		System.out.print(" " + u);
		preParse(T[u].getL());
		preParse(T[u].getR());
	}
	
	static void inParse(int u) {
		if (u == NIL) return;
		inParse(T[u].getL());
		System.out.print(" " + u);
		inParse(T[u].getR());
	}
	
	static void postParse(int u) {
		if (u == NIL) return;
		postParse(T[u].getL());
		postParse(T[u].getR());
		System.out.print(" " + u);
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
