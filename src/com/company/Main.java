package com.company;
import java.util.*;



public class Main {


    public static void main(String[] args) {
	    int[][] interval = {{0,30},{5,10},{15,20}};
	    int answer = minMeetingRooms(interval);
	    System.out.println(answer);
    }

    public static int minMeetingRooms(int[][] intervals){
        if (intervals.length==0){
            return 0;
        }
        PriorityQueue<Integer> numOfRooms = new PriorityQueue<Integer>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        numOfRooms.add(intervals[0][1]);

        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0] >= numOfRooms.peek()) {
                numOfRooms.poll();
            }
            numOfRooms.add(intervals[i][1]);
        }
        return numOfRooms.size();

    }
}
