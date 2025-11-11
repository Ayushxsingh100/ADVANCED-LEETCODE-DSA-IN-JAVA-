public class DP_01_KNAPSACK {
    // declaring a recursive function 
    //function to return the maximum profit 
    public static int knapsack ( int val[] , int wt[] , int w , int n , int dp[][]){
        // val = contains the value of the items
        // wt =  contains the weight of the items
        // w  = total capacity of the knapsack
        // n = ( items left for cheaking ) by default this will contain all the items .
        // dp[][] = a array for storing the results in a form of tables..
        if ( w == 0 || n == 0){
            // base case for recursion
            return 0;
        }
        // checks wheteher the answer has been stored or not ..
        if(dp[n][w] != -1){
            // if not equal to -1 , 
            // then simply we need to return dp[n][w](so that the old result can be used again )
            return dp[n][w];
        }
        // checking whether the capacity of the last item is more or less than 
        // the capcity left in our knapsack ....
        if(wt[n-1] <= w){
            // choice 1 : include the item value in the knapsack
            // 1.) val[n-1] = inlude the profit 
            // 2.) recursively check for the remaining items using (n-1) and also
            // 3.) w-wt[n-1] = decrease the capacity of the bag 
            int ans1 = val[n-1] + knapsack(val, wt, w-wt[n-1], n-1, dp);
            // choice 2 : dont include the item value in the knapsack
            // 1.) recursively check for the next items using (n-1) and also
            // 2.) w =  the capacity of the bag remains the same  
            int ans2 = knapsack(val, wt, w, n-1, dp);
            // compare both the choices (ans1 , ans2) --> the max will be included 
            // in the dp[n][w] array ( table form)   
            dp[n][w] = Math.max(ans1 , ans2);
            return dp[n][w];
        }
        // if weight of item is more than that of knapsack
        else{
            //1.) recursively check for the next items using (n-1) and also
            //2.) w =  the capacity of the bag remains the same
            dp[n][w] = knapsack(val, wt, w, n-1, dp);
            return dp[n][w];
        }
        
    }

  public static void main(String[] args) {
        // Step 1: Items value and weight 
        int val[] = {15, 14, 10, 45, 30}; // Profits
        int wt[] = {2, 5, 1, 3, 4};       // Weights
        
        // Step 2:total capacity of bag 
        int w = 7;
        
        // Step 3: total items
        int n = val.length; // Total 5 items 

        // Step 4: DP table 
        // keeping size as [n+1] and [w+1] , so that can be used as index 
        int dp [][] = new int [n + 1][w + 1];

        // Step 5: initialize whole table as -1 . 
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        // Step 6: calling the function
        int maxProfit = knapsack(val, wt, w, n, dp);
        
        System.out.println("Max profit : " + maxProfit); 
    }
}

