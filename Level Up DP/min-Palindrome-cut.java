/*
Question
1. You are given a string.
2. You have to find the minimum number of cuts required to convert the given string into palindromic partitions.
3. Partitioning of the string is a palindromic partitioning if every substring of the partition is a palindrome.
Input Format
A string
Output Format
Check the sample output and question video.
Constraints
1 <= length of string <= 10^4
Sample Input
abccbc
Sample Output
2
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int minPalindromicCut(String str,int si,int ei,int dp[][]) {
		 for (int gap = 1; gap < str.length(); gap++) {
            for (int i = 0, j = gap; j < str.length(); j++, i++) {
                //i => start idx j => ending idx
                if(gap==1){
                    //two length string..
                    if(str.charAt(i)!=str.charAt(j)){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=0;
                    }
                }else{
                    if(str.charAt(i)==str.charAt(j)&&dp[i+1][j-1]==0){
                        dp[i][j]=0;
                        continue;
                    }
                int min = Integer.MAX_VALUE;
                
                for (int cp = i + 1; cp <= j; cp++) {
                    int leftCall = dp[i][cp-1];
                    int rightCall = dp[cp][j];
                    int myans = leftCall + rightCall + 1;
                    min = Math.min(min, myans);
                }
                dp[i][j] = min;
                }
            }
        }

		return dp[0][str.length()-1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		int dp[][]=new int[str.length()][str.length()];
		System.out.println(minPalindromicCut(str,0,str.length(),dp));
	}
}
