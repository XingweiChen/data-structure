package LeetCode.Array;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * 		Given [1,3],[2,6],[8,10],[15,18],
 * 		return [1,6],[8,10],[15,18].
 * 
 * @author Xingwei Chen
 */


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Merge_Intervals {
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals.size() < 2)
    		return intervals;
    	
    	// Sort by ascending starting point using an anonymous Comparator
    	Collections.sort(intervals, new Comparator<Interval>(){
    		@Override
    		public int compare(Interval i1, Interval i2){
    			return Integer.compare(i1.start, i2.start);
    		}
    	});
    	
    	List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
       
        for(Interval interval: intervals){
        	if(interval.start <= end)
        		// Overlapping intervals, move the end if needed
        		end = Math.max(end, interval.end);
        	else{
        		// Disjoint intervals, add the previous one and reset bounds
        		result.add(new Interval(start, end));
        		start = interval.start;
        		end = interval.end;
        	}
        }
        // Add the last interval
        result.add(new Interval(start, end));
		return result;
    }
    
    public static void main(String[] args){
    	Merge_Intervals test = new Merge_Intervals();
    	List<Interval> intervals = new LinkedList<Interval>();
    	intervals.add(new Interval(1,4));
    	intervals.add(new Interval(1,4));
    	List<Interval> result = test.merge(intervals);
    	for(Interval inter: intervals)
    		System.out.print(inter.start + " " + inter.end + " /");
    	System.out.println();
    	for(Interval inter: result)
    		System.out.print(inter.start + " " + inter.end + " /");
    }
}
