package Chapter8;

/**
 * @author xyn1201
 */

public class Counting_Sort {

	public static void main(String[] args) {
		int[] A = {2, 5, 3, 0, 2, 3, 0, 3};
		int[] B = new int[A.length];
		counting_sort(A, B, 100);
		for(int j = 0; j < B.length; j++)
			System.out.print(B[j] + " ");
	}

	/**
	 * 计数排序
	 */
	public static void counting_sort(int[] A, int[] B, int k) {
		int[] C = new int[k+1];
		for(int i = 0; i <= k; i++)
			C[i] = 0;
		for(int j = 0; j < A.length; j++)
			C[A[j]] += 1; //C[i]表示A数组中值为i的元素的个数
		for(int i = 1; i <= k; i++)
			C[i] = C[i] + C[i-1]; //C[i]表示A数组中值小于等于i的元素的个数
		for(int j = A.length - 1; j >= 0; j--) {
			B[C[A[j]]-1] = A[j];
			C[A[j]] -= 1; //若各元素不互异，希望当下次遇到值A[j]时，放到之前A[j]放的位置的前一个位置
		}		
	}
}
