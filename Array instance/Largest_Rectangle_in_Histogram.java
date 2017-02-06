package LeetCode.Array;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * 
 * A histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * 
 * The largest rectangle has area = 10 unit.
 * 
 * @author Xingwei Chen
 */
public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
        	// 最后添加长为0的bar,来计算最后一个柱子
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
            	// s中最后添加的即最长的height, 将其pop出来
                int tp = s.pop();
                // 如果stack为空, 说明所有的都比他大
                // 比如2 1, 为第1, 2个元素, 那么计算过后stack中会留下1, 所以当stack 为empty时只需计算i
                
                // 当stack不为空时说明之前的节点有比当前节点小的
                // 因此长方形只能计算到那个比他长的节点
                // 只要不比当前的短就可以和之前的相连接, 所以是当前坐标i - 1 - 之前比他长的bar的坐标
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                // 倒回去重新尝试当前的bar, 看剩余的s中的bar还是否有比他高的
                i--;
            }
        }
        return maxArea;
    }
    
    public static void main(String[] args){
    	Largest_Rectangle_in_Histogram test = new Largest_Rectangle_in_Histogram();
    	int[] height = {2,1,5,6,2,3};
    	int res = test.largestRectangleArea(height);
    	System.out.println(res);;
    }
}
