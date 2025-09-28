import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ACTIVITY_SELECTION_UNSORTEDARRAY {
     public static void main(String[] args) { // main methods 
        // unsorted arrays : 
        int start[] = {2,6,5,4,3};
        int end[] = {3,7,9,8,10};
        // declaring a 2d array and with start.length rows and 3 coloums 

                                    // 1 -> index 
                                    // 2 -> start time 
                                    // 3 -> end time

        int activities[][] = new int[start.length][3];
        // THIS LOOP ITERATE B/W START AND END Array
        for ( int i = 0; i<start.length ; i++){
        // stores the orginal index to keep track of the original activity order .
            activities[i][0] = i;
        // stores the start time     
            activities[i][1] = start[i];
        // stores the end time 
            activities[i][2] = end[i];
        }
        // sort the 2d array and use the comparartor based on the end time ( index 2 )to sort on the index 2 of the inner array
        Arrays.sort(activities , Comparator.comparingInt(o -> o[2]));
        // declaring maxact to count the maximum numbers of activities 
        int maxact =0;
        // declaring ans to store the indeces of selected activities 
        ArrayList<Integer>ans = new ArrayList<>();
    // acc. to the greedy approach the first activity that ends early should be selectecd       
    maxact = 1;
    // adding the orginal index of first selected activity
       ans.add(activities [0][0]);
    // this intialize the lastEnd of first selcted activity
       int LastEnd = activities[0][2];
       // this loops iterate to find non overlaping activities
       for( int i = 1 ; i<end.length ; i++){
        // comparing the start time with the current activit's end time 
        if(activities[i][1] >= LastEnd){
            // maxactivities increments ++
            maxact ++;
            // the index of the new non overlapping activity will be updated
            ans.add(activities[i][0]);
            // last end varibale now changes to new selected non-overlapping
            //  activity and this whole process continueeeec!!
            lastend = activities[i][2];
        }
       } 
    }
}

}
