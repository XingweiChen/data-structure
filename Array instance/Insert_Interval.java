package LeetCode.Array;

import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval 
 * into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], 
 * 		insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], 
 * 		insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author Xingwei Chen
 */
public class Insert_Interval {
	public class Interval{
		int start;
		int end;
		Interval(){
			start = 0;
			end =0;
		}
		
		Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int i = 0;
    	while(i < intervals.size() && intervals.get(i).end < newInterval.start){
    		i++;
    	}
    	int start = newInterval.start, end = newInterval.end;
    	while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
    		Interval temp = intervals.remove(i);
    		start = Math.min(start, temp.start);
    		end = Math.max(end, temp.end);
    		i++;
    	}

    	intervals.add(i, (new Interval(start, end)));
    	return intervals;
    }
}
/**
public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	List<Interval> result = new LinkedList<Interval>();
	int i = 0;
	
	while(i < intervals.size() && intervals.get(i).end < newInterval.start){
		result.add(intervals.get(i++));
	}
	int start = newInterval.start, end = newInterval.end;
	while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
		start = Math.min(start, intervals.get(i).start);
		end = Math.max(end, intervals.get(i).end);
		i++;
	}
	if(start != end){
		result.add(new Interval(start, end));
	}
	while(i < intervals.size())
		result.add(intervals.get(i++));	
	return result;
}
*/