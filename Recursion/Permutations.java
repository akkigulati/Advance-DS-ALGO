//https://leetcode.com/problems/permutations/submissions/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        
        permutation(nums,new ArrayList<>(),new boolean[nums.length],ans);
        return ans;
    }
    public static void permutation(int[] nums,List<Integer> ai,boolean vis[],List<List<Integer>> ans){
        if(ai.size()==nums.length){
            ans.add(new ArrayList(ai));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                ai.add(nums[i]);
                vis[i]=true;
                permutation(nums,ai,vis,ans);   
                ai.remove(new Integer(nums[i]));
                vis[i]=false;
            }              
        }
    }
}
