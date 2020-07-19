/*
Question
1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using radix sort.
Input Format
An Integer n 
arr1
arr2..
n integers
Output Format
Check the sample ouput and question video.
Constraints
1 <= N <= 10000
0 <= arr[i] <= 10^8
Sample Input
5
7 
2 
4 
1 
3
Sample Output
After iteration no. 1 -> 1 2 3 4 7 
1 2 3 4 7 
*/
import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    int max=Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++){
        if(max<arr[i])
        max=arr[i];
    }
    for(int exp=1,itr=1;max/exp>0;exp*=10){
        countSort(arr,exp,itr++);
    }

  }

  public static void countSort(int[] arr, int exp, int itr) {
    int freq[]=new int[10];
    for(int val:arr){
        freq[(val/exp)%10]++;
    }
    int parr[]=new int[10];
    parr[0]=freq[0];
    for(int i=1;i<10;i++){
        parr[i]=parr[i-1]+freq[i];
    }
    int ans[]=new int[arr.length];
    for(int i=arr.length-1;i>=0;i--){
        int val=arr[i];
        int pos=parr[(val/exp)%10]--;
        ans[pos-1]=val;
    }
    for(int i=0;i<ans.length;i++){
        arr[i]=ans[i];
    }
    System.out.print("After iteration no. " + itr + " -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}
