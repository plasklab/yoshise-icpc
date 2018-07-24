import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node[] T = new Node[100005];
		int[] D = new int[100005];
		int d=0;
		int v=0;
		int c=0;
		int l=0;
		
		for(int i=0; i<n; i++){
			T[i] = new Node(-1, -1, -1);
		}
		for(int i=0; i<n; i++){
			v = sc.nextInt();
			d = sc.nextInt();
			for(int j=0; j<d; j++){
				c = sc.nextInt();
				if(j==0){
					T[v].setL(c);
				}else{
					T[l].setR(c);
				}
				l = c;
				T[c].setP(v);
			}
		}
        for(int i = 0; i < n; i++) {
            D[i] = rec(i, T);
        }
        for(int i = 0; i < n; i++) {
            disp(i, T, D);
        }
	}
    static int rec(int u, Node[] T) {
        int d = 0;
        while(T[u].getP() != -1) {
            u = T[u].getP();
            d ++;
        }
        return d;
    }
	
    static void disp(int u, Node[] T, int[] D) {
        int i, c;
        System.out.print("node " + u + ": ");
        System.out.print("parent = " + T[u].getP() + ", ");
        System.out.print("depth = " + D[u] + ", ");
        if(T[u].getP() == -1) {
            System.out.print("root, ");
        }else if(T[u].getL() == -1) {
            System.out.print("leaf, ");
        }else {
            System.out.print("internal node, ");
        }
        System.out.print("[");
        for(i = 0, c = T[u].getL(); c != -1; i++, c = T[c].getR()) {
            if(i != 0) {
                System.out.print(", ");
            }
            System.out.print(c);
        }
        System.out.println("]");
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