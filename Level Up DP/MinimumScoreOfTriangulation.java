/*
Question
1. You are given an array of integers, which represents the vertices of an N-sided convex polygon in clockwise order.
2. You have to triangulate the given polygon into N-2 triangles.
3. The value of a triangle is the product of the labels of vertices of that triangle.
4. The total score of the triangulation is the sum of the value of all the triangles.
5. You have to find the minimum score of the triangulation of the given polygon.
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
6
*/
import java.io.*;
import java.util.*;

public class Main {

    public static int minScoreTriangulation(int[] arr, int si, int ei,int mem[][]) {
        if (si +1== ei) {
            return mem[si][ei]=0;
        }
        if(mem[si][ei]!=0){
            return mem[si][ei];
        }
        int min = Integer.MAX_VALUE;
        for (int cp = si + 1; cp <= ei - 1; cp++) {
            int leftCost = minScoreTriangulation(arr, si, cp,mem);
            int rightCost = minScoreTriangulation(arr, cp, ei,mem);
            int mycost = (arr[si] * arr[cp] * arr[ei]) + leftCost + rightCost;
            if (min > mycost) {
                min = mycost;
            }
        }
        return mem[si][ei]=min;}
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(minScoreTriangulation(arr, 0, n - 1,new int[n][n]));
    }
}
