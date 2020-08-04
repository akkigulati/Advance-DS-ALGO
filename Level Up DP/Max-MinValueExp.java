/*
1. You are given a string that represents an expression containing numbers and two operators + and *.
2. You have to find the minimum and maximum value which can be obtained by evaluating this expression by different parenthesization.
Input Format
A string
Output Format
Check the sample output and question video.
Constraints
1 <= length of string <= 100
Range of numbers -> [0,9]
Sample Input
1+2*3+4*5
Sample Output
Minimum Value -> 27
Maximum Value -> 105
*/
import java.io.*;
import java.util.*;

public class Main {

    public static class pair {
        int min = 0, max = 0;
    }
    public static int[] solution(String str1, String str2) {
        //write your code here
        int n = str1.length();
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];
        pair res = new pair();
        for (int gap = 0; gap < n; gap++) {
            for (int si = 0, ei = gap; ei < n; si++, ei++) {
                if (gap == 0) {
                    maxDp[si][ei] = str1.charAt(si) - '0';
                    minDp[si][ei] = str1.charAt(si) - '0';
                }  else {
                    maxDp[si][ei]=Integer.MIN_VALUE;
                    minDp[si][ei]=Integer.MAX_VALUE;
                    for (int cp = si; cp <ei; cp++) {
                        int leftMax=maxDp[si][cp],leftMin=minDp[si][cp];
                        int rightMax=maxDp[cp+1][ei],rightMin=minDp[cp+1][ei];
                        char op = str2.charAt(cp);
                        if (op == '+') {
                            maxDp[si][ei]=Math.max(maxDp[si][ei],leftMax+rightMax);
                            minDp[si][ei]=Math.min(minDp[si][ei],leftMin+rightMin);
                        } else if (op == '*') {
                            maxDp[si][ei]=Math.max(maxDp[si][ei],leftMax*rightMax);
                            minDp[si][ei]=Math.min(minDp[si][ei],leftMin*rightMin);
                        }
                    }

                }
                
            }
        }

        return new int[] {
            minDp[0][n - 1], maxDp[0][n - 1]
        };
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '*') {
                str2 += ch;
            } else {
                str1 += ch;
            }
        }
        int[] arr = solution(str1, str2);
        System.out.println("Minimum Value -> " + arr[0]);
        System.out.println("Maximum Value -> " + arr[1]);
    }

}
