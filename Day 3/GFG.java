import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(array, n));
        }
    }
}


class Solution {
    int missingNumber(int array[], int n) {
             int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < (n - 1); i++) {
            sum1 = sum1 + array[i];
        }
        sum2 = n * (n + 1) / 2;

        return (sum2 - sum1);
    }
}