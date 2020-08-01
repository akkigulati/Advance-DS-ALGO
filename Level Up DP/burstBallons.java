/*
Question
1. You are given an array(arr) of length N which represents N number of balloons.
2. Each balloon is painted with a number on it.
3. You have to collect maximum coins by bursting all the balloons.
4. If you burst a balloon with index i, you will get (arr[i-1] * arr[i] * arr[i+1]) number of coins.
5. If arr[i-1] and arr[i+1] don't exist, then you may assume their value as 1.
Input Format
A number N
a1
a2.. N integers
Output Format
Check the sample output and question video.
Constraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3
1
2
3
Sample Output
12
*/
import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] arr, int si, int ei,int mem[][]) {
        
        if(mem[si][ei]!=0){
            return mem[si][ei];
        }
        int maxscore = Integer.MIN_VALUE;
        int leftpoint=(si - 1 >= 0 ? arr[si - 1] : 1);
        int rightpoint= (ei + 1 < arr.length ? arr[ei + 1] : 1);
        if (si == ei) {
            return mem[si][ei]=leftpoint*arr[si]*rightpoint;
        }
        for (int cut = si; cut <= ei; cut++) {
            
            int leftcoins = cut - 1 >= si ? solution(arr, si, cut - 1,mem) : 0;
            int rightcoins = cut + 1 <= ei ? solution(arr, cut + 1, ei,mem) : 0;
          
            int myscore = leftpoint*arr[cut]*rightpoint;
            myscore =myscore+ leftcoins + rightcoins;
            if (myscore > maxscore) maxscore = myscore;
            
        }
        return mem[si][ei]=maxscore;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr, 0, n-1,new int[n][n]));
    }

}
