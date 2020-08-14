//https://leetcode.com/problems/single-number-ii/submissions/
class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int mask=(1<<i);
            int count=0;
            for(int num:nums){
                if((num&mask)!=0) count++;
            }
            //add bit to ans;
            if(count%3!=0) ans|=mask;
        }
        return ans;
    }
}
