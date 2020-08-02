/*
Question
1. You are given a boolean expression with symbols T,F, and operators &,|,^ , where
   T represents True
   F represents False
   & represents boolean AND
   | represents boolean OR
   ^ represents boolean XOR.
2. You have to find the number of ways in which the expression can be parenthesized so that the value of expression evaluates to true.
Input Format
Two strings s1 and s2
Output Format
Check the sample output and question video.
Constraints
2 <= length of s1 <= 100
1 <= length of s2 <= 99
Sample Input
TFT
^&
Sample Output
2
*/
import java.io.*;
import java.util.*;

public class Main {
    public static class pair {
        int tc = 0, fc = 0;
    }
    public static int solution(String str1, String str2) {
        //write your code here
        int n = str1.length();
        int[][] trueDp = new int[n][n];
        int[][] falseDp = new int[n][n];
        pair res = new pair();
        for (int gap = 0; gap < n; gap++) {
            for (int si = 0, ei = gap; ei < n; si++, ei++) {
                if (gap == 0) {
                    trueDp[si][ei] = str1.charAt(si) == 'T' ? 1 : 0;
                    falseDp[si][ei] = str1.charAt(si) == 'F' ? 1 : 0;
                } else if (gap == 1) {
                    // (si,si) => left expression (ei,ei)=> right expression
                    if (str2.charAt(si) == '^') {
                        trueDp[si][ei] = (falseDp[si][si] * trueDp[ei][ei]) + (trueDp[si][si] * falseDp[ei][ei]);
                        falseDp[si][ei] = (falseDp[si][si] * falseDp[ei][ei]) + (trueDp[si][si] * trueDp[ei][ei]);
                    } else if (str2.charAt(si) == '&') {
                        trueDp[si][ei] = (trueDp[si][si] * trueDp[ei][ei]);
                        falseDp[si][ei] = (trueDp[si][si] * falseDp[ei][ei]) + (falseDp[si][si] * trueDp[ei][ei]) + (falseDp[si][si] * falseDp[ei][ei]);
                    } else {
                        trueDp[si][ei] = (trueDp[si][si] * falseDp[ei][ei]) + (falseDp[si][si] * trueDp[ei][ei]) + (trueDp[si][si] * trueDp[ei][ei]);
                        falseDp[si][ei] = (falseDp[si][si] * falseDp[ei][ei]);
                    }
                } else {

                    for (int cp = si; cp < ei; cp++) {
                        char op = str2.charAt(cp);
                        int left_tc = trueDp[si][cp], left_fc = falseDp[si][cp];
                        int right_tc = trueDp[cp + 1][ei], right_fc = falseDp[cp + 1][ei];

                        if (op == '^') {
                            res.tc = (left_tc * right_fc) + (left_fc * right_tc);
                            res.fc = (left_fc * right_fc) + (left_tc * right_tc);
                        } else if (op == '&') {
                            res.tc = (left_tc * right_tc);
                            res.fc = (left_tc * right_fc) + (left_fc * right_tc) + (left_fc * right_fc);
                        } else if (op == '|') {
                            res.tc = (left_tc * right_tc) + (left_tc * right_fc) + (left_fc * right_tc);
                            res.fc = (left_fc * right_fc);
                        }
                        trueDp[si][ei] += res.tc;
                        falseDp[si][ei] += res.fc;
                    }

                }
            }
        }

        return trueDp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }

}
