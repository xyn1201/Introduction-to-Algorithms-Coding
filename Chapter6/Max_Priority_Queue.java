package Chapter6;

/**
 * @author xyn1201
 */

public class Max_Priority_Queue {

	public static void main(String[] args) {
		int[] A = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		int size = A.length;
		
		build_max_heap(A);
		int max_element = heap_maximum(A);
		System.out.println("max_element is " + max_element);
		output(A, A.length);
		
		int max_element2 = heap_extract_max(A, size);
		System.out.println("max_element2 is " + max_element2);
		output(A, A.length);
		/*
		int max_element3 = heap_extract_max(A, size-1);
		System.out.println("max_element3 is " + max_element3);
		output(A, A.length);
		
		int max_element4 = heap_extract_max(A, size-2);
		System.out.println("max_element4 is " + max_element4);
		output(A, A.length);
		*/
		heap_increase_key(A, 3, 88);
		output(A, A.length);
		
		max_heap_insert(A, 65, size-1);
		output(A, A.length);
	}

	/**
	 * 返回具有最大键字的元素
	 */
	public static int heap_maximum(int[] A) {
		return A[0];
	}
	
	/**
	 * 去掉并返回具有最大键字的元素
	 */
	public static int heap_extract_max(int[] A, int heap_size) {
		int max = A[0];
		A[0] = A[heap_size-1];
		A[heap_size-1] = max;
		heap_size -= 1;
		max_heapify(A, 1, heap_size);
		return max;
	}
	
	/**
	 * 第i个元素的关键字值增长至key
	 */
	public static void heap_increase_key(int[] A, int i, int key) {
		if(A[i-1] < key) {
			A[i-1] = key;
			while(i != 1 && key > A[parent(i)-1]) {
				int temp = A[parent(i)-1];
				A[parent(i)-1] = A[i-1];
				A[i-1] = temp;
				i = parent(i);
			}
		}
	}
	
	/**
	 * 插入元素
	 */
	public static void max_heap_insert(int[] A, int key, int heap_size) {
		heap_size += 1;
		A[heap_size - 1] = Integer.MIN_VALUE;
		heap_increase_key(A, heap_size, key);
	}
	
	
	/**
	 * 建堆
	 */
	public static void build_max_heap(int[] A) {
		int n = A.length;
		for(int i = n/2; i >= 1; i--)
			max_heapify(A, i, n);
	}
	
	/**
	 * 维护最大堆性质
	 */
	public static void max_heapify(int[] A, int i, int heap_size) {
		int l = left(i);
		int r = right(i);
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
	
	/**
	 * 左孩子
	 */
	public static int left(int i) {
		return 2 * i;
	}
	
	/**
	 * 右孩子
	 */
	public static int right(int i) {
		return 2 * i + 1;
	}
	
	/**
	 * 父结点
	 */
	public static int parent(int i) {
		return i / 2;
	}
	
	/**
	 * 展示数组
	 */
	public static void output(int[] A, int heap_size) {
		for(int j = 0; j < heap_size; j++)
			System.out.print(A[j] + " ");
		System.out.println();
	}

}
