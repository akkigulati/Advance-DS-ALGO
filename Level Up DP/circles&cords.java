/*
Question
1. You are given a number N.
2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
3. You have to find the number of ways in which these chords can be drawn.
Input Format
A number N
Output Format
Check the sample output and question video.
Constraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3
Sample Output
5
*/
import java.io.*;
import java.util.*;

public class Main {

    public static long NumberOfChords(int n, int si, int ei) {
        if (si == ei - 1) {
            return 1;
        }
        if(si>=ei){
            return 1;
        }
        long res = 0;
        for (int cp = si + 1; cp <= ei; cp += 2) {
            long leftCall = NumberOfChords(n, si, cp - 1);
            long rightCall = NumberOfChords(n, cp + 1, ei);
            long ways = leftCall * rightCall;
            res += ways;
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NumberOfChords(n, 0, 2 * n - 1));
    }
}
//tab
import java.io.*;
import java.util.*;

public class Main {

    public static long NumberOfChords(int n) {
    
        long dp[]=new long[2*n+1];
        dp[0]=1;
        for(int i=0;i<=2*n;i+=2){
            for(int j=0,k=i-2;j<=i-2;j+=2,k-=2){
                dp[i]+=dp[j]*dp[k];
            }
        }
        return dp[2*n];
        
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NumberOfChords(n));
    }
}
