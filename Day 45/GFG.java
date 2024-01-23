//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
           int flag=0;
        String s="";
        String str = arr[0];
        int min = Integer.MAX_VALUE;
        for(String s1:arr)
        {
            int l = s1.length();
            if(l<min)
            min=l;
        }
        for(int i=0;i<min;i++)
        {
            for(int j=1;j<arr.length;j++)
            {
                String str2 = arr[j];
                if(str.charAt(i)!=str2.charAt(i))
                flag=1;
            }
            if(flag==0)
            s=s.concat(String.valueOf(str.charAt(i)));
            else if(flag==1 && s.isEmpty())
            return "-1";
            else
            return s;
        }
        
        return s;
    }
}