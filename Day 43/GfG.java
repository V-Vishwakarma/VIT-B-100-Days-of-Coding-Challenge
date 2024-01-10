//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        // code here
             StringBuilder sb = new StringBuilder(S);
        int i = 0;

        while (K > 0 && i < sb.length() - 1) {
            if (sb.charAt(i) > sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                K--;
                if (i > 0) {
                    i--; // Backtrack to potentially remove more digits
                }
            } else {
                i++;
            }
        }

        // Remove any remaining digits from the end
        while (K > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            K--;
        }

        // Remove leading zeros
        int start = 0;
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }

        return start == sb.length() ? "0" : sb.substring(start);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.removeKdigits("1432219", 3);
        System.out.println(result); // Output: 1219
    }
}