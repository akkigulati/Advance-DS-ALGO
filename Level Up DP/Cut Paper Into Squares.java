/*
Question
1. You are given two integers N and M which represents the length and breadth of a paper respectively. 
2. You have to divide the given paper into pieces such that every piece is a square.
3. You have to find the minimum number of such pieces.
Input Format
Two integers N and M
Output Format
Check the sample output and question video.
Constraints
1 <= N,M <= 10^3
Sample Input
30 
35
Sample Output
5
*/
import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
        }
        for (int j = 1; j <= m; j++) {
            dp[1][j] = j;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    int val = Integer.MAX_VALUE;
                    //row wise cut 
                    for (int cp = 1; cp <= i / 2; cp++) {
                        //left (cp,j) right(i-cp,j)
                        int left = dp[cp][j];
                        int right = dp[i - cp][j];
                        val = Math.min(val, left + right);

                    }
                    //col wise cut pt
                    for (int cp = 1; cp <= j/ 2; cp++) {
                        //left (i,cp) right(i,j-cp)
                        int left = dp[i][cp];
                        int right = dp[i][j - cp];
                        val = Math.min(val, left + right);
                    }

                    dp[i][j] = val;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(solution(n, m));
    }



}
