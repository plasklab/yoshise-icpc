import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int []a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
        scan.close();
        long ans = mergeSort(a, N, 0, N);
        System.out.println(ans);
    }
    public static long merge(int []A, int n, int left, int mid, int right) {
    	int i, j, k;
        long cnt = 0;
        int n1 = mid- left;
        int n2 = right - mid;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for(i = 0; i < n1; i++) {
        	L[i] = A[left + i];
        }
        for(i = 0; i < n2; i++) {
            R[i] = A[mid + i];
        }
        L[n1] = 2000000000;           
        R[n2] = 2000000000;
        i = 0;
        j = 0;
        for(k = left; k < right; k++) {
            if(L[i] <= R[j]) {
                A[k] = L[i++];
            }else {
                A[k] = R[j++];
                cnt += n1 - i;
            }
        }
        return cnt;
    }
    public static long mergeSort(int []A, int n, int left, int right) {
        int mid;
        long v1, v2, v3;
        if(left + 1 < right) {
            mid = (left + right) / 2;
            v1 = mergeSort(A, n, left, mid);
            v2 = mergeSort(A, n, mid, right);
            v3 = merge(A, n, left, mid, right);
            return v1 + v2 + v3;
        }else {
            return 0;
        }
    }
}
