//https://leetcode.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
            for(int i=0;i<1<<n;i++){
                List<Integer> ai=new ArrayList<>();
                for(int j=0;j<n;j++){
                    if((i&(1<<j))!=0) ai.add(nums[j]);
            }
                ans.add(ai);
        }
        return ans;
    }
}
