import java.io.*;
import java.util.*;

public class Main {

    public static void countSort(int[] arr, int min, int max) {
    
        int freq[] = new int[max - min + 1];
        //creating freq arr of size max-min+1;
        for (int val: arr) {
        //getting idx such that -ve value can get placed in freq array.
        
            int idx = val - min;
            freq[idx]++;
            
        }
        
        //prefix sum
        //represent last position of that value.
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }
        int SortedArray[] = new int[arr.length];
        
        //now traversing from back and then getting position prefix sum array and storing value at that pos.
        //decrement in prefix array by 1.
        //this is to maintain stable sort.
        
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = freq[arr[i] - min];
            SortedArray[pos - 1] = arr[i];
            freq[arr[i] - min]--;
        }
        for(int i=0;i<SortedArray.length;i++){
            arr[i]=SortedArray[i];
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }

}
