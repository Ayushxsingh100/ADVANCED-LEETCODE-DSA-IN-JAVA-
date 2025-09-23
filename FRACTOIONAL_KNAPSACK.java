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
        ratio[i][1] = val[i]/(double)weight[i];

    }
       Array.sort(ratio,Comparator.comparing double(o->o[1]));
       
       int capacity = w;
       int finalval = 0;

       for(int i = radius.length-1 ; i>=0 ; i--){
        int idx = ratio[i][0];

        if ( capacity > weigth[idx]){
            finalval+=val[idx];
            capacity -= weight[idx];
        }
        else{
            finalval += ( ratio[i][1] * capacity);
            capacity =0;
            break;
        }
       }
       public static void main(String[] args) {
        System.out.println(finalval);
       }
}