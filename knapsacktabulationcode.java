public class knapsacktabulationcode {
    // declaring the function of tabulation method 
        // val[] = profir ( value array of items)
        // wt[] = weights array
        // W = TOTAL CAPACITY OF BAG 
    public static int[][] knapsack(int val[],int wt[],int W){
        // TOTAL ITEMS STORED IN 'n' ....
    int n = val.length;
    // initializing the DP 2D-array for tabulation ...
    // both [n+1][W+1] are incresed by 1-by-default 
    // because to handle the 0 and -1 indexing in the table easily 
    int[][] dp = new int [n+1][W+1];
        // dp[i][j] indicates that 
        // using first 'i' elements , how much 'j' capacity we make the max. profit

        // BASE CASE 1 : if capacity of bag -> 0 then 
        // the profit will also be zero 
    for (int i = 0 ; i<dp.length;i++){
       dp[i][0] = 0;
    }
    // BASE CASE 2 : if items are 0 , then 
    // capacity will be 0 . 
    for(int j = 0 ; j<dp[0].length;j++){
        dp[0][j]=0;
    }
    
    // MAIN LOOP : traversing from item 1 to all .. 
    for(int i = 1 ;i <n+1 ; i++){
        // traversing from capacity -> 1 to the total capacity ... 
        for(int j =1 ; j<W+1 ; j++){
            // finding the value and weight of curr. values 
            // i-1 due to indexing ( baisc java fundamental)
            int v = val[i-1];
            int w = wt[i-1];
            // cheaking the capacity and item weights accordingly..
            // if the wight of items [w] is less than that of curr.capacity [j] ,
            if(w<=j){
                // choice 1 : include
                // j-w => capacity left in total after including that 
                int include_Profit = v+dp[i-1][j-w];
                 // choice 2 : exclude
                // j => capacity left in total after excluding that 
                int exclude_Profit = dp[i-1][j];
                // comparing the both and choosing the maximum 
                dp[i][j] = Math.max(include_Profit , exclude_Profit);
            }
            // if the wight of items [w] is more than that of curr.capacity [j] 
            else{
                // exclude that
                int exclude_Profit = dp[i-1][j];
                dp[i][j] = exclude_Profit;
            }
        } 
    }
    // RETURNS THE MAX.PROFIT 
    return dp;
    }
    // simple function to print the matrix :
    public static void print(int dp[][]){
        for(int i =0 ; i<dp.length ; i++){
             for( int j = 0 ; j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
      public static void main(String[] args) {
        // Step 1: Items value and weight 
        int val[] = {15, 14, 10, 45, 30}; // Profits
        int wt[] = {2, 5, 1, 3, 4};       // Weights
        int W = 7;
        int[][] result_table = knapsack(val, wt, W);
        print(result_table);
      }
}
