//https://leetcode.com/problems/single-number-iii/
class Solution {	 
	public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int n:nums){
            xor^=n;
        }
        //mask is last set bit..
        int mask=(xor&(-xor));
        int a=0,b=0;
        for(int n:nums){
            if((n&mask)!=0){
                a^=n;
            }else{
                b^=n;
            }
        }
        int ans[]={
            a,b
        };
        return ans;}
}
