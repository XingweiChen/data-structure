package LeetCode.Array;

public class Product_of_Array_Except_Self {
	public static int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 1;
		// 取得左边所有数的乘积
		for(int i =1; i < nums.length; i++){
			// 1 2 3 4
			// 1
			// --> 1 2 3 4
			//	   1 1
			// 		--> 1 2 3 4
			//		    1 1 2
			//			--> 1 2 3 4
			//				1 1 2 6
			res[i] = res[i -1] * nums[i - 1];
		}
		
		// 乘以右边所有数的乘积
		int accumulate = 1;
		for(int i = nums.length -1; i >= 0; i--){
			res[i] *= accumulate;
			accumulate *= nums[i];
		}
		
		return res;
	}
}
