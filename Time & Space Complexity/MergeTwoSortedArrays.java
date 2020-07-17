/*
Question
1. You are given two sorted arrays(a,b) of integers.
2. You have to merge them and form one sorted array.
3. You have to do it in linear time complexity.
Input Format
An Integer n 
a1
a2..n integers
An integer m
b1
b2..m integers
Output Format
Check the sample output and question video.
Constraints
1 <= N <= 10^8
-10^9 <= a[i],b[i] <= 10^9
Sample Input
4
-2 
5 
9 
11
3
4 
6 
8
Sample Output
-2
4
5
6
8
9
11
*/
import java.io.*;
import java.util.*;

public class Main {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
      int n1=a.length;
      int n2=b.length;
    int arr[]=new int[n1+n2];
    int i=0,j=0,k=0;
    while(i<n1&&j<n2){
        if(a[i]<=b[j])
        {
            arr[k]=a[i];
            i++;
        }else{
           arr[k]=b[j];
            j++; 
        }
        k++;
    }
    while(i<n1){
        arr[k]=a[i];
        i++;
        k++;
    }
    while(j<n2){
        arr[k]=b[j];
        j++;
        k++;
    }
    
    return arr;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}
