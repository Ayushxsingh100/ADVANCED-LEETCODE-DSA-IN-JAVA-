public class knapsack{
    // stores the values of the items
    int val[] = { 60, 100 , 120};
    // stores the weight of the items
    int weight[] ={10,20,30};
    //total capacity of knapsack
    int w = 50;
    // making a 2d array which contains 2 colums 
    //( 0th for items index , 1st for items ratio = value//weight)
    double ratio[][] = new double[val.length][2];
    //loop runs for every single element
    for( int i =0 ; i< val.length ; i++){
       // here the index of array will be stored
        ratio[i][0] = i;
       // here all items value-to-weight ratio is stored
        ratio[i][1] = val[i]/(double)weight[i];
    }
       // setting all value-to-weight ratio of items in assecding order 
       Array.sort(ratio,Comparator.comparing double(o->o[1]));
       // for calculating the remaining capacity of the knapsack(w)
       int capacity = w;
       // this will store the total value that will be stored in the knapsack
       int finalval = 0;
       // running the loop from the last 
       // as we have sorted array in accending order 
       // running the array in the opposite direction to get the 
       // most profitable item  
       for(int i = radius.length-1 ; i>=0 ; i--){
        // finds the orginal index of the sorted array
        int idx = ratio[i][0];
        // 1st condition - if kanp sack item can be 100% stored
        if ( capacity > weigth[idx]){
            // add full value in the finalval variable 
            finalval+=val[idx];
            // minus the weight from knapsack current capacity
            capacity -= weight[idx];
        }
        // if item can be added partially
        else{
            // taking the part of the item and multiplying the remaining capacity
            // by the ratio and update the final value
            finalval += ( ratio[i][1] * capacity);
            // now knapsack is full so just update the remaining capacity
            capacity =0;
            // end the loop and exit !!
            break;
        }
       }
       public static void main(String[] args) {
        System.out.println(finalval);
       }
}
