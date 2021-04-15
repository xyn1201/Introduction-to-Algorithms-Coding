//最大子数组的递归分治算法
import java.util.HashMap;
import java.util.Map;

public class Find_Max_Subarray {

	public static void main(String[] args) {
		int[] A = {-9, 2, -17, 56, -13, 32, -38, 42, 21, -27};
		int low = max_subarray(A, 0, 9).get("low");
		int high = max_subarray(A, 0, 9).get("high");
		int sum = max_subarray(A, 0, 9).get("sum");
		System.out.println("low: " + low + " high: " + high + " sum: " + sum);

	}
	
	public static Map<String, Integer> max_subarray(int[] A, int low, int high) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(low < high) {
			int mid = (low + high) / 2;
			int left_low = max_subarray(A, low, mid).get("low");
			int left_high = max_subarray(A, low, mid).get("high");
			int left_sum = max_subarray(A, low, mid).get("sum");
			int right_low = max_subarray(A, mid + 1, high).get("low");
			int right_high = max_subarray(A, mid + 1, high).get("high");
			int right_sum = max_subarray(A, mid + 1, high).get("sum");
			
			int cross_low = max_crossing_subarray(A, low, mid, high).get("max_left");
			int cross_high = max_crossing_subarray(A, low, mid, high).get("max_right");
			int cross_sum = max_crossing_subarray(A, low, mid, high).get("cross_sum");
			
			if(left_sum >= right_sum && left_sum >= cross_sum) {
				map.put("low", left_low);
				map.put("high", left_high);
				map.put("sum", left_sum);
			}
			else if(right_sum >= cross_sum) {
				map.put("low", right_low);
				map.put("high", right_high);
				map.put("sum", right_sum);
			}
			else {
				map.put("low", cross_low);
				map.put("high", cross_high);
				map.put("sum", cross_sum);
			}				
		}
		else if(low == high) {
			map.put("low", low);
			map.put("high", high);
			map.put("sum", A[low]);
		}
		//System.out.println("low: " + map.get("low") + " high: " + map.get("high") + " sum: " + map.get("sum"));
		return map;
	}
	
	public static Map<String, Integer> max_crossing_subarray(int[] A, int low, int mid, int high) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int left_sum = Integer.MIN_VALUE, right_sum = Integer.MIN_VALUE;
		int sum = 0;
		int max_left = mid, max_right = mid + 1;
		for(int i = mid; i >= 0; i--) {
			sum += A[i];
			if(sum > left_sum) {
				left_sum = sum;
				max_left = i;
			}
		}
		
		sum = 0;
		for(int j = mid + 1; j < high; j++) { //加1之后就不对了，无语
			sum += A[j];
			if(sum > right_sum) {
				right_sum = sum;
				max_right = j;
			}
		}
		
		sum = left_sum + right_sum;
		map.put("max_left", max_left);
		map.put("max_right", max_right);
		map.put("cross_sum", sum);
		//System.out.println("max_left: " + max_left + " max_right: " + max_right + " cross_sum: " + sum);
		return map;
	}
}
