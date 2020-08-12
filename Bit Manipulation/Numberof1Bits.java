//leetcode 191//https://leetcode.com/problems/number-of-1-bits/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int x=1;
        int tot=0;
        while(x!=0){
            if((x&n)!=0) tot++;
            x=x<<1;
        }
        return tot;
    }
}