/*
Question
1. You are given two arrays - 
   The first array(keys), which is sorted and has distinct integers, represents search keys.
   Second one(freq) represents frequency counts, where freq[i] is the number of searches to keys[i].
2. A binary search tree is constructed containing all keys and the total cost of searches is minimum. 
3. The cost of a BST node is the level of that node multiplied by its frequency.
4. You have to find the minimum cost of all searches.
Input Format
A number N
a1
a2.. N integers
b1
b2.. N numbers
Output Format
Check the sample output and question video.
Constraints
1 <= N <= 1000
1 <= keys[i],freq[i] <= 1000
Sample Input
9
1
3
4
5
6
7
8
9
11
3
6
4
8
7
3
7
4
7
Sample Output
125
*/
//recursive
import java.io.*;
import java.util.*;

public class Main {

    private static int optimalbst(int[] keys, int[] frequency, int n, int startidx, int endIdx) {
         if(startidx==endIdx){
             return frequency[endIdx];
         }
         if(startidx<0||startidx>endIdx){
             return 0;
         }
        int min=Integer.MAX_VALUE;
        for (int cut = startidx; cut <= endIdx; cut++) {
          //  
            int leftTreeCost = optimalbst(keys, frequency, n, startidx, cut - 1);
            int rightTreeCost = optimalbst(keys, frequency, n, cut + 1, endIdx);
            int mycost=leftTreeCost+rightTreeCost;
            for(int i=startidx;i<=endIdx;i++){
                mycost+=frequency[i];
            }
            if(min>mycost){
                
                min=mycost;
                
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequency[i] = scn.nextInt();
        }
        
        System.out.println(optimalbst(keys, frequency, n,0,n-1));
    }

}
//Memorisation

import java.io.*;
import java.util.*;

public class Main {

    private static int optimalbst(int[] keys, int[] frequency, int mem[][], int startidx, int endIdx) {
         if(startidx==endIdx){
             return mem[startidx][endIdx]=frequency[endIdx];
         }
         if(startidx<0||startidx>endIdx){
             return 0;
         }
         if(mem[startidx][endIdx]!=0){
             return mem[startidx][endIdx];
         }
         
        int min=Integer.MAX_VALUE;
        for (int cut = startidx; cut <= endIdx; cut++) {
          //  
            int leftTreeCost = optimalbst(keys, frequency, mem, startidx, cut - 1);
            int rightTreeCost = optimalbst(keys, frequency, mem, cut + 1, endIdx);
            int mycost=leftTreeCost+rightTreeCost +sumofallnodes(frequency,startidx,endIdx);
            //adding sum of all nodes 
            
            if(min>mycost){
                
                min=mycost;
                
            }
        }
        return mem[startidx][endIdx]=min;
    }
    public static int sumofallnodes(int frequency[],int startidx,int endIdx){
        int sum=0;
        for(int i=startidx;i<=endIdx;i++){
                sum+=frequency[i];
            }
            return sum;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequency[i] = scn.nextInt();
        }
        int mem[][]=new int[n][n];
        System.out.println(optimalbst(keys, frequency, mem,0,n-1));
    }

}
//optimized mem or recursion
import java.io.*;
import java.util.*;

public class Main {

    private static int optimalbst(int[] keys, int[] frequency, int mem[][], int startidx, int endIdx) {
         if(startidx==endIdx){
             return mem[startidx][endIdx]=frequency[endIdx];
         }
         if(startidx<0||startidx>endIdx){
             return 0;
         }
         if(mem[startidx][endIdx]!=0){
             return mem[startidx][endIdx];
         }
         int sum=sumofallnodes(frequency,startidx,endIdx);
        int min=Integer.MAX_VALUE;
        for (int cut = startidx; cut <= endIdx; cut++) {
          //  
            int leftTreeCost = optimalbst(keys, frequency, mem, startidx, cut - 1);
            int rightTreeCost = optimalbst(keys, frequency, mem, cut + 1, endIdx);
            int mycost=leftTreeCost+rightTreeCost +sum;
            //adding sum of all nodes 
            
            if(min>mycost){
                
                min=mycost;
                
            }
        }
        return mem[startidx][endIdx]=min;
    }
    public static int sumofallnodes(int frequency[],int startidx,int endIdx){
        int sum=0;
        for(int i=startidx;i<=endIdx;i++){
                sum+=frequency[i];
            }
            return sum;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequency[i] = scn.nextInt();
        }
        int mem[][]=new int[n][n];
        System.out.println(optimalbst(keys, frequency, mem,0,n-1));
    }

}
//more optimized 
import java.io.*;
import java.util.*;

public class Main {

    private static int optimalbst(int[] keys, int[] frequency, int mem[][], int startidx, int endIdx) {
         if(startidx==endIdx){
             return mem[startidx][endIdx]=frequency[endIdx];
         }
         if(startidx<0||startidx>endIdx){
             return 0;
         }
         if(mem[startidx][endIdx]!=0){
             return mem[startidx][endIdx];
         }
        //  int sum=sumofallnodes(frequency,startidx,endIdx);
        int sum=0;
        int min=Integer.MAX_VALUE;
        for (int cut = startidx; cut <= endIdx; cut++) {
            sum+=frequency[cut];
            int leftTreeCost = optimalbst(keys, frequency, mem, startidx, cut - 1);
            int rightTreeCost = optimalbst(keys, frequency, mem, cut + 1, endIdx);
            int mycost=leftTreeCost+rightTreeCost;
            //adding sum of all nodes 
            
            if(min>mycost){
                
                min=mycost;
                
            }
        }
            min+=sum;
        return mem[startidx][endIdx]=min;
    }
    public static int sumofallnodes(int frequency[],int startidx,int endIdx){
        int sum=0;
        for(int i=startidx;i<=endIdx;i++){
                sum+=frequency[i];
            }
            return sum;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequency[i] = scn.nextInt();
        }
        int mem[][]=new int[n][n];
        System.out.println(optimalbst(keys, frequency, mem,0,n-1));
    }

}
