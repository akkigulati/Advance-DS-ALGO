//https://leetcode.com/problems/permutations-ii/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        
        permutation(nums,new ArrayList<>(),new boolean[nums.length],ans);
        return ans;
    }
    public static void permutation(int[] nums,List<Integer> ai,boolean vis[],List<List<Integer>> ans){
        if(ai.size()==nums.length){
            ans.add(new ArrayList(ai));
            return;
        }
        HashSet<Integer> unique=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            
            if(!vis[i]&&!unique.contains(nums[i])){
                ai.add(0,nums[i]);
                vis[i]=true;
                permutation(nums,ai,vis,ans);   
                ai.remove(new Integer(nums[i]));
                vis[i]=false;
                unique.add(nums[i]);
            }              
        }
    }
}
////
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        permutation(nums,new ArrayList<>(),new boolean[nums.length],ans);
        return ans;
    }
    public static void permutation(int[] nums,List<Integer> ai,boolean vis[],List<List<Integer>> ans){
        if(ai.size()==nums.length){
            ans.add(new ArrayList(ai));
            return;
        }
        // HashSet<Integer> unique=new HashSet<>();
        int prev=(int)-1e8;
        for(int i=0;i<nums.length;i++){
            
            if(!vis[i]&&prev!=nums[i]){
                ai.add(nums[i]);
                vis[i]=true;
                permutation(nums,ai,vis,ans);   
                ai.remove(ai.size()-1);
                vis[i]=false;
                prev=nums[i];
                // unique.add(nums[i]);
            }              
        }
    }
}
