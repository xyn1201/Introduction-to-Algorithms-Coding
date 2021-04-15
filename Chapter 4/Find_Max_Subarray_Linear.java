//最大子数组的非递归、线性算法
import java.util.HashMap;
import java.util.Map;

public class Find_Max_Subarray_Linear {

	public static void main(String[] args) {
		int[] A = {-9, 2, -17, 56, -13, 32, -38, 42, 21, -27};
		//int[] A = {11, -47, -7, 72, -13, 32, -38, 6, -19, 58};
		int low = max_subarray(A).get("low");
		int high = max_subarray(A).get("high");
		int sum = max_subarray(A).get("sum");
		System.out.println("low: " + low + " high: " + high + " sum: " + sum);
	}

	public static Map<String, Integer> max_subarray(int[] A) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int max_left = 0, max_right = 0; //当前最大子数组的左右下标
		int bound_left = 0, bound_right = 0; //当前最大边界子数组的左右下标
		int max_sum = A[0]; //当前最大子数组的和
		int bound_sum = A[0]; //当前最大边界子数组的和
		for(int i = 1; i < A.length; i++) {
			//先计算下一轮边界子数组中只包含最新元素&不只包含最新元素
			int only_new_sum = A[i]; 
			int notonly_new_sum = A[i] + bound_sum;
			if(only_new_sum > notonly_new_sum) {
				bound_left = i;
				bound_right = i;
				bound_sum = only_new_sum;
			}
			else {
				bound_right += 1;
				bound_sum = notonly_new_sum;
			}
			
			//将上述两种可能的最大子数组与上一轮的最大子数组进行比较
			if(bound_sum > max_sum) {
				max_left = bound_left;
				max_right = bound_right;
				max_sum = bound_sum;
			}		
			//System.out.println("i: "+ i + " low: " + max_left + " high: " + max_right + " sum: " + max_sum);
		}	
		map.put("low", max_left);
		map.put("high", max_right);
		map.put("sum", max_sum);
		return map;
	}	
}
