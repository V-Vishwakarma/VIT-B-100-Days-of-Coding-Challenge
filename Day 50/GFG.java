//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
       public int calc(int i, int prev, String str, int[][] dp) {
        if (i == str.length()) {
            return 1;
        }
        if (dp[i][prev] != -1) {
            return dp[i][prev];
        }
        int sum = 0, ans = 0;
        for (int j = i; j < str.length(); ++j) {
            sum += Integer.parseInt(str.substring(j, j + 1));
            if (sum >= prev) {
                ans += calc(j + 1, sum, str, dp);
            }
        }
        return dp[i][prev] = ans;
    }
    public int TotalCount(String str)
    {
        // Code here
         int sum = 0, n = str.length();
        for (int i = 0; i < n; ++i) {
            sum += Integer.parseInt(str.substring(i, i + 1));
        }
        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = 0;
        sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += Integer.parseInt(str.substring(i, i + 1));
            ans += calc(i + 1, sum, str, dp);
        }
        return ans;
    }
}