// importing all the classes....
import java.util.*;

// class --> JOB_SEQUENCING
public class JOB_SEQUENCING {
    // A INNER CLASS MADE JUST TO STORE THE PROPERTIES OF THE JOB
    static class job {
        // EVERY JOB OBJECT WILL BE CONTAINING THESE 
        int deadline ;
        int profit;
        int id;
    // CONSTRUCTOR MADE JUST FOR CALLING METHOD
    // AND TO SET THE PROPERTIES OF A JOB
    public job (int i ,int d , int p) {
           id = i;
           deadline = d;
           profit = p; 
    }
}
// MAIN METHOD
public static void main(String[] args) {
    // A 2D ARRAY TO STORE THE DATA OOF THE JOBS 
    // FORMAT --> {DEADLINE , PROFIT}
    int jobINFO[][] = {{4,20},{1,10},{1,40},{1,30}};
    // CREATED A ARRAY ;LIST TO STORE ALL job OBJECTS
    ArrayList<job> jobs = new ArrayList<>();
     // TRAVERSING IN THE jonINFO MATRIX
    for(int i =0; i < jobINFO.length ; i++){
        // ADDING ALL THE job OBJECTS TO THIS NEW ARRAYLIST
        // I -> ID , 0TH -> deadline , 1st = profit 
        jobs.add(new job (i , jobINFO[i][0] ,jobINFO[i][1]));
    }
    // sorting the array to get maximum profit ( descending order)
        Collections.sort(jobs , (obj1 , obj2) ->obj2.profit - obj1.profit);
        // a new arraylist to store the id of the jobs in sequence
        ArrayList<Integer> seq = new ArrayList<>();
        int time =0;
        // travesring again
        for(int i =0 ; i < jobs.size();i++){
            // get the most profitable jobs in sorted list ( one by one)
            job curr = jobs.get(i);
            // cheaking the free slots
            if(curr.deadline > time ){
                // if job is able to do ... putting job id in seq list ...
                seq.add(curr.id);
                // as jobs are getting selected ,
                // increment thgis time by 1...........
                time++;
            }
        }
        // total how many jobs selected
        System.out.println(seq.size());
        
        for(int i =0 ; i<seq.size();i++){
            System.out.println(seq.get(i));
        }
        System.out.println();
    }
}
}
