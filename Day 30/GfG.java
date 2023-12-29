//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int k = sc.nextInt();
            int answer = new Solution().kSubstrConcat(n,s,k);
    		System.out.println(answer);
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int kSubstrConcat(int n, String s, int k)
    {
        // Your Code Here   
        if (n % k != 0) {
            return 0;
        }

        HashMap<String, Integer> substringFreq = new HashMap<>();
        
        for (int i = 0; i <= n - k; i += k) {
            String substr = s.substring(i, i + k);
            substringFreq.put(substr, substringFreq.getOrDefault(substr, 0) + 1);
            if (substringFreq.size() > 2 || substringFreq.get(substr) > n / k) {
                return 0;
            }
        }

        return substringFreq.size() <= 2 ? 1 : 0;
    }
}