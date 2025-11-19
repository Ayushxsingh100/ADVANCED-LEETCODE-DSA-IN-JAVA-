public class LCSTabulation {
    // initializing a function that takes input of two strings 
    // this function will only be returning the length 
    public static int LCSTabulation(String str1, String str2) {
        // n = total length of string 1
        // m = total length of string 2
        int n = str1.length();
        int m = str2.length();


        // creting a 2d array for the table 
        // DP table is initialized with 0s by default
        //  (base case: dp[i][0] = 0, dp[0][j] = 0)
        int dp[][] = new int[n + 1][m + 1];
        // (this loop traverse only for str1 --> row wise)

        // ** running this loop from 1 so that java default stores the 0 value for 
        // i=0 and j=0 for entire table..
        for (int i = 1; i < n + 1; i++) {
            // (this loop traverse only for str2 --> column wise)
            for (int j = 1; j < m + 1; j++) {
        
                // check whether the string 1 (last letter of the (i) matches the last
                // Last of the (j))
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                // if yes, we add the diagonal of the table by addding 1 in that 
                // ( diagonal in the table representaion)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // If characters don't match
                //
                else {

                    // Taking upper element in the table in (ans1)
                    int ans1 = dp[i - 1][j];
                    // Taking left element in the table in (ans2)
                    int ans2 = dp[i][j - 1];
                    // the max value from both stores in that particular 
                    // cell of the table i.e dp[i][j]
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

// --------------------------------- NEW ADDED FOR TABLE ( NOT IMPORTANT) ------------------------
             System.out.println("DP TABLE IS :");
             // for all ROWS
             for(int i = 0 ; i < dp.length ; i++){
                // for all COLUMNS 
                for(int j =0 ; j<dp[0].length ; j++){
                    // a new line after every row 
               System.out.print(dp[i][j] +" ");
                }
                System.out.println();
             }
              System.out.println();
             
// -------------------------------- ENDS --------------------------------------------------
        // return the bottom right corner final answer
        return dp[n][m];
    }

    public static void main(String[] args) {
        // declaring both the strings
        String str1 = "abcdge";
        String str2 = "abedg";

        // printing the result .....
        System.out.println(LCSTabulation(str1, str2));
    }
}