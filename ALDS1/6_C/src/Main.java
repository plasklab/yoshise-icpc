import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q=0;
        Data []A = new Data[n];
        Data []B = new Data[n];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            int t = sc.nextInt();
            A[i] = new Data(s.charAt(0), t);
            B[i] = new Data(s.charAt(0), t);
        }
		quickSort(A, 0, n-1);
		mergeSort(B, n, 0, n);
		
        int stable = 1;
        for(int i = 0; i < n; i++) {
            if(A[i].getSuit() != B[i].getSuit()) {
                stable = 0;
                break;
            }
        }
        if(stable == 1) {
            System.out.println("Stable");
        }else {
            System.out.println("Not stable");
        }
        for(int i = 0; i < n; i++) {
            System.out.println(A[i].getSuit() + " " + A[i].getValue());
        }
	}
	
	static void quickSort(Data[] A, int p, int r){
		int q;
		if (p < r){
			q = partition(A, p, r);
			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
		}
	}
	
	static int partition(Data[] A, int p, int r){
		Data x;
		Data tmp;
		x = A[r];
		int i = p-1;
		for (int j = p; j<r; j++){
			if(A[j].getValue() <= x.getValue()){
				i++;
				tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		tmp = A[i+1];
		A[i+1] = A[r];
		A[r] = tmp;
		return i+1;
	}
	
	public static void merge(Data[] A, int n, int left, int mid, int right){
		int n1 = mid - left;
		int n2 = right - mid;
		Data[] L = new Data[n1+1];
		Data[] R = new Data[n2+1];
		for(int i=0; i<n1; i++){
			L[i] = A[left+i];
		}
		for(int i=0; i<n2; i++){
			R[i] = A[mid + i];
		}
		L[n1] = new Data(' ', 2000000000);
		R[n2] = new Data(' ', 2000000000);
		int i = 0;
		int j = 0;
		for(int k=left; k<right; k++){
			if(L[i].getValue() <= R[j].getValue()){
				A[k] = L[i];
				i = i + 1;
			}else {
				A[k] = R[j];
				j = j + 1;
			}
		}
	}
	
	public static void mergeSort(Data[] A, int n,int left, int right){
		if (left+1 < right){
			int mid = (left + right)/2;
			mergeSort(A, n,left, mid);
			mergeSort(A, n, mid, right);
			merge(A, n, left, mid, right);
		}
	}
}

class Data {
    private char suit;
    private int value;
    public Data(char suit, int value) {
        this.suit = suit;
        this.value = value;
    }
    public char getSuit() {
        return suit;
    }
    public int getValue() {
        return value;
    }
    public void setSuit(char suit) {
        this.suit = suit;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
