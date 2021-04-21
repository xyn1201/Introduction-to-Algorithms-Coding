package Chapter6;

/**
 * @author xyn1201
 */

public class Heap_Sort {

	public static void main(String[] args) {
		int[] A = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		build_max_heap(A);
		int temp;
		int heap_size = A.length;
		for(int i = A.length; i >= 2; i--) {
			temp = A[i-1];
			A[i-1] = A[0];
			A[0] = temp;
			heap_size -= 1;
			max_heapify(A, 1, heap_size);
		}
		for(int j = 0; j < A.length; j++)
			System.out.print(A[j] + " ");

	}
	
	public static void build_max_heap(int[] A) {
		int n = A.length;
		for(int i = n/2; i >= 1; i--)
			max_heapify(A, i, n);
	}
	
	public static void max_heapify(int[] A, int i, int heap_size) {
		int l = left(i);
		int r = right(i);
		//int heap_size = A.length;
		int largest = 0;
		int temp;
		if(l <= heap_size && A[l-1] > A[i-1])
			largest = l;
		else
			largest = i;
		if(r <= heap_size && A[r-1] > A[largest-1])
			largest = r;
		if(largest != i) {
			temp = A[i-1];
			A[i-1] = A[largest-1];
			A[largest-1] = temp;
			max_heapify(A, largest, heap_size);
		}
	}
	
	public static int left(int i) {
		return 2 * i;
	}
	
	public static int right(int i) {
		return 2 * i + 1;
	}	
}
