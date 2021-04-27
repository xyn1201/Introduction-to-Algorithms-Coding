package Chapter7;

/**
 * @author xyn1201
 */

public class Quick_Sort {

	public static void main(String[] args) {
		int[] A = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		quick_sort(A, 0, A.length-1);
		for(int j = 0; j < A.length; j++)
			System.out.print(A[j] + " ");
	}
	
	/**
	 * 递归调用快速排序算法
	 */
	public static void quick_sort(int[] A, int start_index, int end_index) {
		int p = start_index, r = end_index;
		int q;
		if(p < r) {
			q = partition(A, p, r);
			quick_sort(A, p, q-1);
			quick_sort(A, q+1, r);
		}
	}
	
	/**
	 * 分解数组，返回中间下标（该算法需要搭配图示理解）
	 */
	public static int partition(int[] A, int start_index, int end_index) {
		int p = start_index, r = end_index;
		int x = A[r]; //将最后一个元素值作为分界线元素值
		int i = p - 1;
		int temp;
		for(int j = p; j < r; j++) {
			if(A[j] <= x) {
				i += 1; //最终i的值为：比中线元素值小的元素数目
				temp = A[i];
				A[i] = A[j];
				A[j] = temp; //代码进入此处时：i位于中线以左的区域处，j位于小于中线的元素值处。交换A[i]和A[j]可以将小于中线值的元素移到中线左边
			}
		}
		temp = A[i+1]; //i+1为中线下标，交换A[i+1]和A[r]可以将中线元素值移到中线处
		A[i+1] = A[r];
		A[r] = temp;
		return i + 1;
	}
}
