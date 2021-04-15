//归并排序
public class Merge_Sort {

	public static void main(String[] args) {
		int[] A = {9, 77, 56, 13, 112, 38, 92, 21};
		int[] B = merge_sort(A, 0, 7);
		for(int k = 0; k < B.length; k++)
			System.out.print(B[k] + " ");

	}

	public static int[] merge_sort(int[] A, int p, int r) {
		if(p < r) {
			int q = (p + r) / 2;
			merge_sort(A, p, q);
			merge_sort(A, q + 1, r);
			merge(A, p, q, r);
		}		
		return A;
	}
	
	public static int[] merge(int[] A, int p, int q, int r) { //合并
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		for(int m = 0; m < n1; m++) 
			L[m] = A[p + m];
		for(int n = 0; n < n2; n++) 
			R[n] = A[q + 1 + n];
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		int i = 0, j = 0;
		for(int k = p; k <= r; k++) { //A[k]表示输出对
			if(L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			}
			else {
				A[k] = R[j];
				j++;
			}	
		}
		return A;
	}
}
