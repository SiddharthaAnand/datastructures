/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
*/

/*
There are 3 lines in the input

Line 1 ( Corresponds to arg 1 ) : An array of intervals. First number represents the number of intervals to follow. Then for every interval we get a pair of integers. 
	For example, Intervals: [(1, 3), (6, 9)] will be written as "2 1 3 6 9"(without quotes).

Line 2 & Line 3 ( Corresponds to arg 2 ) : New Interval represented by a pair of integers. 
	For example, Interval: (2, 5) will be written as "2 5"(without quotes)

*/
/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 * };
 *
 * typedef struct Interval interval;
 */
/*
 * intervals : the array of interval
 * sz : number of entries in intervals
 * newInterval : new Interval to be inserted
 * len : populate the length of returned array of intervals in len
 */
 
 
int max(int a, int b) {
    return a > b ? a : b;
}

int min(int a, int b) {
    return a < b ? a : b;
}

interval* insert(interval *intervals, int sz, interval newInterval, int *len) {
    int i = 0, j = 0, k, z;
    interval insertInterval;
    interval *newIntervals = (interval*)malloc(sizeof(interval)*(sz+1));
    
    for(i = 0; i < sz; i++) {
        if(newInterval.start > intervals[i].end) {
            newIntervals[i] = intervals[i];
        }
        else break;
    }
    k = i + 1;
    
    for(j = i; j < sz; j++) {
        if(newInterval.end < intervals[j].start) {
            newIntervals[k++] = intervals[j];
        } else {
            z = j;
        }
    }
    
    if(i == sz) {
        newIntervals[i] = newInterval;
        k = sz + 1;
    } else if( newInterval.end < intervals[i].start ) {
                newIntervals[i] = newInterval;
    } else {
        insertInterval.start = min(intervals[i].start, newInterval.start);
        insertInterval.end = max(intervals[z].end, newInterval.end);
        newIntervals[i] = insertInterval;
    }
    
    *len = k;
    return newIntervals;
    
}
