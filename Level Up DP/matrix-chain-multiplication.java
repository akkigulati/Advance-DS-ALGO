/*
Question
1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.
Input Format
A number N
arr1
arr2.. N integers
Output Format
Check the sample output and question video.
Constraints
2 <= N <= 1000
1 <= arr[i] <= 500
Sample Input
3
1
2
3
Sample Output
6
*/
//recursive solution
import java.io.*;
import java.util.*;

public class Main {

	public static int mcm(int[] arr,int si,int ei){
		
	    if(si+1==ei){
		   //means single matrix arr[si][ei].
	        return 0;
	    }
        int min=Integer.MAX_VALUE;
        
        //ci => curent indx  si => start idx  ei =>ending idx..
        for(int ci=si+1;ci<ei;ci++){
            int leftCall=mcm(arr,si,ci);
            int rightCall=mcm(arr,ci,ei);
            int myans=leftCall+rightCall+(arr[si]*arr[ci]*arr[ei]);
            if(min>myans){
                min=myans;
            }
        }
		return min;
}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(mcm(arr,0,arr.length-1));
	}	
}
// Memorization method
import java.io.*;
import java.util.*;

public class Main {

	public static int mcm(int[] arr,int si,int ei,int mem[][]){
	    if(si+1==ei){
	        return 0;
	    }
	    if(mem[si][ei]!=0){
	        return mem[si][ei];
	    }
        int min=Integer.MAX_VALUE;
        
        //ci => curent indx  si => start idx  ei =>ending idx..
        for(int ci=si+1;ci<ei;ci++){
            int leftCall=mcm(arr,si,ci,mem);
            int rightCall=mcm(arr,ci,ei,mem);
            int myans=leftCall+rightCall+(arr[si]*arr[ci]*arr[ei]);
            if(min>myans){
                min=myans;
            }
        }
		return mem[si][ei]=min;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int Mem[][]=new int[arr.length+1][arr.length+1];
		System.out.println(mcm(arr,0,arr.length-1,Mem));
	}

	
}
