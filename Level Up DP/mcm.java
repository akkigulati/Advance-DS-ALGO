import java.io.*;
import java.util.*;

public class Main {

	public static int mcm(int[] arr,int si,int ei){
	    if(si+1==ei){
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