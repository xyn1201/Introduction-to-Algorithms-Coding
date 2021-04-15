//线性查找的递归版本
public class Linear_Search_Recur {

	public static void main(String[] args) {
		int[] num_arr = {9, 77, 56, 13, 112, 38, 92, 21};
		int num = 9;
		System.out.println("Found position is " + recur_search(num, num_arr, num_arr.length - 1));
	}

	public static int recur_search(int num, int[] num_arr, int end) {
		int pos = Integer.MAX_VALUE;
		if(end >= 1) {
			pos = recur_search(num, num_arr, end - 1);
			int new_pos = Integer.MAX_VALUE;
			if(num == num_arr[end])
				new_pos = end;
			pos = (new_pos < pos) ? new_pos : pos; //若待查整数出现在多个位置，则输出最小的位置
			System.out.println("end=" + end + " pos=" + pos);
			end -= 1;
		}
		if(end == 0) {
			if(num == num_arr[end])
				pos = end;
			System.out.println("end=" + end + " pos=" + pos);
		}
		return pos;
	}	
}
