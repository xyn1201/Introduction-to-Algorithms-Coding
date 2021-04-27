package Chapter8;

/**
 * @author xyn1201
 */

public class Radix_Sort {

	public static void main(String[] args) {
		int[] A = {329, 457, 657, 839, 436, 720, 355};
		//int[] A = {329, 6457, 657, 3839, 436, 1720, 355};
		int[] B = new int[A.length];
		radix_sort(A, B);
		for(int j = 0; j < B.length; j++)
			System.out.print(B[j] + " ");
	}

	/**
	 * 基数排序
	 */
	public static void radix_sort(int[] A, int[] B) {
		int count = get_max_length(A);
		int[] A_num = new int[A.length]; //暂存A数组各元素的各个位的数字
		for(int i = 1; i <= count; i++) {
			for(int j = 0; j < A.length; j++)
				A_num[j] = A[j] % (int)(Math.pow(10, i)) / (int)(Math.pow(10, i-1));		
			counting_sort(A_num, A, B, 100); //根据A_num里某位数数据对A数组重新排序，排好的结果存在B中
			for(int k = 0; k < A.length; k++)
				A[k] = B[k]; //更新A数组为当前排序数组B
		}
	}
	
	/**
	 * 计数排序
	 */
	public static void counting_sort(int[] A_num, int[] A, int[] B, int k) {
		int[] C = new int[k+1];
		for(int i = 0; i <= k; i++)
			C[i] = 0;
		for(int j = 0; j < A_num.length; j++)
			C[A_num[j]] += 1; //C[i]表示A数组中值为i的元素的个数
		for(int i = 1; i <= k; i++)
			C[i] = C[i] + C[i-1]; //C[i]表示A数组中值小于等于i的元素的个数
		for(int j = A_num.length - 1; j >= 0; j--) {
			B[C[A_num[j]]-1] = A[j];
			C[A_num[j]] -= 1; //若各元素不互异，希望当下次遇到值A[j]时，放到之前A[j]放的位置的前一个位置
		}		
	}
	
	/**
	 * 获取数组元素的最大位数
	 */
	public static int get_max_length(int[] A) {
		int max = A[0];
		int count = 0;
		for(int i = 1; i < A.length; i++) {
			if(A[i] > max)
				max = A[i];
		}
		while(max > 0) {
			max /= 10;
			count += 1;
		}
		return count;
	}
}
