//https://leetcode.com/problems/power-of-four/
class Solution {
    public boolean isPowerOfFour(int num) {
        
        return (num>0)&&((num&(num-1))==0) &&(num %3==1);
        // int n=num,count=0;
        // while(n>1){
        //     n>>=2;
        //     count+=2;
        // }
        // return (n<<count)==num;
    }
}
