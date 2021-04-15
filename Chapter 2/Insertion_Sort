//插入排序
public class Insertion_Sort {

	public static void main(String[] args) {
		int[] A = {9, 77, 56, 13, 112, 38, 92, 21};
		int[] B = insert_sort(A);
		for(int k = 0; k < B.length; k++)
			System.out.print(B[k] + " ");

	}
	
	public static int[] insert_sort(int[] A) { //递增插入排序
		int i, j, key;
		for(j = 1; j <= A.length - 1; j++) { //插入第几张牌
			key = A[j];
			i = j - 1;
			while(i >= 0 && A[i] > key) {
				A[i + 1] = A[i];
				i -= 1;
			}
			A[i + 1] = key;
		}
		return A;
	}

}
